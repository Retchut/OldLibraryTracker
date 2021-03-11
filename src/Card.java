import java.io.Console;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Card {
    String name, expansion, condition, language;
    boolean firstEd;
    int amount;

    //Class constructor
    public Card(String name, String expansion, String condition, String language, boolean firstEd, int amount){
        this.name = name;
        this.expansion = expansion;
        this.condition = condition;
        this.language = language;
        this.firstEd = firstEd;
        this.amount = amount;
    }

    private void printCard(){
        //clearConsole()
        System.out.println("Name: " + this.name);
        System.out.println("Expansion: " + this.expansion);
        System.out.println("Condition: " + this.condition);
        System.out.println("Language: " + this.language);
        System.out.println("Is First Ed: " + this.firstEd);
        System.out.println("Amount: " + this.amount);
    }

    private void addCopies(){
        //clearConsole()
        Scanner scanner = new Scanner(System.in);
        while(true){
            try{
                //clear console
                System.out.println("Please input the number of cards you want to add.");
                int toAdd = scanner.nextInt();

                if(toAdd <= 0){
                    System.out.println("That is an invalid amount. No changes were made.");
                    return;
                }
                else{
                    this.amount += toAdd;
                    System.out.println("You added " + toAdd + " copies of " + this.expansion + " " + this.name + "to your library.");
                    System.out.println("You now own " + this.amount + " copies of this card.");
                }
            }
            catch(InputMismatchException e){
                System.out.println("You must input a valid integer.");
                scanner.next();
            }
        }
    }

    private void removeCopies(){
        //clearConsole()
        Scanner scanner = new Scanner(System.in);
        while(true){
            try{
                //clear console
                System.out.println("Please input the number of cards you want to remove.");
                int toRemove = scanner.nextInt();

                if(toRemove <= 0){
                    System.out.println("That is an invalid amount. No changes were made.");
                    return;
                }
                else if(toRemove > this.amount){
                    System.out.println("That amount is larger than the copies of this card you currently own.");
                    System.out.println("You currently own " + this.amount + " copies of " + this.expansion + " " + this.name + ".");
                    continue;
                }
                else{
                    this.amount += toRemove;
                    System.out.println("You removed " + toRemove + " copies of " + this.expansion + " " + this.name + "to your library.");
                    System.out.println("You now own " + this.amount + " copies of this card.");
                }
            }
            catch(InputMismatchException e){
                System.out.println("You must input a valid integer.");
                scanner.next();
            }
        }
    }

    public void modifyCard(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            try{
                //clear console
                System.out.println("Please input what you want to do.");
                System.out.println("1 - View card data.");
                System.out.println("2 - Add copies of this card to the library.");
                System.out.println("3 - Remove copies of this card from the library.");
                System.out.println("0 - Go back.");
                int input = scanner.nextInt();

                switch(input){
                    case 1:
                        this.printCard();
                        break;
                    case 2:
                        this.addCopies();
                        break;
                    case 3:
                        this.removeCopies();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Please input an integer from 0-3.");
                }
            }
            catch(InputMismatchException e){
                System.out.println("You must input a valid integer.");
                scanner.next();
            }
        }
    }
}
