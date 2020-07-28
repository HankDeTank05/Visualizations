package sorting.algs;

import sorting.SortingAlg;
import support.Helpers;

public class InsertionSort extends SortingAlg {

    int currentIndex = 1;
    int swapIndex;

    public InsertionSort(){
        super();
    }

    public InsertionSort(int size){
        super(size);
    }

    @Override
    /**
     * performs one insertion in the insertion sort algorithms
     */
    public void update(){
        if(!sorted()){
            int tempCurrent = currentIndex;
            while(values[tempCurrent] < values[tempCurrent - 1]){
                swap(tempCurrent, tempCurrent - 1);
                if(tempCurrent > 1) {
                    tempCurrent--;
                }
                else{
                    break;
                }
            }
            currentIndex++;
        }
    }

    public static void main(String[] args){
        InsertionSort is = new InsertionSort();
        do{
            is.update();
            Helpers.print(is.values);
        }while(!is.sorted());
    }
}
