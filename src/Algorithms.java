import java.util.List;

final public class Algorithms {

    /**
     * @brief Simple Binary Search algorithm
     * @param arr   The array we're searching
     * @param i     First index of the array
     * @param j     Last index of the array
     * @param item  Item to look for
     * @return      Index of the item in the array
     */
    static final int binarySearch(List<Card> arr, int i, int j, String item){
        //array with 1 item
        if(i == j){
            return (arr.get(i).getName() == item)? i : -1;
        }
        //array of a different size
        else if (j > i){
            //get the index of the middle of the array
            int mid = i + (j-i)/2;

            switch(item.compareTo(arr.get(mid).getName())){
                //our item is at the middle
                case 0:
                    return mid;

                //our item is in the left portion of the array
                case -1:
                    return binarySearch(arr, i, mid, item);

                //our item is on the right portion of the array
                case 1:
                    return binarySearch(arr, mid, j, item);
            }
        }

        //in case something goes wrong
        return -1;
    }
}
