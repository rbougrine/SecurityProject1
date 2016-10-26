package com.hr.securitylab.database.models.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

  // @OneToMany(mappedBy = "user")
   // private Set<Product> products;

    @Column(name = "username", length = 32)
    private String username;

    @Column(name = "password", length = 32)
    private String password;


    public User() {
    }

    public User(int id, String username, String password) {
        this.id = id;
     // this.products = products;
        this.username = username;
        this.password = password;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public Set<Product> getProducts() { return products; }

//    public void setProducts(Set<Product> products) {  this.products = products;}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
