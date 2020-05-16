package com.how2java.tmall.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Property;

public interface PropertyDAO extends JpaRepository<Property,Integer>{
    Page<Property> findByCategory(Category category, Pageable pageable);
    //根据分类进行查询
    //jpa 的规范，对于条件查询可以按照这种方式来开发
    //怎么实现？去读源码哈哈哈哈
}
