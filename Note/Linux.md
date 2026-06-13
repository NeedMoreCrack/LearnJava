# <center>Linux</center>

### 壓縮類型
* tar
    * 說明:
        * .tar的檔案只是完成打包 並沒有壓縮
        * .tar.gz表示打包+壓縮

    * 參數:
        * -z 表示gzip 通過gzip命令處理檔案 gzip可以壓縮或解壓
        * -c 表示create 創建新的包文件
        * -x 表示extract 從包中提取檔案
        * -v 表示verbose 顯示執行過程
        * -f 表示file 用於指定包文件的名稱

* zip
    * 說明:
        * 支援密碼 跨平台支援度最好 可壓縮多個檔案

    * 參數:
        * -r 遞迴壓縮資料夾（包含所有子資料夾與檔案）
        * -v 顯示詳細資訊（verbose 模式，顯示每個檔案壓縮過程）
        * -q 安靜模式（quiet，不顯示壓縮細節）
        * -e 啟用密碼保護模式（會互動式輸入密碼）
        * -P 密碼   直接指定密碼（⚠️ 不安全，密碼會被寫入 shell history）
        * -x 檔名   排除某些檔案或路徑（可搭配萬用字元）
        * -j 忽略路徑，只壓縮檔案本身（flat 壓縮）
        * -m 壓縮後刪除原始檔案（move 壓縮）
        * -T 測試壓縮檔內容是否正確（test archive）
        * -FS 使用檔案同步模式（更新或新增檔案進現有 zip）

* find
    * 說明:
        * 尋找檔案
        下方語法是指在當前資料夾及子資料夾下找結尾是.log的檔案
    * 語法:
        * find . -name "*.log"

* grep
    * 說明:
        * 從指定文件中查詢指定的文字

    * 參數:
        * -i 忽略搜尋的關鍵字大小寫
        * -n 顯示關鍵字所在的行號
        * -A 輸出關鍵字所在及<mark>之後（After）的幾行</mark>（舉例:-A5 表示輸出關鍵字所在行之後的5行記錄）
        * -B 輸出關鍵字所在及<mark>之前（Before）的幾行</mark>（舉例:-B5 表示輸出關鍵字所在行之前的5行記錄）

    * 舉例:

        grep Hello HelloWorld.java  查詢HelloWorld.java中的Hello文字位置

        grep hello *.java  查詢所有以.java檔案中的hello文字位置

### MySQL
* 安裝指令
    * apt install mysql-server

* 啟動指令
    * systemctl start mysql

* 設定環境變數 - /home/username/.bashrc or .zshrc
    * export PATH='/usr/local/mysql/bin':$PATH

* 首次安裝完畢的設定
    * sudo mysql_secure_installation
        1. 設定 root 密碼
        2. 移除匿名用戶
        3. 禁止 root 遠端登入
        4. 移除 test 資料庫
        5. 重新載入權限表

* 如果你想讓 root 使用密碼登入（非 auth_socket）
    * 修改root密碼
    ```mysql
        ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY '你的密碼';
        FLUSH PRIVILEGES;
    ```

* 建立自己的新帳號（不用 root 操作）
    ```mysql
        CREATE USER '使用者名稱'@'localhost' IDENTIFIED BY '你的密碼';
        GRANT ALL PRIVILEGES ON *.* TO '使用者名稱'@'localhost' WITH GRANT OPTION;
        FLUSH PRIVILEGES;
    ```

### 補充...Windows WSL2無法連線的解決方法
1. 先將WSL關閉
> wsl --shutdown

2. 設定Netsh
    1. 重置Winsock目錄。 Winsock定義了如何存取網路服務和應用程式程式設計介面（API）
    > netsh winsock reset

    2. 重置所有IP設置，恢復為初始狀態
    > netsh int ip reset all

    3. 重置Windows HTTP代理設置
    > netsh winhttp reset proxy

3. 刷新IP設定
> ipconfig /flushdns

4. 完成以上所有步驟后，重啟電腦以確保所有配置更改生效。<br>
通過以上步驟，你可以有效地解決由於網路設定問題引起的WSL網络連接問題。<br>
這些命令不僅適用於WSL，也適用於其他網路問題的排查和修復

### SSH連線開放ROOT來連線
1. 修改文件 <mark>/etc/ssh/sshd_config</mark> 找到 <mark>PermitRootLogin no</mark> 將 no 改成 yes <br>或是改成  prohibit-password 只允許用 key 登入 root

2. 儲存後重新啟動 SSH 服務 
    > systemctl restart sshd

3. 如果報錯
    > Failed to restart sshd.service: Unit sshd.service not found.
4. 你的系統使用的是 ssh 而不是 sshd 將語法改成下列指令
    > systemctl restart ssh

---

## 練習 grep / sed / awk

### 先準備下列三個檔案

#### grep_access.log
```
2026-06-14 08:01:12 INFO  user=andy ip=192.168.1.10 method=GET path=/login status=200 size=532
2026-06-14 08:03:44 WARN  user=guest ip=10.0.0.8 method=POST path=/login status=401 size=128
2026-06-14 08:05:02 INFO  user=mary ip=172.16.0.5 method=GET path=/products status=200 size=2048
2026-06-14 08:07:15 ERROR user=system ip=127.0.0.1 method=GET path=/api/report status=500 size=64
2026-06-14 08:10:21 INFO  user=andy ip=192.168.1.10 method=GET path=/dashboard status=200 size=4096
2026-06-14 08:12:35 WARN  user=bob ip=203.0.113.9 method=POST path=/payment status=403 size=300
2026-06-14 08:15:48 INFO  user=alice ip=198.51.100.22 method=GET path=/api/orders status=200 size=1024
2026-06-14 08:18:01 ERROR user=api ip=10.0.0.12 method=POST path=/api/orders status=502 size=90
2026-06-14 08:20:17 INFO  user=guest ip=10.0.0.8 method=GET path=/ status=200 size=1200
2026-06-14 08:24:55 DEBUG user=dev ip=192.168.1.99 method=GET path=/debug/env status=200 size=8192
2026-06-14 08:30:10 INFO  user=mary ip=172.16.0.5 method=GET path=/logout status=302 size=256
2026-06-14 08:33:42 ERROR user=andy ip=192.168.1.10 method=POST path=/api/report status=504 size=70
2026-06-14 08:36:19 WARN  user=guest ip=10.0.0.8 method=POST path=/login status=401 size=128
2026-06-14 08:39:27 INFO  user=bob ip=203.0.113.9 method=GET path=/products status=200 size=3050
2026-06-14 08:42:03 INFO  user=alice ip=198.51.100.22 method=DELETE path=/api/orders/1001 status=204 size=0
2026-06-14 08:45:31 ERROR user=system ip=127.0.0.1 method=GET path=/health status=503 size=45
2026-06-14 08:48:09 INFO  user=andy ip=192.168.1.10 method=GET path=/api/orders status=200 size=1600
2026-06-14 08:51:56 WARN  user=dev ip=192.168.1.99 method=GET path=/admin status=403 size=512
2026-06-14 08:55:22 INFO  user=mary ip=172.16.0.5 method=POST path=/cart status=201 size=780
2026-06-14 08:58:40 ERROR user=api ip=10.0.0.12 method=POST path=/api/payment status=500 size=88
```

#### sed_users.csv
```
id,name,email,phone,status,created_at
1,Andy Chen,andy.chen@example.com,0912-345-678,active,2026/06/01
2,Mary Lin,mary.lin@example.com,0988-111-222,inactive,2026/06/02
3,Bob Wang,bob.wang@example.com,0933-222-333,active,2026/06/03
4,Alice Huang,alice.huang@example.com,0955-333-444,pending,2026/06/04
5,David Lee,david.lee@example.com,0966-444-555,active,2026/06/05
6,Guest User,guest@example.com,0900-000-000,inactive,2026/06/06
7,Test Account,test.account@example.com,0999-999-999,pending,2026/06/07
8,Dev Admin,dev.admin@example.com,0911-222-333,active,2026/06/08
9,Old User,old.user@example.com,0922-333-444,inactive,2026/06/09
10,Api Robot,api.robot@example.com,0933-444-555,active,2026/06/10
```

#### awk_sales.tsv
```
date	region	product	qty	unit_price	sales
2026-06-01	TW	Keyboard	3	1200	3600
2026-06-01	TW	Mouse	5	600	3000
2026-06-01	JP	Monitor	2	5200	10400
2026-06-02	TW	Monitor	1	5200	5200
2026-06-02	US	Keyboard	4	1100	4400
2026-06-02	US	Mouse	8	550	4400
2026-06-03	JP	Keyboard	2	1250	2500
2026-06-03	TW	Laptop	1	32000	32000
2026-06-03	US	Monitor	3	5000	15000
2026-06-04	TW	Mouse	10	600	6000
2026-06-04	JP	Laptop	1	34000	34000
2026-06-04	US	Keyboard	6	1100	6600
2026-06-05	TW	Keyboard	7	1200	8400
2026-06-05	JP	Mouse	9	580	5220
2026-06-05	US	Laptop	2	31000	62000
2026-06-06	TW	Monitor	2	5200	10400
2026-06-06	JP	Monitor	1	5300	5300
2026-06-06	US	Mouse	12	550	6600
```

#### 一、grep 練習題：grep_access.log

#### 基礎
1. 找出所有包含 ERROR 的行。
2. 找出所有包含 WARN 的行。
3. 找出所有 status=200 的行。
4. 找出所有 user=andy 的行。
5. 找出所有 method=POST 的行。
6. 找出所有訪問 /api/orders 的紀錄。
7. 找出所有來自 192.168.1.10 的紀錄。
8. 找出所有包含 guest 的紀錄。
9. 找出所有 status=401 的紀錄。
10. 找出所有 path=/login 的紀錄。

#### 中階
11. 找出所有 ERROR 或 WARN 的行。
12. 找出所有 status=500 或 status=504 的行。
13. 找出所有 /api/ 開頭的路徑。
14. 找出不是 INFO 的行。
15. 找出不是 status=200 的行。
16. 找出所有 GET 且 status=200 的行。
17. 找出所有 POST 且狀態不是成功的行。
18. 找出所有 IP 是 10.0.0.x 的紀錄。
19. 找出所有 IP 是 192.168.1.x 的紀錄。
20. 找出所有 status=4xx 的行，例如 401、403。

#### 進階
21. 統計 ERROR 出現幾次。
22. 統計 WARN 出現幾次。
23. 統計 user=guest 出現幾次。
24. 只顯示包含 ERROR 的行號。
25. 只顯示包含 /api/ 的行號。
26. 找出同時包含 andy 和 /api/report 的行。
27. 找出所有 status=5xx 的錯誤。
28. 找出所有 size=0 的紀錄。
29. 找出所有 DELETE 請求。
30. 找出所有不是 DEBUG 的紀錄。

---

#### 二、sed 練習題：sed_users.csv

#### 基礎
1. 顯示第 1 行。
2. 顯示第 3 行。
3. 刪除第 1 行 header。
4. 刪除第 5 行。
5. 只顯示第 2 到第 5 行。
6. 把所有 active 改成 enabled。
7. 把所有 inactive 改成 disabled。
8. 把所有 pending 改成 waiting。
9. 把所有 email 的 example.com 改成 demo.com。
10. 把日期格式中的 / 改成 -。

#### 中階
11. 只處理第 2 行，把 active 改成 enabled。
12. 刪除所有包含 inactive 的行。
13. 刪除所有包含 pending 的行。
14. 刪除所有包含 guest 的行。
15. 把 Andy Chen 改成 Andy Wang。
16. 把手機號碼中的 - 移除。
17. 把每一行開頭加上 USER: 。
18. 把每一行結尾加上 ,checked。
19. 把 CSV header 的 status 改成 account_status。
20. 把 created_at 改成 register_date。

#### 進階
21. 只印出包含 active 的行。
22. 只印出第 3 到第 8 行。
23. 把空白名字中的空白改成底線，例如 Andy Chen → Andy_Chen。
24. 把所有 email 隱藏成 ***@example.com。
25. 把所有手機號碼隱藏成 09xx-xxx-xxx。
26. 刪除最後一行。
27. 只刪除第 1 行和第 10 行。
28. 把每行的第一個逗號改成 |。
29. 把每行所有逗號改成 tab。
30. 把 status 欄位中的 active/inactive/pending 統一改成大寫。

---

#### 三、awk 練習題：awk_sales.tsv

#### 基礎
1. 印出整個檔案。
2. 印出第 1 欄 date。
3. 印出第 2 欄 region。
4. 印出第 3 欄 product。
5. 印出第 6 欄 sales。
6. 跳過 header，只印資料列。
7. 印出 region 和 sales。
8. 印出 product 和 qty。
9. 印出 date product sales。
10. 印出行號加上原始內容。

#### 中階
11. 只印出 region 是 TW 的資料。
12. 只印出 region 是 JP 的資料。
13. 只印出 product 是 Keyboard 的資料。
14. 只印出 product 是 Laptop 的資料。
15. 只印出 sales 大於 10000 的資料。
16. 只印出 qty 大於等於 5 的資料。
17. 計算所有 sales 總和。
18. 計算所有 qty 總和。
19. 計算資料總筆數，不含 header。
20. 計算平均 sales。

#### 進階
21. 計算 TW 的 sales 總和。
22. 計算 JP 的 sales 總和。
23. 計算 US 的 sales 總和。
24. 依照 region 分組統計 sales 總和。
25. 依照 product 分組統計 sales 總和。
26. 依照 region 分組統計 qty 總和。
27. 找出 sales 最大的一筆資料。
28. 找出 sales 最小的一筆資料。
29. 找出 qty 最大的一筆資料。
30. 找出 Laptop 的總銷售額。
31. 找出 Mouse 的總數量。
32. 印出 sales = qty * unit_price 驗算結果。
33. 找出 sales 欄位和 qty * unit_price 不一致的資料。
34. 輸出格式改成：地區=TW 商品=Keyboard 銷售額=3600。
35. 把 TSV 轉成 CSV 格式輸出。

---

#### 四、混合練習題 

#### grep + awk
1. 從 grep_access.log 找出 ERROR 後，只印出日期、時間、user、status。
2. 從 grep_access.log 找出 status=200 後，統計有幾筆。
3. 從 grep_access.log 找出 /api/ 後，統計有幾筆。
4. 從 grep_access.log 找出 POST 後，只印出 path。
5. 從 grep_access.log 找出 ERROR 後，只印出 path 和 status。

#### sed + awk
6. 用 sed 把 sed_users.csv 的逗號改成 tab，再用 awk 印出姓名和狀態。
7. 用 sed 刪除 header，再用 awk 印出第 2 欄姓名。
8. 用 sed 把 inactive 改成 disabled，再用 awk 印出狀態欄。
9. 用 sed 把 email domain 改成 demo.com，再只印出 email 欄位。
10. 用 sed 移除手機號碼的 -，再印出姓名和手機。

#### grep + sed
11. 從 grep_access.log 找出 ERROR，再把 ERROR 改成 FAIL。
12. 從 grep_access.log 找出 WARN，再把 WARN 改成 WARNING。
13. 從 grep_access.log 找出 status=401，再把 guest 改成 anonymous。
14. 從 grep_access.log 找出 /api/，再把 /api/ 改成 /backend-api/。
15. 從 grep_access.log 找出 192.168.1.10，再把 IP 改成 [hidden-ip]。

---

#### 五、挑戰題
1. 統計 grep_access.log 裡每種 HTTP status 各出現幾次。
2. 統計 grep_access.log 裡每個 user 各出現幾次。
3. 統計 grep_access.log 裡每個 method 各出現幾次。
4. 找出 grep_access.log 裡 response size 最大的一行。
5. 找出 grep_access.log 裡所有 5xx 錯誤，輸出成 user path status。
6. 把 sed_users.csv 轉成 TSV。
7. 把 sed_users.csv 的 email 全部遮罩，只保留網域。
8. 把 sed_users.csv 的 phone 全部遮罩，只保留前三碼。
9. 從 awk_sales.tsv 算出每個地區的總銷售額，並由大到小排序。
10. 從 awk_sales.tsv 算出每個商品的總銷售額，並由大到小排序。
