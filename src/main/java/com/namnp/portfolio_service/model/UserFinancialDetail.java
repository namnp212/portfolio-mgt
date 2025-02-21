package com.namnp.portfolio_service.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class UserFinancialDetail {

    @Id
    private long id;

    @OneToOne(mappedBy = "userFinancialDetail")
    @JsonBackReference
    private User user;
    private double cash;

    @OneToMany(mappedBy = "userFinancialDetail", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<Portfolio> portfolios;

    public UserFinancialDetail() { }

    public UserFinancialDetail(long id, User user, double cash, List<Portfolio> portfolios) {
        this.id = id;
        this.user = user;
        this.cash = cash;
        this.portfolios = portfolios;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public List<Portfolio> getPortfolios() {
        return portfolios;
    }

    public void setPortfolios(List<Portfolio> portfolios) {
        this.portfolios = portfolios;
    }
}
