import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    ArrayList<Card> collection;

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

    public void addCard(){
        //TODO: Clear console

    }

    public void accessCard(){
        //TODO: Clear console

    }

    public void removeCard(){
        //TODO: Clear console

    }
}
