# Netrut
基于kotlin的网络请求框架
# 使用方法
## 1.编写网络请求接口
@RequestMapping注解用于绑定请求地址  
绑定在接口上视为BaseUrl
```kotlin
@RequestMapping("http://localhost:8080/")
interface Api {

}
```
## 2.编写请求方法
@Get用于Get请求
@Post用于Post请求
```kotlin
@RequestMapping("http://localhost:8080/")
interface Api {

  @Get("user-info")
  fun sendUserInfo()
  
}
```
## 3.进行入参  
参数可以传入String或者Map  
默认参数名为请求参数  
或者使用@Param自定义参数名  
返回类型必须为Data<>  
泛型为String将直接返回RequestBody  
泛型为Json将封装为Json对象
```kotlin
interface Api {

  @Get("user-info")
  fun sendUserInfo(@Param("user") user:String):Data<String>
  
  @Post("user-info")
  fun sendUserInfo(map: Map<Any, Any>):Data<Json>
  
}
```
## 4.初始化接口
```kotlin
Netrut.create<Api>()
```
## 5.异步调用发送网络请求
```kotlin
val create = Netrut.create<Api>()
    create.postUser(
        hashMapOf(
            "user" to "123",
            "password" to "123456"
        )
    ).success {
        println(it)
    }.error{
        println(it.message)
    }
```
