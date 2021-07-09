package com.retchut.LibraryTracker.Model;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Crawler {
    final private String url;

    public Crawler(String name, String expansion){
        UrlBuilder urlBuilder = new UrlBuilder();
        this.url = urlBuilder.buildUrl(name, expansion);
    }

    public double crawl(){
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
            Connection con = Jsoup.connect(this.url);
            Document doc = con.get();


            if(con.response().statusCode() == 200)  //successful response
                return doc;
            else
                return null;
        }
        catch(IOException e){
            return null;
        }
    }
}
