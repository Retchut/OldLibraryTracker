package com.retchut.LibraryTracker.Model;

import com.retchut.LibraryTracker.Algorithms;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Library {
    File libraryFile;
    List<Card> collection;

    /**
     * @brief Default constructor
     */
    public Library(){
        this.libraryFile = new File("library.txt");
        this.collection = new ArrayList<>();
    }

    /**
     * @brief Loads library from file
     */
    public void loadLibrary() throws IOException {
        System.out.println();
        if(libraryFile.createNewFile()){
            System.out.println("The file library.txt did not yet exist, so it was created.");
        }
        else{
            System.out.println("A library.txt was detected and will be loaded.");
            boolean success = true;
            Scanner fileReader = new Scanner(libraryFile);
            fileReader.useDelimiter("[|\\n]");
            String name, expansion, condition, language;
            boolean firstEd;
            int amount;
            List<Card> loadedCollection = new ArrayList<>();
            try{
                while(fileReader.hasNextLine()){
                    name = fileReader.next();
                    expansion = fileReader.next();
                    condition = fileReader.next();
                    language = fileReader.next();
                    firstEd = fileReader.nextBoolean();
                    amount = fileReader.nextInt();
                    fileReader.nextLine();
                    loadedCollection.add(new Card(name, expansion, Card.CONDITION.valueOf(condition), Card.LANGUAGE.valueOf(language), firstEd, amount));
                }
            }
            catch(IllegalArgumentException e){
                System.out.println("That library file is invalid. No library was loaded.");
                success = false;
                fileReader.close();
            }
            if(success){
                this.collection = loadedCollection;
                System.out.println("The library was loaded successfully.");
            }
        }
    }

    /**
     * @brief Saves library to file
     */
    public void saveLibrary() throws IOException {
        FileWriter fileWriter = new FileWriter("library.txt");
        String name, expansion, condition, language;
        boolean firstEd;
        int amount;
        for(Card c : collection){
            name = c.getName();
            expansion = c.getExpansion();
            condition = c.getCondition().name();
            language = c.getLanguage().name();
            firstEd = c.getFirstEd();
            amount = c.getAmount();
            fileWriter.write(name + "|" + expansion + "|" + condition + "|" + language + "|" + firstEd + "|" + amount + "\n");
        }
        fileWriter.close();
    }

    /**
     * @brief Prints the library
     * @param scanner Scanner to read input
     */
    public void printLib(Scanner scanner){
        //TODO: Clear console
        //check if the collection is empty
        if(this.collection.isEmpty()){
            System.out.println("The library is empty.");
        }
        else{
            System.out.println("Amount\t|\tExpansion\t|\tcom.retchut.LibraryTracker.Model.Card Name");
            for(Card current : collection){
                System.out.println(current.getAmount() + "\t|\t" + current.getExpansion() + "\t|\t" + current.getName());
            }
        }
        //TODO: find a better way to make this work
        System.out.println("Please input something to exit.");
        scanner.nextLine();
    }

    /**
     * @brief Adds a new card to the library
     * @param scanner Scanner to read input
     * @return 0 on success, 1 otherwise
     */
    public int addCard(Scanner scanner){
        String name, expansion;
        Card.CONDITION condition;
        Card.LANGUAGE language;
        boolean firstEd;
        int amount;
        //TODO: Clear console
        try{
            String input;

            //Get card name
            System.out.println("Please input the name of the card you'd like to add, taking into account any possible alternate versions, if said versions exist:");
            System.out.println("E.g.: \"The Winged Dragon of Ra (V.2 - Ghost Rare)\"");
            name = scanner.nextLine();

            //Get card expansion
            System.out.println("Please input the card expansion:");
            expansion = scanner.nextLine();

            //Get card condition
            System.out.println("Please input the condition of the card (M, NM, EX, GD, LP, PL or P):");
            input = scanner.nextLine();
            condition = Card.CONDITION.valueOf(input);

            //Get card language
            System.out.println("Please input the card language (ENGLISH, FRENCH, GERMAN, SPANISH, ITALIAN or PORTUGUESE):");
            input = scanner.nextLine();
            language = Card.LANGUAGE.valueOf(input);

            //Get card edition
            System.out.println("Is the card 1st ed? (y/n)");
            input = scanner.nextLine().toLowerCase();
            switch(input){
                case "y":
                    firstEd = true;
                    break;
                case "n":
                    firstEd = false;
                    break;
                default:
                    System.out.println("That is not a valid answer.");
                    return 1;
            }

            //Get number of copies owned
            System.out.println("Please input the number of copies you own:");
            amount = scanner.nextInt();

            //Create card
            this.collection.add(new Card(name, expansion, condition, language, firstEd, amount));
            System.out.println("A new card has been created with the given information and added to the library.");
        }
        //TODO: find a better way to do this
        catch(InputMismatchException e){
            System.out.println("You must input a valid integer when asked to.");
            return 1;
        }
        catch(IllegalArgumentException e){
            System.out.println("That's not a valid value.");
            return 1;
        }

        return 0;
    }

    /**
     * @brief Accesses a card on the library
     * @param scanner Scanner to read input
     * @return 0 on success, 1 otherwise
     */
    public int accessCard(Scanner scanner){
        //TODO: Clear console
        if(this.collection.isEmpty()){
            System.out.println("The library is empty.");
            return 1;
        }
        else{
            scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            int pos = Algorithms.binarySearch(this.collection, 0, this.collection.size() - 1, name);

            if(pos == -1){
                //TODO: Clear console
                System.out.println("That card is not on your library.");
                return 1;
            }
            else{
                return this.collection.get(pos).modifyCard(scanner);
            }
        }
    }

    /**
     * @brief Removes a card from the library
     * @param scanner Scanner to read input
     * @return 0 on success, 1 otherwise
     */
    public int removeCard(Scanner scanner){
        //TODO: Clear console
        if(this.collection.isEmpty()){
            System.out.println("The library is empty.");
            return 1;
        }
        else{
            scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            int pos = Algorithms.binarySearch(this.collection, 0, this.collection.size() - 1, name);

            if(pos == -1){
                //TODO: Clear console
                System.out.println("That card is not on your library.");
                return 1;
            }
            else{
                this.collection.remove(pos);
                return 0;
            }
        }
    }
}
