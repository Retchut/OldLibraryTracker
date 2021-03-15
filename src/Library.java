import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Library {
    ArrayList<Card> collection;
    Algorithms alg = new Algorithms();

    public void loadLibrary(){
    }

    public void saveLibrary(){

    }

    public void printLib(){
        //TODO: Clear console
        if(this.collection.isEmpty()){
            System.out.println("The library is empty.");
        }
        else{
            System.out.println("Amount\t|\tExpansion\t|\tCard Name");
            for(Card current : collection){
                System.out.println(current.getAmount() + "\t|\t" + current.getExpansion() + "\t|\t" + current.getName());
            }
        }
        //TODO: find a better way to make this work
        System.out.println("\nPlease input something to exit.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return;
    }

    public int addCard(){
        Scanner scanner = new Scanner(System.in);
        String name, expansion, condition, language, boolInput;
        boolean firstEd;
        int amount;
        //TODO: Clear console
        try{
            //Get card name
            System.out.println("Please input the name of the card you'd like to add:");
            name = scanner.nextLine();

            //Get card expansion
            System.out.println("Please input the card expansion:");
            expansion = scanner.next();

            //Get card condition
            System.out.println("Please input the condition of the card:");
            condition = scanner.next();

            //Get card language
            System.out.println("Please input the card language:");
            language = scanner.next();

            //Get card edition
            System.out.println("Is the card 1st ed? (y/n)");
            boolInput = scanner.next().toLowerCase();
            switch(boolInput){
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
        catch(InputMismatchException e){
            System.out.println("You must input a valid integer when asked to.");
            return 1;
        }
        return 0;
    }

    public void accessCard(){
        //TODO: Clear console
        if(this.collection.isEmpty()){
            System.out.println("The library is empty.");
        }
        else{
            //get the name of the card to remove
            Scanner input = new Scanner(System.in);
            String name = input.nextLine();
            int pos = alg.binarySearch(this.collection, 0, this.collection.size() - 1, name);

            //if the card doesn't exist
            if(pos == -1){
                //TODO: Clear console
                System.out.println("That card is not on your library.");
            }
            //if the card exists in the library
            else{
                this.collection.get(pos).modifyCard();
            }
        }

        return;
    }

    public void removeCard(){
        //TODO: Clear console

    }
}
