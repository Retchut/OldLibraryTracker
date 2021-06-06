package com.retchut.LibraryTracker.Model;

final public class UrlBuilder {
    private StringBuilder url;

    private void getUrlExpansion(String expansionKey){
        String expansion = ExpansionMap.getExpansion(expansionKey);
        if(expansion == "")
            //TODO: throw exception / return false and go back
        url.append(expansion);
        url.append('/');
    }

    private void getUrlName(String name){
        for(int i = 0; i < name.length(); i++){
            char current = name.charAt(i);
            //TODO: put this in an array, and use contains (is it more efficient?)
            if(current == '"' || current == '?' || current == '!' || current == ',' || current == '@'|| current == '/'){
                //ignore
            }
            else if(current == '-' || current == ' '){
                //replace space with '-', or write '-', if one hasn't been already written
                if(url.charAt(url.length()-1) != '-')
                    url.append('-');
            }
            else{
                //add normal char to url
                url.append(current);
            }
        }
        //TODO: support multiple versions of cards
    }
    public UrlBuilder(){
        this.url = new StringBuilder();
    }


    public String buildUrl(String name, String expansion){
        url.append("https://www.cardmarket.com/en/YuGiOh/Products/Singles/");
        getUrlExpansion(expansion);
        getUrlName(name);
        return url.toString();
    }
}
