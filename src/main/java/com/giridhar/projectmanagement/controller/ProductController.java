package com.giridhar.projectmanagement.controller;

import com.giridhar.projectmanagement.dataAxisObject.IproductRepo;
import com.giridhar.projectmanagement.dataAxisObject.IuserRepo;
import com.giridhar.projectmanagement.entity.Products;
import com.giridhar.projectmanagement.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IproductRepo productRepo;

    @Autowired
    IuserRepo iuserRepo;

    @GetMapping
    public String getAllProducts(Model model){
       List<Products> productsList=productRepo.findAll();
       model.addAttribute("products", productsList);
       return "product/productsListingPage";
    }

    @GetMapping("/new")
    // To bind html and spring we use Model;
    public String displayForm(Model model){
        Products aProduct=new Products();
        List<Users> users =iuserRepo.findAll();
        //Atrribute name should be same name as entity class name
        model.addAttribute("products",aProduct);
        model.addAttribute("Users", users);
        return "product/new-project";
    }

    //create products in database;
    @PostMapping("/save")
        public String createProduct(Products products, Model model){
        productRepo.save(products);
        //use redirect to prevent duplicate submissions
        return "redirect:/products";
    }
}
