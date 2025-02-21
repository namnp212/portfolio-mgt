package com.namnp.portfolio_service.service;

import com.namnp.portfolio_service.dto.AssetDTO;

import java.util.List;

public interface iAssetService {
    public AssetDTO save(AssetDTO dto);

    public List<AssetDTO> findAll();

    public AssetDTO findById(long id);

}
