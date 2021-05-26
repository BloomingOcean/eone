package com.liyang.educenter.controller;


import com.liyang.commonutils.JwtUtils;
import com.liyang.commonutils.Result;
import com.liyang.commonutils.ordervo.UcenterMemberOrder;
import com.liyang.educenter.entity.UcenterMember;
import com.liyang.educenter.entity.vo.RegisterVo;
import com.liyang.educenter.service.UcenterMemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 登录注册API
 * </p>
 *
 * @author liyang
 * @since 2021-05-08
 */
@RestController
@RequestMapping("/educenter/member")
@CrossOrigin
public class UcenterMemberController {

    @Autowired
    private UcenterMemberService memberService;

    //登录
    @PostMapping("login")
    public Result loginUser(@RequestBody UcenterMember member) {
        //member对象封装手机号和密码
        //调用service方法实现登录
        //返回token值，使用jwt生成
        String token = memberService.login(member);
        return Result.ok().data("token",token);
    }

    //注册
    @PostMapping("register")
    public Result registerUser(@RequestBody RegisterVo registerVo) {
        memberService.register(registerVo);
        return Result.ok();
    }

    //根据token获取用户信息
    @GetMapping("getMemberInfo")
    public Result getMemberInfo(HttpServletRequest request) {
        //调用jwt工具类的方法。根据request对象获取头信息，返回用户id
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        //查询数据库根据用户id获取用户信息
        UcenterMember member = memberService.getById(memberId);
        return Result.ok().data("userInfo",member);
    }

    // 根据用户id获取用户信息
    // UcenterMember的“创建时间”和“修改时间”没有自动修改功能(@TableField)
    // UcenterMemberOrder修改或添加时可以自动修改时间
    @PostMapping("getUserInfoOrder/{id}")
    public UcenterMemberOrder getUserInfoOrder(@PathVariable String id) {
        UcenterMember member = memberService.getById(id);
        //把member对象里面值复制给UcenterMemberOrder对象
        UcenterMemberOrder ucenterMemberOrder = new UcenterMemberOrder();
        BeanUtils.copyProperties(member, ucenterMemberOrder);
        return ucenterMemberOrder;
    }

    //查询某一天注册人数
    @GetMapping("countRegister/{day}")
    public Result countRegister(@PathVariable String day) {
        Integer count = memberService.countRegisterDay(day);
        return Result.ok().data("countRegister",count);
    }
}

