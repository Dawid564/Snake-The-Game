package com.snake.engine;

import com.snake.dao.Snake;

import java.util.List;
import java.util.Random;

public class SnakeFood {

    private Random rand;

    public int[] initFood(int[] x, int[] y, List<Snake> snakeTail){
        int lenOfMap = convertToNum(x,y);
        int[] excludes = calculateExclude(x,y,snakeTail);
        return null;
    }

    private int[] calculateExclude(int[] x, int[] y, List<Snake> snakeTail){
        int[] excludes = new int[snakeTail.size()-1];
        for(int i=0; i<snakeTail.size()-1; i++){
            excludes[i] = calcExcludePos(findIndex(x,snakeTail.get(i)), findIndex(y,snakeTail.get(i)));
        }
        return null;
    }

    private int calcExcludePos(int a, int b){
        return 0;
    }

    private int findIndex(int[] array, Snake snake){
        return 0;
    }

    private int convertToNum(int[] x, int[] y){
        return x.length * y.length;
    }

}
