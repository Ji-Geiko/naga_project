package manager;

import java.awt.*;
import java.util.*;

import entity.*;
import entity.physique.collide.*;

public class EntityManager {

    private boolean upSpawn = true;
    private ArrayList<Entity> objects;
    private ArrayList<Collide> collides;

    private Graphics g;
    private Ground ground;

    public EntityManager(Graphics g) {
        this.objects = new ArrayList<Entity>();
        this.g = g;
        this.collides= new ArrayList<Collide>();
    }

    public void addGround() {
        ground = new Ground(g);
        this.objects.add(ground);
    }

    public void addEnnemi() {
        /*
         * if(getRandom(1, 100)==50){ this.objects.add(new EnnemiEntity(1200,435,g)); }
         */
    }

    public void addObstacle() {
        int obstacleSpawn;

        if (upSpawn == false) {
            obstacleSpawn = this.getRandom(0, 350);
            upSpawn = true;
        } else {
            obstacleSpawn = (this.getRandom(350, 450));
            upSpawn = false;
        }
        this.objects.add(new ObstacleEntity(1000, obstacleSpawn, g, Entity.DIRECTION_LEFT, 5));
    }

    public int getRandom(int minRandom, int maxRandom) {
        int n = (int) (Math.random() * (maxRandom - minRandom)) + minRandom;
        return n;
    }

    public void attract(Entity ob) {
        ob.setY(ob.attract(ob.getY()));
    }

    public ArrayList<Collide> getCollides() {
        for (Entity ob : new ArrayList<>(objects)) {
            ArrayList<Collide> obCollide = ob.getCollides();
            for(int i = 0; i == obCollide.size(); i++){
                if(this.collides.size()!=0){
                    this.collides.add(obCollide.get(i));
                }
            }
        }

        return this.collides;
    }

    public void setSpeed(int speed) {
        for (Entity ob : new ArrayList<>(objects)) {
            if (ob instanceof ObstacleEntity || ob instanceof EnnemiEntity) {
                ob.setSpeed(speed);
            }
        }
    }

    public void draw() {
        for (Entity ob : new ArrayList<>(objects)) {
            if (ob != null) {
                if (ob.getX() == -1 * ob.getAnimation().getWidth()) {
                    objects.remove(ob);
                }
                this.attract(ob);
                ob.move();
                ob.draw();
            } else
                break;
        }
    }

    public ArrayList<Entity> getObjects() {
        return this.objects;
    }

    public void setObjects(Entity e) {
        objects.add(e);
    }
}