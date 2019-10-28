package entity.animation;

import java.awt.*;

public class Sprite{
    private Image image;
    private int x;
    private int y;
    Graphics g;
    private String pref;
    private String specialPref;

    SpriteStore store;

    public Sprite(Graphics g, String pref,String specialPref){
        this.pref = pref;
        this.specialPref = specialPref;
        store = new SpriteStore(this.pref, this.specialPref);
        this.g = g;
    }

    public void draw(int x, int y){
        this.x = x;
        this.y = y;
        this.ChangeSprite();
        g.drawImage(image,this.x, this.y,image.getWidth(null)*2,image.getHeight(null)*2,null);
        //g.drawRect(10,10,10,10);
    }

    public void ChangeSprite(){
        image = store.getSprite();
    }

    public int getNbImage(){
        return store.getNbImage();
    }

    public int getWidth(){
        this.ChangeSprite();
        return image.getWidth(null);
    }

    public int getHeight(){
        this.ChangeSprite();
        return image.getHeight(null);
    }
}