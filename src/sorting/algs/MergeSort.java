package sorting.algs;

/*
Credit to https://www.geeksforgeeks.org/iterative-merge-sort/
The iterative Java implementation at the link above was modified in this implementation
 */

import sorting.SortingAlg;
import support.Helpers;

public class MergeSort extends SortingAlg {

    // for current size of subarrays to be merged currentSize varies from 1 to SIZE
    private int currentSize = 1;
    // for picking the starting index of left subarray to be merged
    private int leftStart = 0;

    public MergeSort(){
        super();
//        int[] testVals = {6, 9, 2, 1, 4, 10, 5, 7, 8, 3};
//        values = testVals;
    }

    public MergeSort(int size){
        super(size);
    }

    private void merge(int left, int mid, int right){
        // size of the two subarrays to be merged
        int sLeft = mid - left + 1;
        int sRight = right - mid;

        // two temp arrays for each half
        int[] aLeft = new int[sLeft];
        int[] aRight = new int[sRight];

        // copy data into the temp arrays
        for(int li = 0; li < sLeft; li++){
            aLeft[li] = values[left + li];
        }
        for(int ri = 0; ri < sRight; ri++){
            aRight[ri] = values[mid + ri + 1];
        }

        // initial indices of the temp arrays
        int li = 0;
        int ri = 0;

        // initial index of merged subarray
        int mi = left;

        // merge the left and right temp arrays
        while(li < sLeft && ri < sRight){
            if(aLeft[li] <= aRight[ri]){
                values[mi] = aLeft[li];
                li++;
            }
            else{
                values[mi] = aRight[ri];
                ri++;
            }
            mi++;
        }

        // empty out the remaining values in the left array
        while(li < sLeft){
            values[mi] = aLeft[li];
            li++;
            mi++;
        }

        // empty out the remaining values in the right array
        while(ri < sRight){
            values[mi] = aRight[ri];
            ri++;
            mi++;
        }
    }

    @Override
    /**
     * performs one "modification" in an iterative implementation of the merge sort algorithm
     */
    public void update(){
        if(!sorted()){

            // find ending point of left subarray. mid+1 is starting point of right
            int mid = Math.min(leftStart + currentSize - 1, SIZE - 1);
            int rightEnd = Math.min(leftStart + 2 * currentSize - 1, SIZE - 1);

            // merge subarrays arr[left_start...mid] & arr[mid+1...right_end]
            merge(leftStart, mid, rightEnd);

            // pick starting point of different subarrays of current size
            leftStart += 2*currentSize;

            /*
            merge subarrays in bottom-up manner. first merge subarrays of size 1 to create subarrays
            of size 2, then merge subarrays of size 2 to create sorted subarrays of size 4, and so on
             */
            if(leftStart >= SIZE - 1) {
                currentSize *= 2;
                leftStart = 0;
            }
        }
    }

    public static void main(String[] args){
        MergeSort ms = new MergeSort();
        do{
            ms.update();
            Helpers.print(ms.values);
            System.out.println();
        }while(!ms.sorted());
    }
}
