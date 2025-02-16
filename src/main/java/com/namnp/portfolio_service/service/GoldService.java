package com.namnp.portfolio_service.service;

import com.namnp.portfolio_service.model.Asset;
import com.namnp.portfolio_service.model.AssetType;
import com.namnp.portfolio_service.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoldService extends AssetService{

    public List<Asset> findAllGold(){
        return assetRepository.findByType(AssetType.Gold);
    }

    public Asset getGoldBySymbol(String symbol){
        Asset result = assetRepository.findByTypeAndSymbol(AssetType.Gold, symbol).orElse(new Asset());
        return result;
    }
}
