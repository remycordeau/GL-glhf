package com.glhf.bomberball.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.*;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.glhf.bomberball.Constants;
import com.glhf.bomberball.Game;

public abstract class StateMenu extends State{
    protected VerticalGroup centerButtons;

    public StateMenu() {

        centerButtons = new VerticalGroup();
        centerButtons.setFillParent(true);
        centerButtons.center();

        stage.addActor(centerButtons);
    }


    public class SetStateListener extends ChangeListener {
        private State state;
        public SetStateListener(State state){
            this.state = state;
        }

        @Override
        public void changed(ChangeEvent event, Actor actor) {
            Game.setState(state);
        }
    }
}