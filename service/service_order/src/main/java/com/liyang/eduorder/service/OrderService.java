package com.liyang.eduorder.service;

import com.liyang.eduorder.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author liyang
 * @since 2021-05-20
 */
public interface OrderService extends IService<Order> {

    //1 生成订单的方法
    String createOrders(String courseId, String memberIdByJwtToken);
}
