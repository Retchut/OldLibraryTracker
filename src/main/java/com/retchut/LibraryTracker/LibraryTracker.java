package com.retchut.LibraryTracker;

import com.retchut.LibraryTracker.Card;
import com.retchut.LibraryTracker.Crawler;
import com.retchut.LibraryTracker.Library;
import com.retchut.LibraryTracker.CardInfo;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

public class LibraryTracker {

    public static void main(String[] args) {

        //Initialize library object
        Library lib = new Library();
        try{
            //Load library
            lib.loadLibrary();

            boolean save = trackerLoop(lib);

            //Save library
            if(save) lib.saveLibrary();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private static boolean trackerLoop(Library lib){
        Scanner scanner = new Scanner(System.in);
        while(true){
            try{
                //TODO: Clear console
                System.out.println();
                System.out.println("Please input what you want to do.");
                System.out.println("1 - View your card collection.");
                System.out.println("2 - Add cards to the library.");
                System.out.println("3 - Modify a card in the library.");
                System.out.println("4 - Remove cards from the library.");
                System.out.println("5 - Look up a specific card's value.");
		        System.out.println("6 - Update the price of all cards in the library.");
                System.out.println();
                System.out.println("9 - Exit without saving the library.");
                System.out.println("0 - Exit and save the library.");
                int input = scanner.nextInt();
                scanner.nextLine();
                System.out.println();

                switch(input){
                    case 1:
                        lib.printLib(scanner);
                        break;
                    case 2:
                        if (lib.addCard(scanner) != 0)
                            System.out.println("The operation was canceled. No changes to the library were made. Try again.");
                        break;
                    case 3:
                        if(lib.accessCard(scanner) != 0)
                            System.out.println("The operation was canceled. No changes to the library were made. Try again.");
                        break;
                    case 4:
                        if(lib.removeCard(scanner) != 0)
                            System.out.println("The operation was canceled. No changes to the library were made. Try again.");
                        break;
                    case 5:
                        if(lookUpPrice(scanner) != 0)
                            System.out.println("Operation error. Please try again.");
                        break;
                    case 6:
                        updatePrices(lib, scanner);
                        break;
                    case 9:
                        System.out.println("The program will now exit. No changes to the library were made.");
                        scanner.close();
                        return false;
                    case 0:
                        System.out.println("The program will now exit, and your library will be saved.");
                        scanner.close();
                        return true;
                    default:
                        System.out.println("Please input a valid integer.");
                }
            }
            catch(InputMismatchException e){
                System.out.println("You must input a valid integer.");
                scanner.next();
            }
        }
    }

    private static CardInfo getCardInfo(Scanner scanner){
        CardInfo cardInfo = new CardInfo();
        //TODO: Clear console
        try{
            String input = "";

            //Get card name
            System.out.println("Please input the name of the card you'd like to add.");
            input = scanner.nextLine();
            cardInfo.setName(input);

            //Get card version number
            System.out.println("If the card has any alternate versions in this set, please input the card's version number.");
            System.out.println("If it does not, please input 0.");
            int altVer = scanner.nextInt();
            scanner.nextLine();
            if(altVer < 0){
                System.out.println("That is not a valid answer.");
                return new CardInfo();
            }
            else if (altVer >= 0){
                cardInfo.setVersion(altVer);
            }
            
            //Get card rarity
            System.out.println("Please input the rarity of the card.");
            input = scanner.nextLine();
            cardInfo.setRarity(input);

            //Get card expansion
            System.out.println("Please input the card expansion:");
            input = scanner.nextLine();
            cardInfo.setExpansion(input);
        }
        //TODO: find a better way to do this
        catch(InputMismatchException e){
            System.out.println("Please input a correct value.");
            return new CardInfo();
        }
        catch(IllegalArgumentException e){
            System.out.println("That's not a valid value.");
            return new CardInfo();
        }
        return cardInfo;
    }

    private static int lookUpPrice(Scanner scanner){
        CardInfo cardInfo = getCardInfo(scanner);

        if(cardInfo.getName().equals("") && cardInfo.getExpansion().equals("")) return 1;

        Crawler crawler = new Crawler(cardInfo);
        System.out.println(cardInfo.getName());
        System.out.println("From: " + crawler.crawl());

        return 0;
    }

    private static void updatePrices(Library lib, Scanner scanner){
        List<Card> collection = lib.getCollection();
        for(Card card : collection){
            CardInfo cardInfo = card.getCardInfo();
            System.out.print("Fetching " + cardInfo.getName() + "...\t");
            Crawler crawler = new Crawler(cardInfo);
            double newPrice = crawler.crawl();
            if(newPrice == 0.0){
                System.out.println("Error fetching " + cardInfo.getName() + "(" + cardInfo.getExpansion() + ")'s price. No changes were made...");
                System.out.println("Failure");
            }
            else{
                card.setPrice(newPrice);
                System.out.println("Success");
            }
        }
    }


/*
    private static String osName = System.getProperty("os.name").toLowerCase();

    public static void clearConsole() throws IOException {
        switch(osName){
            case "linux":
                Runtime.getRuntime().exec("clear");
                break;
            case "windows":
                Runtime.getRuntime().exec("cls");
                break;
        }
    }
    */
}
