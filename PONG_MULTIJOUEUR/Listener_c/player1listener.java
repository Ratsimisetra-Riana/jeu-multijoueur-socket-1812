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
            this.mytable.getClient().setMessage_client("client_left");
            this.mytable.getClient().getOut().writeUTF(this.mytable.getClient().getMessage_client());
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            this.mytable.getClient().setMessage_client("client_right");
            this.mytable.getClient().getOut().writeUTF(this.mytable.getClient().getMessage_client());
        }
        if(e.getKeyCode()==KeyEvent.VK_SPACE)
        {
            this.mytable.getClient().setMessage_client("frappe_client");
            this.mytable.getClient().getOut().writeUTF(this.mytable.getClient().getMessage_client());
        }
        if(e.getKeyCode()==KeyEvent.VK_Z)//manetsika ball a gauche 
        {
            this.mytable.getClient().setMessage_client("ball_left");
            this.mytable.getClient().getOut().writeUTF(this.mytable.getClient().getMessage_client());
        }
        if(e.getKeyCode()==KeyEvent.VK_X)//manetsika ball a gauche 
        {
            this.mytable.getClient().setMessage_client("ball_right");
            this.mytable.getClient().getOut().writeUTF(this.mytable.getClient().getMessage_client());
        }
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
    }
        
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            this.mytable.getTabletennis().getPl2().setDirection_frappe("");
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            this.mytable.getTabletennis().getPl2().setDirection_frappe("");
        }
    }
}
