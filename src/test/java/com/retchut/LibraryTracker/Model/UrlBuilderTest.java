package com.retchut.LibraryTracker.Model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class UrlBuilderTest {

    @Test
    void urlSimpleOneWord1(){
        String name = "Tatsunoko";
        int version = 0;
        String rarity = "Super Rare";
        String expansion = "HISU";
        String expected = "https://www.cardmarket.com/en/YuGiOh/Products/Singles/Hidden-Summoners/Tatsunoko";

        UrlBuilder urlBuilder = new UrlBuilder();
        List<String> returned = urlBuilder.buildUrl(new CardInfo(name, version, rarity, expansion));
        
        assertTrue(Arrays.asList(returned).get(0).contains(expected));
    }

    @Test
    void urlSimpleOneWord2(){
        String name = "Zefraath";
        int version = 0;
        String rarity = "Super Rare";
        String expansion = "MACR";
        String expected = "https://www.cardmarket.com/en/YuGiOh/Products/Singles/Maximum-Crisis/Zefraath";

        UrlBuilder urlBuilder = new UrlBuilder();
        List<String> returned = urlBuilder.buildUrl(new CardInfo(name, version, rarity, expansion));
        
        assertTrue(Arrays.asList(returned).get(0).contains(expected));
    }

    @Test
    void urlSimpleTwoWords(){
        String name = "Zefra Providence";
        int version = 0;
        String rarity = "Rare";
        String expansion = "MACR";
        String expected = "https://www.cardmarket.com/en/YuGiOh/Products/Singles/Maximum-Crisis/Zefra-Providence";

        UrlBuilder urlBuilder = new UrlBuilder();
        List<String> returned = urlBuilder.buildUrl(new CardInfo(name, version, rarity, expansion));
        
        assertTrue(Arrays.asList(returned).get(0).contains(expected));
    }

    @Test
    void urlSimpleMultipleWords(){
        String name = "Oracle of Zefra";
        int version = 0;
        String rarity = "Super Rare";
        String expansion = "PEVO";
        String expected = "https://www.cardmarket.com/en/YuGiOh/Products/Singles/Pendulum-Evolution/Oracle-of-Zefra";

        UrlBuilder urlBuilder = new UrlBuilder();
        List<String> returned = urlBuilder.buildUrl(new CardInfo(name, version, rarity, expansion));
        
        assertTrue(Arrays.asList(returned).get(0).contains(expected));
    }

    @Test
    void urlWithCommas(){
        String name = "Zefraniu, Secret of the Yang Zing";
        int version = 0;
        String rarity = "Rare";
        String expansion = "CROS";
        String expected = "https://www.cardmarket.com/en/YuGiOh/Products/Singles/Crossed-Souls/Zefraniu-Secret-of-the-Yang-Zing";

        UrlBuilder urlBuilder = new UrlBuilder();
        List<String> returned = urlBuilder.buildUrl(new CardInfo(name, version, rarity, expansion));
        
        assertTrue(Arrays.asList(returned).get(0).contains(expected));
    }


    @Test
    void urlWithSlash(){
        String name = "D/D/D Supersight King Zero Maxwell";
        int version = 0;
        String rarity = "Common";
        String expansion = "LIOV";
        String expected = "https://www.cardmarket.com/en/YuGiOh/Products/Singles/Lightning-Overdrive/DDD-Supersight-King-Zero-Maxwell";

        UrlBuilder urlBuilder = new UrlBuilder();
        List<String> returned = urlBuilder.buildUrl(new CardInfo(name, version, rarity, expansion));
        
        assertTrue(Arrays.asList(returned).get(0).contains(expected));
    }


    @Test
    void urlWithEquals(){
        String name = "Damage = Reptile";
        int version = 0;
        String rarity = "Rare";
        String expansion = "ANGU";
        String expected = "https://www.cardmarket.com/en/YuGiOh/Products/Singles/Ancient-Guardians/Damage-Reptile";

        UrlBuilder urlBuilder = new UrlBuilder();
        List<String> returned = urlBuilder.buildUrl(new CardInfo(name, version, rarity, expansion));
        
        assertTrue(Arrays.asList(returned).get(0).contains(expected));
    }

    @Test
    void urlWithColon(){
        String name = "Number 39: Utopia";
        int version = 0;
        String rarity = "Ultra Rare";
        String expansion = "DUPO";
        String expected = "https://www.cardmarket.com/en/YuGiOh/Products/Singles/Duel-Power/Number-39-Utopia";

        UrlBuilder urlBuilder = new UrlBuilder();
        List<String> returned = urlBuilder.buildUrl(new CardInfo(name, version, rarity, expansion));
        
        assertTrue(Arrays.asList(returned).get(0).contains(expected));
    }


    @Test
    void urlWithAmpersand(){
        String name = "Ghost Reaper & Winter Cherries";
        int version = 0;
        String rarity = "Ultra Rare";
        String expansion = "DUPO";
        String expected = "https://www.cardmarket.com/en/YuGiOh/Products/Singles/Duel-Power/Ghost-Reaper-Winter-Cherries";

        UrlBuilder urlBuilder = new UrlBuilder();
        List<String> returned = urlBuilder.buildUrl(new CardInfo(name, version, rarity, expansion));
        
        assertTrue(Arrays.asList(returned).get(0).contains(expected));
    }

    @Test
    void urlWithAt(){
        String name = "Bururu @Ignister";
        int version = 0;
        String rarity = "Rare";
        String expansion = "IGAS";
        String expected = "https://www.cardmarket.com/en/YuGiOh/Products/Singles/Ignition-Assault/Bururu-Ignister";

        UrlBuilder urlBuilder = new UrlBuilder();
        List<String> returned = urlBuilder.buildUrl(new CardInfo(name, version, rarity, expansion));
        
        assertTrue(Arrays.asList(returned).get(0).contains(expected));
    }

    @Test
    void urlLotsOfSymbols(){
        String name = "Danger!? Tsuchinoko?";
        int version = 0;
        String rarity = "Ultra Rare";
        String expansion = "MP19";
        String expected = "https://www.cardmarket.com/en/YuGiOh/Products/Singles/2019-Gold-Sarcophagus-Tin-Mega-Pack/Danger-Tsuchinoko";

        UrlBuilder urlBuilder = new UrlBuilder();
        List<String> returned = urlBuilder.buildUrl(new CardInfo(name, version, rarity, expansion));
        
        assertTrue(Arrays.asList(returned).get(0).contains(expected));
    }

    @Test
    void urlDash() {
        String name = "Blue-Eyes White Dragon";
        int version = 0;
        String rarity = "Premium Gold Rare";
        String expansion = "MAGO";
        String expected = "https://www.cardmarket.com/en/YuGiOh/Products/Singles/Maximum-Gold/Blue-Eyes-White-Dragon";

        UrlBuilder urlBuilder = new UrlBuilder();
        List<String> returned = urlBuilder.buildUrl(new CardInfo(name, version, rarity, expansion));
        
        assertTrue(Arrays.asList(returned).get(0).contains(expected));
    }

    @Test
    void urlDashWithSpace() {
        String name = "Abyss Actor - Superstar";
        int version = 0;
        String rarity = "Secret Rare";
        String expansion = "DESO";
        String expected = "https://www.cardmarket.com/en/YuGiOh/Products/Singles/Destiny-Soldiers/Abyss-Actor-Superstar";

        UrlBuilder urlBuilder = new UrlBuilder();
        List<String> returned = urlBuilder.buildUrl(new CardInfo(name, version, rarity, expansion));
        
        assertTrue(Arrays.asList(returned).get(0).contains(expected));
    }

    @Test
    void urlWithParentheses1(){
        String name = "Knightmare Unicorn";
        int version = 1;
        String rarity = "Rare";
        String expansion = "GEIM";
        String expected = "https://www.cardmarket.com/en/YuGiOh/Products/Singles/Genesis-Impact/Knightmare-Unicorn-V1-Rare";

        UrlBuilder urlBuilder = new UrlBuilder();
        List<String> returned = urlBuilder.buildUrl(new CardInfo(name, version, rarity, expansion));
        
        assertTrue(Arrays.asList(returned).get(0).contains(expected));
    }

    @Test
    void urlWithParentheses2(){
        String name = "The Winged Dragon of Ra";
        int version = 2;
        String rarity = "Ghost Rare";
        String expansion = "LED7";
        String expected = "https://www.cardmarket.com/en/YuGiOh/Products/Singles/Legendary-Duelists-Rage-of-Ra/The-Winged-Dragon-of-Ra-V2-Ghost-Rare";

        UrlBuilder urlBuilder = new UrlBuilder();
        List<String> returned = urlBuilder.buildUrl(new CardInfo(name, version, rarity, expansion));
        
        assertTrue(Arrays.asList(returned).get(0).contains(expected));
    }

    @Test
    void urlQuotationMarks1() {
        String name = "\"A\" Cell Breeding Device";
        int version = 0;
        String rarity = "Common";
        String expansion = "FOTB";
        String expected = "https://www.cardmarket.com/en/YuGiOh/Products/Singles/Force-of-the-Breaker/A-Cell-Breeding-Device";

        UrlBuilder urlBuilder = new UrlBuilder();
        List<String> returned = urlBuilder.buildUrl(new CardInfo(name, version, rarity, expansion));
        
        assertTrue(Arrays.asList(returned).get(0).contains(expected));
    }

    @Test
    void urlQuotationMarks2() {
        String name = "\"A\" Cell Incubator";
        int version = 0;
        String rarity = "Common";
        String expansion = "GLAS";
        String expected = "https://www.cardmarket.com/en/YuGiOh/Products/Singles/Gladiators-Assault/A-Cell-Incubator";

        UrlBuilder urlBuilder = new UrlBuilder();
        List<String> returned = urlBuilder.buildUrl(new CardInfo(name, version, rarity, expansion));
        
        assertTrue(Arrays.asList(returned).get(0).contains(expected));
    }


    @Test
    void alternateRarities1(){
        String name = "Effect Veiler";
        int version = 2;
        String rarity = "Ultimate Rare";
        String expansion = "DREV";
        String expected = "https://www.cardmarket.com/en/YuGiOh/Products/Singles/Duelist-Revolution/Effect-Veiler-V-2";

        UrlBuilder urlBuilder = new UrlBuilder();
        List<String> returned = urlBuilder.buildUrl(new CardInfo(name, version, rarity, expansion));
        
        assertTrue(Arrays.asList(returned).get(0).contains(expected));
    }

    @Test
    void alternateRarities2(){
        String name = "Blue-Eyes White Dragon";
        int version = 2;
        String rarity = "Ultimate Rare";
        String expansion = "YSKR";
        String expected = "https://www.cardmarket.com/en/YuGiOh/Products/Singles/Starter-Deck-Kaiba-Reloaded/Blue-Eyes-White-Dragon-V-2";

        UrlBuilder urlBuilder = new UrlBuilder();
        List<String> returned = urlBuilder.buildUrl(new CardInfo(name, version, rarity, expansion));
        
        assertTrue(Arrays.asList(returned).get(0).contains(expected));
    }

    @Test
    void alternateRarities3(){
        String name = "Celestia, Lightsworn Angel";
        int version = 2;
        String rarity = "Ultimate Rare";
        String expansion = "LODT";
        String expected = "https://www.cardmarket.com/en/YuGiOh/Products/Singles/Light-of-Destruction/Celestia-Lightsworn-Angel-V-2-Ultimate-Rare";

        UrlBuilder urlBuilder = new UrlBuilder();
        List<String> returned = urlBuilder.buildUrl(new CardInfo(name, version, rarity, expansion));
        
        assertTrue(Arrays.asList(returned).get(0).contains(expected));
    }

    @Test
    void alternateRarities4(){
        String name = "Lightning Storm";
        int version = 2;
        String rarity = "Prismatic Secret Rare";
        String expansion = "IGAS";
        String expected = "https://www.cardmarket.com/en/YuGiOh/Products/Singles/Ignition-Assault/Lightning-Storm-V-2-Prismatic-Secret-Rare";

        UrlBuilder urlBuilder = new UrlBuilder();
        List<String> returned = urlBuilder.buildUrl(new CardInfo(name, version, rarity, expansion));

        assertTrue(Arrays.asList(returned).get(0).contains(expected));
    }

    @Test
    void testTest(){
        String name = "Lightning Storm";
        int version = 2;
        String rarity = "Prismatic Secret Rare";
        String expansion = "IGAS";
        String expected = "https://www.cardmarket.com/en/YuGiOh/Products/Singles/Ignition-Assault/Lightning-Storm-V-2-Prismatic-Secret-Rare";

        UrlBuilder urlBuilder = new UrlBuilder();
        List<String> returned = urlBuilder.buildUrl(new CardInfo(name, version, rarity, expansion));

        assertTrue(Arrays.asList(returned).get(0).contains(expected));
    }
}