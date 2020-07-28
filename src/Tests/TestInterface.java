package Tests;

import sorting.SortingAlg;
import sorting.algs.*;

public abstract class TestInterface {
    protected String[] algs = {"bubble", "selection", "insertion", "merge"};
    public abstract void run();
}
