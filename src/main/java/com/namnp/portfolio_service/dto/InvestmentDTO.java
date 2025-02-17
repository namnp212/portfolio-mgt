package com.namnp.portfolio_service.dto;

import com.namnp.portfolio_service.model.Asset;
import com.namnp.portfolio_service.model.Portfolio;

public class InvestmentDTO {
    private long id;
    private AssetDTO asset;
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
}
