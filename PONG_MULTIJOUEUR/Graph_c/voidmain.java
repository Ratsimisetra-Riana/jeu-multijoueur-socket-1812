package Graph_c;
import javax.swing.*;
import Listener_c.player1listener;
import socket_c.Client;
public class voidmain extends JFrame{

    Table tabletennis;
    Client client=null;
   
    public voidmain(Table t ,Client c)
    {
      this.setFocusable(true);
      this.requestFocus();
      this.setTitle("Pong game . developped by Riana ,JOIN");
      this.tabletennis=t;
      this.client=c;
      this.setVisible(true);
      this.setBounds(10,10,1000,900);
      this.setLayout(null);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.addKeyListener(new player1listener(this));
    }

    public Table getTabletennis() {
      return tabletennis;
    }

    public void setTabletennis(Table tabletennis) {
      this.tabletennis = tabletennis;
    }

    public Client getClient() {
      return client;
    }

    public void setClient(Client client) {
      this.client = client;
    }

    

}
