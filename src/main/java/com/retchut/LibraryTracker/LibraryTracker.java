package com.retchut.LibraryTracker;

import com.retchut.LibraryTracker.Model.Card;
import com.retchut.LibraryTracker.Model.Crawler;
import com.retchut.LibraryTracker.Model.Library;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryTracker {

    public static void main(String[] args) {

        //Initialize library object
        Library lib = new Library();
        try{
            //Load library
            lib.loadLibrary();

            trackerLoop(lib);

            //Save library
            lib.saveLibrary();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void trackerLoop(Library lib){
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
                        if(updatePrices(scanner) != 0)
                            System.out.println("Operation error. Please try again.");
                        break;
                    case 0:
                        System.out.println("The program will now exit, and your library will be saved.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Please input an integer from 0-4.");

                }
            }
            catch(InputMismatchException e){
                System.out.println("You must input a valid integer.");
                scanner.next();
            }
        }
    }

    private Pair<String, String> getCardInfo(Scanner scanner){
        String name, expansion;
        //TODO: Clear console
        try{
            //Get card name
            System.out.println("Please input the card's name, taking into account any possible alternate versions, if said versions exist.");
            System.out.println("E.g.: \"The Winged Dragon of Ra (V.2 - Ghost Rare)\"");
            name = scanner.nextLine();

            //Get card expansion
            System.out.println("Please input the card expansion:");
            expansion = scanner.nextLine();
        }
        //TODO: find a better way to do this
        catch(InputMismatchException e){
            System.out.println("Please input a correct value.");
            return new Pair();
        }
        catch(IllegalArgumentException e){
            System.out.println("That's not a valid value.");
            return new Pair();
        }
        return new Pair<String, String>(name, expansion);
    }

    private static int lookUpPrice(Scanner scanner){
        Pair<String, String> cardInfo = getCardInfo(scanner);
        String name = cardInfo.getKey();
        String expansion = cardInfo.getValue();

        Crawler crawler = new Crawler(name, expansion);
        System.out.println(name);
        System.out.println("From: " + crawler.crawl());

        return 0;
    }

    private static int updatePrices(Scanner scanner){
        List<Card> collection = library.getCollection();
        for(Card card : collection){
            Crawler crawler = new Crawler(name, expansion);
            double newPrice = crawler.crawl()
            if(newPrice == 0.0){
                System.out.println("Error fetching " + name + "(" + expansion + ")'s price. No changes were made...");
            }
            else{
                card.setPrice(crawler.crawl)
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
