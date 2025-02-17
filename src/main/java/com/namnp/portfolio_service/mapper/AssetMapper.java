package com.namnp.portfolio_service.mapper;

import com.namnp.portfolio_service.dto.AssetDTO;
import com.namnp.portfolio_service.model.Asset;
import com.namnp.portfolio_service.model.AssetType;
import org.springframework.stereotype.Component;

@Component
public class AssetMapper {
    public Asset toAsset(AssetDTO dto, Asset assetFromDB){
        assetFromDB.setId(dto.getId());
        assetFromDB.setName(dto.getName());
        assetFromDB.setSymbol(dto.getSymbol());
        assetFromDB.setType(AssetType.valueOf(dto.getType()));
        assetFromDB.setBuyPrice(dto.getBuyPrice());
        assetFromDB.setSellPrice(dto.getSellPrice());
        return assetFromDB;
    }

    public AssetDTO toDTO(Asset asset){
        AssetDTO dto = new AssetDTO();
        dto.setId(asset.getId());
        dto.setName(asset.getName());
        dto.setSymbol(asset.getSymbol());
        dto.setType(asset.getType().toString());
        dto.setBuyPrice(asset.getBuyPrice());
        dto.setSellPrice(asset.getSellPrice());
        return dto;
    }
}
