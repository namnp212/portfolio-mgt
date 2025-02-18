package com.namnp.portfolio_service.service;

import com.namnp.portfolio_service.dto.AssetDTO;
import com.namnp.portfolio_service.mapper.AssetMapper;
import com.namnp.portfolio_service.model.Asset;
import com.namnp.portfolio_service.model.AssetType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FundCertService extends AssetService {

    @Autowired
    AssetMapper assetMapper;

    @Override
    public double getPriceFromWeb(String symbol){
        try {
            String url = "https://fmarket.vn/quy/" + symbol;
            Document docFund = Jsoup.connect(url).get();
            String price = docFund.getElementsByClass("fund__intro fund__nav").select("span").get(1).text().replace(" VND", "").replace(",", "");
            return Double.parseDouble(price);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<AssetDTO> findAllFundCert() {
        return assetMapper.toDTO(assetRepository.findByType(AssetType.FundCert));
    }
}
