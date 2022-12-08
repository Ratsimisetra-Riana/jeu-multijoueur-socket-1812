package graph_menu;
import javax.swing.JFrame;
import javax.swing.JButton;
import socket.Server;
import socket_c.Client;
import menu_listener.Choose_menu_listener;

public class Choose_menu extends JFrame{
    
    public String choice="";
    public JButton host=null;
    public JButton join=null;
    public Server server=null;
    public Client client=null;
    public Adresse_ip a_ip=null;

    public Choose_menu()
    {
        this.setTitle("Pong multiplayer Menu");
        this.setBounds(10,10,500,500);
        
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.host=new JButton("HOST");
        this.host.setBounds(50,125,125,125);
        this.host.addActionListener(new Choose_menu_listener(this,this.host));
        this.join=new JButton("JOIN");
        this.join.setBounds(300,125,125,125);
        this.join.addActionListener(new Choose_menu_listener(this,this.join));
        this.setLayout(null);

        this.add(this.host);
        this.add(this.join);
    }
}
