package com.emusic.dao;

import com.emusic.model.Cart;

/**
 * Created by bappy on 3/6/17.
 */
public interface CartDao {

    Cart create(Cart cart);

    Cart read(String cartId);

    void update(String cartId, Cart cart);

    void delete(String cartId);

}
