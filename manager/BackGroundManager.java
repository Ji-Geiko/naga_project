package manager;

import java.util.*;
import java.awt.*;

import background.*;

public class BackGroundManager {
    private ArrayList<BackGround> backGround;
    private Graphics g;
    private BackGround backOne;
    private BackGround backtwo;
    private BackGround backOneNext;
    private BackGround backtwoNext;

    public BackGroundManager(Graphics g) {
        this.g = g;
        backGround = new ArrayList<BackGround>();
    }

    public void draw() {
        for (BackGround bg : backGround) {
            bg.draw(g);
        }
    }

    public void addBackground(int nbGround) {
        backOne = new BackGround();
        backGround.add(backOne);
        backtwo = new BackGround(0, 0, 2);
        backGround.add(backtwo);
        backOneNext = new BackGround(backOne.getXSize(), 0, 1);
        backOneNext.setX(backOne.getXSize());
        backGround.add(backOneNext);
        backtwoNext = new BackGround(backOne.getXSize(), 0, 2);
        backtwoNext.setX(backOne.getXSize());
        backGround.add(backtwoNext);
    }

}