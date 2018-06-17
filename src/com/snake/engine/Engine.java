package com.snake.engine;

import com.snake.gui.Game;
import javafx.scene.canvas.GraphicsContext;

public class Engine{

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

    }


    public void createMap(){
        this.map = new int[preferSize];
    }
}
