package sorting.algs;

import sorting.SortingAlg;
import support.Helpers;

public class SelectionSort extends SortingAlg {

    private int sortedPortion = 0;

    public SelectionSort(){
        super();
    }

    public SelectionSort(int size){
        super(size);
    }

    @Override
    /**
     * perform one "swap" in the selection sort algorithm
     */
    public void update(){
        if(!sorted()){
            int minIndex = Helpers.getMinIndex(values, sortedPortion, values.length);
            int temp = values[sortedPortion];
            values[sortedPortion] = values[minIndex];
            values[minIndex] = temp;
            sortedPortion++;
        }
    }

    public static void main(String[] args){
        SelectionSort ss = new SelectionSort();
        do{
            ss.update();
            Helpers.print(ss.values);
        }while(!ss.sorted());
    }
}
