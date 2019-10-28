package entity.physique.collide;

import entity.*;
import entity.animation.*;
import game.Game;

public class PlayerGameOverCollide extends Collide{
    public PlayerGameOverCollide(Animation animation, int x, int y, PlayerEntity player, Game game){
        super(animation, x, y);
    }

    @Override
    public void collidedWith(Collide other) {

    }
}