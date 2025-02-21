package com.namnp.portfolio_service.service;

import com.namnp.portfolio_service.dto.AssetDTO;
import com.namnp.portfolio_service.model.Asset;
import com.namnp.portfolio_service.model.AssetType;

import java.util.List;

public interface iAssetService {
    public AssetDTO saveAsset(AssetDTO dto);

    public List<AssetDTO> findAll();

    public AssetDTO findById(long id);

}
