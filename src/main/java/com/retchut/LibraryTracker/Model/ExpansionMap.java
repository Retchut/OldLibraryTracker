package com.retchut.LibraryTracker.Model;

import java.util.HashMap;
import java.util.Map;

final public class ExpansionMap {

    static Map<String, String> expansions;

    static{
        expansions = new HashMap<>();
        //Taken from https://yugioh.fandom.com/wiki/Expansion_Pack

        //Booster SP / Deck Build Packs
            //OCG
            //TCG equivalents
        expansions.put("THSF","The-Secret-Forces");
        expansions.put("HSRD", "HighSpeed-Riders");
        expansions.put("WIRA", "Wing-Raiders");
        expansions.put("DESO", "Destiny-Soldiers");
        expansions.put("FUEN", "Fusion-Enforcers");
        expansions.put("SPWA", "Spirit-Warriors");
        expansions.put("DASA", "Dark-Saviors");
        expansions.put("HISU", "Hidden-Summoners");
        expansions.put("INCH", "The-Infinity-Chasers");
        expansions.put("MYFI", "Mystic-Fighters");
        expansions.put("SESL", "Secret-Slayers");
        expansions.put("GEIM", "Genesis-Impact");
        expansions.put("ANGU", "Ancient-Guardians");

        //Collectors Packs / Collection Pack
            //OCG
            //TCG equivalents
        expansions.put("NUMH", "Number-Hunters");
        expansions.put("DRLG", "Dragons-of-Legend");
        expansions.put("DRL2", "Dragons-of-Legend-2");
        expansions.put("DRL3", "Dragons-of-Legend-Unleashed");
        expansions.put("BLLR", "Battles-of-Legend-Lights-Revenge");
        expansions.put("BLRR", "Battles-of-Legend-Relentless-Revenge");
        expansions.put("BLHR", "Battles-of-Legend-Heros-Revenge");
        expansions.put("BLAR", "Battles-of-Legend-Armageddon");
            //TCG compilations
        expansions.put("DLCS", "Dragons-of-Legend-The-Complete-Series");

        //Demo Decks

        //Duelist Packs
        expansions.put("DP1", "Duelist-Pack-Jaden-Yuki");
        expansions.put("DP2", "Duelist-Pack-Chazz-Princeton");
        expansions.put("DP03", "Duelist-Pack-Jaden-Yuki-2");
        expansions.put("DP04", "Duelist-Pack-Zane-Truesdale");
        expansions.put("DP05", "Duelist-Pack-Aster-Phoenix");
        expansions.put("DP06", "Duelist-Pack-Jaden-Yuki-3");
        expansions.put("DP07", "Duelist-Pack-Jesse-Anderson");
        expansions.put("DP08", "Duelist-Pack-Yusei");
        expansions.put("DPYG", "Duelist-Pack-Yugi");
        expansions.put("DP09", "Duelist-Pack-Yusei-2");
        expansions.put("DPKB", "Duelist-Pack-Kaiba");
        expansions.put("DP10", "Duelist-Pack-Yusei-3");
        expansions.put("DP11", "Duelist-Pack-Crow");
        expansions.put("DPBC", "Duelist-Pack-Battle-City");
        expansions.put("DPRP", "Duelist-Pack-Rivals-of-the-Pharaoh");
        expansions.put("DPDG", "Duelist-Pack-Dimensional-Guardians");
            //Legend Duelist    - OCG
            //Legendary Duelists
        expansions.put("LEDU", "Legendary-Duelists");
        expansions.put("LED2", "Legendary-Duelists-Ancient-Millennium");
        expansions.put("LED3", "Legendary-Duelists-White-Dragon-Abyss");
        expansions.put("LED4", "Legendary-Duelists-Sisters-of-the-Rose");
        expansions.put("LED5", "Legendary-Duelists-Immortal-Destiny");
        expansions.put("LED6", "Legendary-Duelists-Magical-Hero");
        expansions.put("LED7", "Legendary-Duelists-Rage-of-Ra");
        expansions.put("LED8", "Legendary-Duelists-Synchro-Storm");
            //Legendary Duelists Compilations
        expansions.put("LDS1", "Legendary-Duelists-Season-1");
        expansions.put("LDS2", "Legendary-Duelists-Season-2");

        //Expansion Packs - korean only

        //Extra Packs   - OCG

        //Gold Series
        expansions.put("GLD1", "Gold-Series-1");
        expansions.put("GLD2", "Gold-Series-2");
        expansions.put("GLD3", "Gold-Series-3");
        expansions.put("GLD4", "Gold-Series-4-Pyramids-Edition");
        expansions.put("GLD5", "Gold-Series-5-Haunted-Mine");
        expansions.put("PGLD", "Premium-Gold");
        expansions.put("PGL2", "Premium-Gold-2");
        expansions.put("PGL3", "Premium-Gold-Infinite-Gold");
        expansions.put("MAGO", "Maximum-Gold");

        //Hidden Arsenal
        expansions.put("HA01", "Hidden-Arsenal");
        expansions.put("HA02", "Hidden-Arsenal-2");
        expansions.put("HA03", "Hidden-Arsenal-3");
        expansions.put("HA04", "Hidden-Arsenal-4");
        expansions.put("HA05", "Hidden-Arsenal-5");
        expansions.put("HA06", "Hidden-Arsenal-6");
        expansions.put("HA07", "Hidden-Arsenal-7");
        expansions.put("HASE", "Hidden-Arsenal-Special-Edition");

        //Jump Festas   - OCG

        //Mega Packs
        expansions.put("RYMP", "Ra-Yellow-Mega-Pack");
        expansions.put("LC01", "Legendary-Collection");
        expansions.put("LCGX", "Legendary-Collection-2-Mega-Pack");
        expansions.put("LC02", "Legendary-Collection-2-The-Duel-Academy-Years");
        expansions.put("LCYW", "Legendary-Collection-3-Mega-Pack");
        expansions.put("LC03", "Legendary-Collection-3-Yugis-World");
        expansions.put("LC04", "Legendary-Collection-4-Joeys-World");
        expansions.put("LCJW", "Legendary-Collection-4-Mega-Pack");
        expansions.put("LC05", "Legendary-Collection-5Ds");
        expansions.put("LC5D", "Legendary-Collection-5Ds-Mega-Pack");
        expansions.put("LC06", "Legendary-Collection-Kaiba");
        expansions.put("LCKC", "Legendary-Collection-Kaiba-Mega-Pack");
        expansions.put("CT11", "2014-MegaTins");
        expansions.put("MP14", "2014-MegaTin-MegaPack");
        expansions.put("CT12", "2015-MegaTins");
        expansions.put("MP15", "2015-MegaTin-Mega-Pack");
        expansions.put("CT13", "2016-MegaTins");
        expansions.put("MP16", "2016-MegaTin-Mega-Pack");
        expansions.put("CT14", "2017-MegaTins");
        expansions.put("MP17", "2017-MegaTin-Mega-Pack");
        expansions.put("CT15", "2018-Mega-Tins");
        expansions.put("MP18", "2018-MegaTin-Mega-Pack");
        expansions.put("TN19", "2019-Gold-Sarcophagus-Tin");
        expansions.put("MP19", "2019-Gold-Sarcophagus-Tin-Mega-Pack");
        expansions.put("MP20", "2020-Tin-of-Lost-Memories-Mega-Pack");

        //Movie Packs
        expansions.put("MOV", "YuGiOh-The-Movie");
        expansions.put("YMP1", "3D-Bonds-Beyond-Time-Movie-Pack");
        expansions.put("MVP1", "The-Dark-Side-of-Dimensions-Movie-Pack");

        //Power-Up Packs / Enhancement Packs    - OCG

        //Premium Packs
        expansions.put("PP01", "Premium-Pack-1-Booster");
        expansions.put("PP02", "Premium-Pack-2-Booster");

        //Promotion Packs   - OCG

        //Special Packs - OCG

        //Star Packs
        expansions.put("SP13", "Star-Pack-2013");
        expansions.put("SP14", "Star-Pack-2014");
        expansions.put("SP15", "Star-Pack-Arc-V-Booster");
        expansions.put("SP17", "Star-Pack-Battle-Royal");
        expansions.put("SP18", "Star-Pack-VRAINS");

        //Speed Duel Booster Packs

        //Other
        expansions.put("YAP1", "Anniversary-Pack");
        expansions.put("EP1", "Exclusive-Pack-1");
            //OCG
            //TCG
        expansions.put("DUSA", "Duelist-Saga");
        expansions.put("DUPO", "Duel-Power");
        expansions.put("DUOV", "Duel-Overload");
        expansions.put("PEVO", "Pendulum-Evolution");
        expansions.put("SHVA", "Shadows-in-Valhalla");
        expansions.put("FIGA", "Fists-of-the-Gadgets");
        expansions.put("TOCH", "Toon-Chaos");
        expansions.put("GFTP", "Ghosts-From-the-Past");
        expansions.put("MIL1", "Millennium-Pack");
        expansions.put("TKN1", "Token-Promos-1");
        expansions.put("TKN2", "Token-Promos-2");
        expansions.put("TKN3", "Token-Promos-3");
        expansions.put("TKN4", "Token-Promos-4");
        expansions.put("WC4", "World-Championship-2004");
        expansions.put("WC5", "World-Championship-2005");
        expansions.put("WC6", "World-Championship-2006");
        expansions.put("WC07", "World-Championship-2007");
        expansions.put("WC08", "World-Championship-2008");
        expansions.put("WCPP", "World-Championship-2010-Card-Pack");
        expansions.put("WC11", "World-Championship-2011-Card-Pack");
        expansions.put("WSUP", "World-Superstars");
    }

    public String getExpansion(String key){
        if(expansions.containsKey(key))
            return expansions.get(key);
        return "";
    }
}
