package entity.animation;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class SpriteStore{
    ImageIcon imgIcon;
    private int index=1;
    private String pref;
    private int maxSprite;
    private boolean remainSprite=true;
    private ArrayList<Image> sprites = new ArrayList<Image>();

    public SpriteStore(String pref, String specialPref){
        this.pref = pref;
        while(remainSprite==true){
            //Get all files from directory
            String path = "sprite/"+this.pref+"/"+specialPref+index+".png";
            if(new File(path).exists()){
                imgIcon = new ImageIcon(path);
                //Set max
                maxSprite ++;
                index ++;
                // store in memory (array)
                sprites.add(imgIcon.getImage());
            }else{
                remainSprite=false;
                index= -1;
            }
        }
    }

	public Image getSprite() {
        if(index == maxSprite-1){
            index = -1;
        }
        index++;   
        return sprites.get(index);
    }

    public int getNbImage(){
        return maxSprite -1;
    }
}