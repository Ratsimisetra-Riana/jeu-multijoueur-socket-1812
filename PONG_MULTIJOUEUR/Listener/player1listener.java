package Listener;

import java.awt.event.*;
import Graph.voidmain;
public class player1listener implements KeyListener{

    voidmain mytable;

    public player1listener(voidmain t)
    {
        this.mytable=t;
    }
   
    public void keyTyped(KeyEvent e) {
    }

    
    public void keyPressed(KeyEvent e) {
        
        try{
            System.out.println("Mety");
            
            if(e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                this.mytable.getTabletennis().getPl1().setX(this.mytable.getTabletennis().getPl1().getX()-5);
            }
            if(e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                this.mytable.getTabletennis().getPl1().setX(this.mytable.getTabletennis().getPl1().getX()+5);
            }
            if(e.getKeyCode()==KeyEvent.VK_SPACE)
            {
                if((this.mytable.getTabletennis().getBall().getDirection()==0)&&(this.mytable.getTabletennis().getBall().getY()==this.mytable.getTabletennis().getPl1().getY()+this.mytable.getTabletennis().getPl1().getHeight()))
                {
                    this.mytable.getTabletennis().getBall().setY(this.mytable.getTabletennis().getBall().getY()+2);
                    this.mytable.getTabletennis().getBall().setDirection(1);
                }
            }
            if(e.getKeyCode()==KeyEvent.VK_Z)//manetsika ball a gauche 
            {
                if(this.mytable.getTabletennis().getBall().getDirection()==1)
                {
                    this.mytable.getTabletennis().getBall().setDirectionx(-1);
                }
            }
            if(e.getKeyCode()==KeyEvent.VK_X)//manetsika ball a gauche 
            {
                if(this.mytable.getTabletennis().getBall().getDirection()==1)
                {
                    this.mytable.getTabletennis().getBall().setDirectionx(1);
                }
            }

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
        
    public void keyReleased(KeyEvent e) {
    }

    
}
