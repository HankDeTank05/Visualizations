package sorting;

import java.util.Random;
import support.Helpers;

/*
for a list of sorting algorithms you can implement, visit
https://www.geeksforgeeks.org/sorting-algorithms/#algo
NOTE: if there is more than one implementation of an
algorithm, you'll want to pick the iterative one in order
to utilize the update() method prooperly
 */

public class SortingAlg implements SortingAlgInterface {
    public int[] values;
    public int SIZE = 10;  // the default size of the array is 10
    public boolean sorted;
    public Random rand = new Random();

    //////////////////
    /* CONSTRUCTORS */
    //////////////////

    /**
     * The default constructor. Uses the unchanged SIZE attribute to set the array size
     */
    public SortingAlg(){
        init();
        sorted = false;
    }

    /**
     * The constructor used to specify array size.
     * SIZE is assigned the "size" value passed to the constructor
     */
    public SortingAlg(int size){
        SIZE = size;
        init();
        sorted = false;
    }

    /////////////////////
    /* MUTATOR METHODS */
    /////////////////////

    /**
     * Initialize an array of size SIZE with random integers in the range [1, SIZE]
     * Precondition: SIZE is initialized to a value greater than zero
     * Postcondition: values is an integer array initialized with unique integers in the range [1, SIZE]
     */
    public void init(){

        assert SIZE > 0 : "SIZE is less than or equal to zero.";

        values = new int[SIZE];
        for(int index = 0; index < SIZE; index++){
            do {
                values[index] = rand.nextInt(SIZE) + 1;
            }
            while(Helpers.contains(values, values[index], index));
        }
    }

    /**
     * Checks whether or not the array is sorted
     * The array is sorted if every value in "values" equals it's (index + 1)
     * @return
     * returns true if the array is sorted. returns false otherwise.
     */
    public boolean sorted(){
        sorted = true;
        for(int index = 0; index < values.length; index++){
            if(values[index] != index + 1){
                sorted = false;
                break;
            }
        }
        return sorted;
    }

    /**
     * This update method does nothing, and is meant to be overridden by subclasses of SortingAlg.
     * The update() method is used to perform one active step of a sorting algorithm.
     * This method is intended for visualization purposes.
     */
    public void update(){

    }

    /**
     * The sort() method is used to perform a sorting algorithm continuously until the array is sorted.
     * This method is not intended for visualization purposes.
     */
    public void sort(){
        do{
            update();
        }while(!sorted());
    }

    public void swap(int aIndex, int bIndex){
        assert aIndex >= values.length : "aIndex is too large!";
        assert aIndex < 0 : "aIndex is too small!";
        assert bIndex >= values.length : "bIndex is too large!";
        assert bIndex < 0 : "bIndex is too small!";

        int temp = values[aIndex];
        values[aIndex] = values[bIndex];
        values[bIndex] = temp;
    }

    public static void main(String[] args){
        SortingAlg sa = new SortingAlg();
        Helpers.print(sa.values);
    }
}
