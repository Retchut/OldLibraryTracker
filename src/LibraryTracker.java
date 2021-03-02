import java.io.IOException;

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

    private static void trackerLoop(){
        while(true){
            
        }
    }

    public static void main(String[] args) {

        //Initialize library object
        Library lib = new Library();
        //Load library
        lib.loadLibrary();

        trackerLoop();

        lib.saveLibrary();
    }
}
