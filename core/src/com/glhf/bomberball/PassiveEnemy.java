package com.glhf.bomberball;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;


public class PassiveEnemy extends Enemy {

    // constructor
    public PassiveEnemy(int position_x, int position_y, Texture appearance, int life, ArrayList<moves> way) { // temporary, create a file with parameter
        super(position_x, position_y, appearance, life);
        strength = 1;
        this.way = way;
    }
}
