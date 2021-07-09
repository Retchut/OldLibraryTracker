package com.retchut.LibraryTracker.Model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CrawlerTest {
    //Note: The delta argument is to account for fluctuations in the price.
    //      Don't worry too much if this test fails. It's likely because of market fluctuations
    @Test
    void testCrawler1(){
        String name = "Tatsunoko";
        String expansion = "HISU";

        Crawler crawler = new Crawler(name, expansion);
        Assertions.assertEquals(crawler.crawl(), 0.02, 0.02);
    }

    @Test
    void testCrawler2(){
        String name = "Knightmare Unicorn (V.1 - Rare)";
        String expansion = "GEIM";

        Crawler crawler = new Crawler(name, expansion);
        Assertions.assertEquals(crawler.crawl(), 0.13, 0.10);
    }

    @Test
    void testCrawler3(){
        String name = "The Winged Dragon of Ra (V.2 - Ghost Rare)";
        String expansion = "LED7";

        Crawler crawler = new Crawler(name, expansion);
        Assertions.assertEquals(crawler.crawl(), 200, 50);
    }
}
