package com.emusic.controller;
import com.emusic.dao.ProductDao;
import com.emusic.model.Product;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@Controller
public class HomeController {

    private static final Logger logger = LogManager.getLogger(HomeController.class);

    private Path path;

    @Autowired
    private ProductDao productDao;

    @RequestMapping("/emusic")
    public String home() {

        return "home";
    }




    @RequestMapping("/emusic/productlist")
    public String getProducts(Model model) {

        List<Product> productList = productDao.getAllProducts();
//        Product product = productList.get(0);
        model.addAttribute("product", productList);

        return "productlistt";
    }


    @RequestMapping("/emusic/productlist/viewproduct/{productId}")
    public String viewProduct(@PathVariable String productId, Model model) throws IOException {

        Product product = productDao.getProductById(productId);


        model.addAttribute(product);

        return "viewProduct";
    }


//    @RequestMapping("/admin")
//    public String adminPage(){
//        return "admin";
//    }
//
//    @RequestMapping("/admin/productInventory")
//    public String productInventory(Model model){
//
//        List<Product> products = productDao.getAllProducts();
//        model.addAttribute("product",products);
//
//        return "productinventory";
//    }
//
//
//    @RequestMapping("/admin/productInventory/addProduct")
//    public String addProduct(Model model){
//
//        Product product = new Product();
//        product.setProductCategory("instrument");
//        product.setProductCondiation("new");
//        product.setProductStatus("active");
//
//        model.addAttribute("product", product);
//        return "addProduct";
//    }
//
//
//    @RequestMapping(value="/admin/productInventory/addProduct", method = RequestMethod.POST)
//    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request){
//
//        if (result.hasErrors()){
//            return "addProduct";
//        }
//
//        productDao.addProduct(product);
//        MultipartFile productImage = product.getProductImage();
//
//        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
//
//        logger.info(productImage.isEmpty()+"+++++++++++++++++++++________________"+rootDirectory);
//        path = Paths.get(rootDirectory + "//WEB-INF//resources//images//"+product.getProductId()+".png");
//
//        logger.info(productImage.isEmpty()+"+++++++++++++++++++++________________"+path.toString());
//
//
//
//        if (productImage !=null && !productImage.isEmpty()) {
//
//            try {
//                productImage.transferTo(new File(path.toString()));
//
//            }
//            catch (Exception e){
//                e.printStackTrace();
//                throw new RuntimeException("Product Image saving failed");
//            }
//        }
//
//        return "redirect:/admin/productInventory";
//    }
//
//
//    @RequestMapping("/admin/productInventory/deleteProduct/{productId}")
//    public String deleteProduct(@PathVariable String productId, Model model, HttpServletRequest request){
//
//        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
//        path = Paths.get(rootDirectory + "//WEB-INF//resources//images//"+productId+".png");
//
//        if (Files.exists(path)){
//
//            try {
//                Files.delete(path);
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        productDao.deleteProduct(productId);
//
//        return "redirect:/admin/productInventory";
//    }
//
//    @RequestMapping("/admin/productInventory/editProduct/{productId}")
//    public String editProduct(@Valid @PathVariable String productId, Model model){
//        Product product = productDao.getProductById(productId);
//
//
//        model.addAttribute(product);
//        return "editProduct";
//    }
//
//    @RequestMapping(value="/admin/productInventory/editProduct", method = RequestMethod.POST)
//    public String editProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request){
//
//        logger.info("____________________________________"+result.hasErrors());
//
//        if (result.hasErrors()){
//            return "editProduct";
//        }
//
//
//        MultipartFile productImage = product.getProductImage();
//
//        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
//
//        logger.info(productImage.isEmpty()+"+++++++++++++++++++++________________"+rootDirectory);
//        path = Paths.get(rootDirectory + "//WEB-INF//resources//images//"+product.getProductId()+".png");
//
//        logger.info(productImage.isEmpty()+"+++++++++++++++++++++________________"+path.toString());
//
//
//
//        if (productImage !=null && !productImage.isEmpty()) {
//
//            try {
//                productImage.transferTo(new File(path.toString()));
//
//            }
//            catch (Exception e){
//                e.printStackTrace();
//                throw new RuntimeException("Product Image saving failed");
//            }
//        }
//
//        productDao.editProduct(product);
//
//        return "redirect:/admin/productInventory";
//    }

}
