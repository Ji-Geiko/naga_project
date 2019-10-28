package entity;

import java.awt.*;

import entity.animation.Animation;
import entity.physique.*;
import entity.physique.collide.*;

public class ObstacleEntity extends Entity{

    private Collide collide;

    public ObstacleEntity(int x, int y,Graphics g, String mainDirection, int speed){
        super(x,y,Gravity.STATIC,g);
        this.animation=new Animation(g, "Obstacle", 0,"",this);
        this.speed = speed;
        this.direction= mainDirection;

        collide = new ObstacleCollider(animation, x, y);

        collides.add(collide);
    }

    public void collidedWith(Entity other){}
}