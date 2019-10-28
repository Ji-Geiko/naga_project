package entity.animation;

import java.awt.*;
import entity.*;
public class Animation{
    private Sprite sprite;
    private int frame;
    private int nbImage;
    private int tempsImage;
    private int nbChangedSprite;
    private Entity entity;

    public Animation(Graphics g, String pref, int duration, String specialPref, Entity entity){
        sprite = new Sprite(g,pref, specialPref);
        this.entity=entity;
        nbImage=sprite.getNbImage();
        float nbFrame =((float)duration/1000*60)/nbImage;
        tempsImage = Math.round(nbFrame);
    }

    public void ChangeSprite(){
        frame++;
        if(frame==tempsImage){
            frame=0;
            sprite.ChangeSprite();
            nbChangedSprite++;
            if(nbChangedSprite==nbImage){
                entity.attack(false);
            }
        }
    }

    public void draw(int x, int y){
        this.ChangeSprite();
        sprite.draw(x, y);
    }

    public int getWidth(){
        return sprite.getWidth();
    }

    public int getHeight(){
        return sprite.getHeight();
    }
}