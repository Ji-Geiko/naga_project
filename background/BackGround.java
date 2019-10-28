package background;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;

import java.io.*;

public class BackGround {
    private BufferedImage image;
    private int x;
    private int y;
    private int index = 1;
    private int xSize;
    private int ySize;

    public BackGround() {
        this(0, 0, 1);
    }

    public BackGround(int x, int y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;

        try {
            image = ImageIO.read(new File("sprite/backGround/" + this.index + ".png"));
        } catch (Exception e) {
            System.out.println(e);
        }
        xSize = image.getWidth() * 3;
        ySize = image.getHeight() * 3;
    }

    public void draw(Graphics g) {
        g.drawImage(image, this.getX(), this.getY(), xSize, ySize, null);
        this.x -= 5 * index;

        if (this.x <= -1 * getXSize()) {
            this.x = this.x + this.getXSize() * 2;
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getImageWidth() {
        return image.getWidth();
    }

    public int getXSize() {
        return xSize;
    }

    public int getYSize() {
        return ySize;
    }
}