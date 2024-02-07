package com.example.mall.repository;

import com.example.mall.constant.GoodsCategory;

import com.example.mall.constant.GoodsStatus;
import com.example.mall.POJO.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GoodsRepository extends JpaRepository<Goods, Long> {


    @Query("select distinct g from Goods g where g.Id = ?1")
    Goods findOneById(Long id);


    @Query("select g from Goods g where g.seller.Id = ?1 and g.goodsCurrStatus <> ?2")
    Page<Goods> findAllGoodsBySeller(Long sellerId, GoodsStatus goodsStatus , Pageable pageable);


    Page<Goods> findAllByGoodsCurrStatus(GoodsStatus goodsCurrStatus, Pageable pageable);



    @Query("select g from Goods g where g.category = ?1 and g.goodsCurrStatus = ?2")
    Page<Goods> findAllByCategory(GoodsCategory category, GoodsStatus goodsCurrStatus, Pageable pageable);


    @Query("select g from Goods g where g.goodsName like %?1%")
    Page<Goods> fuzzySearchByGoodsName(String id, Pageable pageable);
}
