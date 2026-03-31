# API測試工具
* [Postman](https://www.postman.com/) - 需註冊 + 下載 Postman-Agent
* Google瀏覽器插件 - [API Tester](https://chromewebstore.google.com/detail/talend-api-tester-free-ed/aejoelaoggembcahagimdiliamlcdmfm?hl=en-US&utm_source=ext_sidebar)
* 

# 設定檔
### application.properties MySQL
```properties
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.url=jdbc:mysql://localhost:<port>/<database name>
    spring.datasource.username=<user name>
    spring.datasource.password=<password>
```

### application.yml MySQL
```yml
    spring:
        datasource:
            driver-class-name: com.mysql.cj.jdbc.Driver
            url:
            username:
            password:
```

### pom.xml
```xml
    <!-- 資料庫 -->
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
    </dependency>
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>3.0.4</version>
    </dependency>

    <!-- Bean撰寫 -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>

    <!-- 參數正則表達式 使用時在參數型別左方加入@Pattern(regexp = "規則") 該類上方也要加入@Validated-->
    <!-- 或是直接在JavaBean的參數上方加 @要使用的規則 如:(NotEmpty,NotNull,JsonIgnore,Email,JsonFormat,等等...) -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>

    <!-- JWT -->
    <dependency>
        <groupId>com.auth0</groupId>
        <artifactId>java-jwt</artifactId>
        <version>4.4.0</version>
    </dependency>

    <!-- 單元測試 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
```

# Java JWT 使用
1. 產生Token
    ```Java
        //定義一個要儲存的資訊放入Map
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("username","Geo");
        String token = JWT.create() //建立JWT物件
            .withClaim("user",claims) //將儲存的資訊放入名為user的Claim中
            .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*12)) //單位：毫秒 設定當前時間+12小時
            .sign(Algorithm.HMAC256("mywebproject")); //使用HMAC256演算法與自訂密鑰簽署token
    ```
2. 驗證Token
    ```Java
        //模擬使用者傳遞的JWT字串
        String token = "Token";

        //建立JWT驗證器，指定使用的密鑰與加密演算法
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("myWebProject")).build();

        //驗證並解析 token，若驗證失敗會拋出異常
        DecodedJWT decodedJWT = jwtVerifier.verify(token);

        //取得所有Claims（聲明），這裡是從 payload 中解析出來的資料
        Map<String, Claim> claimMap = decodedJWT.getClaims();

        //印出名為 "user" 的 Claim 內容
        System.out.println(claimMap.get("user"));
    ```

# Bean註冊
| 注解          | 說明             | 位置             |
|-------------|----------------|----------------|
| @Component  | 聲明bean的基本註解    | 不屬於以下三種時用此註解   |
| @Controller | @Component衍生註解 | 標注在控制類上        |
| @Service    | @Component衍生註解 | 標注在業務類上        |
| @Repository | @Component衍生註解 | 標注在數據訪問類上(用的少) |

<hr>

# Aspect Oriented Programming (面向方向程式)

### pom.xml AOP
```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-aop</artifactId>
    </dependency>
```

### AOP核心概念
|語法|說明|
|---|---|
|@JoinPoint|可以被AOP控制的方法|
|@Advice|重複的邏輯,最終體現為一個方法|
|@PointCut|匹配連接點的條件|
|@Aspect|描述通知與切入點的對應關係|
|@Target|通知所應用的對象|

### 通知類型
|語法|說明|注意事項|
|---|---|---|
|@Around|此註解標注的通知方法在目標前/後都會被執行|1.需調用ProceedingJoinPoint.proceed() <br>讓原始方法執行,其他通知不需要考慮目標方法執行<br>2.返回值必須指定為Object,來接收原始方法的返回值|
|@Before|通知方法在目標前被執行|預設執行的順序依照<mark>類名字母排序</mark><br>加上<mark>@Order(number)</mark> 控制順序 數字小的<mark><b>先</b></mark>執行|
|@After|通知方法在目標方法後被執行,無論是否有異常都會執行|預設執行的順序依照<mark>類名字母排序</mark><br>加上<mark>@Order(number)</mark> 控制順序 數字小的<mark><b>後</b></mark>執行|
|@AfterReturning|返回後通知,通知方法在目標方法後被執行,有異常不執行||
|@AfterThrowing|異常後通知,通知方法發生異常後執行||

### 切入點表達式 - execution
execution 主要根據方法的返回值,包名,類名,方法名,方法參數等來匹配  語法為 :
```Java
    execution(訪問修飾符? 返回值 包名.類名.?方法名(方法參數) throws 異常?)
```
- 其中帶有<mark> ? </mark>的表示可以省略
    1. 訪問修飾符: 可省略 如:(public , protected)
    2. 包名.類名: 可省略
    3. throws 異常: 可省略(是方法上聲明拋出的異常,非實際拋出的異常)

- 可以使用通配符描述切入點
    1. \* : 單個獨立的任意符號,可以通配任意返回值,包名,類名,方法名,任意類型的一個參數,也可以通配包,類,方法名的一部分
    >   execution(* com.*.service.*.update*(*))
    2. \.\. : 多個連續的任意符號,可以通配任意層級的包,或任意類型,任意個數的參數
    >    execution(* com.company<mark>..</mark>DeptService.*(..))

### 切入點表達式 - @annotation
創建一個新的類 方法上加入
> @Around("@annotation(包名.<mark>類名</mark>)")

要切入的方法上方加入上方宣告的類名
> @<mark>類名</mark>

### JoinPoint joinPoint
- 獲取對象
    ```Java
        Object targetjoinPoint.getTarget();
    ```
- 獲取目標類
    ```
        String className = joinPoint.getTarget().getclass().getName();
    ```
- 獲取方法名
    ```
        String methodName = joinPoint.getSignature().getName();
    ```
- 獲取目標方法參數
    ```
        Object args = joinPoint.getArgs()
    ```

### 事務管理四大特性(ACID)
|原子性(Atomicity)|一致性(Consistency)|隔離性(Isolation)|持久性(Durability)|
|:---:|:---:|:---:|:---:|
|交易是不可分割的最小單元只能全部成功或是全部失敗|交易完成時必須所有資料都保持一致|資料庫提供的隔離機制保證交易在不受外部併發操作影響的獨立環境下運行|一旦成功或是回滾對資料庫中的資料改變就是永久的|

### ThreadLocal
1. ThreadLocal不是Thread 而是Thread的局部變數
2. ThreadLocal為每個線程提供一份單獨的儲存空間 有隔離效果 不同的線程不會相互干擾
3. ThreadLocal常用方法：
```Java
    public void set(T value)  //設定當前線程的線程局部變數的值

    public T get() //返回當前線程所對應的線程局部變數的值

    public void remove() //印出當前線程的線程局部變數
```

### 工具類 - SHA-256雜湊演算
```Java
    public class ShaUtil {
        public static String getSHA256(String str) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                md.update(str.getBytes());
                byte[] digest = md.digest();
                return new BigInteger(1, digest).toString(16).toUpperCase();
            } catch (NoSuchAlgorithmException e) {
                System.err.println("無法建立 SHA-256 雜湊實例：" + e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }
```

### 火狐F12使用測試工具
1. JSON格式需要設定Headers
```Headers
    Content-type:application/json
```
傳送格式為
```JSON
    {
        "Key":"Value",
        "Key":"Value"
    }
```

2. x-www-form-urlencoded Headers 格式設定
```Headers
    Content-Type: application/x-www-form-urlencoded
```
傳送格式為
```x-www-form-urlencoded
    username=testuser&password=123456
```

# Interceptor 攔截器
* interceptors包
```Java
    @Component
    public class LoginInterceptor implements HandlerInterceptor {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            String token = request.getHeader("Authorization");
            try{
                Map<String,Object> claims = JwtUtil.parseToken(token);
                return true;
            }catch (Exception e){
                response.setStatus(401);
                return false;
            }
        }
    }
```

* config包
```Java
    @Configuration
    public class WebConfig implements WebMvcConfigurer {
        @Autowired
        private LoginInterceptor loginInterceptor;

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(loginInterceptor).excludePathPatterns("/user/login","/user/register");
        }
    }
```

* exceprion包
```Java
    @RestControllerAdvice
    public class GlobalExceptionHandler {
        @ExceptionHandler(Exception.class)
        public Result handleException(Exception e){
            e.printStackTrace();
            return Result.error((StringUtils.hasLength(e.getMessage()) ? e.getMessage() : "操作失敗"));
        }
    }
```

# MyBatis Bean底線命名to駝峰命名
application.yml
```yml
    mybatis:
        configuration:
            map-underscore-to-camel-case: true
```

# ThreadLocal - util包
1. 用於存取資料
2. 使用完畢一定要用 remove 方法釋放
```Java
    public class ThreadLocalUtil {
        private static final ThreadLocal THREAD_LOCAL = new ThreadLocal<>();

        public static <T> T get(){
            return (T) THREAD_LOCAL.get();
        }

        public static void set(Object value){
            THREAD_LOCAL.set(value);
        }

        public static void remove(){
            THREAD_LOCAL.remove();;
        }
    }
```

# Redis
application.xml
```yml
    spring:
        data:
            redis:
                host: localhost
                port: 6379
```

pom.xml
```xml
    <!-- Redis -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-redis</artifactId>
    </dependency>
```

Method
```Java
    public void testSet(){
        ValueOperations<String,String> operations = stringRedisTemplate.opsForValue();
        operations.set("username","admin");
        operations.set("id","1",15,TimeUnit.SECONDS);
    }

    public void testGet(){
        ValueOperations<String,String> operations = stringRedisTemplate.opsForValue();
        System.out.println(operations.get("username"));
    }
```

# 打包jar的插件
```xml
        <build>
            <plugins>
                <plugin>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-maven-plugin</artifactId>
                    <configuration>
                        <excludes>
                            <exclude>
                                <groupId>org.projectlombok</groupId>
                                <artifactId>lombok</artifactId>
                            </exclude>
                        </excludes>
                    </configuration>
                </plugin>
            </plugins>
        </build>

```

Maven 常用指令
```cli
    # 打包成jar檔
    mvn package

    # 打包成jar檔 跳過測試 並且會清除舊檔 再編譯打包
    mvn clean package -DskipTests

    # 清除舊的build
    mvn clean
```

# 多環境開發
### < 方法一 > 單文件配置 
application.yml 不同設定以 <mark> --- </mark> 做區隔
```yml
    # 指定生效的環境
    spring:
        profiles:
            active: dev

    # 共同的屬性
    server:
        servlet:
            context-path: /abc

    ---

    # 開發環境
    spring:
        config:
            activate:
                on-profile: dev
    server:
    port: 8081

    ---

    # 測試環境
    spring:
        config:
            activate:
                on-profile: test
    server:
    port: 8082

    ---

    # 用戶環境
    spring:
        config:
            activate:
                on-profile: pro
    server:
    port: 8083

```

---

### < 方法二 > 多文件配置
resources 內會有多個配置文件<br>
使用 application.yml 設定要使用的配置
```yml
    spring:
        profiles:
            active: test
```

* 其他配置
    1. application-dev.yml
    2. application-test.yml
    3. application-pro.yml
