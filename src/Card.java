import java.util.InputMismatchException;
import java.util.Scanner;

public class Card {
    private String name, expansion;
    private CONDITION condition;
    private LANGUAGE language;
    private boolean firstEd;
    private int amount;

    //Getters
    public String getName(){ return this.name; }
    public String getExpansion(){ return this.expansion; }
    public CONDITION getCondition(){ return this.condition; }
    public LANGUAGE getLanguage(){ return this.language; }
    public boolean getFirstEd(){ return this.firstEd; }
    public int getAmount(){ return this.amount; }

    //Setters
    public void setName(String newName){ this.name = newName; }
    public void setExpansion(String newExpansion){ this.expansion = newExpansion; }
    public void setCondition(CONDITION newCondition){ this.condition = newCondition; }
    public void setLanguage(LANGUAGE newLanguage){ this.language = newLanguage; }
    public void setFirstEd(boolean newFirstEd){ this.firstEd = newFirstEd; }
    public void setAmount(int newAmount) { this.amount = newAmount; }

    enum CONDITION { M, NM, EX, GD, LP, PL, P}
    enum LANGUAGE {ENGLISH, FRENCH, GERMAN, SPANISH, ITALIAN, PORTUGUESE}

    /**
     * @brief Default constructor
     */
    public Card(String name, String expansion, CONDITION condition, LANGUAGE language, boolean firstEd, int amount){
        setName(name);
        setExpansion(expansion);
        setCondition(condition);
        setLanguage(language);
        setFirstEd(firstEd);
        setAmount(amount);
    }

    /**
     * @brief Prints detailed card data
     */
    private void printCard(){
        //TODO: Clear console
        System.out.println("Name: " + getName());
        System.out.println("Expansion: " + getExpansion());
        System.out.println("Condition: " + getCondition());
        System.out.println("Language: " + getLanguage());
        System.out.println("Is First Ed: " + getFirstEd());
        System.out.println("Amount: " + getAmount());
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
                    return 1;
                }
                else{
                    setAmount(getAmount() + toAdd);
                    System.out.println("You added " + toAdd + " copies of " + getExpansion() + " " + getName() + "to your library.");
                    System.out.println("You now own " + getAmount() + " copies of this card.");
                    return 1;
                }
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
                    System.out.println("You currently own " + getAmount() + " copies of " + getExpansion() + " " + getName() + ".");
                }
                else{
                    setAmount(getAmount() - toRemove);
                    System.out.println("You removed " + toRemove + " copies of " + getExpansion() + " " + getName() + "to your library.");
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
                System.out.println("0 - Go back.");
                int input = scanner.nextInt();

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
}
