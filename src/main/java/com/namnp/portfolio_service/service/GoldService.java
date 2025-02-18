package com.namnp.portfolio_service.service;

import com.namnp.portfolio_service.dto.AssetDTO;
import com.namnp.portfolio_service.mapper.AssetMapper;
import com.namnp.portfolio_service.model.Asset;
import com.namnp.portfolio_service.model.AssetType;
import com.namnp.portfolio_service.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoldService extends AssetService{

    @Autowired
    AssetMapper assetMapper;

    public List<AssetDTO> findAllGold(){
        return assetMapper.toDTO(assetRepository.findByType(AssetType.Gold));
    }

    public AssetDTO getGoldBySymbol(String symbol){
        return assetMapper.toDTO(assetRepository.findByTypeAndSymbol(AssetType.Gold, symbol).orElse(new Asset()));
    }
}
