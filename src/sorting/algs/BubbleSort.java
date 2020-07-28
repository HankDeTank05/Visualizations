package sorting.algs;

import support.Helpers;

import java.util.Random;
import sorting.SortingAlg;

public class BubbleSort extends SortingAlg{

    private int currentIndex = 0;
    private int sortedPortion = 0;

    public BubbleSort(){
        super();
    }

    public BubbleSort(int size) {
        super(size);
    }

    @Override
    /**
     * perform one swap in the bubble sort algorithm
     */
    public void update(){
        if(!sorted()) {
            if (values[currentIndex] > values[currentIndex + 1]) {
                swap(currentIndex, currentIndex + 1);
            }
            currentIndex++;
            if (currentIndex == SIZE - sortedPortion - 1) {
                currentIndex = 0;
                sortedPortion++;
            }
        }
    }


    public static void main(String[] args){
        BubbleSort bs = new BubbleSort(50);
        Helpers.print(bs.values);

        while(!bs.sorted()){
            bs.update();
            Helpers.print(bs.values);
        }

//        bs.sort();

        Helpers.print(bs.values);
    }

}
