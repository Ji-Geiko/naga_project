package entity.physique.collide;

import entity.animation.*;
import entity.physique.collide.Collide;

public class GroundCollide extends Collide {
    public GroundCollide(Animation animation, int x, int y) {
        super(animation, x, y);
    }

    @Override
    public void collidedWith(Collide other) {

    }
}