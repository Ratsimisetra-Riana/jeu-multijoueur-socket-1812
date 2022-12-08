package Listener_c;

import java.awt.event.*;
import Graph_c.voidmain;
public class player1listener implements KeyListener{

    voidmain mytable;

    public player1listener(voidmain t)
    {
        this.mytable=t;
    }
   
    public void keyTyped(KeyEvent e) {
    }

    
    public void keyPressed(KeyEvent e) {
        
        System.out.println("Mety");
        
        try{
        
        if(e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            this.mytable.getTabletennis().getPl2().setX(this.mytable.getTabletennis().getPl2().getX()-5);
            //mietsika gauche any amn serveur
            this.mytable.getClient().setMessage_client("client_left");
            this.mytable.getClient().getOut().writeUTF(this.mytable.getClient().getMessage_client());
            if((this.mytable.getTabletennis().getBall().getDirection()==0)&&(this.mytable.getTabletennis().getBall().getDirectionx()==0)&&(this.mytable.getTabletennis().getBall().getY()>=(this.mytable.getTabletennis().getWidth()/2)))/*deplacer getBall() avec player */
            {
                this.mytable.getTabletennis().getBall().setX(this.mytable.getTabletennis().getPl2().getX()+(this.mytable.getTabletennis().getPl2().getWidth()/2));
                //mietsika gauche miaraka amn ball any amn serveur
                this.mytable.getClient().setMessage_client("client_ball_left");
                this.mytable.getClient().getOut().writeUTF(this.mytable.getClient().getMessage_client());
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            this.mytable.getTabletennis().getPl2().setX(this.mytable.getTabletennis().getPl2().getX()+5);
            //mietsika droite any amn serveur
            this.mytable.getClient().setMessage_client("client_right");
            this.mytable.getClient().getOut().writeUTF(this.mytable.getClient().getMessage_client());
            if((this.mytable.getTabletennis().getBall().getDirection()==0)&&(this.mytable.getTabletennis().getBall().getDirectionx()==0)&&(this.mytable.getTabletennis().getBall().getY()>=(this.mytable.getTabletennis().getWidth()/2)))/*deplacer getBall() avec player */
            {
                this.mytable.getTabletennis().getBall().setX(this.mytable.getTabletennis().getPl2().getX()+(this.mytable.getTabletennis().getPl2().getWidth()/2));
                //mietsika gauche miaraka amn ball any amn serveur
                this.mytable.getClient().setMessage_client("client_ball_right");
                this.mytable.getClient().getOut().writeUTF(this.mytable.getClient().getMessage_client());
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_SPACE)
        {
            if((this.mytable.getTabletennis().getBall().getDirection()==0)&&(this.mytable.getTabletennis().getBall().getY()+this.mytable.getTabletennis().getBall().getHeight()==this.mytable.getTabletennis().getPl2().getY()))
            {
                this.mytable.getTabletennis().getBall().setY(this.mytable.getTabletennis().getBall().getY()-2);
                this.mytable.getTabletennis().getBall().setDirection(-1);
                //manetsika bol any amn server 
                this.mytable.getClient().setMessage_client("frappe_client");
                this.mytable.getClient().getOut().writeUTF(this.mytable.getClient().getMessage_client());
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
