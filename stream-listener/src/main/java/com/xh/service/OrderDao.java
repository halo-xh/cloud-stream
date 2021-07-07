package com.xh.service;

import com.xh.pojo.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderDao  extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {
}
