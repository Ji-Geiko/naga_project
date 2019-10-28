package entity.physique;

public class Gravity {
    public static final String DYNAMIC = "DYNAMIQUE";
    public static final String STATIC = "STATIC";
    public static final int G = 5;
    private String state;
    private int y;
    private Boolean inCollide = false;

    public Gravity(String state, int x, int y) {
        this.state = state;
    }

    public Gravity getGravity() {
        return this;
    }

    public void setCollide(boolean collide) {
        inCollide = collide;
    }

    public int attract(int y) {
        this.y = y;
        if (this.state == DYNAMIC && inCollide == false) {
            y=this.y+Gravity.G;
        } else {
            inCollide = false;
        }
        return y;
    }
}