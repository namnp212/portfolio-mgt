package com.namnp.portfolio_service.service;

import com.namnp.portfolio_service.model.Asset;
import com.namnp.portfolio_service.model.AssetType;
import com.namnp.portfolio_service.repository.AssetRepository;
import com.namnp.portfolio_service.scheduler.Scheduler;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CryptoService extends AssetService {

    private static final Logger log = LoggerFactory.getLogger(CryptoService.class);

    @Override
    public double getPriceFromWeb (String symbol){
        try {
            String url = "https://coinmarketcap.com/currencies/" + symbol;
            Document doc = Jsoup.connect(url).get();
            Elements cryptoPrice = doc.getElementById("section-coin-overview").children().get(1).select("span");
            String price = "0";
            switch (cryptoPrice.size()){
                case 0:{
                    log.error("No <span> . Something wrong with symbol: " + symbol + ". Please check!");
                    break;
                }
                case 1: {
                    price = new StringBuilder(cryptoPrice.text()).deleteCharAt(0).toString().replace(",", "");break;
                }
                case 3: {
                    Element newCryptoPrice = cryptoPrice.get(2);
                    int numberOfZero = Integer.parseInt(newCryptoPrice.select("sub").text());
                    StringBuilder sb = new StringBuilder();
                    for(int i = 0; i < numberOfZero-1; i++){
                        sb.append("0");
                    }
                    newCryptoPrice.select("sub").html(sb.toString());
                    price = new StringBuilder(newCryptoPrice.text()).deleteCharAt(0).toString().replace(",", "");
                break;
                }
                default:{
                    log.error("Uncovered. Something wrong with symbol: " + symbol + ". Please check!");
                    break;
                }
            }

            return Double.parseDouble(price);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Asset> findAllCryptos() {
        return assetRepository.findByType(AssetType.Crypto);
    }
}
