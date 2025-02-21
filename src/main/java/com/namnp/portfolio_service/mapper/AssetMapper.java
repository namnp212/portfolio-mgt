package com.namnp.portfolio_service.mapper;

import com.namnp.portfolio_service.dto.AssetDTO;
import com.namnp.portfolio_service.model.Asset;
import com.namnp.portfolio_service.model.AssetType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssetMapper {
    public Asset toModel(AssetDTO dto, Asset assetFromDB){
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
        dto.setLastUpdated(asset.getLastUpdated().toString());
        return dto;
    }

    public List<AssetDTO> toDTO(List<Asset> list) {
        return list.stream()
                .map(item -> toDTO(item))
                .collect(Collectors.toList());
    }
}
