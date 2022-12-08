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
                //mietsika gauche any amn client
                this.mytable.getServer().setMessage_server("server_left");
                this.mytable.getServer().getOut().writeUTF(this.mytable.getServer().getMessage_server());
                if((this.mytable.getTabletennis().getBall().getDirection()==0)&&(this.mytable.getTabletennis().getBall().getDirectionx()==0)&&(this.mytable.getTabletennis().getBall().getY()<=(this.mytable.getTabletennis().getWidth()/2)))/*deplacer getBall() avec player */
                {
                    this.mytable.getTabletennis().getBall().setX(this.mytable.getTabletennis().getPl1().getX()+(this.mytable.getTabletennis().getPl1().getWidth()/2));
                    //mietsika gauche miaraka amn ball any amn client
                    this.mytable.getServer().setMessage_server("server_ball_left");
                    this.mytable.getServer().getOut().writeUTF(this.mytable.getServer().getMessage_server());
                }
            }
            if(e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                this.mytable.getTabletennis().getPl1().setX(this.mytable.getTabletennis().getPl1().getX()+5);
                //mietsika droite server any amn client
                this.mytable.getServer().setMessage_server("server_right");
                this.mytable.getServer().getOut().writeUTF(this.mytable.getServer().getMessage_server());
                if((this.mytable.getTabletennis().getBall().getDirection()==0)&&(this.mytable.getTabletennis().getBall().getDirectionx()==0)&&(this.mytable.getTabletennis().getBall().getY()<=(this.mytable.getTabletennis().getWidth()/2)))/*deplacer getBall() avec player */
                    {
                        this.mytable.getTabletennis().getBall().setX(this.mytable.getTabletennis().getPl1().getX()+(this.mytable.getTabletennis().getPl1().getWidth()/2));
                        //mietsika droite miaraka amn ball any amn client
                        this.mytable.getServer().setMessage_server("server_ball_right");
                        this.mytable.getServer().getOut().writeUTF(this.mytable.getServer().getMessage_server());
                    }
            }
            if(e.getKeyCode()==KeyEvent.VK_SPACE)
            {
                if((this.mytable.getTabletennis().getBall().getDirection()==0)&&(this.mytable.getTabletennis().getBall().getY()==this.mytable.getTabletennis().getPl1().getY()+this.mytable.getTabletennis().getPl1().getHeight()))
                {
                    this.mytable.getTabletennis().getBall().setY(this.mytable.getTabletennis().getBall().getY()+2);
                    this.mytable.getTabletennis().getBall().setDirection(1);
                    //manetsika bol any amn client 
                    this.mytable.getServer().setMessage_server("frappe_server");
                    this.mytable.getServer().getOut().writeUTF(this.mytable.getServer().getMessage_server());
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
