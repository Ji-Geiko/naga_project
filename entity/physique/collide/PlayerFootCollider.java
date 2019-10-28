package entity.physique.collide;

import entity.*;
import entity.animation.*;
import game.Game;

public class PlayerFootCollider extends Collide {
    public PlayerEntity player;

    public PlayerFootCollider(Animation animation, int x, int y, PlayerEntity player, Game game) {
        super(animation, x, y);
        this.player = player;
    }

    @Override
    public void collidedWith(Collide other) {
        if (other instanceof GroundCollide){
            player.setCollide(true);
            System.out.println("in collide");
        }
    }
}