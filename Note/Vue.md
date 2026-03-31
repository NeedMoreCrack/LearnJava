# <center>Vue</center>

[Element Plus](https://element-plus.org/en-US) - A Vue 3 based component library for designers and developers

[Vue Router](https://router.vuejs.org/) - The official Router for Vue.js

### VsCode 插件安裝
- Vue - Official
- Vue Emmet

### 創建專案
> npm create vue@版本號

### 創建好後出現
> cd 剛剛創建的專案名<br>
npm install<br>
npm run dev

### main.js中加入
> import { createApp } from 'vue'<br>
import ElementPlus from 'element-plus'<br>
import 'element-plus/dist/index.css'<br>
import App from './App.vue'<br><br>
const app = createApp(App)<br><br>
app.use(ElementPlus)<br>
app.mount('#app')

### 啟動專案
> npm run dev

### 啟動專案時如果出現下列錯誤
> error when starting dev server:<br>
Error: listen EACCES: permission denied ::1:5173<br>
    at Server.setupListenHandle [as _listen2] (node:net:1882:21)<br>
    at listenInCluster (node:net:1961:12)<br>
    at GetAddrInfoReqWrap.doListen [as callback] (node:net:2135:7)<br>
    at GetAddrInfoReqWrap.onlookup [as oncomplete] (node:dns:111:8)

### 解決方法
> 1.先判斷是否是埠佔用的問題導致的
```netstat -ano| findstr 5173```
發現並沒有程式在使用這個埠<br>
2.改用管理員再運行一遍  發現仍然不行<br>
3.使用管理員許可權運行以下命令<br>
```netsh winsock reset```<br>
```netsh int ip reset all```<br>
```netsh winhttp reset proxy```<br>
```ipconfig /flushdns```<br>
4.如果不想每次都執行命令的話 可以弄一個batch<br>
```batch
    @echo off
    echo restart WinNAT service...
    netsh winsock reset
    netsh int ip reset all
    netsh winhttp reset proxy
    ipconfig /flushdns
    echo done.
    pause
```


### 如果不想在網頁下方看見Toggle Vue DevTools的圖示
修改vite.config.js
```JavaScript
    export default defineConfig({
    plugins: [
        vue()
        // vueDevTools(),   <= 把這行註解掉
    ],
    resolve: {
        alias: {
        '@': fileURLToPath(new URL('./src', import.meta.url))
        },
    },
    })
```

### Icon使用
```
    //終端安裝
    npm install @element-plus/icons-vue

    //註冊所有Icons  main.js
    import * as ElementPlusIconsVue from '@element-plus/icons-vue'

    const app = createApp(App)
    for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
        app.component(key, component)
    }
```

### Vue常用指令
|指令|作用|
|:---:|---|
|v-for|列表渲染,迴圈容器的元素或是對象的屬性|
|v-bind|為HTML綁定屬性,例如 設定 href , CSS等|
|v-if/v-else-if/v-else|條件性的渲染某元素,為true時渲染|
|v-show|根據條件展示某元素,區別在用切換的是display屬性的值|
|v-model|在表單元素上創建雙向資料的綁定|
|v-on|為HTML標籤綁定事件|

### 手動加入Router設定
```JavaScpipt
    //終端機 當前專案資料夾
    npm install vue-router@4

    // 新增index.js => src/router/index.js
    //加入以下文字
    import { createRouter, createWebHistory } from 'vue-router'

    const router = createRouter({
        history: createWebHistory(import.meta.env.BASE_URL),
        routes: [

        ]
    })

    export default router

    //main.js 加入下方兩行
    import router from './router'

    app.use(router)
```

### 假資料生成API測試網站
- [Mocky](https://designer.mocky.io/design)

### Axios - [Axios API](https://axios-http.com/docs/api_intro)
```JavaScript
    //需先在專案內安裝
    npm install axios

    //新增 utils/request.js

    import axios from 'axios'

    const request = axios.create({
        baseURL:'網址固定的部分',
        timeout:60000
    })

    request.interceptors.response.use(
        (response) => {
            return response.date
        },
        (error) => {
            return Promise.reject(error)
        }
    )
    export default request

    //Axios簡短寫法
    axios.get('URL').then((result) => {

    }).catch((error) => {

    })
```

### request.js 攔截器設定
```JavaScript
    import axios from "axios";
    import { ElMessage } from "element-plus";
    import { useTokenStore } from "@/stores/token";

    const baseURL = '/api';
    const instance = axios.create({baseURL})


    //請求攔截器
    instance.interceptors.request.use(
        config => {
            const tokenStore = useTokenStore();
            if(tokenStore.token){
                config.headers.Authorization = tokenStore.token
            }
            return config;
        },
        error => {
            return Promise.reject(error)
        }
    )

    //響應攔截器
    instance.interceptors.response.use(
        result => {
            if(result.data.code === 0){
                return result.data;
            }

            ElMessage.error(result.data.msg ? result.data.msg : '服務異常');
            return Promise.reject(result.data);
        },
        error => {
            ElMessage.error('服務異常');
            return Promise.reject(error);
        }
    )

    export default instance;
```

### vite.config.js設定 請求後端服務訊息
```JavaScript
    //跟resolve同一層
    server:{
        proxy:{
            '/api':{//加上api表示請求後端
                target:'http://localhost:9090',//寫後端Tomcat連線的URL+port
                secure:false,
                changeOrigin: true,
                rewrite:(path) => path.replace(/^\/api/,''),
            }
        }
    }
```

### 表單效驗規則(Validation)
```JavaScript
    //將下方這段寫在el-form的右邊
    :rules="rules"

    //增加效驗的規則
    const rules = ref({
        name: [
            { required: true, message: '不得為空白', trigger: 'blur' },
            { min: 2, max: 10, message: '名稱長度必須為2~10', trigger: 'blur' },
        ]
    })

    //新增變數
    const deptFormRef = ref();

    //將下方這段寫在el-form的右邊
    ref="deptFormRef"

    //撰寫通過驗證及不通過處理
    if(!deptFormRef.value) return;
    deptFormRef.value.validate(async(valid) => {//valid = 是否通過驗證
        if(valid){
            const result = await addApi(dept.value);
            if(result.code){
                ElMessage.success('成功');
                dialogFormVisible.value = false;
                search();
            }else{
                ElMessage.error(result.msg);
            }
        }else{
            ElMessage.error('驗證不通過');
        }
    })

    //出現效驗錯誤的訊息後 dialog關閉重開時錯誤訊息還在
    //將下方這段加到dialog觸發的方法內
    if(deptFormRef.value){
        deptFormRef.value.resetFields();
    }

    //清空上次輸入的值
    //要看這一行內的值是什麼  el-input v-model="dept.value"
    dept.value = {name:''};
```

### watch監聽
```JavaScript
    import { watch } from 'vue'

    //一旦監聽的對象有變化  將會觸發
    watch(要監聽的對象,(newVal,oldVal) => {
            console.log(newVal)
            console.log(oldVal)
        },
        {
            //深度監聽  監聽對象內所有的值
            deep:true
        }
    )
```

### 靜態的資源
* 專案下的public 是 Vue 專案中用來放置靜態資源的地方<br>
裡面的東西在打包後，會直接「原樣」輸出到網站根目錄 /

放在 public/image/test.jpg 裡，前端這樣寫：
```html
    <img src="/image/test.jpg" />
```
這樣你開啟網頁時，實際載入的是：
```html
    http://localhost:8080/image/test.jpg
```

### 靜態的資源
* 專案下的public 是 Vue 專案中用來放置靜態資源的地方<br>
裡面的東西在打包後，會直接「原樣」輸出到網站根目錄 /

放在 public/image/test.jpg 裡，前端這樣寫：
```html
    <img src="/image/test.jpg" />
```
這樣你開啟網頁時，實際載入的是：
```html
    http://localhost:8080/image/test.jpg
```

### LocalStorage
* localStorage是瀏覽器提供的本地儲存機制(5MB)
* 儲存的形式是:key-value,key&value都是字串類型
* API方法:
    * localStorage.setItem(key,value)
    * localStorage.getItem(key)
    * localStorage.removeItem(key)
    * localStorage.clear()

```JavaScript
    //設定時  將取得的資料要轉換成JSON格式
    localStorage.setItem('loginUser',JSON.stringify(result.data));

    //取用時  將localStorage中的token設定到hearders中
    request.interceptors.request.use(
        (config) => {
            const loginUser = JSON.parse(localStorage.getItem('loginUser'));
            if(loginUser && loginUser.token){
                config.headers.token = loginUser.token;
            }
            return config
        },
        (error) => {
            return Promise.reject(error)
        }
    )
```

### 使用Router進行頁面跳轉
```JavaScript
    //最上方引入
    import { useRouter } from 'vue-router';

    const router = useRouter();
    router.push('要跳轉的頁面');
```

### 將專案打包部屬

1. 先打包文件

>  npm run build

執行完畢後會出現dist資料夾<br>

2. 下載 [Nginx](https://nginx.org/en/download.html) <br>
Nginx介紹 - 一款輕量級的Web伺服器/反向代理伺服器及電子郵件（IMAP/POP3）<br>
特點是佔RAM少併發能力強

下載完後解壓縮會有下列資料夾及檔案<br>

|名稱|作用|
|:---:|:---:|
|conf|配置文件目錄，內含 nginx.conf 主設定檔及其他子設定檔（如虛擬主機、反向代理等配置）|
|contrib|存放一些額外的模組、第三方插件或範例腳本（視發行版本而定，部分版本可能為空或未使用）|
|docs|說明文件目錄，可能包含 Nginx 的使用手冊、README、授權資訊等。部分版本可能為空|
|html|預設的網頁根目錄，當 Nginx 成功啟動但沒有指定虛擬主機時，會顯示這個資料夾下的 index.html|
|logs|記錄目錄，儲存存取日誌（access.log）與錯誤日誌（error.log），方便除錯與分析|
|temp|暫存目錄，Nginx 用來暫時儲存處理請求時產生的中間檔案（如快取檔案、上傳檔案暫存等）|
|nginx.exe|Nginx 主程式執行檔，雙擊或從命令列啟動它，即可啟動 Nginx 伺服器|

3. 將打包後dist內的檔案加入nginx資料夾中的html資料夾内<br>
還需要設定conf底下的nginx內的nginx.conf

```conf
    server {
        #連線用的port
        listen       90;
        server_name  localhost;
        client_max_body_size 10m;

        location / {
            root   html;
            index  index.html index.htm;
            try_files $uri $uri/ /index.html;
        }

        #看專案內的vite.config.js內是怎麼配置的就怎麼寫
        這邊專案配置的是
        /*
            server:{
                proxy:{
                    '/api':{
                        target:'http://localhost:9090',
                        secure:false,
                        changeOrigin: true,
                        rewrite:(path) => path.replace(/^\/api/,''),
                    }
                }
            }
        */
        location ^~ /api/ {
            rewrite ^/api/(.*)$ /$1 bread;
            proxy_pass http://localhost:9090;
        }

        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
    }
```

### 圖表製作 - [Echarts](https://echarts.apache.org/examples/en/index.html)
```Javascript
    <script setup>
    import { onMounted } from 'vue';
    import * as echarts from 'echarts';

    onMounted(() => {
        //圖表 垂直圖
        var dom1 = document.getElementById('要綁定的ID');
        var myChart = echarts.init(dom1, 'dark', { //沒寫dark的話預設是light
            renderer: 'canvas',
            useDirtyRect: false
        });
        myChart.setOption({
            title:{
                text:'分析圖標題',
                left:'center',
                top:'top',
                textStyle:{
                    fontSize:24,
                    color:'gray'
                }
            },
            xAxis: {
                type: 'category',
                data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    data: [120, 200, 150, 80, 70, 110, 130],
                    type: 'bar'
                }
            ]
        })
        window.addEventListener('resize', myChart.resize);
</script>
```

### Pinia([Official](https://pinia.vuejs.org/introduction.html)) - Pinia is a store library for Vue.

1. install
```cli
    npm install pinia
```

2. main.js
```JavaScript
    import { createPinia } from 'pinia'
    const pinia = createPinia()

    app.use(pinia)
```

3. token.js
```JavaScript
    import { defineStore } from "pinia";
    import { ref } from "vue";

    /*
        第一個參數: 是給狀態取名
        第二個參數: 函數,可以定義該狀態擁有的東西
    */
    export const useTokenStore = defineStore('token',() => {
        const token = ref('')

        const setToken = (newToken) => {
            token.value = newToken
        }

        const removeToken = () => {
            token.value = ''
        }

        return {
            token,setToken,removeToken
        }
    });
```

4. 使用插件將資料儲存 確保網頁刷新後token還在 - [pinia-plugin-persistedstate](https://github.com/prazdevs/pinia-plugin-persistedstate)

```JavaScript
    // 安裝
    npm i pinia-plugin-persistedstate

    // 在main.js 引入
    import { createPinia } from 'pinia'
    import piniaPluginPersistedstate from 'pinia-plugin-persistedstate'

    const pinia = createPinia()
    pinia.use(piniaPluginPersistedstate)

    // 上方的JavaScript defineStore方法加入第三個參數
    ,{
        persist: true
    }
```

### [quilljs](https://quilljs.com/docs/quickstart) - 文本編輯器
