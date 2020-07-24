package com.nuoyan.globalexception.model;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class User {
    @NotNull(message = "用户id不能为空")
    private int id;
    @NotNull(message = "用户名不能为空")
    private String name;
    private int age;
}
