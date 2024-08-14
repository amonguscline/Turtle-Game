import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import java.lang.*;
class Enemy{
  private Turtle target;
  private int x=(int)(Math.random()*400);  
  private int y=(int)(Math.random()*400);
  protected Turtle t;
  protected int speed;
  private World w;
  private ArrayList<ArrayList <Integer>> coordinates = new ArrayList<ArrayList <Integer>>();
  public Enemy(World w, Turtle q){
    this.w=w;
    target=q;
    while(target.getDistance(x,y)<100){
      y=(int)(Math.random()*400);
      x=(int)(Math.random()*400);
    }
    t = new Turtle(x,y,w);
    speed=2;
    t.setBodyColor(Color.red);
  }
  public void update(){
    t.turnToFace(target.getXPos(), target.getYPos());
    for(int i=0;i<9;i++){
      ArrayList<Integer> currCord = new ArrayList<Integer>();
      currCord.add(t.getXPos()+(i-1)%3);
      currCord.add(t.getYPos()+(i-1)/3);
      coordinates.add(currCord);
    }
    if(t.getDistance(target.getXPos(),target.getYPos())<12){
      System.out.println("you died");
      System.exit(0);
    }
    t.forward(speed);
    for(int i=0;i<coordinates.size();i++){
      if(target.getXPos()==coordinates.get(i).get(0)&&target.getYPos()==coordinates.get(i).get(1)){
        coordinates.clear();
        t.clearPath();
        t.hide();
        t=null;
        Main.clearEnemy(this);
      }
    }
  }
  
}