package com.example.crudbook.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private String productDescription;
    private double productPurchasePrice;
    private double productSellingPrice;
    private int productQuantity;
    private int productActive;

    public Product() {
    }

    public Product(String productName, String productDescription, double productPurchasePrice, double productSellingPrice, int productQuantity, int productActive) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPurchasePrice = productPurchasePrice;
        this.productSellingPrice = productSellingPrice;
        this.productQuantity = productQuantity;
        this.productActive = productActive;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPurchasePrice() {
        return productPurchasePrice;
    }

    public void setProductPurchasePrice(double productPurchasePrice) {
        this.productPurchasePrice = productPurchasePrice;
    }

    public double getProductSellingPrice() {
        return productSellingPrice;
    }

    public void setProductSellingPrice(double productSellingPrice) {
        this.productSellingPrice = productSellingPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getProductActive() {
        return productActive;
    }

    public void setProductActive(int productActive) {
        this.productActive = productActive;
    }
}
