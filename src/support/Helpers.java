package support;

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
}
