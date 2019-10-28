package game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.awt.event.*;

import entity.Entity;
import entity.PlayerEntity;
import entity.physique.collide.Collide;
import manager.*;

public class Game extends Canvas {
    /**
     * 
     **/
    private static final long serialVersionUID = 1L;
    private BufferStrategy strategy;
    public JPanel panel;
    private JButton btn;
    private Color c;
    private JFrame frame;
    private boolean gameRunning = true;
    private boolean gameStarted = false;
    private PlayerEntity player;
    private Graphics g;
    private boolean touchKey = false;
    private boolean spacePressed;
    private int wight = 800;
    private int height = 600;
    private BackGroundManager bgManager;
    private EntityManager enManager;
    private boolean click;
    public boolean gameOver;
    private long NbFrame = 0;
    private long NOW;
    private long start = 0;
    private long FPS;
    private ArrayList<Collide> playerCollides;
    private ArrayList<Collide> otherCollides;

    public Game(boolean inGame) {
        frame = new JFrame("naga run");
        panel = (JPanel) frame.getContentPane();
        panel.setPreferredSize(new Dimension(this.wight, this.height));
        panel.setLayout(null);
        setBounds(0, 0, 800, 600);
        panel.add(this);

        frame.setIgnoreRepaint(true);
        frame.setLocationRelativeTo(null);

        frame.pack();
        frame.setResizable(true);
        frame.setVisible(true);

        createBufferStrategy(2);
        strategy = getBufferStrategy();
        addKeyListener(new KeyInputHandler());
        addMouseListener(new MouseInputHandler());

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // request the focus so key events come to us

        requestFocus();

        // this.startMenu();

        // startGame();

        g = (Graphics2D) strategy.getDrawGraphics();
        player = new PlayerEntity(100, 350, g, this, Entity.DIRECTION_NULL, 5);

        bgManager = new BackGroundManager(g);
        enManager = new EntityManager(g);

        enManager.addGround();

        bgManager.addBackground(2);

        gameStarted = !gameStarted;
    }

    public void gameLoop() {
        // Get time in millisecond please
        System.currentTimeMillis();
        enManager.setObjects(player);

        while (gameRunning == true) {
            NOW = System.currentTimeMillis();

            if (gameStarted) {
                Graphics2D g = (Graphics2D) strategy.getDrawGraphics();

                g.fillRect(0, 0, 800, 600);

                event();

                logic();

                render();

                uiRender();

                g.dispose();
                strategy.show();
                NbFrame++;
            }
        }
    }

    public void event() {
        if (touchKey) {
            if (spacePressed == true && player.getJump() == false) {
                player.setDirection(Entity.DIRECTION_JUMP);
                player.setJump(true);
                spacePressed = false;
            }
            touchKey = false;
        }


        // COLLIDE CHECK
        playerCollides = player.getCollides();

        otherCollides = enManager.getCollides();

        for (int p = 0; p < playerCollides.size(); p++) {
            Collide me = (Collide) playerCollides.get(p);
            for (int s = p; s < otherCollides.size(); s++) {
                Collide him = (Collide) otherCollides.get(s);
                if (me.isCollidedWith(him)) {
                    me.collidedWith(him);
                    him.collidedWith(me);
                }
            }
        }
        /*
         * for (int p = 0; p < entities.size(); p++) { Entity me = (Entity)
         * entities.get(p); for (int s = p + 1; s < entities.size(); s++) { Entity him =
         * (Entity) entities.get(s); if (me.isCollidedWith(him)) { me.collidedWith(him);
         * him.collidedWith(me); } } }
         */
    }

    public void logic() {
        if (getRandom(0, 1000) >= 950) {
            enManager.addObstacle();
        }

        if (click == true) {
            player.attack(true);
            click = false;
        }

        enManager.addEnnemi();

        if (player.getJump() == true) {
            player.jump();
        } else {
            // player.jump();
        }
    }

    public void render() {
        bgManager.draw();
        enManager.draw();
    }

    public void uiRender() {
        if (gameOver == true) {
            int fontSize = 50;
            g.setColor(Color.RED);
            g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
            g.drawString("GAME OVER", 200, 300);
        }
        // If now is greater than start+1000
        // then store nbFrame to FPS
        // reset NbFrame and store NOW in Start

        if (NOW >= start + 1000) {
            FPS = NbFrame;
            NbFrame = 0;
            start = NOW;
            System.out.println("fps:" + FPS);
        }

        try {
            Thread.sleep(16);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void playerSetSpeed(int speed) {
        player.setSpeed(speed);
    }

    public void obstacleSetSpeed(int speed) {
        enManager.setSpeed(speed);
    }

    public void startMenu() {
        btn = new JButton("Start");
        btn.addMouseListener(new MouseInputHandler());

        panel.add(btn);
    }

    public void startGame() {
        g.setColor(Color.black);
        c = g.getColor();
        panel.setBackground(c);
        this.btn.setVisible(false);
        this.gameStarted = true;
    }

    public static void main(String[] args) {
        Game game = new Game(false);

        game.gameLoop();
    }

    public int getRandom(int minRandom, int maxRandom) {
        int n = (int) (Math.random() * (maxRandom - minRandom)) + minRandom;
        return n;
    }

    public void gameOver(Graphics g) {
        gameRunning = false;
        System.out.println("perdue");
        this.gameOver = true;
    }

    private class KeyInputHandler extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            touchKey = !touchKey;
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            }

            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            }

            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                spacePressed = true;
            }
        }
    }

    private class MouseInputHandler extends MouseAdapter {
        public void mouseClicked(MouseEvent event) {
            System.out.println("click");
            click = true;
        }
    }
}