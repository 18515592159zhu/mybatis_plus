package com.atguigu.mp.pojo;

import com.baomidou.mybatisplus.annotation.Version;

/**
 * @Author zhuchifeng
 * @Date 2022/10/21 8:09
 * @Version 1.0
 */
public class Product {
    private Long id;
    private String name;
    private Integer price;

    @Version
    private Integer version;

    public Product() {
    }

    public Product(Long id, String name, Integer price, Integer version) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", version=" + version +
                '}';
    }
}
