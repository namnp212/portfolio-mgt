package com.namnp.portfolio_service.dto;

import com.namnp.portfolio_service.model.Portfolio;
import com.namnp.portfolio_service.model.User;

import java.util.List;

public class UserFinancialDetailDTO {
    private long id;
    //private User user;
    private double cash;
    private List<PortfolioDTO> portfolios;

    public UserFinancialDetailDTO() {
    }

    public UserFinancialDetailDTO(long id, double cash, List<PortfolioDTO> portfolios) {
        this.id = id;
        this.cash = cash;
        this.portfolios = portfolios;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public List<PortfolioDTO> getPortfolios() {
        return portfolios;
    }

    public void setPortfolios(List<PortfolioDTO> portfolios) {
        this.portfolios = portfolios;
    }
}
