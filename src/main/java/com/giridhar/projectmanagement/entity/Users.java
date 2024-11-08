package com.giridhar.projectmanagement.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq") //import
    private long userId;

    private String name;
    private String Email;
    private long PhoneNumber;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
    fetch = FetchType.LAZY)
    @JoinTable(name="product_user",
            joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name = "product_id") )
    private List<Products> products;

    public Users() {
    }

    public Users(String name, String email, long phoneNumber) {
        this.name = name;
        this.Email = email;
        this.PhoneNumber = phoneNumber;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public long getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
}
