package com.emusic.dao;

import com.emusic.model.Product;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by bappy on 1/26/17.
 */

public interface ProductDao {

    void addProduct(Product product);
    void editProduct(Product product);
    Product getProductById(String id);
    List<Product> getAllProducts();
    void deleteProduct(String id);

}
