package com.example.mall.repository;

import com.example.mall.POJO.Cart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Integer countCartByUserId(Long userId);

    Page<Cart> findCartByUserId(Long userId, Pageable pageable);

    @Query("select distinct c from Cart c where c.Id = ?1")
    Cart getOneById(Long id);

    @Query("select distinct c from Cart c where c.goodsId=?1 and c.userId=?2")
    Cart getOneByGoodsIdAndUserId(Long goodsId, Long userId);
}
