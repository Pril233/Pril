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
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //主键
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
