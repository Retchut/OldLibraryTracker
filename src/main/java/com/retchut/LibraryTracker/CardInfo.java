package com.retchut.LibraryTracker;

public class CardInfo {
    private String name, rarity, expansion;
    private int version;

    public CardInfo(){
      this.name = "";
      this.version = 0;
      this.rarity = "";
      this.expansion = "";
    }

    public CardInfo(String n, int v, String r, String e)
    {
      this.name = n;
      this.version = v;
      this.rarity = r;
      this.expansion = e;
      
    }

    //---------------------------------------SETTERS
    public void setName(String n){
      this.name = n;
    }

    public void setVersion(int v){
      this.version = v;
    }

    public void setRarity(String r){
      this.rarity = r;
    }

    public void setExpansion(String e){
      this.expansion= e;
    }


    //---------------------------------------GETTERS
    public String getName()
    {
      return this.name;
    }

    public int getVersion()
    {
      return this.version;
    }

    public String getRarity()
    {
      return this.rarity;
    }

    public String getExpansion()
    {
      return this.expansion;
    }
}