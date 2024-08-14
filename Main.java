import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import java.lang.*;
public class Main {
  private static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
  public static World world = new World(400,400);
  public static Player p = new Player(world);
  public static int difficulty=0;
  public static void main(String[] args) {  
    enemies.add(new Enemy(world,p.getSprite()));
    world.setVisible(true);
    start();
    
  }
  public static void clearEnemy(Enemy n){
    n=null;
  }
  public static void addEnemy(){
    int spawnchance = (int)(Math.random()*150-difficulty);
    if(spawnchance-148+difficulty>0){
      int turtletypeprobability = (int)(Math.random()*4);
      if(turtletypeprobability-2>0){
        enemies.add(new FastEnemy(world,p.getSprite()));
      }
      else{enemies.add(new Enemy(world,p.getSprite()));}
    }
  }
  public static void start(){
    int increment=0;
    while(true){
      p.update();
      addEnemy();
      for(int i=0;i<enemies.size();i++){
        try{
          enemies.get(i).update();
        }
        catch(Exception e){
          enemies.remove(i);
          i++;
          addEnemy();
        }
      }
      increment++;
      if(increment==20){
        increment=0;
        difficulty++;
      }
      //f.update();
      try{Thread.sleep(1000/100);}
      catch(Exception e){System.out.println("task failed incorrectly");}
    }
  }
}
