package com.liyang.aclservice.service;

import com.alibaba.fastjson.JSONObject;
import com.liyang.aclservice.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 权限 服务类
 * </p>
 *
 * @author liyang
 * @since 2021-05-07
 */
public interface PermissionService extends IService<Permission> {

    //获取全部菜单
    List<Permission> queryAllMenu();

    //获取全部菜单（递归）
    List<Permission> queryAllMenuEone();

    //根据角色获取权限菜单
    List<Permission> selectAllMenu(String roleId);

    //递归删除菜单
    void removeChildById(String id);

    //递归删除菜单（递归）
    void removeChildByIdEone(String id);

    //根据用户id获取用户菜单
    List<String> selectPermissionValueByUserId(String id);
    List<JSONObject> selectPermissionByUserId(String id);

    //给角色分配权限（重建）
    void saveRolePermissionRealtionShip(String roleId, String[] permissionId);

    //给角色分配权限（添加）
    void saveRolePermissionRealtionShipEone(String roleId, String[] permissionId);
}
