package com.how2java.tmall.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;




@Entity
@Table(name = "category")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
//因为是做前后端分离，而前后端数据交互用的是 json 格式。 那么 Category 对象就会被转换为 json 数据。
// 而本项目使用 jpa 来做实体类的持久化，jpa 默认会使用 hibernate, 在 jpa 工作过程中，就会创造代理类来继承 Category ，
// 并添加 handler 和 hibernateLazyInitializer 这两个无须 json 化的属性，
// 所以这里需要用 JsonIgnoreProperties 把这两个属性忽略掉。
public class Category {


    @Id //声明一个实体类的属性映射为数据库的主键列
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //主键生成策略
    //————————————————
    //@GeneratedValue注解存在的意义主要就是为一个实体生成一个唯一标识的主键、@GeneratedValue提供了主键的生成策略。
    //@GeneratedValue注解有两个属性,分别是strategy和generator,
    //generator属性的值是一个字符串,默认为"",其声明了主键生成器的名称
    //strategy属性：提供四种值:
    //-AUTO主键由程序控制, 是默认选项 ,不设置就是这个

    //-IDENTITY 主键由数据库生成, 采用数据库自增长, Oracle不支持这种方式
    //
    //-SEQUENCE 通过数据库的序列产生主键, MYSQL  不支持
    //
    //-Table 提供特定的数据库产生主键, 该方式更有利于数据库的移植
    //————————————————

    @Column(name = "id")
    int id;

    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
