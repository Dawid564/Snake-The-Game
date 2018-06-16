package com.snake.gui;

import com.snake.App;
import com.snake.engine.Engine;
import com.snake.logic.Run;
import javafx.application.Application;
import javafx.stage.Stage;

public class GameGui extends Application {

    private Game game;
    private Engine engine;
    private static GameGui instance;
    private Stage primaryStage;
    /*
    public static void run(String[] args){
        launch(args);
    }*/

    public void runGui(){
        Application.launch(getInstance().getClass(),new String[]{});
    }

    public GameGui(){
        Game game = new Game(primaryStage);
        this.game = game;
        System.out.println("obiekt juz gotowy 1");
    }

    public static GameGui getInstance(){
        if(instance == null){
            instance = new GameGui();
        }
        return instance;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        System.out.println("obiekt juz gotowy 1");
    }

    public void setGame(){

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
