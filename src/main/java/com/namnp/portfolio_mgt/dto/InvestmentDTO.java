package com.namnp.portfolio_mgt.dto;

public class InvestmentDTO {
    private long id;
    private AssetDTO asset;

    private PortfolioDTO portfolio;
    private double entry;
    private  double volume;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AssetDTO getAsset() {
        return asset;
    }

    public void setAsset(AssetDTO asset) {
        this.asset = asset;
    }

    public double getEntry() {
        return entry;
    }

    public void setEntry(double entry) {
        this.entry = entry;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public PortfolioDTO getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(PortfolioDTO portfolio) {
        this.portfolio = portfolio;
    }
}
