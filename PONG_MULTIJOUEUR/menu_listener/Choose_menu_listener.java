package menu_listener;
import socket.Server;
import socket_c.Client;
import java.awt.event.*;
import graph_menu.Choose_menu;
import graph_menu.Adresse_ip;
import thread.Thread_client;
import thread.Thread_server;
import javax.swing.JButton;

public class Choose_menu_listener implements ActionListener {

    Choose_menu c=null;
    JButton button=null;

    public Choose_menu_listener (Choose_menu cmenu,JButton b)
    {
        this.c=cmenu;
        this.button=b;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(button.getText().equals("HOST"))
        {
            this.c.setVisible(false);
            this.c.remove(this.c.host);
            this.c.remove(this.c.join);
            //this.c.dispose();
            //this.c.server = new Server(5000);
            Thread_server t1 = new Thread_server();
            t1.start();
        }
        else if(button.getText().equals("JOIN"))
        {
            this.c.setVisible(false);
            this.c.remove(this.c.host);
            this.c.remove(this.c.join);
            this.c.repaint();
            Adresse_ip a=new Adresse_ip();
            this.c.a_ip=a;
            this.c.a_ip.getButton().addActionListener(new Adresse_ip_listener(this.c));
            this.c.add(a);
            this.c.setVisible(true);
            //this.c.dispose();
            //Thread_client t2 = new Thread_client();
            //t2.start();
        }
    }
    
}
