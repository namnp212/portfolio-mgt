package com.namnp.portfolio_service.service;

import com.namnp.portfolio_service.dto.AssetDTO;
import com.namnp.portfolio_service.mapper.AssetMapper;
import com.namnp.portfolio_service.model.Asset;
import com.namnp.portfolio_service.model.AssetType;
import com.namnp.portfolio_service.repository.AssetRepository;
import com.namnp.portfolio_service.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.List;

@Service
public class AssetServiceImpl implements iAssetService{
    @Autowired
    AssetRepository assetRepository;

    @Autowired
    AssetMapper assetMapper;

    public AssetDTO saveAsset(AssetDTO dto) {
        Asset asset = assetMapper.toAsset(dto, assetRepository.findById(dto.getId()).orElse(new Asset()));
        asset.setLastUpdated(DateUtil.getLocalDateTimeNowByTimeZone(ZoneId.of("Asia/Saigon")));
        return assetMapper.toDTO(assetRepository.save(asset));
    }
    public List<AssetDTO> findByType(AssetType type) { return assetMapper.toDTO(assetRepository.findByType(type)); }

    public List<AssetDTO> findAll() { return assetMapper.toDTO(assetRepository.findAll()); }

    public AssetDTO findById(long id) {
        return assetMapper.toDTO(assetRepository.findById(id).orElse(new Asset()));
    }

    public List<AssetDTO> findAllStocks() {
        return findByType(AssetType.Stock);
    }

    public List<AssetDTO> findAllCrypto() {
        return findByType(AssetType.Crypto);
    }

    public List<AssetDTO> findAllFundCert() {
        return findByType(AssetType.FundCert);
    }

    public AssetDTO getGoldBySymbol(String symbol) {
        return assetMapper.toDTO(assetRepository.findByTypeAndSymbol(AssetType.Gold, symbol).orElse(new Asset()));
    }
}
