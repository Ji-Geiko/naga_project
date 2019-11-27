package entity.physique.collide;

import java.awt.*;

import entity.animation.*;

public abstract class Collide {
    protected Rectangle me = new Rectangle();
    protected Rectangle him = new Rectangle();
    protected int x;
    protected int y;
    protected Animation animation;

    public Collide(Animation animation, int x, int y) {
        this.animation = animation;
        this.x = x;
        this.y = y;

        me.setBounds((int) x, (int) y, animation.getWidth() * 2, animation.getHeight() * 2);
    }

    public boolean isCollidedWith(Collide other) {

        him.setBounds((int) other.x, (int) other.y, other.getAnimation().getWidth(), other.getAnimation().getHeight());

        return me.intersects(him);
    }

    public Animation getAnimation() {
        return animation;
    }

    public abstract void collidedWith(Collide other);
}