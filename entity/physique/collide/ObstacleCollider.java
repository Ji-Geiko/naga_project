package entity.physique.collide;

import entity.animation.*;

public class ObstacleCollider extends Collide {

    public ObstacleCollider(Animation animation, int x, int y) {
        super(animation, x, y);
    }

    @Override
    public void collidedWith(Collide other) {
        
    }
}