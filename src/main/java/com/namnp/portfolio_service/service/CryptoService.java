package com.namnp.portfolio_service.service;

import com.namnp.portfolio_service.model.Asset;
import com.namnp.portfolio_service.model.AssetType;
import com.namnp.portfolio_service.repository.AssetRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CryptoService {
    @Autowired
    AssetRepository assetRepository;
    public double getCryptoPrice(String symbol){
        try {
            String url = "https://coinmarketcap.com/currencies/" + symbol;
            Document doc = Jsoup.connect(url).get();
            Elements cryptoPrice = doc.getElementById("section-coin-overview").children().get(1).select("span");
            String price = new StringBuilder(cryptoPrice.text()).deleteCharAt(0).toString().replace(",", "");
            return Double.parseDouble(price);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveAsset(Asset item) {
        assetRepository.save(item);
    }

    public List<Asset> findAllCryptos() {
        return assetRepository.findByType(AssetType.Crypto);
    }
}
