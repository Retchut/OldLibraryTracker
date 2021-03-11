import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryTracker {
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

    private static void trackerLoop(Library lib){
        Scanner scanner = new Scanner(System.in);
        while(true){
            try{
                //TODO: Clear console
                System.out.println("Please input what you want to do.");
                System.out.println("1 - View your card collection.");
                System.out.println("2 - Add cards to the library.");
                System.out.println("3 - Modify a card in the library.");
                System.out.println("4 - Remove cards from the library.");
                System.out.println("0 - Exit and save the library.");
                int input = scanner.nextInt();

                switch(input){
                    case 1:
                        lib.printLib();
                        break;
                    case 2:
                        if (lib.addCard() != 0)
                            System.out.println("The operation was canceled. No changes to the library were made. Try again.");
                        break;
                    case 3:
                        lib.accessCard();
                        break;
                    case 4:
                        lib.removeCard();
                        break;
                    case 0:
                        System.out.println("The program will now exit, and your library will be saved.");
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

    public static void main(String[] args) {

        //Initialize library object
        Library lib = new Library();

        //Load library
        lib.loadLibrary();

        trackerLoop(lib);

        //Save library
        lib.saveLibrary();
    }
}
