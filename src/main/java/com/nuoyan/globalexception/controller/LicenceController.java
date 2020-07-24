package com.nuoyan.globalexception.controller;

import com.nuoyan.globalexception.exception.BaseException;
import com.nuoyan.globalexception.exception.ResponseEnum;
import com.nuoyan.globalexception.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class LicenceController {
    @PostMapping("/user")
    public boolean insert(@RequestBody User user) {
        log.info("开始新增用户.. {}",user.toString());
        ResponseEnum.LICENCE_NOT_FOUND.assertNotNull(user.getName(),"用户传递参数:", user.toString());
        return true;
    }
    @PutMapping("/user")
    public boolean update(@RequestBody User user) {
        System.out.println("开始更新...");
        //这里故意造成一个空指针的异常，并且不进行处理
        String str=null;
        str.equals("111");
        return true;
    }

    @DeleteMapping("/user")
    public boolean delete(@RequestBody User user)  {
        System.out.println("开始删除...");
        //这里故意造成一个异常，并且不进行处理
        Integer.parseInt("abc123");
        return true;
    }

    @GetMapping("/user")
    public List<User> findByUser(User user) {
        System.out.println("开始查询...");
        List<User> userList =new ArrayList<>();
        User user2=new User();
        user2.setId(1);
        user2.setName("xuwujing");
        user2.setAge(18);
        userList.add(user2);
        return userList;
    }
}
