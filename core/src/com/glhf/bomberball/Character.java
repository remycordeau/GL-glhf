package com.glhf.bomberball;

public abstract class Character extends GameObject {
    //attributes
    private int position_x;
    private int position_y;
    private int life;
    private int number_move_remaining;
    private String sprite_path;

    public void getDamage(int damage){
        life -= damage;
    }

    public void moveRight(){
        position_x+=1;
        number_move_remaining-=1;
    }

    public int getPositionX() {
        return position_x;
    }

    public int getPositionY() {
        return position_y;
    }

    public int getLife() {
        return life;
    }

    public int getNumberMoveRemaining() {
        return number_move_remaining;
    }

    public String getSpritePath() {
        return sprite_path;
    }

    public void setPositionX(int position_x) {
        this.position_x = position_x;
    }

    public void setPositionY(int position_y) {
        this.position_y = position_y;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setNumberMoveRemaining(int number_move_remaining) {
        this.number_move_remaining = number_move_remaining;
    }

    public void setSpritePath(String sprite_path) {
        this.sprite_path = sprite_path;
    }

    public void moveLeft(){
        position_x-=1;
        number_move_remaining-=1;
    }

    public void moveUp(){
        position_y-=1;
        number_move_remaining-=1;
    }

    public void moveDown(){
        position_y+=1;
        number_move_remaining-=1;
    }

    // call this method only if number_move_remaining is >=0 after the move
    public void move(int position_x, int position_y){
        this.setPositionX(position_x);
        this.setPositionY(position_y);
        number_move_remaining -= Math.abs(position_x - this.position_x) + Math.abs(position_y - this.position_y);
    }
}