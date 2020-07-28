package Tests;

import sorting.SortingAlg;
import support.Helpers;

import java.util.Scanner;

public class LimitedTimeTest extends TestInterface{
    /**
     * This class tests how big of a dataset each algorithm can handle in a given amount of seconds.
     */

    @Override
    public void run() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the time limit in seconds: ");
        long timeLimit = in.nextInt()*1000000000;  // execution time is measured in nanoseconds
        System.out.println("\n");

        System.out.print("Enter the number of tests to conduct: ");
        int numTests = in.nextInt();
        int[] tests = new int[algs.length];
        System.out.println("\n");

        for(int alg = 0; alg < tests.length; alg++){
            System.out.println("Now testing the " + algs[alg] + " sort algorithm");
            int N = 10;

            long totalExecution = 0;

            while(true) {
                System.out.println(algs[alg] + ": " + "Testing for size " + N + " commencing...");
                for (int test = 0; test < numTests; test++) {

                    SortingAlg algorithm = Helpers.createAlgInstance(algs[alg], N);

//                    System.out.println("\tTest #" + (test+1) + " for size" + N + " commencing...");

                    long startTime = System.nanoTime();
                    assert algorithm != null : "no algorthim found!";
                    algorithm.sort();
                    long endTime = System.nanoTime();

                    long executionTime = endTime - startTime;
                    totalExecution += executionTime;

                    System.out.println(algs[alg] + ": " + "\tTest #" + (test+1) + " concluded! Data has been logged!");
                }
                long averageExecution = totalExecution / numTests;
                System.out.print(algs[alg] + ": " + "Testing for size " + N + " has concluded. ");
                if (averageExecution < timeLimit) {
                    N *= 2;
                    System.out.println("Continuing testing...");
                } else {
                    tests[alg] = N;
                    System.out.println("Done testing!");
                    break;
                }
            }
        }

        for(int alg = 0; alg < tests.length; alg++){
            System.out.println(algs[alg] + " sort maximum size = " + tests[alg]);
        }

    }

    public static void main(String[] args){
        LimitedTimeTest ltt = new LimitedTimeTest();
        ltt.run();
    }
}
