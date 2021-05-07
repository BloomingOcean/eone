package com.liyang.aclservice.controller;

import com.liyang.aclservice.entity.User;
import com.liyang.aclservice.service.RoleService;
import com.liyang.aclservice.service.UserService;
import com.liyang.commonutils.MD5;
import com.liyang.commonutils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/acl/user")
@Api("用户管理")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @ApiOperation("添加管理用户")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Result save(@ApiParam("用户信息") @RequestBody User user) {
//        user.setPassword(MD5.encrypt(user.getPassword()));
        if (userService.save(user)) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }

    @ApiOperation("修改管理用户")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result updateById(@ApiParam("用户信息") @RequestBody User user) {
        userService.updateById(user);
        return Result.ok();
    }

    @ApiOperation(value = "删除管理用户")
    @RequestMapping(value = "/remove/{id}",method = RequestMethod.DELETE)
    public Result remove(@ApiParam("用户ID") @PathVariable String id) {
        userService.removeById(id);
        return Result.ok();
    }

    @ApiOperation(value = "根据id列表删除管理用户")
    @RequestMapping(value = "/batchRemove",method = RequestMethod.DELETE)
    public Result batchRemove(@ApiParam("用户ID集合") @RequestBody List<String> idList) {
        userService.removeByIds(idList);
        return Result.ok();
    }

    @ApiOperation(value = "根据用户获取角色数据")
    @RequestMapping(value = "/toAssign/{userId}",method = RequestMethod.GET)
    public Result toAssign(@ApiParam("用户ID") @PathVariable String userId) {
        Map<String, Object> roleMap = roleService.findRoleByUserId(userId);
        return Result.ok().data(roleMap);
    }

    @ApiOperation(value = "根据用户分配角色")
    @RequestMapping(value = "/doAssign",method = RequestMethod.POST)
    public Result doAssign(@ApiParam("用户ID") @RequestParam String userId,
                           @ApiParam("角色ID") @RequestParam String[] roleId) {
        roleService.saveUserRoleRealtionShip(userId, roleId);
        return Result.ok();
    }
}
