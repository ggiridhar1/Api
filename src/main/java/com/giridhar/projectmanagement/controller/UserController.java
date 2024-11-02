package com.giridhar.projectmanagement.controller;

import com.giridhar.projectmanagement.dataAxisObject.IuserRepo;
import com.giridhar.projectmanagement.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    IuserRepo userRepo;

    @GetMapping
    public String displayUsers(Model model) {
        List<Users> anUsers=userRepo.findAll();
        model.addAttribute("users", anUsers);
        return "User/usersListingPage";
    }

    @GetMapping("/new")
    public String displayUserSignupPage(Model models){
        Users auser = new Users();
        models.addAttribute("user",auser);
        return "User/usersignup";
    }

    @PostMapping("/save")
    public String CreateUser(Model models, Users user){
        userRepo.save(user);
        return "redirect:/users";
    }
}
