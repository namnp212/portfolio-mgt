package com.namnp.portfolio_service.scheduler;

import com.namnp.portfolio_service.model.Asset;
import com.namnp.portfolio_service.model.AssetType;
import com.namnp.portfolio_service.service.GoldService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class Scheduler {

    private static final Logger log = LoggerFactory.getLogger(Scheduler.class);

    @Autowired
    GoldService goldService;

    @Scheduled(cron = "0/10 * * * * *")
    public void updateGoldPrice() {
        log.info("===============================Fetch start===============================");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        try {
            Document docGold = Jsoup.connect("https://giavang.org/trong-nuoc/doji/").get();
            Elements goldPrice = docGold.getElementsByClass("gold-price");
            Element sjcBuy = goldPrice.get(1);
            sjcBuy.select("small").remove();

            Element sjcSell = goldPrice.get(0);
            sjcSell.select("small").remove();

            Asset sjcBar = goldService.getGoldBySymbol("sjc-bar");
            if (sjcBar.getSymbol() == null || sjcBar.getSymbol().isEmpty()) {
                sjcBar.setName("SJC Gold");
                sjcBar.setSymbol("sjc-bar");
                sjcBar.setType(AssetType.Gold);
            }
            sjcBar.setBuyPrice(Float.parseFloat(sjcBuy.text()));
            sjcBar.setSellPrice(Float.parseFloat(sjcSell.text()));
            sjcBar.setLastUpdated(LocalDateTime.parse(LocalDateTime.now().format(formatter), formatter));
            goldService.saveAsset(sjcBar);

            Element dojiBuy = goldPrice.get(3);
            dojiBuy.select("small").remove();

            Element dojiSell = goldPrice.get(2);
            dojiSell.select("small").remove();

            Asset dojiRing = goldService.getGoldBySymbol("doji-ring");
            if (dojiRing.getSymbol() == null || dojiRing.getSymbol().isEmpty()) {
                dojiRing.setName("DOJI Gold");
                dojiRing.setSymbol("doji-ring");
                dojiRing.setType(AssetType.Gold);
            }
            dojiRing.setBuyPrice(Float.parseFloat(dojiBuy.text()));
            dojiRing.setSellPrice(Float.parseFloat(dojiSell.text()));
            dojiRing.setLastUpdated(LocalDateTime.parse(LocalDateTime.now().format(formatter), formatter));
            goldService.saveAsset(dojiRing);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        log.info("===============================Fetch end===============================");

    }


}
