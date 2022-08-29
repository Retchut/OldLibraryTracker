package com.retchut.LibraryTracker;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

import com.retchut.LibraryTracker.Algorithms;

public class Crawler {
    final private List<String> urls;
    final private CardInfo cardInfo;

    public Crawler(CardInfo cardInfo){
        this.cardInfo = cardInfo;
        UrlBuilder urlBuilder = new UrlBuilder();
        this.urls = urlBuilder.buildUrl(cardInfo);
    }

    public double crawl(){
        Algorithms.log("Crawling " + this.cardInfo.getName() + " (" + this.cardInfo.getExpansion() + ", " + this.cardInfo.getRarity() + ", " + this.cardInfo.getVersion() + " )");

        Document doc = request();
        if(doc == null)
            return 0.0;

        String fromPriceString = "";
        for(Element row : doc.select("dl.labeled.row.no-gutters.mx-auto")){
            Elements elements = row.children();
            for (int i = 0; i < elements.size(); i++){
                if(elements.get(i).text().contains("From")){
                    fromPriceString = elements.get(i+1).text();
                    break;
                }
            }
        }

        if(fromPriceString.equals(""))
            return 0.0;

        //TODO: Clean up this mess, it's ugly
        String[] split = fromPriceString.split("[ ,]");

        return Double.parseDouble(split[0]) + Double.parseDouble("0." + split[1]);
    }

    public Document request(){
        try{
            //Try to connect to all the possible urls
            for(String url : this.urls){
                Connection con = Jsoup.connect(url);
                Algorithms.log("statusCode = " + con.response().statusCode());

                Document doc = con.get();
                if(con.response().statusCode() == 200)  //successful response
                    return doc;
            }
            return null;
        }
        catch(IOException e){
            return null;
        }
    }
}
