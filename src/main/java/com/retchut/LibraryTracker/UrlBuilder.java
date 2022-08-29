package com.retchut.LibraryTracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final public class UrlBuilder {
    private StringBuilder urlStart;
    private List<String> possibleUrls;

    private void buildUrlExpansion(String expansionKey){
        String expansion = ExpansionMap.getExpansion(expansionKey);
        if(expansion == "")
            System.out.println(expansionKey + ": There's no such expansion");
            //TODO: throw exception / return false and go back
        urlStart.append(expansion);
        urlStart.append('/');
    }

    private void buildUrlNames(String name, int version, String rarity){
        if(version > 0){
            //Add the 4 possible different urls that cardmarket may use for the item, in order of most common to least common
            possibleUrls.add(urlStart.toString() + makeUrl(name + " (V" + version + " " + rarity + ")"));
            possibleUrls.add(urlStart.toString() + makeUrl(name + " (V-" + version + " " + rarity + ")"));
            possibleUrls.add(urlStart.toString() + makeUrl(name + " (V" + version + ")"));
            possibleUrls.add(urlStart.toString() + makeUrl(name + " (V-" + version + ")"));
        }
        else{
            possibleUrls.add(urlStart.toString() + makeUrl(name));
        }
    }

    private String makeUrl(String urlName){
        StringBuilder buildName = new StringBuilder();
        //Characters cardmarket seems to ignore, when creating the url of cards
        List<Character> ignoreChars = Arrays.asList('"', '?', '!', ',', '@', '/', '&', '=', ':', '(', ')', '.');

        for(int i = 0; i < urlName.length(); i++){
            char current = urlName.charAt(i);
            if(ignoreChars.contains(current)){
                //ignore
            }
            else if(current == '-' || current == ' '){
                //replace space with '-', or write '-', if one hasn't been already written
                if(buildName.charAt(buildName.length()-1) != '-')
                    buildName.append('-');
            }
            else{
                //add normal char to url
                buildName.append(current);
            }
        }
        return buildName.toString();
    }

    public UrlBuilder(){
        this.urlStart = new StringBuilder();
        this.possibleUrls = new ArrayList<String>();
    }


    public List<String> buildUrl(CardInfo cardInfo){
        this.urlStart.append("https://www.cardmarket.com/en/YuGiOh/Products/Singles/");
        buildUrlExpansion(cardInfo.getExpansion());
        buildUrlNames(cardInfo.getName(), cardInfo.getVersion(), cardInfo.getRarity());
        return possibleUrls;
    }
}
