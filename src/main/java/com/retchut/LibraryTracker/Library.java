package com.retchut.LibraryTracker;

import com.retchut.LibraryTracker.Algorithms;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Library {
    final int PRINT_MAX_ELEMENTS = 20;

    File libraryFile;
    List<Card> collection;

    Comparator<Card> cardNameComparator = Comparator.comparing(Card::getCardName);
    Comparator<Card> cardPriceComparator = Comparator.comparing(Card::getPrice);
    Comparator<Card> cardExpansionComparator = Comparator.comparing(Card::getCardExpansion);
    Comparator<Card> cardRarityComparator = Comparator.comparing(Card::getCardRarity);

    /**
     * @brief Default constructor
     */
    public Library(){
        this.libraryFile = new File("library.txt");
        this.collection = new ArrayList<>();
    }

    public List<Card> getCollection(){
        return this.collection;
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
            String name, rarity, expansion, condition, language;
            boolean firstEd;
            int version, amount;
            double price;
            int line = 1;
            List<Card> loadedCollection = new ArrayList<>();
            int check = 0;
            try{
                while(fileReader.hasNextLine()){
                    check = 0;
                    name = fileReader.next();
                    check++;
                    version = fileReader.nextInt();
                    check++;
                    rarity = fileReader.next();
                    check++;
                    expansion = fileReader.next();
                    check++;
                    condition = fileReader.next();
                    check++;
                    language = fileReader.next();
                    check++;
                    firstEd = fileReader.nextBoolean();
                    check++;
                    amount = fileReader.nextInt();
                    check++;
                    price = fileReader.nextDouble();
                    check++;
                    fileReader.nextLine();
                    loadedCollection.add(new Card(new CardInfo(name, version, rarity, expansion), Card.CONDITION.valueOf(condition), Card.LANGUAGE.valueOf(language), firstEd, amount, price));
                    line++;
                }
            }
            catch(IllegalArgumentException e){
                e.printStackTrace();
                System.out.println("Failed reading line " + line + " past check number " + check + " of the library file. No library was loaded.");
                success = false;
                fileReader.close();
            }
            catch(InputMismatchException e){
                e.printStackTrace();
                System.out.println("Failed reading line " + line + " past check number " + check + " of the library file. No library was loaded.");
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
        String name, rarity, expansion, condition, language;
        boolean firstEd;
        int version, amount;
        double price;
        for(Card c : collection){
            name = c.getCardInfo().getName();
            version = c.getCardInfo().getVersion();
            rarity = c.getCardInfo().getRarity();
            expansion = c.getCardInfo().getExpansion();
            condition = c.getCondition().name();
            language = c.getLanguage().name();
            firstEd = c.getFirstEd();
            amount = c.getAmount();
            price = c.getPrice();
            fileWriter.write(name + "|" + version + "|" + rarity + "|" + expansion + "|" + condition + "|" + language + "|" + firstEd + "|" + amount + "|" + price + "\n");
        }
        fileWriter.close();
    }

    /**
     * @brief Prints the library
     * @param scanner Scanner to read input
     */
    public void printLib(Scanner scanner){
        try {
            System.out.println("Which field do you want to sort by?");
            System.out.println("1 - Name (Asc)");
            System.out.println("2 - Name (Desc)");
            System.out.println("3 - Price (Asc)");
            System.out.println("4 - Price (Desc)");
            System.out.println("5 - Expansion (Asc)");
            System.out.println("6 - Expansion (Desc)");
            System.out.println("7 - Rarity");
            int input = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            if(sortLibrary(input) != 0){
                throw new InputMismatchException();
            }
        }
        catch(InputMismatchException e){
            System.out.println("That's not a valid option. Sorting by name.");
            scanner.nextLine();
            collection.sort(cardNameComparator);
        }

        //TODO: Clear console
        //check if the collection is empty
        if(this.collection.isEmpty()){
            System.out.println("The library is empty.");
        }
        else{
            int itemsToDisplay = PRINT_MAX_ELEMENTS;
            int collectionSize = collection.size();
            int fullPages = collectionSize / PRINT_MAX_ELEMENTS;
            boolean hasLeftover = (collectionSize % fullPages) != 0;
            int currentPage = 0;
            int pageNum = fullPages + ((hasLeftover) ? 1 : 0);

            boolean loop = true;
            do{
                if(hasLeftover && currentPage == fullPages + 1){
                    itemsToDisplay = collectionSize % PRINT_MAX_ELEMENTS;
                }
                int start = currentPage * PRINT_MAX_ELEMENTS;
                printSubCollection(start, start + itemsToDisplay);
                System.out.println((currentPage+1) + "/" + pageNum);
                System.out.println("Please input a/d to see the previous/next cards in your collection");
                System.out.println("Input anything else to quit this screen.");
                //TODO: cases where the input starts with a letter
                char input = scanner.next().charAt(0);
                scanner.nextLine();
                switch(input){
                    case 'a':
                        if(currentPage == 0){
                            System.out.println("Can't go back.");
                            break;
                        }
                        currentPage--;
                        break;
                    case 'd':
                        if(currentPage == pageNum-1){
                            System.out.println("Can't go forward.");
                            break;
                        }
                        currentPage++;
                        break;
                    default:
                        loop = false;
                }
                System.out.println();
            } while(loop);
        }
    }

    private void printSubCollection(int start, int end){
        String amStr = " Amount ";
        String prStr = "  Price  ";
        String expStr = " Expansion ";
        String rarStr = "    Rarity    ";
        String naStr  = " Card Name ";
        List<Card> subCollection = collection.subList(start, end);
        System.out.println();
        System.out.println(amStr + "|" + prStr + "|" + expStr + "|" + rarStr + "|" + naStr);
        for(Card current : subCollection){
            System.out.println(
                    Algorithms.padString(String.valueOf(current.getAmount()),  amStr.length())  + "|"
                            + Algorithms.padString(String.valueOf(current.getPrice()), prStr.length())  + "|"
                            + Algorithms.padString(current.getCardExpansion(),         expStr.length()) + "|"
                            + Algorithms.padString(current.getCardRarity(),            rarStr.length()) + "|"
                            + Algorithms.padString(current.getCardName(),              0)
            );
        }
        System.out.println();
    }

    /**
     * @brief Adds a new card to the library
     * @param scanner Scanner to read input
     * @return 0 on success, 1 otherwise
     */
    public int addCard(Scanner scanner){
        CardInfo cardInfo = new CardInfo();
        Card.CONDITION condition;
        Card.LANGUAGE language;
        boolean firstEd;
        int amount;
        double price;
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
                return 1;
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
            scanner.nextLine();

            Crawler crawler = new Crawler(cardInfo);
            price = crawler.crawl();
            if(price == 0.0){
                System.out.println("Error fetching " + cardInfo.getName() + "(" + cardInfo.getExpansion() + ")'s price. The price was set to 0.0.");
            }

            //Create card
            this.collection.add(new Card(cardInfo, condition, language, firstEd, amount, price));
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
            System.out.println("Please input the name of the card you want to access.");
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
            System.out.println("Please input the name of the card to be removed.");
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

    private int sortLibrary(int choice){
        switch(choice){
            case 1:
                collection.sort(cardNameComparator);
                break;
            case 2:
                collection.sort(cardNameComparator.reversed());
                break;
            case 3:
                collection.sort(cardPriceComparator);
                break;
            case 4:
                collection.sort(cardPriceComparator.reversed());
                break;
            case 5:
                collection.sort(cardExpansionComparator);
                break;
            case 6:
                collection.sort(cardExpansionComparator.reversed());
                break;
            case 7:
                collection.sort(cardRarityComparator);
                break;
            default:
                return 1;
        }
        return 0;
    }
}
