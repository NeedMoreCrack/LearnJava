# <center>Docker</center>

1. Docker 常見參數 - [Dockerdocs](https://docs.docker.com/reference/)
    * -d：讓容器後台運行
    * --name：給容器命名,唯一
    * --network：加入指定網路
    * -e：環境變數
    * -p：主機端口映射到容器内端口
    * -v：<mark>/宿主機資料夾路徑:容器內的資料夾</mark>&nbsp;&nbsp;&nbsp;←使用此方法可以將資料永久保存(前方一定要加上 <mark>/</mark> 或是 <mark>./</mark>不然會被視為是數據卷)
        * 第二種 - 數據卷 掛載方式
            ```Dockerfile
                docker volume create 創建的名稱

                #執行docker run命令的時候 : 的左方不用寫路徑  直接寫剛剛創建的名稱
                docker run -d -v 上方創建的名稱:容器內的資料夾 運行的鏡像

                #查詢卷掛載的目錄位置
                docker volume inspect 剛剛創建的名稱

                #查詢所有的卷
                docker volume ls

                #刪除指定的卷
                docker rm 名稱

                #刪除所有沒有任何容器在使用的卷
                docker volume prune -a
            ```

2. image名稱結構：
    * Reository：TAG
    * image名稱：版本(對應上方)

3. 常見命令：
    * docker pull：拉取鏡像
    * docker images：查看有哪些鏡像
    * docker rmi imageName：移除指定的鏡像
    * docker build：構建鏡像
    * docker save：打包鏡像
    * docker load：將包加載為鏡像
    * docker push：將製作好的鏡像推送到DockerHub
    * docker run imageName：運行指定的鏡像
    * docker stop 容器ID：停止指定的容器
    * docker start 容器ID：繼續運行指定的容器
    * docker rm 容器ID：移除指定的容器
    * docker exec -it 容器名稱 bash：進入指定的容器 並使用終端bash shell操作

4. Dockerfile
    1. Dockerfile沒有副檔名
    2. 撰寫Dockerfile
        ```Dockerfile
            FROM 要使用的鏡像

            #類似Linux的cd指令
            WORKDIR /目錄名稱

            #第一個點表示撰寫時的當前目錄
            #第二個點表示WORKDIR的目錄
            COPY . .

            #此命令是在鏡像中執行
            RUN 要執行的命令

            #CMD命令最好寫成陣列形式 ["命令","命令"]
            #一個Dockerfile文件只能寫一個CMD命令
            CMD 容器啟動時執行的命令
        ```
    3. Dockerfile的常見指令:

        |指令|說明|示範|
        |:---:|:---:|:---:|
        |FROM|指定鏡像|FROM 鏡像名:版本|
        |ENV|設定環境變數,可在後面指令使用|ENV key=value|
        |COPY|複製本地檔案到鏡像的指定資料夾|COPY ./jdk17.tar.gz /tmp|
        |RUN|執行Linux的shell指令,通常是安裝過程的指令|RUN tar -zxvf /tmp/jdk17.tar.gz|
        |EXPOSE|指定容器運行時的監聽端口,給鏡像使用者看的|EXPOSE 8080|
        |ENTRYPOINT|鏡像中的app的啟動命令,容器運行時使用|ENTRYPOINT java -jar 檔名.jar|

    4. 創建鏡像
        ```cli
            //鏡像名稱後方可以加上版本號 最後的 點 是指在當前目錄創建
            docker build -t <鏡像名:版本> 鏡像名稱 .
        ```
5. Docker network

    |指令|說明|
    |:---:|:---:|
    |docker network create|創建一個網路|
    |docker network ls|查看所有網路|
    |docker network rm|刪除指定網路|
    |docker network prune|清除未使用的網路|
    |docker network connect|容器連線指定網路|
    |docker network disconnect|容器斷開指定網路|
    |docker network inspect|查看網路詳細訊息|

6. 將自訂的鏡像推送到DockerHub
    1. 先登入DockerHub
        ```
            docker login
        ```
    2. 會得到一個驗證碼 還有一個網址 將驗證碼填入網站後成功登入
    3. 推送自己的鏡像時需要加上自己的用戶名稱
        ```
            docker build -t DockerHubUserName/鏡像名稱 .
        ```
    4. 將鏡像推送到DockerHub
        ```
            docker push DockerHubUserName/鏡像名稱
        ```
    5. 推送成功後在[DockerHub](https://hub.docker.com)搜尋 <mark>DockerHubUserName/鏡像名稱</mark> 就可以搜尋到自己的鏡像

    6. 補充：鏡像可以直接使用指令來搜尋
        ```
            docker search java

            只搜尋官方的鏡像結果
            docker search java --filter "is-official=true"

            如果不想每次搜尋官方鏡像都打這麼長的話
            可以將別名寫進.bashrc的檔案內
            alias dso='docker search --filter "is-official=true"'

            下次搜尋時指令如下
            dso java
        ```
7. DockerCompose - 通過docker-compose.yml來定義一組容器,幫助實現多個相互關聯的Docker容器快速部屬
    1. 撰寫yml配置文件 yam文件的 <mark>:</mark> 符號後面都要有空格 不然會報錯

        ```yml
            services:
                mysql:
                    # 鏡像
                    image:mysql:8

                    # 容器名稱
                    container_name:mysql

                    # 端口
                    port:
                        - "3307:3306"

                    # 環境變數
                    environment:
                        TZ: Asiz/Taipei
                        MYSQL_ROOT_PASSWORD: 321321321

                    # 卷
                    volumes:
                        - "自訂的本地路徑:/etc/mysql/conf.d"
                        - "自訂的本地路徑:/var/lib/mysql"
                        - "自訂的本地路徑:/docker-entrypoint-initb.d"

                    # 網路
                    network:
                        - my-web
                java-backend:
                    build:
                        context: .
                        dockerfile: Dockerfile
                    container_name: backend-server
                    ports:
                        - "9090:9090"
                    networks:
                        - my-web

                    # 等待mysql部屬完畢後才部屬
                    depends_on:
                        - mysql
                nginx:
                    image: nginx:1.28.0
                    container_name: fontend-nginx
                    ports:
                        - "80:80"
                    volumes:
                        - "自訂的本地目錄:/etc/nginx/nginx.conf"
                        - "自訂的本地目錄:/usr/share/nginx/html"
                    # 等待java-backend部屬完畢後才部屬
                    depends_on:
                        - java-backend
                    networks:
                        - my-web
            networks:
                my-web:
                    name:自訂的網路
        ```

    2. 所有指令都是 <mark>docker compose</mark> 開頭 後面接Options或Commands
        * Options
            |參數|說明|
            |:---:|:---:|
            |-f|指定compose文件的路徑和名稱|
            |-p|指定project名稱|
            |-d|後台運行|
        * Commands
            |指令|說明|
            |:---:|:---:|
            |up|創建並啟動所有service容器|
            |down|停止並移除所有容器及網路|
            |ps|列出所有啟動的容器|
            |logs|查看指定容器的Log|
            |stop|停止容器|
            |stars|啟動容器|
            |restart|重啟容器|
            |top|查看運行的進程|
