package com.desafio_picpay.entity;

import com.desafio_picpay.entity.enums.UserType;
import jakarta.persistence.*;


import java.math.BigDecimal;



@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String cpf_cnpj;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    private BigDecimal walletBalance;
    private boolean isActive = true;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public Users() {
    }

    public Users(Long id, String name, String cpf_cnpj, String email, String password, BigDecimal walletBalance, boolean isActive, UserType userType) {
        this.id = id;
        this.name = name;
        this.cpf_cnpj = cpf_cnpj;
        this.email = email;
        this.password = password;
        this.walletBalance = walletBalance;
        this.isActive = isActive;
        this.userType = userType;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public BigDecimal getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(BigDecimal walletBalance) {
        this.walletBalance = walletBalance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
