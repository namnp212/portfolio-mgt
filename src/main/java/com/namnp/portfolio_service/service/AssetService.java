package com.namnp.portfolio_service.service;

import com.namnp.portfolio_service.model.Asset;
import com.namnp.portfolio_service.model.AssetType;
import com.namnp.portfolio_service.repository.AssetRepository;
import com.namnp.portfolio_service.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AssetService {
    @Autowired
    AssetRepository assetRepository;

    public void saveAsset(Asset item) {
        item.setLastUpdated(DateUtil.getLocalDateTimeNowByTimeZone(ZoneId.of("Asia/Saigon")));
        assetRepository.save(item);
    }
    public double getPriceFromWeb(String symbol) {
        return 0;
    }
    public List<Asset> findByType(AssetType type) {
        return assetRepository.findByType(type);
    }

}
