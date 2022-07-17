package com.retchut.LibraryTracker;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Card {
    private CardInfo cardInfo;
    private CONDITION condition;
    private LANGUAGE language;
    private boolean firstEd;
    private int amount;
    private double price;

    //Getters
    public CardInfo getCardInfo(){ return this.cardInfo; }
    public String getCardName(){ return this.cardInfo.getName(); }
    public String getCardExpansion(){ return this.cardInfo.getExpansion(); }
    public String getCardRarity(){ return this.cardInfo.getRarity(); }
    public CONDITION getCondition(){ return this.condition; }
    public LANGUAGE getLanguage(){ return this.language; }
    public boolean getFirstEd(){ return this.firstEd; }
    public int getAmount(){ return this.amount; }
    public double getPrice(){ return this.price; }

    //Setters
    public void setCardInfo(CardInfo newCardInfo){ this.cardInfo = newCardInfo; }
    public void setName(String newName){ this.cardInfo.setName(newName); }
    public void setExpansion(String newExpansion){ this.cardInfo.setExpansion(newExpansion); }
    public void setCondition(CONDITION newCondition){ this.condition = newCondition; }
    public void setLanguage(LANGUAGE newLanguage){ this.language = newLanguage; }
    public void setFirstEd(boolean newFirstEd){ this.firstEd = newFirstEd; }
    public void setAmount(int newAmount) { this.amount = newAmount; }
    public void setPrice(double newPrice) { this.price = newPrice; }

    enum CONDITION { M, NM, EX, GD, LP, PL, P}
    enum LANGUAGE {ENGLISH, FRENCH, GERMAN, SPANISH, ITALIAN, PORTUGUESE}

    public Card(){
        this.cardInfo = new CardInfo();
        this.condition = CONDITION.valueOf("M");
        this.language = LANGUAGE.valueOf("ENGLISH");
        this.firstEd = false;
        this.amount = 0;
        this.price = 0.0;
    }

    /**
     * @brief Default constructor
     */
    public Card(CardInfo cardInfo, CONDITION condition, LANGUAGE language, boolean firstEd, int amount, double price){
        setCardInfo(cardInfo);
        setCondition(condition);
        setLanguage(language);
        setFirstEd(firstEd);
        setAmount(amount);
        setPrice(price);
    }

    /**
     * @brief Prints detailed card data
     */
    private void printCard(){
        //TODO: Clear console
        System.out.println("Name: " + cardInfo.getName());
        System.out.println("Expansion: " + cardInfo.getExpansion());
        System.out.println("Rarity: " + cardInfo.getRarity());
        System.out.println("Condition: " + getCondition());
        System.out.println("Language: " + getLanguage());
        System.out.println("Is First Ed: " + getFirstEd());
        System.out.println("Amount: " + getAmount());
        System.out.println("Price : " + getPrice());
    }

    /**
     * @brief Adds a number of copies to the library
     * @param scanner Scanner to read input
     * @return 0 on success, 1 otherwise
     */
    private int addCopies(Scanner scanner){
        //TODO: Clear console
        while(true){
            try{
                //clear console
                System.out.println("Please input the number of cards you want to add.");
                int toAdd = scanner.nextInt();
                scanner.nextLine();

                if(toAdd <= 0){
                    System.out.println("That is an invalid amount. No changes were made.");
                }
                else{
                    setAmount(getAmount() + toAdd);
                    System.out.println("You added " + toAdd + " copies of " + cardInfo.getExpansion() + " " + cardInfo.getName() + "to your library.");
                    System.out.println("You now own " + getAmount() + " copies of this card.");
                }
                return 1;
            }
            catch(InputMismatchException e){
                System.out.println("You must input a valid integer.");
                scanner.nextLine();
            }
        }
    }


    /**
     * @brief Removes a number of copies from the library
     * @param scanner Scanner to read input
     * @return 0 on success, 1 otherwise
     */
    private int removeCopies(Scanner scanner){
        while(true){
            try{
                //TODO: Clear console
                System.out.println("Please input the number of cards you want to remove.");
                int toRemove = scanner.nextInt();
                scanner.nextLine();

                if(toRemove <= 0){
                    System.out.println("That is an invalid amount. No changes were made.");
                    return 1;
                }
                else if(toRemove > getAmount()){
                    System.out.println("That amount is larger than the copies of this card you currently own.");
                    System.out.println("You currently own " + getAmount() + " copies of " + cardInfo.getExpansion() + " " + cardInfo.getName() + ".");
                }
                else{
                    setAmount(getAmount() - toRemove);
                    System.out.println("You removed " + toRemove + " copies of " + cardInfo.getExpansion() + " " + cardInfo.getName() + "to your library.");
                    System.out.println("You now own " + getAmount() + " copies of this card.");
                    return 0;
                }
            }
            catch(InputMismatchException e){
                System.out.println("You must input a valid integer.");
                scanner.nextLine();
            }
        }
    }

    /**
     * @brief Modifies card's data
     * @param scanner Scanner to read input
     * @return 0 on success, 1 otherwise
     */
    public int modifyCard(Scanner scanner){
        while(true){
            try{
                //TODO: Clear console
                System.out.println("Please input what you want to do.");
                System.out.println("1 - View card data.");
                System.out.println("2 - Add copies of this card to the library.");
                System.out.println("3 - Remove copies of this card from the library.");
                System.out.println("4 - Update this card's price.");
                System.out.println("0 - Go back.");
                int input = scanner.nextInt();
                scanner.nextLine();

                switch(input){
                    case 1:
                        this.printCard();
                        break;
                    case 2:
                        if(this.addCopies(scanner) != 0)
                            return 1;
                        break;
                    case 3:
                        if(this.removeCopies(scanner) != 0)
                            return 1;
                        break;
                    case 4:
                        if(this.updatePrice() != 0)
                            return 1;
                        break;
                    case 0:
                        return 0;
                    default:
                        System.out.println("Please input an integer from 0-3.");
                }
            }
            catch(InputMismatchException e){
                System.out.println("You must input a valid integer.");
                scanner.nextLine();
            }
        }
    }


    /**
     * @brief Modifies card's data
     * @param scanner Scanner to read input
     * @return 0 on success, 1 otherwise
     */
    public int updatePrice(){
        CardInfo cardInfo = this.getCardInfo();
        Crawler crawler = new Crawler(cardInfo);
        double newPrice = crawler.crawl();
        if(newPrice == 0.0){
            System.out.println("Error fetching " + cardInfo.getName() + "(" + cardInfo.getExpansion() + ")'s price. No changes were made...");
            return 1;
        }
        else{
            this.setPrice(newPrice);
            return 0;
        }
    }

    /**
     * @brief Default card comparison
     * @param other
     * @return Comparison by name
     */
    public int compareTo(Card other){
        return this.getCardName().compareTo(other.getCardName());
    }
}
