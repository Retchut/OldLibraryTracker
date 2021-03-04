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
                System.out.println("Please input what you want to do.");
                System.out.println("1 - View your card collection.");
                System.out.println("2 - Add cards to the library.");
                System.out.println("3 - Modify a card in the library.");
                System.out.println("4 - Remove cards from the library.");
                System.out.println("0 - Exit and save the library.");
                int input = scanner.nextInt();
                System.out.println(input);

                switch(input){
                    case 1:
                        lib.printLib();
                    case 2:
                        lib.addCard();
                    case 3:
                        lib.accessCard();
                    case 4:
                        lib.removeCard();
                    case 0:
                        System.out.println("The program will now exit, and your library will be saved.");
                        return;
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

        lib.saveLibrary();
    }
}
