### Filter  啟動類要加上@ServletComponentScan
```Java
    @Slf4j
    @WebFilter(urlPatterns = "/*") //連結所有請求
    public class DemoFilter implements Filter {
        //初始化方法 web伺服器啟動時執行 只執行一次
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            log.info("init 初始化方法...");
        }

        //攔截到請求後執行 會執行多次
        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            log.info("攔截到了請求...");

            //放行
            filterChain.doFilter(servletRequest,servletResponse);
        }

        //銷毀方法 web伺服器關閉時執行 只執行一次
        @Override
        public void destroy() {
            log.info("destroy 銷毀方法...");
        }
    }
```

### Interceptor
1. Interceptor

    ```Java
        @Slf4j
        @Component
        public class DemoInterceptor implements HandlerInterceptor {
            //在目標資源方法運行之前運行 - 返回值:true放行,false不放行
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                log.info("preHandle...");
                return true;
            }

            //在目標資源方法運行後運行
            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
                log.info("postHandle...");
            }

            //視圖渲染完畢後執行
            @Override
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
                log.info("afterCompletion...");
            }
        }
    ```

2. 配置類

    ```Java
        @Configuration
        public class WebConfig implements WebMvcConfigurer {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new DemoInterceptor()).addPathPatterns("/**");
            }
        }
    ```

### 文件上傳
* 前端頁面<br>
>
    1. 方法一定要是post , 如果是get會限制大小
    2. enctype="multipart/form-data" 不能少 , 沒寫的話文件的內容不會上傳
    3. 類型是file , name的值要跟後端變數對上

```html
    <form action="/upload" method="post" enctype="multipart/form-data">
        姓名:<input type="text" name="name"><br>
        年齡:<input type="text" name="age"><br>
        照片:<input type="file" name="file"><br>
        <input type="submit" value="送出">
    </form>
```

* 後端頁面<br>
>
    1. 接收文件類型是MultipartFile  變數要跟前端name內的值一樣

```Java
    @Slf4j
    @RestController
    public class UploadController {
        @PostMapping("/upload")
        public Result upload(String name, Integer age, MultipartFile file){
            log.info("傳入的值:{},{},{}",name,age,file);
            return Result.success();
        }
    }
    ```
