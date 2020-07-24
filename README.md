# global-exception
Use Assert Capture Exception
> 感谢 巨人的思路 [链接](https://www.cnblogs.com/jurendage/p/11255197.html)
- SpringBoot 2.2.6
- javax.validation 2.0.2
-------------------------------------------------------------------------

#### Feature 

> `@Valid` 接口参数的默认检查 
```java
@NotNull(message = "用户名不能为空") 
private String name;
```

```java
public boolean insert(@RequestBody @Valid User user) {
    log.info("开始新增用户.. {}",user.toString());
    return true;
}
```
> 全局异常错误捕获,以及使用断言 `Assert` 方式进行 异常判断与捕获, 基本抛弃 `if ... throw new Exception` 或者 `try {} catch{} finally{}`