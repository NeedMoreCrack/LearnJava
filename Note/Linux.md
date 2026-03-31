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
