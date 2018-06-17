package com.snake.engine;

import com.snake.gui.Game;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Engine{

    private int height = 300;
    private int width = 300;
    private int preferSize = 20;
    private int[] map = null;
    private Game game;

    public Engine(int preferSize, Game game){
        this.preferSize = preferSize;
        this.game = game;
        initialize();
    }

    //initialize components
    private void initialize(){
        //draw grid for snake
        drawGrid();
    }



    private void drawGrid(){
        GraphicsContext gc = game.getGc();
        gc.setFill(Color.BLACK);
        gc.setStroke(Color.BLACK);

        double y;
        for (int i=0; i<preferSize; i++){
            y = (height/preferSize)*i;
            gc.strokeLine(0,y,width,y);
        }

        double x;
        for (int i=0; i<preferSize; i++){
            x = (width/preferSize)*i;
            gc.strokeLine(x,0,x,height);
        }
    }


    public void createMap(){
        this.map = new int[preferSize];
    }
}
