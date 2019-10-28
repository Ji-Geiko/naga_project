package ui;

import java.awt.event.*;

import javax.swing.JButton;

public class Bouton extends JButton implements MouseListener {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  /*
   * private String name; private Image img; private Game game;
   * 
   * public Bouton(String str, Game game) { super(str); this.name = str;
   * this.addMouseListener(this); this.game = game; }
   */
  public void mouseClicked(MouseEvent event) {
    System.out.println("click");
    //game.startGame(this);
  }

  public void mouseEntered(MouseEvent event) {
  }

  public void mouseExited(MouseEvent event) {
  }

  public void mousePressed(MouseEvent event) {
  }

  public void mouseReleased(MouseEvent event) {
  }
}