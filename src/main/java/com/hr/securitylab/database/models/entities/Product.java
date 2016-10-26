package com.hr.securitylab.database.models.entities;

import javax.persistence.*;


    @Entity
    @Table(name = "product")
    public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "product_id")
        private int id;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        @Column(name = "productKey", length = 16)
        private String productKey;

        @Column(name = "pin", length = 6)
        private String pin;

        @Column(name = "encryption_key")
        private String encryption_key;

        @Column(name = "activated")
        private boolean activated;

        public Product() {
        }

        public Product(int id, User user, String productKey, String pin, boolean activated, String encryption_key) {
            this.id = id;
            this.user = user;
            this.productKey = productKey;
            this.pin = pin;
            this.encryption_key = encryption_key;
            this.activated = activated;

        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public String getproductKey() {
            return productKey;
        }

        public void setproductKey(String productKey) {
            this.productKey = productKey;
        }

        public String getEncryption_key() {
            return encryption_key;
        }

        public void setEncryption_key(String encryption_key) {
            this.encryption_key = encryption_key;
        }

        public String getPin() {
            return pin;
        }

        public void setPin(String pin) {
            this.pin = pin;
        }

        public boolean isActivated() {
        return activated;
    }

        public void setActivated(boolean activated) {
        this.activated = activated;
    }

    }

