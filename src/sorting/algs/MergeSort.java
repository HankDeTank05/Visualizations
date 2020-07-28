package sorting.algs;

import sorting.SortingAlg;
import support.Helpers;
import support.RangeStack;

public class MergeSort extends SortingAlg {

    private int currentSize = 1;
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
//            for(int leftStart = 0; leftStart < SIZE-1; leftStart += 2*currentSize) {}

            int mid = Math.min(leftStart + currentSize - 1, SIZE - 1);
            int rightEnd = Math.min(leftStart + 2 * currentSize - 1, SIZE - 1);
            merge(leftStart, mid, rightEnd);

            leftStart += 2*currentSize;

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
