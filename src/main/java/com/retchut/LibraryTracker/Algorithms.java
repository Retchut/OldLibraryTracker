package com.retchut.LibraryTracker;

import com.retchut.LibraryTracker.Card;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

final public class Algorithms {

    /**
     * @brief Simple Binary Search algorithm
     * @param arr   The array we're searching
     * @param i     First index of the array
     * @param j     Last index of the array
     * @param name  Name to look for
     * @return      Index of the first item in the array with the name specified
     */
    public static int binarySearch(List<Card> arr, int i, int j, String name){
        //array with 1 item
        if(i == j){
            return (arr.get(i).getCardInfo().getName().equals(name))? i : -1;
        }
        //array of a different size
        else if (j > i){
            //get the index of the middle of the array
            int mid = i + (j-i)/2;
            int test = name.compareTo(arr.get(mid).getCardInfo().getName());
            if(test == 0)
                return mid;
            else if(test < 0){  //elem in left side of the array
                return binarySearch(arr, i, mid, name);
            }
            else if(test > 0){  //elem in right side of the array
                return binarySearch(arr, mid+1, j, name);
            }
        }

        //in case something goes wrong
        return -1;
    }

    public static void log(String toLog){
        try {
            File myObj = new File("log.txt");
            myObj.createNewFile();
            FileWriter myWriter = new FileWriter("log.txt", true);
            myWriter.write(toLog + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String padString(String toPad, int length){
        StringBuilder stringBuilder = new StringBuilder(toPad);
        if(toPad.length() >= length){
            stringBuilder.insert(0, " ");
            return stringBuilder.toString();
        }

        stringBuilder.append(" ");
        Boolean prepended = false;
        while(stringBuilder.length() < length){
            if(prepended){
                stringBuilder.append(" ");
            }
            else{
                stringBuilder.insert(0, " ");
            }
            prepended = !prepended;
        }

        return stringBuilder.toString();
    }
}
