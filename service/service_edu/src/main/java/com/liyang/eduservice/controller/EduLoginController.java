package com.liyang.eduservice.controller;

import com.liyang.commonutils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eduservice/user")
public class EduLoginController {
    //login
    @PostMapping("login")
    public Result login() {
        return Result.ok().data("token","admin");
    }
    //info
    @GetMapping("info")
    public Result info() {
        return Result.ok().data("roles","[admin]").data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}
