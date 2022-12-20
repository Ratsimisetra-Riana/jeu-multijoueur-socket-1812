package menu_listener;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JTextField;
import graph_menu.Choose_menu;
import thread.Thread_client;
public class Adresse_ip_listener implements ActionListener  {

    Choose_menu c_m=null;
    
    public Adresse_ip_listener(Choose_menu c)
    {
        this.c_m=c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Adresse ip de l'hote: "+this.c_m.a_ip.getField().getText());

        this.c_m.setVisible(false);
        this.c_m.remove(this.c_m.a_ip.getButton());
        this.c_m.remove(this.c_m.a_ip.getField());
        Thread_client t1 = new Thread_client(this.c_m.a_ip.getField().getText(),this.c_m.a_ip.getField2().getText());
        t1.start();
    }
    
}
