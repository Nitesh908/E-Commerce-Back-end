package com.example.mall.repository;

import com.example.mall.POJO.Goods;

import com.example.mall.POJO.Orders;
import com.example.mall.constant.GoodsStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrdersRepository extends JpaRepository<Orders, String> {

    @Query("select o from Orders o where o.user.Id = ?1")
    Page<Orders> findOrdersByUserId(Long userId,Pageable pageable);


    @Query("select o from Orders o where o.seller.Id = ?1 and o.orderStatus <> 'CREATING' and o.orderStatus <> 'CREATE_FAILED'")
    Page<Orders> findOrdersBySellerId(Long sellerId,Pageable pageable);

    @Query("select distinct o from Orders o where o.Id = ?1")
    Orders findOneById(String id);

}
