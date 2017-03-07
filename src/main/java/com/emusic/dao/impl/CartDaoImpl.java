package com.emusic.dao.impl;

import com.emusic.dao.CartDao;
import com.emusic.model.Cart;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bappy on 3/6/17.
 */
@Repository
public class CartDaoImpl implements CartDao {


    private Map<String, Cart> listOfCarts;

    public CartDaoImpl(){
        listOfCarts = new HashMap<String, Cart>();
    }

    public Cart create(Cart cart) {

        if (listOfCarts.keySet().contains(cart.getCartId())){
            throw new IllegalArgumentException(String.format("Can not create a cart, A cart with the given id %f",cart.getCartId()));
        }
        listOfCarts.put(cart.getCartId(), cart);
        return cart;
    }


    public Cart read(String cartId) {
        return listOfCarts.get(cartId);
    }

    public void update(String cartId, Cart cart) {

    }

    public void delete(String cartId) {

        if (!listOfCarts.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Can delet a cart, not existing with the given id %f",cartId));

        }

        listOfCarts.remove(cartId);

    }
}
