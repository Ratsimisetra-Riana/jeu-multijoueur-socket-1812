package Graph;
import javax.swing.*;
import Listener.player1listener;
import socket.Server;
public class voidmain extends JFrame{

    Table tabletennis;
    Server server=null;
  
    public voidmain(Table t,Server ser)
    {
      this.setFocusable(true);
      this.requestFocus();
      this.setTitle("Pong game . developped by Riana ,HOST");
      this.tabletennis=t;
      this.server=ser;
      this.setVisible(true);
      this.setBounds(10,10,1000,900);
      this.setLayout(null);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.addKeyListener(new player1listener(this));
    }

    public Table getTabletennis(){
      return tabletennis;
    }

    public void setTabletennis(Table tabletennis) {
      this.tabletennis = tabletennis;
    }

    public Server getServer() {
      return server;
    }

    public void setServer(Server server) {
      this.server = server;
    }

    

}
