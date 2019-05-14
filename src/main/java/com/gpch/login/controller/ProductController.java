package com.gpch.login.controller;

import com.gpch.login.product.Product;
import com.gpch.login.product.ProductService;
import com.gpch.login.product.ProductValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;
    private final ProductValidator productValidator;

    @Autowired
    public ProductController(ProductService productService,ProductValidator productValidator)
    {
        this.productService = productService;
        this.productValidator = productValidator;
    }

    @GetMapping("/product/new")
    public String newProduct(Model model){
        model.addAttribute("productForm",new Product());
        model.addAttribute("method","new");
        return "product";
    }
    @PostMapping("/product/new")
    public String newProduct(@ModelAttribute("productForm") Product productForm,Model model,BindingResult bindingResult)
    {
        productValidator.validate(productForm,bindingResult);
        if (bindingResult.hasErrors()){
            logger.error(String.valueOf(bindingResult.getFieldError()));
            model.addAttribute("method","new");
            return "product";
        }
        productService.save(productForm);
        logger.debug(String.format("Product with id :%s successfuly created",productForm.getId()));
        return "redirect:/home";
    }
      @PostMapping("/product/edit/{id}")
      public String editProduct(@PathVariable("id") long productId,@ModelAttribute("productForm") Product productForm,BindingResult bindingResult,Model model){
        productValidator.validate(productForm,bindingResult);
        if (bindingResult.hasErrors()){
            logger.error(String.valueOf(bindingResult.getFieldError()));
            model.addAttribute("method","edit");
            return "product";
        }
        productService.edit(productId,productForm);
        logger.debug(String.format("Product with id : %s has been successfully edited"),productId);
        return "redirect:/home";
      }

      @PostMapping("/product/delete/{id}")
      public String deleteProduct(@PathVariable("id") long productId){
        Product product = productService.findById(productId);
        if (product!=null){
            productService.delete(productId);
            logger.debug(String.format("Product with id: %s successfully deleted",product.getId()));
            return "redirect:/home";
        }
            return "/error/404";

      }

}
