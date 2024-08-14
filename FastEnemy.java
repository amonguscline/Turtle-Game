import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import java.lang.*;

class FastEnemy extends Enemy{
  public FastEnemy(World w, Turtle q){
    super(w,q);
    super.speed=3;
    super.t.setBodyColor(Color.black);
    super.t.setHeight(10);
    super.t.setWidth(10);
  }
}