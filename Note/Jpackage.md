# <center>jpackage</center>

### java to class
```
    c = compile
    java檔案
    javac First.java
```

### class to jar

```
    c = create
    f = file
    e = entry point
    創建名.jar main的類 打包的class
    jar cfe myApp.jar FirstApp FirstApp.class
```

### jar to exe

```
    --讀取jar檔的資料夾 --輸出資料夾名 --使用的jar包 --打包類型 --如果沒有圖形介面要加上這個 以控制台輸出
    jpackage --input input --name myApp --main-jar myFirstApp.jar --type app-image  --win-console
```
