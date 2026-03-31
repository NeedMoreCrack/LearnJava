# <center>RabbitMQ</center>

### [RabbitMQ Offical](https://www.rabbitmq.com/)
### [Docker hub - RabbitMQ](https://hub.docker.com/_/rabbitmq)

1. 先以Docker建立環境

```cli
    docker run -d --hostname mq --name rabbitMQ -p 15672:15672 -p 5672:5672 -e RABBITMQ_DEFAULT_USER=<使用者名稱> -e RABBITMQ_DEFAULT_PASS=<設定的密碼> -v mq-plugins:/plugins rabbitmq:3-management
```

2. 容器啟用後 以網頁開啟 http://localhost:15672 登入

3. Admin頁面可以設定使用者

4. Queues and Streams頁面可以新增Queue

5. RabbitMQ Exchange 類型分為四種:
    * Direct Exchange（直連交換機）- 根據 完全匹配的 Routing Key 將消息路由到綁定的隊列

    * Fanout Exchange（扇形交換機）- 不看 Routing Key，直接把消息廣播給所有綁定到此交換機的隊列

    * Topic Exchange（主題交換機）- 根據 通配符規則的 Routing Key 來分發消息

    * Headers Exchange（標頭交換機）- 根據 消息頭 (Headers) 來路由，而不是 Routing Key

6. SpringBoot使用需要先設定pom.xml
    ```xml
         <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.amqp</groupId>
            <artifactId>spring-rabbit</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-amqp</artifactId>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <scope>provided</scope>
        </dependency>
    ```

7. Java程式碼範例
    ```Java
        /* 發送端 */
        import org.junit.jupiter.api.Test;
        import org.springframework.amqp.rabbit.core.RabbitTemplate;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.context.SpringBootTest;

        @SpringBootTest
        class PublisherApplicationTests {
            @Autowired
            private RabbitTemplate rabbitTemplate;

            @Test
            void testSendFanout() {
                String exchangeName = "my.fanout"; //這邊寫的是Exchanges頁面表格中Name的名稱
                String msg = "Type fanout!"; //要傳送的字串
                rabbitTemplate.convertAndSend(exchangeName,null,msg);
            }

            @Test
            void testSendDirect() {
                String exchangeName = "my.direct";
                String msg = "Type fanout!";
                rabbitTemplate.convertAndSend(exchangeName,"blue",msg); //第二個參數是對應Routing key欄位的值
            }

            @Test
            void testSendTopic() {
                String exchangeName = "my.topic";
                String msg = "Type topic test";
                rabbitTemplate.convertAndSend(exchangeName,"china.news",msg);
            }
        }


        /* 接收端 */
        import lombok.extern.slf4j.Slf4j;
        import org.springframework.amqp.rabbit.annotation.RabbitListener;
        import org.springframework.stereotype.Component;

        @Slf4j
        @Component
        public class MqListener {
            @RabbitListener(queues = "my.fanout1") //寫的是Queues and Streams頁面表格中的Name
            public void listenFanout1(String msg){
                log.info("Fanout1 收到訊息: "+msg);
            }

            @RabbitListener(queues = "my.fanout2")
            public void listenFanout2(String msg){
                log.info("Fanout2 收到訊息: "+msg);
            }

            @RabbitListener(queues = "topic.queue1")
            public void listenTopic1(String msg){
                log.info("Topic1 收到訊息: "+msg);
            }

            @RabbitListener(queues = "topic.queue2")
            public void listenTopic2(String msg){
                log.info("Topic2 收到訊息: "+msg);
            }
        }

        /* 以程式碼建立Exchange Queue Binding */
        import org.springframework.amqp.core.Binding;
        import org.springframework.amqp.core.BindingBuilder;
        import org.springframework.amqp.core.FanoutExchange;
        import org.springframework.amqp.core.Queue;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;

        @Configuration
        public class FanoutConfiguration {
            @Bean
            public FanoutExchange fanoutExchange(){
                return new FanoutExchange("topic.queue"); //建立名稱為 topic.queue 的 fanout 類型 Exchange
            }

            @Bean
            public Queue fanoutQueue(){
                return new Queue("fanout.queue"); //建立名稱為 fanout.queue 的 Queue
            }

            @Bean
            public Binding fanoutBinding(Queue fanoutQueue,FanoutExchange fanoutExchange){
                return BindingBuilder.bind(fanoutQueue).to(fanoutExchange); // 將 fanout.queue 綁定到 fanoutExchange
            }
        }
    ```

8. 常見的CLI

    * 使用者與權限管理
    ```
        # 新增使用者
        rabbitmqctl add_user andy 321321321

        # 刪除使用者
        rabbitmqctl delete_user andy

        # 修改密碼
        rabbitmqctl change_password andy newpassword

        # 設定使用者角色 (administrator, monitoring, management, policymaker)
        rabbitmqctl set_user_tags andy administrator

        # 設定使用者權限 (對 vhost 的 configure/write/read 權限)
        rabbitmqctl set_permissions -p / andy ".*" ".*" ".*"

        # 查看使用者清單
        rabbitmqctl list_users
    ```

    * Virtual Host (vhost)
    ```
        # 建立 vhost
        rabbitmqctl add_vhost myvhost

        # 刪除 vhost
        rabbitmqctl delete_vhost myvhost

        # 查看 vhost 列表
        rabbitmqctl list_vhosts -p <Admin頁面表格中的Can access virtual hosts名稱>
    ```

    * Queue / Exchange
    ```
        # 列出所有 Queue
        rabbitmqctl list_queues

        # 列出所有 Exchange
        rabbitmqctl list_exchanges

        # 查看 Queue 詳細資訊 (name, messages_ready, messages_unacknowledged)
        rabbitmqctl list_queues name messages_ready messages_unacknowledged

        # 查看綁定 (queue <-> exchange)
        rabbitmqctl list_bindings
    ```

    * Plugin 管理
    ```
        # 查看已安裝插件
        rabbitmq-plugins list

        # 啟用管理介面 (Web UI)
        rabbitmq-plugins enable rabbitmq_management

        # 停用管理介面
        rabbitmq-plugins disable rabbitmq_management
    ```

    * 監控 / 狀態
    ```
        # 查看整體狀態
        rabbitmqctl status

        # 節點健康檢查
        rabbitmq-diagnostics check_running

        # 查看 cluster 節點
        rabbitmqctl cluster_status

        # 查看連線
        rabbitmqctl list_connections

        # 查看 channel
        rabbitmqctl list_channels
    ```

    * Cluster (進階)
    ```
        # 把某個節點加入 cluster
        rabbitmqctl stop_app
        rabbitmqctl join_cluster rabbit@mq1
        rabbitmqctl start_app

        # 解除 cluster
        rabbitmqctl reset
    ```
