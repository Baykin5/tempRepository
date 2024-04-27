package com.example.webpos.model;

import jakarta.persistence.*;

//  保存所有product

@Entity
@Table(name = "products")
public class Product {
    
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public String id;

    @Column(name = "tid")
    public String tid;

    @Column(name = "price")
    public double price;

    @Column(name = "category")
    public String category;

    @Column(name = "quantity")
    public int quantity;

    @Column(name = "product_name")
    public String name;

    @Column(name = "stock")
    public int stock;

    @Column(name = "img")
    public String img;

    public Product(){
        this.id = "undefined";
        this.tid = "undefined";
        this.price = 0;
        this.category = "null";
        this.quantity = 0;
        this.name = "null";
        this.stock = 0;
        this.img = "null";
    }

    public Product(String id, String tid, double price, String category,int quantity, String name ,int stock, String img){
        this.id = id;
        this.tid = tid;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        this.name = name;
        this.stock = stock;
        this.img = img;
    }
    

    public String getId(){
        return id;
    }


    @Override
    public String toString() {
        return id + "\t" + name + "\t" + price + "\t" + img;
    }

}
