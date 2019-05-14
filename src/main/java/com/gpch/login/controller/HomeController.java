package com.gpch.login.controller;

import com.gpch.login.product.Product;
import com.gpch.login.product.ProductService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class HomeController {
    private final ProductService productService;

    @Autowired
    public HomeController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping(value = {"/","/index","/home"})
    public String home(Model model){
        model.addAttribute("products",getAllProducts());
        model.addAttribute("productsCount",productsCount());
        return "home";
      }

      @GetMapping("/about")
      public String about(){
        return "about";
      }
      private List<Product> getAllProducts(){
        return productService.findAllByOrderByIdAsc();
      }
      private long productsCount(){
        return productService.count();
      }
}
