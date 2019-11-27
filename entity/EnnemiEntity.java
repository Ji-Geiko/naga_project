package entity;

import java.awt.*;

import entity.physique.*;
import entity.animation.*;

public class EnnemiEntity extends Entity{
    public EnnemiEntity(int x, int y, Graphics g){
        super(x, y, Gravity.STATIC,g);
        this.animation=new Animation(g, "ennemi", 2000,"run/", this);
    }

    @Override
    public void collidedWith(Entity other) {
        
    }
}