package sorting.algs;

import support.Helpers;

import java.util.Random;
import sorting.SortingAlg;

public class BubbleSort extends SortingAlg{

    public BubbleSort(){
        super();
    }

    public BubbleSort(int size) {
        super(size);
    }

    @Override
    /**
     * perform one pass of the bubble sort algorithm
     */
    public void update(){
        for(int index = 0; index < SIZE - 1; index++){
            if(values[index] > values[index + 1]){
                swap(index, index + 1);
            }
        }
    }

    @Override
    /**
     * repeatedly update the array until it is sorted
     */
    public void sort(){
        do{
            update();
        }while (!sorted());
    }

    public static void main(String[] args){
        BubbleSort bs = new BubbleSort();
        Helpers.print(bs.values);

        while(!bs.sorted()){
            bs.update();
            Helpers.print(bs.values);
        }

//        bs.sort();

        Helpers.print(bs.values);
    }

}
