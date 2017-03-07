package com.emusic.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;


/**
 * Created by bappy on 1/26/17.
 */

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String productId;

    @NotEmpty(message = "The Product name Must not be null")
    private String productName;


    private String productCategory;
    private String productDescription;

    @Min(value = 1, message = "The product price must no be zero")
    private double productPrice;
    private String  productCondiation;
    private String productStatus;

    @Min(value = 1, message = "The product price must no be zero")
    private int unitInStoke;
    private String productManufacture;

    @Transient
    private MultipartFile productImage;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCondiation() {
        return productCondiation;
    }

    public void setProductCondiation(String productCondiation) {
        this.productCondiation = productCondiation;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public int getUnitInStoke() {
        return unitInStoke;
    }

    public void setUnitInStoke(int unitInStoke) {
        this.unitInStoke = unitInStoke;
    }

    public String getProductManufacture() {
        return productManufacture;
    }

    public void setProductManufacture(String productManufacture) {
        this.productManufacture = productManufacture;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }


    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                ", productCondiation='" + productCondiation + '\'' +
                ", productStatus='" + productStatus + '\'' +
                ", unitInStoke=" + unitInStoke +
                ", productManufacture='" + productManufacture + '\'' +
                ", productImage=" + productImage +
                '}';
    }
}
