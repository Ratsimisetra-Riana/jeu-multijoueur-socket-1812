package menu_listener;
import java.awt.event.*;
import graph_menu.Choose_menu;
import thread.Thread_server;
public class Port_server_listener implements ActionListener {
    
    Choose_menu c_m=null;
    
    public Port_server_listener(Choose_menu c)
    {
        this.c_m=c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
        this.c_m.setVisible(false);
        this.c_m.remove(this.c_m.port.getButton());
        this.c_m.remove(this.c_m.port.getField());
        Thread_server t1 = new Thread_server(this.c_m.port.getField().getText());
        t1.start();
    }
}
