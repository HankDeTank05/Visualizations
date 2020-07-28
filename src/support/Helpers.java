package support;

import sorting.SortingAlg;
import sorting.algs.*;

public class Helpers {

    /**
     * prints an integer array with each element separated by a space, followed by a newline character at the end
     * @param array
     * the integer array to print out
     */
    public static void print(int[] array){
        for(int index = 0; index < array.length; index++){
            System.out.print(array[index] + " ");
        }
        System.out.println();
    }

    /**
     * Checks whether a value exists in the sub-array of array, from index 0 (inclusive) to index end (exclusive).
     * @param array
     * the integer array to check against.
     * @param value
     * the target value to find in array.
     * @param end
     * equal to 1 + (the index of the last element to check).
     * to search the whole array, end must equal array.length.
     * @return
     * returns true if value is contained in array. returns false otherwise.
     */
    public static boolean contains(int[] array, int value, int end){

        assert end <= array.length : "end value is too large";
        assert end > 0 : "end value is less than or equal to zero";

        for(int index = 0; index < end; index++){
            if(value == array[index]){
                return true;
            }
        }
        return false;
    }

    /**
     * returns the index of the smallest value in a given subarray of integers. searches indices in the range [start, end)
     * @param array
     * the integer array to be searched
     * @param start
     * the index at which to start the search
     * @param end
     * the index before which to end the search
     * @return
     */
    public static int getMinIndex(int[] array, int start, int end){

        assert array.length >= 2 : "array size is less than two!";
        assert start >= 0 : "starting index is less than zero!";
        assert end > start : "ending index is less than or equal to start!";
        assert end < array.length : "ending index is too large!";

        int minIndex = start;
        for(int index = start + 1; index < end; index++){
            if(array[index] < array[minIndex]){
                minIndex = index;
            }
        }
        return minIndex;
    }

    public static SortingAlg createAlgInstance(String alg, int size){
        switch(alg){
            case "bubble":
                return new BubbleSort(size);
            case "selection":
                return new SelectionSort(size);
            case "insertion":
                return new InsertionSort(size);
            case "merge":
                return new MergeSort(size);
            default:
                System.out.println(alg + " sort is not a valid sorting algorithm");
                return null;
        }
    }

    public static SortingAlg createAlgInstance(String alg){
        return createAlgInstance(alg, 10);
    }
}
