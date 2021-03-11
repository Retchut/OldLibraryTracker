import java.io.Console;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Card {
    private String name, expansion, condition, language;
    private boolean firstEd;
    private int amount;

    //Getters
    public String getName(){ return this.name; }
    public String getExpansion(){ return this.expansion; }
    public String getCondition(){ return this.name; }
    public String getLanguage(){ return this.language; }
    public boolean getFirstEd(){ return this.firstEd; }
    public int getAmount(){ return this.amount; }

    //Setters
    public void setName(String newName){ this.name = newName; }
    public void setExpansion(String newExpansion){ this.expansion = newExpansion; }
    public void setCondition(String newCondition){ this.condition = newCondition; }
    public void setLanguage(String newLanguage){ this.language = newLanguage; }
    public void setFirstEd(boolean newFirstEd){ this.firstEd = newFirstEd; }
    public void setAmount(int newAmount) { this.amount = newAmount; }

    //Class constructor
    public Card(String name, String expansion, String condition, String language, boolean firstEd, int amount){
        setName(name);
        setExpansion(expansion);
        setCondition(condition);
        setLanguage(language);
        setFirstEd(firstEd);
        setAmount(amount);
    }

    private void printCard(){
        //TODO: Clear console
        System.out.println("Name: " + getName());
        System.out.println("Expansion: " + getExpansion());
        System.out.println("Condition: " + getCondition());
        System.out.println("Language: " + getLanguage());
        System.out.println("Is First Ed: " + getFirstEd());
        System.out.println("Amount: " + getAmount());
    }

    private void addCopies(){
        //TODO: Clear console
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
                    setAmount(getAmount() + toAdd);
                    System.out.println("You added " + toAdd + " copies of " + getExpansion() + " " + getName() + "to your library.");
                    System.out.println("You now own " + getAmount() + " copies of this card.");
                }
            }
            catch(InputMismatchException e){
                System.out.println("You must input a valid integer.");
                scanner.next();
            }
        }
    }

    private void removeCopies(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            try{
                //TODO: Clear console
                System.out.println("Please input the number of cards you want to remove.");
                int toRemove = scanner.nextInt();

                if(toRemove <= 0){
                    System.out.println("That is an invalid amount. No changes were made.");
                    return;
                }
                else if(toRemove > getAmount()){
                    System.out.println("That amount is larger than the copies of this card you currently own.");
                    System.out.println("You currently own " + getAmount() + " copies of " + getExpansion() + " " + getName() + ".");
                    continue;
                }
                else{
                    setAmount(getAmount() - toRemove);
                    System.out.println("You removed " + toRemove + " copies of " + getExpansion() + " " + getName() + "to your library.");
                    System.out.println("You now own " + getAmount() + " copies of this card.");
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
                //TODO: Clear console
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
