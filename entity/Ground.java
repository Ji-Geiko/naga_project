package entity;

import java.awt.*;

import entity.animation.Animation;
import entity.physique.collide.*;

public class Ground extends Entity{
    
    public Collide collide;

    public Ground(Graphics g){
        super(0,450,Entity.STATIC,g);
        this.animation= new Animation(g, "ground", 100,"", this);
        this.collide=new GroundCollide(animation, x, y);

        this.collides.add(collide);
    }

    @Override
    public void collidedWith(Entity other) {
        
    }
}