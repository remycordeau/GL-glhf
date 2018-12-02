package com.glhf.bomberball.menu;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.glhf.bomberball.Constants;
import com.glhf.bomberball.GUI.Button;
import com.glhf.bomberball.GUI.ButtonUndo;
import com.glhf.bomberball.GUI.SelectButton;
import com.glhf.bomberball.Game;
import com.glhf.bomberball.Graphics;
import com.glhf.bomberball.config.Config;
import com.glhf.bomberball.config.GameConfig;

public class StateMultiMenu extends State {
    //Attributes
    private Button retrievePlayer;
    private Button addPlayer;
    private SelectButton numberPlayer;
    private Button begin;
    private Button begin_random;
    private ButtonUndo cancel;
    private boolean err =false;
    private GameConfig config;
    private SpriteBatch batch = new SpriteBatch();

    //Constructor
    public StateMultiMenu(String name){
        config = Config.importConfig("config_multi", GameConfig.class);
        this.settings();
    }

    /*Loading textures*/
    public void settings(){
        //Button retrievePlayer
        retrievePlayer = new Button(100, 15, 20, 200, "Minus2");

        //Button addPlayer
        addPlayer = new Button(200, 15, 20, 20, "Plus2");

        //Button numberPlayer
        numberPlayer = new SelectButton(137, 2, 50, 50, config.player_count+"");

        //Button Cancel
        State s = new StateMainMenu("MainMenu");
        cancel = new ButtonUndo(400, 0, 100, 100, s);

        //Button Begin
        begin = new Button(160, 200, 400, 100, "BoutonMulti");

        //Button Beign Random
        begin_random = new Button(160, 100, 400, 100, "BoutonMulti");
    }

    public void draw(){
        retrievePlayer.draw(batch);
        addPlayer.draw(batch);
        numberPlayer.draw(batch);
        cancel.draw(batch);
        begin.draw(batch);
        begin_random.draw(batch);
        if(err)
        {
            batch.begin();
            batch.draw(Graphics.GUI.get("erreur"), 0, 0);
            batch.end();
        }
    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
        y = Constants.APP_HEIGHT - y;

        if(retrievePlayer.contains(x, y))
        {
            int newNumberOfPlayers;
            newNumberOfPlayers = config.player_count;
            if(newNumberOfPlayers > 1) {
                newNumberOfPlayers--;
                config.player_count = newNumberOfPlayers;
                numberPlayer.setNbPlayers(newNumberOfPlayers);
            }
        }

        if(addPlayer.contains(x, y))
        {
            int newNumberOfPlayers;
            newNumberOfPlayers = config.player_count;
            if(newNumberOfPlayers < 4) {
                newNumberOfPlayers++;
                config.player_count = newNumberOfPlayers;
                numberPlayer.setNbPlayers(newNumberOfPlayers);
            }
        }

        if(begin.contains(x, y)) {
            State state = new StateGameMulti("maze_0.json");
            Game.setState(state);
        }
        if(begin_random.contains(x, y)) {
            err =true;
            //TODO: On lance le jeu solo
        }

        if(cancel.contains(x, y)){
            Game.setState(cancel.getState());
        }
        return false;
    }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (err){err=false;}
        return super.touchUp(screenX, screenY, pointer, button);
    }
}
