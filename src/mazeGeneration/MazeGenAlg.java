package mazeGeneration;

import java.util.Random;

public class MazeGenAlg implements MazeGenAlgInterface{

    public int cWidth, cHeight;  // width/height in cells
    public int aWidth, aHeight;  // width/height of the array
    public int[][] maze;
    /*
    Even number columns and even number rows are wall spaces
    Odd number columns and rows are the maze cells
        0 1 2 3 4 5 6 7 8
        -----------------
    0 | 1 1 1 1 1 1 1 1 1
    1 | 1 _ 1 _ 1 _ 1 _ 1
    2 | 1 1 1 1 1 1 1 1 1
    3 | 1 _ 1 _ 1 _ 1 _ 1
    4 | 1 1 1 1 1 1 1 1 1
    5 | 1 _ 1 _ 1 _ 1 _ 1
    6 | 1 1 1 1 1 1 1 1 1
     */
    public boolean generated;
    public Random rand = new Random();

    //////////////////
    /* CONSTRUCTORS */
    //////////////////

    public MazeGenAlg(){
        cWidth = 10;
        cHeight = 10;
        generated = false;
        init();
    }

    public MazeGenAlg(int cWidth, int cHeight){
        this.cWidth = cWidth;
        this.cHeight = cHeight;
        generated = false;
        init();
    }

    /////////////////////
    /* MUTATOR METHODS */
    /////////////////////

    /**
     * Initialize aWidth and aHeight to be 2*cWidth and cHeight + 1 respectively, and initialize the 2d maze array to be
     * of height aHeight and of width aWidth.
     * Precondition: cWidth and cHeight are initialized to positive integers
     * Postcondtition: maze is a 2d integer array where (x,y) locations on the grid with x and y as odd numbers contain
     * the number 0 (the maze cells), and all other locations on the grid contain a 1 (the maze walls)
     */
    public void init(){

        assert cWidth > 0 : "cWidth is less than or equal to zero";
        assert cHeight > 0 : "cHeight is less than or equal to zero";

        aWidth = 2*cWidth + 1;
        aHeight = 2*cHeight + 1;
        maze = new int[aHeight][aWidth];
        for(int ht = 0; ht < aHeight; ht++){
            for(int wd = 0; wd < aWidth; wd++) {
                if (ht % 2 == 1 && wd % 2 == 1) {
                    maze[ht][wd] = 0;
                }
                else {
                    maze[ht][wd] = 1;
                }
            }
        }
    }

    /**
     * returns a boolean value representing whether or not the maze has finished generating
     * @return
     * returns true if generation has finished. returns false otherwise
     */
    public boolean generated(){
        return generated;
    }

    /**
     * this update method does nothing, and is meant to be overridden by subclasses of MazeGenAlg.
     * The update() method is used ot perform one active step of a maze generation algorithm.
     * This method is intended for visualization purposes.
     *
     * NOTE: when maze generation has completed, this method will set the "generated" boolean attribute accordingly.
     * This is different from the sorting algorithms' sorted() method and "sorted" boolean attribute, where the sorted()
     * method checks if the array is sorted. This is because defining a completely generated maze is very algorithm-
     * dependant and implementation-dependant. A sorting algorithm has done it's job completely when the array is sorted
     * in ascending or descending order. However, for mazes, a fully generated maze is more difficult to determine
     * universally, and therefore will be defined by the algorithm and its implementation.
     */
    public void update(){

    }

    /**
     * This generate() method continuously calls the update() method until the generated() method returns true. This
     * is a universally functional way to generate a maze, regardless of the implementation of the update() method
     * because a few things are assumed of the update() method:
     * - it performs one active step of a maze generation algorithm
     * - it will stop performing such steps when it is done and set the "generated" boolean attribute accordingly
     * The second bullet point ensures that generated() always accurately reports whether generation of a maze is
     * complete or not, and therefore can effectively be used as a universal loop invariant.
     * This method is not intended for visualization purposes.
     */
    public void generate(){
        do {
            update();
        }while(!generated());
    }

    private void printMaze(){
        for(int ht = 0; ht < maze.length; ht++){
            for(int wd = 0; wd < maze[ht].length; wd++){
                System.out.print(maze[ht][wd] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        MazeGenAlg mga = new MazeGenAlg();
        mga.printMaze();
    }

}
