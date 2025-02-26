package com.namnp.portfolio_service.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fin_detail_id", referencedColumnName = "id")
    @JsonManagedReference
    private UserFinancialDetail userFinancialDetail;

    public User() {
    }

    public User(long id, String firstName, String lastName, String userName, String password, String email, UserFinancialDetail userFinancialDetail) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.userFinancialDetail = userFinancialDetail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public UserFinancialDetail getUserFinancialDetail() {
        return userFinancialDetail;
    }

    public void setUserFinancialDetail(UserFinancialDetail userFinancialDetail) {
        this.userFinancialDetail = userFinancialDetail;
    }
}
