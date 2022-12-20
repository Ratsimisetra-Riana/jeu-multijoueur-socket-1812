// A Java program for a Client
package socket_c;
import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import Graph_c.Table;
import Graph_c.voidmain;

 
public class Client extends Thread 
{
    Socket socket=null;
    public DataOutputStream out=null;
    public String message_client = "";
    public voidmain mytable=null;
 
    // constructor to put ip address and port
    public Client(String address, int port)
    {
        // establish a connection
        try
        {   
            this.socket = new Socket(address, port);
            System.out.println("Connected");

            //interface graphique pong
            Table t=new Table(this);
            this.mytable=new voidmain(t,this);
            this.mytable.add(t);
 
            // create an outpout stream for this socket
            this.out = new DataOutputStream(this.socket.getOutputStream());

            //take the message you wrote on terminal
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
            
            
            //877keep reading until "Over" is input
           
            Thread thread=new Thread(this);
            thread.start();
            while (!this.message_client.equals("Over"))
            {
                try
                {
                    this.message_client = br.readLine();//mila mtaper entrer de raha tsy te hitaper entrer de tokony tonga de out.write no atsoina fa tsy manao readline() tsony
                    this.out.writeUTF("Client:"+this.message_client);
                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            // close the connection
                this.out.close();
                this.socket.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void run()//maka anle message avy any amn server
    {
        System.out.println("Connected");

        try {
            // take server message
            DataInputStream input = new DataInputStream(this.socket.getInputStream());
            String message_server = "";

             // keep reading until "Over" is input
            while (!message_server.equals("Over"))
            {
                try
                {
                    message_server=input.readUTF();
                    this.check_message_server(message_server);
                    System.out.println(message_server);
                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
        input.close();
        this.socket.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void check_message_server(String message_server)
    {
        if(message_server.split(" ")[0].equals("ball"))
        {
            this.mytable.getTabletennis().getBall().setX(Integer.parseInt(message_server.split(" ")[1]));
            this.mytable.getTabletennis().getBall().setY(Integer.parseInt(message_server.split(" ")[2]));
        }
        else if(message_server.split(" ")[0].equals("pl1"))
        {
            this.mytable.getTabletennis().getPl1().setX(Integer.parseInt(message_server.split(" ")[1]));
            this.mytable.getTabletennis().getPl1().setY(Integer.parseInt(message_server.split(" ")[2]));
        }
        else if(message_server.split(" ")[0].equals("pl2"))
        {
            this.mytable.getTabletennis().getPl2().setX(Integer.parseInt(message_server.split(" ")[1]));
            this.mytable.getTabletennis().getPl2().setY(Integer.parseInt(message_server.split(" ")[2]));
        }
        else if(message_server.split(" ")[0].equals("score"))
        {
            this.mytable.getTabletennis().getPoint1().setScore(Integer.parseInt(message_server.split(" ")[1]));
            this.mytable.getTabletennis().getPoint2().setScore(Integer.parseInt(message_server.split(" ")[2]));
        }
        else
        {

        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public DataOutputStream getOut() {
        return out;
    }

    public void setOut(DataOutputStream out) {
        this.out = out;
    }

    public String getMessage_client() {
        return message_client;
    }

    public void setMessage_client(String message_client) {
        this.message_client = message_client;
    }

    
}