package entity;

import java.awt.Graphics;
import java.util.ArrayList;

import entity.animation.Animation;
import entity.physique.Gravity;
import entity.physique.collide.*;

import game.Game;

public class PlayerEntity extends Entity {
    private int animationDurationRun = 800;
    private String spriteRef = "player";
    private Game game;
    private Graphics g;
    private long duration = 0;
    private int jumpTime=10;
    private PlayerFootCollider foot;
    private PlayerAttackCollider attack;
    private PlayerGameOverCollide GameOver;
    private ArrayList<Collide> collides;

    public PlayerEntity(int x, int y, Graphics g, Game game, String mainDirection, int mainSpeed) {
        super(x, y, Gravity.DYNAMIC, g);
        this.g = g;
        this.animation = new Animation(g, this.spriteRef, this.animationDurationRun, "run/", this);
        this.game = game;
        this.speed = mainSpeed;
        this.direction= mainDirection;
        this.collides=new ArrayList<Collide>();


        foot = new PlayerFootCollider(animation, x, y,this,game);
        attack = new PlayerAttackCollider(animation, x, y,this,game);
        GameOver = new PlayerGameOverCollide(animation, x, y,this,game);

        collides.add(foot);
        collides.add(attack);
        collides.add(GameOver);
    }

    public ArrayList<Collide> getCollides(){
        return this.collides;
    }

    public void jump() {
        if (inJump == true) {
            this.move();
            duration++;
        }
        if (duration >= jumpTime) {
            inJump = false;
            duration = 0;
        }
    }

    public Boolean getJump() {
        return inJump;
    }

    public void setJump(boolean newJump) {
        inJump = newJump;
        this.setCollide(newJump);
    }


    public void setLose() {
        game.gameOver(this.g);
    }
}