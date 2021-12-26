package com.retchut.LibraryTracker;

import com.retchut.LibraryTracker.Model.Card;

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
}
