package com.retchut.LibraryTracker;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

final public class ExpansionMap {

    static Map<String, String> expansions;

    static{
        expansions = new HashMap<>();
        File expansionsFile = new File("expansions.txt");
        int line = 0;
        try{
            Scanner fileReader = new Scanner(expansionsFile);
            fileReader.useDelimiter("[,\\r\\n]");
            String expansionName, expansionURL;
            while(fileReader.hasNextLine()){
                expansionName = fileReader.next();
                if(expansionName.charAt(0) == '/'){
                    line++;
                    fileReader.nextLine();
                    continue;
                }
                expansionURL = fileReader.next();
                expansions.put(expansionName, expansionURL);
                line++;
                fileReader.nextLine();
            }
            fileReader.close();
        }
        catch (IOException e){
            throw new RuntimeException("Exception while initializing expansion map");
        }
        catch (NoSuchElementException e){
            System.out.println("Error reading expansion at line " + line);
            e.printStackTrace();
            throw new RuntimeException("Exception while initializing expansion map");
        }
    }

    public static String getExpansion(String key){
        if(expansions.containsKey(key))
            return expansions.get(key);
        return "";
    }
}
