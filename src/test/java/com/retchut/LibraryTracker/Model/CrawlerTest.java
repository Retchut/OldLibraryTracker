package com.retchut.LibraryTracker.Model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CrawlerTest {
    //Note: The delta argument is to account for fluctuations in the price.
    //      Don't worry too much if this test fails. It's likely because of market fluctuations
    @Test
    void testCrawler1(){
        String name = "Tatsunoko";
        int version = 0;
        String rarity = "Super Rare";
        String expansion = "HISU";

        Crawler crawler = new Crawler(new CardInfo(name, version, rarity, expansion));
        Assertions.assertEquals(0.02, crawler.crawl(), 0.02);
    }

    @Test
    void testCrawler2(){
        String name = "Knightmare Unicorn (V.1 - Rare)";
        int version = 1;
        String rarity = "Rare";
        String expansion = "GEIM";

        Crawler crawler = new Crawler(new CardInfo(name, version, rarity, expansion));
        Assertions.assertEquals(0.02, crawler.crawl(), 0.02);
    }

    @Test
    void testCrawler3(){
        String name = "The Winged Dragon of Ra";
        int version = 2;
        String rarity = "Ghost Rare";
        String expansion = "LED7";

        Crawler crawler = new Crawler(new CardInfo(name, version, rarity, expansion));
        Assertions.assertEquals(180, crawler.crawl(), 50);
    }
}
