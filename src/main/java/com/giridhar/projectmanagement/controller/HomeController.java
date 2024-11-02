package com.giridhar.projectmanagement.controller;

import com.giridhar.projectmanagement.dataAxisObject.IproductRepo;
import com.giridhar.projectmanagement.dataAxisObject.IuserRepo;
import com.giridhar.projectmanagement.entity.Products;
import com.giridhar.projectmanagement.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Home")
public class HomeController {
    @Autowired
    IproductRepo productRepo;
    @Autowired
    IuserRepo  iuserRepo;

    @GetMapping()
    public String displayHome(Model model) {
        List<Users> users = iuserRepo.findAll();
        List<Products> products = productRepo.findAll();
        model.addAttribute("listproducts", products);
        model.addAttribute("listusers", users);
        return "HomePage";
    }
}
