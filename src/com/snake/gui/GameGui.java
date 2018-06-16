package com.snake.gui;

import com.snake.engine.Engine;
import javafx.application.Application;
import javafx.stage.Stage;

public class GameGui extends Application {

    private Game game;
    private Engine engine;

    public static void run(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Game game = new Game(primaryStage);
        this.game = game;
        if(game == null){
            System.out.println("game is null");
        }else{
            System.out.println("game is ok");
        }
        System.out.println("obiekt juz gotowy");
    }

    public void setEngine(Engine engine){
        this.engine = engine;
        if(this.game == null){
            System.out.println("wtf null?");
        }
        game.setEngine(this.engine);
    }

    public Game getGame(){
        boolean isNull = true;
        while (isNull){
            if (this.game == null){
                //System.out.println("We got null :(");
            }else{
                System.out.println("hello");
                isNull = false;
            }
        }
        return this.game;
    }

}
