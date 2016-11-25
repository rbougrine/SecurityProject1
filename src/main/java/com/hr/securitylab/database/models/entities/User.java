package com.hr.securitylab.database.models.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @OneToMany(mappedBy = "user")
    private Set<Product> products;

    @Column(name = "username", length = 32)
    private String username;

    @Column(name = "password", length = 32)
    private String password;

    @Column(name = "role", length = 32)
    private String role;

    @Column(name = "securityAnswer", length = 32)
    private String securityAnswer;

    @Column(name = "securityQuestion", length = 32)
    private String securityQuestion;


    public User()
    {
    }

    public User(int id, String username, String role ,Set<Product> products, String password, String securityAnswer, String securityQuestion)
    {
        this.id = id;
        this.products = products;
        this.username = username;
        this.password = password;
        this.role = role;
        this.securityAnswer = securityAnswer;
        this.securityQuestion = securityQuestion;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Product> getProducts() { return products; }

    public void setProducts(Set<Product> products) {  this.products = products;}

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

    //still in contruction, need to add new table Role
    public String getRole(){return "user"; }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {this.securityAnswer = securityAnswer;}

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {this.securityQuestion = securityQuestion;}


}



