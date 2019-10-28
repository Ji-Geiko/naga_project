package entity.physique.collide;

import entity.animation.*;
import game.Game;
import entity.*;

public class PlayerAttackCollider extends Collide{
    public PlayerAttackCollider(Animation animation, int x, int y, PlayerEntity player, Game game){
        super(animation, x, y);
    }

    @Override
    public void collidedWith(Collide other) {

    }
}