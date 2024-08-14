import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
class Player{
  private int speed;
  private int theta;
  private Turtle playerSprite;
  private int speedLimit=3;
  private HashMap<String, Boolean> keys = new HashMap<String, Boolean>();
  //make an arraylist that keeps track of each keypress and change it when released
  public Player(World w){
    playerSprite = new Turtle(w);
    keys.put("w",false);
    keys.put("a",false);
    keys.put("s",false);
    keys.put("d",false);
    w.getFrame().addKeyListener(new KeyListener() {
      public void keyPressed(KeyEvent e) {
        inputMove(e);
      }
      public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W) keys.put("w",false);
        if(e.getKeyCode() == KeyEvent.VK_A) keys.put("a",false);
        if(e.getKeyCode() == KeyEvent.VK_S) keys.put("s",false);
        if(e.getKeyCode() == KeyEvent.VK_D) keys.put("d",false);
      }
      public void keyTyped(KeyEvent e) { /* ... */ }
    });
  }
  private int frame=0;
  public void update(){
    //check if all four of the keypress are false
    boolean allfalse=true;
    for(Map.Entry<String, Boolean> key:keys.entrySet()){
      if(key.getValue()) {
        allfalse=false;
      }
    }
    if(speed>0&&allfalse&&frame>10){
      speed--;
      frame=5;
      //decrease the speed every x amount of frames
    }
    playerSprite.forward(speed);
    
    frame++;
  }
  public void inputMove(KeyEvent e){
    if (e.getKeyCode() == KeyEvent.VK_W) {
      if(speed<speedLimit)speed++;
      keys.put("w",true);
      playerSprite.setHeading(0);
    }
    else if (e.getKeyCode() == KeyEvent.VK_A) {
      if(speed<speedLimit)speed++;
      keys.put("a",true);
      playerSprite.setHeading(270);
    }
    else if (e.getKeyCode() == KeyEvent.VK_S) {
      if(speed<speedLimit)speed++;
      keys.put("s",true);
      playerSprite.setHeading(180);
    }
    else if (e.getKeyCode() == KeyEvent.VK_D) {
      if(speed<speedLimit)speed++;
      keys.put("d",true);
      playerSprite.setHeading(90);
    }
  }
  public Turtle getSprite(){
    return playerSprite;
  }
}