package com.app.wasteless.models;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "products")
public class Product {

    @Column("id")
    private Long id;

    @Column("user_id")
    private Long userId;

    @Column("food_name")
    private String foodName;

    @Column("description")
    private String description;

    @Column("quantity")
    private int quantity;

    @Column("price")
    private double price;

    private String storeName;
    private String storeAddress;

    // Constructors

    public Product() {
    }

    public Product(String foodName, Long userId, String description, int quantity, double price) {
        this.foodName = foodName;
        this.userId = userId;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser() {
        return userId;
    }

    public void setUser(Long userId) {
        this.userId = userId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    // toString method (optional, for debugging)

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", user=" + userId +
                ", foodName='" + foodName + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}