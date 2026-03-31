# <center>Keygen</center>

### SSH免密碼

1. 輸入<mark>ssh-keygen</mark>產生key 一直Enter
2. 公鑰設定放到伺服器上,透過<mark>ssh-copy-id</mark>
```cli
    ssh-copy-id server_user_name@server_ip
```
3. 使用SSH連線試試,如果不需要密碼 表示成功了

### GitHub SSH
1. GitHub -> setting -> SSH and GPG keys -> New SSH key
2. 開啟電腦的終端機 輸入<mark>ssh-keygen -t rsa</mark> 一直Enter
3. 進入到當前使用者資料夾內的.ssh資料夾將<mark>id_rsa.pub</mark>的內容複製到key的欄位內
    * id_rsa.pub：公開金鑰 (可以讓大家都知道)
    * id_rsa：私密金鑰 (無論如何不能洩漏)
