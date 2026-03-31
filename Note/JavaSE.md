# 反射(Reflection)

| 獲取                | 使用    |      |      |        |
|-------------------|-------|------|------|--------|
| 獲取類物件(Class)      |       |      |      |        |
| 構造方法(Constructor) | 獲取修飾符 | 獲取名字 | 獲取類型 | 賦值/獲取值 |
| 成員變數(Field)       | 獲取修飾符 | 獲取名字 | 獲取型參 | 創建物件   |
| 成員方法(Method)      | 獲取修飾符 | 獲取名字 | 獲取型參 | 獲取返回值  |
| 成員方法(Method)      | 拋出的異常 | 獲取註解 | 運行方法 |        |

### 獲取類的方法
1.
    ```Java
        Class class1 = Class.forName("完整的類名");
    ```
2.
    ```Java
        Class class2 = 類名.class;
    ```
3.
     ```Java
         類名 變數 = new 類名();
         Class class3 = 變數.getClass();
     ```
   
### 獲取構造方法
1.
   ```Java
      //只能獲取public構造方法
      Constructor<?>[] 變數 = Class的變數.getConstructors();
   ```
2.
   ```Java
      //可以獲取全部的構造方法
      Constructor<?>[] 變數 = Class的變數.getDeclaredConstructors();
   ```
3.
   ```Java
      //只能獲取public構造方法
      Constructor<T> 變數 = Class的變數.getConstructor(Class<?>...parameterTypes);
      Object o = 變數.newInstance();
   ```
4.
   ```Java
      //可以獲取全部的構造方法
      Constructor<T> 變數 = Class的變數.getDeclaredConstructor(Class<?>...parameterTypes);
      Object o = 變數.newInstance();
   ```

### 獲取修飾符
```Java
    //方法:getModifiers()
    //public static final int 
    ABSTRACT = 1024
    FINAL = 16
    INTERFACE = 512
    PIRVATE = 2
    PROTECTED = 4
    PUBLIC = 1
    STATIC = 8
```

### 創建一個實例物件
```Java
    //newInstance() 填入的參數必須跟當前構造函數一致
    //如果是private 必須加上setAccessible(true)才能獲取
    Constructor<?> 變數 = persionClass.getDeclaredConstructor(String.class,int.class);
    變數.setAccessible(true);
    Student andy = (Student)變數.newInstance("Andy", 18);
```

### 獲取成員變數
1.
   ```Java
      //getFields() 只能獲取public成員變數
      Class<?> 變數 = Class.forName("完整的類名");
      Field[] fields = 變數.getFields();
      for(Field field : fields){
          field.setAccessible(true);
          String name = field.getName();//getName()方法取得變數名稱
      }
   ```

2.
   ```Java
      //getDeclaredFields() 可以獲取所有成員變數
      Class<?> 變數 = Class.forName("完整的類名");
      Field[] fields = 變數.getDeclaredFields();
      for(Field field : fields){
          field.setAccessible(true);
          String name = field.getName();//getName()方法取得變數名稱
      }
   ```

3.
   ```Java
      //getField(要獲取的成員變數) 獲取一個public成員變數
      Class<?> 變數 = Class.forName("完整的類名");
      Field gender = 變數.getField("要獲取的成員變數");
   ```
  
4.
   ```Java
      //getDeclaredField(要獲取的成員變數) 獲取一個private成員變數
      Class<?> 變數 = Class.forName("完整的類名");
      Field gender = 變數.getDeclaredField("要獲取的成員變數");
   ```
   
### 獲取成員變數的值
```Java
    Class 變數 = obj.getClass();
    Field[] fields = 變數.getDeclaredFields();
    for(Field field : fields){
        field.setAccessible(true);
        Object value = field.get(obj);//get()方法取得value
    }
```
   
### 獲取成員方法
1.
   ```Java
      //getMethods() 獲取所有的public方法(包含父類中所有的public方法)
      Class<?> 變數 = Class.forName("完整的類名");
      Method[] methods = 變數.getMethods();
   ```

2.
   ```Java
      //getDeclaredMethods() 獲取所有的方法(不能獲取父類,但可以獲取私有方法)
      Class<?> 變數 = Class.forName("完整的類名");
      Method[] methods = 變數.getDeclaredMethods();
   ```

3.
   ```Java
      //getMethod("要獲取的方法",類別.class) 獲取一個指定方法
      Class<?> 變數 = Class.forName("完整的類名");
      Method[] methods = 變數.getMethod();
   ```
   
4.
   ```Java
      //getDeclaredMethod("要獲取的方法",類別.class) 獲取一個指定方法(可取得private)
      Class<?> 變數 = Class.forName("完整的類名");
      Method[] methods = 變數.getDeclaredMethods();
   ```

### 方法運行
* Object invoke(Object obj, Object...args)
* 參數一 : 用obj物件調用該方法
* 參數二 : 調用方法傳遞的參數(沒有就不寫)
* 返回值 : 方法的返回值(沒有就不寫)

```Java
    Method 變數 = persionClass.getDeclaredMethod("要調用的方法名稱", 型別.class);
    Student s = new Student();//創建一個Student的物件
    變數.setAccessible(true);//如果方法是private 加上這行才能獲取
    變數.invoke(s,"要傳遞的參數");//如果有返回值的話用Object接收
```