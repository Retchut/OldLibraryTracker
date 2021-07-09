package com.retchut.LibraryTracker.Model;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

final public class ExpansionMap {

    static Map<String, String> expansions;

    static{
        expansions = new HashMap<>();
        File expansionsFile = new File("expansions.txt");
        try{
            Scanner fileReader = new Scanner(expansionsFile);
            fileReader.useDelimiter("[,\\r\\n]");
            String expansionName, expansionURL;
            while(fileReader.hasNextLine()){
                expansionName = fileReader.next();
                if(expansionName.charAt(0) == '/'){
                    fileReader.nextLine();
                    continue;
                }
                expansionURL = fileReader.next();
                expansions.put(expansionName, expansionURL);
                fileReader.nextLine();
            }
        }
        catch (IOException e){
            throw new RuntimeException("Exception while initializing expansion map");
        }
    }

    public static String getExpansion(String key){
        if(expansions.containsKey(key))
            return expansions.get(key);
        return "";
    }
}
