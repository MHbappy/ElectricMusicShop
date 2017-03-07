package com.emusic.controller;

import com.emusic.dao.CartDao;
import com.emusic.dao.ProductDao;
import com.emusic.model.Cart;
import com.emusic.model.CartItem;
import com.emusic.model.Product;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by bappy on 3/7/17.
 */

@Controller
@RequestMapping("/emusic/rest/cart")
public class CartController {

    private static final Logger logger = LogManager.getLogger(HomeController.class);

    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;


    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public @ResponseBody Cart read(@PathVariable(value = "/{cartId}") String cartId){
        return cartDao.read(cartId);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value = "cartId") String cartId, @RequestBody Cart cart){
        logger.info("____________________________________"+cartId);
        cartDao.update(cartId,cart);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "cartId") String cartId){
        cartDao.delete(cartId);
    }

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable(value = "productId") String productId, HttpServletRequest request){



        String sessionId = request.getSession(true).getId();
        Cart cart = cartDao.read(sessionId);



        if (cart == null){
            cart = cartDao.create(new Cart(sessionId));
        }

        Product product = productDao.getProductById(productId);

        logger.info("+++++++++++++++++++++++++++++++++++++++++++++"+cart.getCartId());

        if (product == null){
            throw new IllegalArgumentException(new Exception());
        }

        cart.addCartItem(new CartItem(product));
        cartDao.update(sessionId,cart);
    }

    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable(value = "productId") String productId, HttpServletRequest request){

        String sessionId = request.getSession(true).getId();
        Cart cart = cartDao.read(sessionId);

        if (cart == null){
            cart = cartDao.create(new Cart(sessionId));
        }

        Product product = productDao.getProductById(productId);

        if (product == null){
            throw new IllegalArgumentException(new Exception());
        }

        cart.removeCartItem(new CartItem(product));
        cartDao.update(sessionId,cart);
    }


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verigy your payload")
    public void handleClientErrors(Exception e){

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server Error")
    public void handleServerErrors(Exception e){

    }



}
