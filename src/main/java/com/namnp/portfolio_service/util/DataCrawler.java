package com.namnp.portfolio_service.util;

import com.namnp.portfolio_service.model.AssetType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public final class DataCrawler {
    private static final Logger log = LoggerFactory.getLogger(DataCrawler.class);

    private DataCrawler(){}

    public static double getPriceFromWeb(String symbol, AssetType type){
        switch (type){
            case Stock:
                return getStockPrice(symbol);
            case Crypto:
                return getCryptoPrice(symbol);
            case FundCert:
                return getFundCertPrice(symbol);
        }
        return -1;
    }

    private static double getFundCertPrice(String symbol) {
        try {
            String url = "https://fmarket.vn/quy/" + symbol;
            Document docFund = Jsoup.connect(url).get();
            String price = docFund.getElementsByClass("fund__intro fund__nav").select("span").get(1).text().replace(" VND", "").replace(",", "");
            return Double.parseDouble(price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static double getCryptoPrice(String symbol) {
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static double getStockPrice(String symbol){
        try {
            String url = "https://24hmoney.vn/stock/" + symbol;
            Document doc = Jsoup.connect(url).get();
            Elements stockPrice = doc.getElementsByClass("price-detail").select("span");
            return Double.parseDouble(stockPrice.get(0).text());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
