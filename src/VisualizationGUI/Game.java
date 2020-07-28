package VisualizationGUI;

import VisualizationGUI.display.Display;
import sorting.SortingAlg;
import sorting.algs.BubbleSort;
import sorting.algs.InsertionSort;
import sorting.algs.MergeSort;
import sorting.algs.SelectionSort;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    private Display display;
    public int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    public SortingAlg sortingAlg;

    int barWidth;

    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        sortingAlg = new MergeSort(width);
        barWidth = (int)((double)width/(double)sortingAlg.values.length);
    }

    private void init(){
        // initialize graphics and set up the game
        display = new Display(title, width, height);
    }

    private void update(){
        sortingAlg.update();
    }

    private void draw(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        // clear screen
        g.clearRect(0, 0, width, height);
        // draw here!

        for(int index = 0; index < sortingAlg.values.length; index++){
            int drawLeftStart = index*(width/sortingAlg.values.length);
            int drawHeight = (int) ((double)height*((double)sortingAlg.values[index]/(double)sortingAlg.values.length));
            g.fillRect(drawLeftStart, height-drawHeight, barWidth, drawHeight);
        }

        // end drawing!
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();

        int fps = 120;

        long lastTime = System.nanoTime();
        long lag = 0;
        long NS_PER_UPDATE = 1000000000 / fps;

        // main game loop
        while(running){
            long currentTime = System.nanoTime();
            long elapsed = currentTime - lastTime;
            lastTime = currentTime;
            lag += elapsed;
            // process input here

            while(lag >= NS_PER_UPDATE){
                update();
                lag -= NS_PER_UPDATE;
            }
            draw();

        }
        stop();
    }

    public synchronized void start(){
        if(running){
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if(!running){
            return;
        }
        running = false;
        try{
            thread.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
