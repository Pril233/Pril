package com.how2java.tmall.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.pojo.PropertyValue;

public interface PropertyValueDAO extends JpaRepository<PropertyValue,Integer>{

    List<PropertyValue> findByProductOrderByIdDesc(Product product);
    //增加通过分类获取所有属性集合的方法
    PropertyValue getByPropertyAndProduct(Property property, Product product);
    //根据产品和属性获取PropertyValue对象

}