# <center>logback.xml</center>

### 取代System.out.print
```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <configuration>
        <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
            <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
                <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} - %msg%n</pattern>
            </encoder>
        </appender>
        <root level="info">
            <appender-ref ref="STDOUT"/>
        </root>
    </configuration>
```

### 寫入檔案
```xml
    <configuration>
        <appender name="FILE" class="ch.qos.logback.core.FileAppender">
            <file>${USER_HOME}/myApp.log</file>
            <encoder>
                <pattern>%msg%n</pattern>
            </encoder>
        </appender>
        <root level="info">
            <appender-ref ref="FILE" />
        </root>
    </configuration>
```
