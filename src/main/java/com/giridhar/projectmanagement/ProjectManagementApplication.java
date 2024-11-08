package com.giridhar.projectmanagement;

import com.giridhar.projectmanagement.dataAxisObject.IproductRepo;
import com.giridhar.projectmanagement.dataAxisObject.IuserRepo;
import com.giridhar.projectmanagement.entity.Products;
import com.giridhar.projectmanagement.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ProjectManagementApplication {

    @Autowired
    IproductRepo productRepo;

    @Autowired
    IuserRepo iuserRepo;

    public static void main(String[] args) {
        SpringApplication.run(ProjectManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(){
        return args -> {
            Users user1 = new Users("Giridhar", "ggiridhar91@gmail.com", 9003181007L);
            Users user2 = new Users("Deepthi", "ggiridhar91@gmail.com", 9003181007L);
            Users user3 = new Users("koushik", "ggiridhar91@gmail.com", 9003181007L);

            Products pro1=new Products("Red Bull",120.00,"energy drink","https://www.istockphoto.com/photo/aluminium-can-of-red-bull-energy-drink-iced-background-gm537022544-95088531",true);

            Products pro2 = new Products("Apple iPhone 14", 999.99, "Latest Apple iPhone with A15 Bionic chip and 5G capability", "https://www.istockphoto.com/photo/iphone-14-in-hand-gm1441443474-481001543", true);

            Products pro3 = new Products("Nike Air Max", 150.00, "Comfortable and stylish running shoes", "https://www.istockphoto.com/photo/nike-air-max-running-shoes-gm1021088650-274001245", true);

            Products pro4 = new Products("Sony WH-1000XM4", 349.99, "Wireless noise-canceling headphones with high-resolution audio", "https://www.istockphoto.com/photo/sony-headphones-on-table-gm1314542010-401097891", true);

            Products pro5 = new Products("Dell XPS 13", 1199.99, "Ultra-thin laptop with Intel i7 processor and 4K display", "https://www.istockphoto.com/photo/dell-xps-13-laptop-on-desk-gm1253184697-374227582", true);

            Products pro6 = new Products("Canon EOS R5", 3899.99, "Professional mirrorless camera with 45MP sensor and 8K video recording", "https://www.istockphoto.com/photo/canon-eos-r5-camera-on-wooden-table-gm1279829863-376308531", true);

            pro1.setUsers(Arrays.asList(user1,user2,user3));
            pro2.setUsers(Arrays.asList(user1,user2,user3));
            pro3.setUsers(Arrays.asList(user1,user2,user3));



            user1.setProducts(Arrays.asList(pro1,pro2,pro3));
            user2.setProducts(Arrays.asList(pro1,pro2,pro3));
            user3.setProducts(Arrays.asList(pro1,pro2,pro3));


            iuserRepo.save(user1);
            iuserRepo.save(user2);
            iuserRepo.save(user3);
            productRepo.save(pro1);
            productRepo.save(pro2);
            productRepo.save(pro3);
            productRepo.save(pro4);
            productRepo.save(pro5);
            productRepo.save(pro6);

        };
    }

}
