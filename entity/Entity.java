package entity;

import entity.animation.*;
import entity.physique.Gravity;
import entity.physique.collide.*;

import java.awt.*;
import java.util.*;

public abstract class Entity extends Gravity {
    protected int x;
    protected int y;
    protected Animation animation;
    protected double dx;
    protected double dy;
    protected boolean inJump = false;
    protected boolean inCollide = false;
    protected int maxJump = 60;
    protected int minJump;
    protected boolean jumpUp = true;
    protected Gravity gravity;
    protected boolean inAttack;
    protected int gravityPower;
    protected int speed;

    protected ArrayList<Collide> collides; 

    protected String direction;

    private Graphics g;
    Entity entity = this;
    public static final String DIRECTION_LEFT = "direction_left";
    public static final String DIRECTION_RIGHT = "direction_right";
    public static final String DIRECTION_JUMP = "direction_jump";
    public static final String DIRECTION_NULL = "direction_null";


    public Entity(int x, int y, String GravityState, Graphics g) {
        super(GravityState, x, y);
        this.g=g;
        this.gravity = getGravity();
        this.x = x;
        this.y = y;
        minJump = this.y;
        this.gravityPower=Gravity.G;
        this.collides=new ArrayList<Collide>();
    }

    public void move() {
        if (this.direction == Entity.DIRECTION_LEFT) {
            x -= speed;
        }
        if (this.direction == Entity.DIRECTION_JUMP) {
            y -= gravityPower*1.5;
            if(inJump==false){
                this.direction=Entity.DIRECTION_NULL;
            }
        }
    }

    public ArrayList<Collide> getCollides(){
        return this.collides;
    }

    /*public void move(Entity entity){
        y=attract(y);
        if()
    }*/

    public void setDirection(String direction){
        this.direction=direction;
    }

    public void attack(boolean newAttack) {
        this.inAttack = newAttack;
        if (this.inAttack == true) {
            this.animation = new Animation(g, "player", 1000, "attack/", this);
        } else {
            this.animation = new Animation(g, "player", 1000, "run/", this);
        }
    }

    public void draw() {
        animation.draw(x, y);
    }

    public Animation getAnimation() {
        return this.animation;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int newY) {
        this.y = newY;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }


}