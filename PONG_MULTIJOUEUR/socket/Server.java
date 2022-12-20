// A Java program for a Server
package socket;
import java.net.*;

import javax.lang.model.util.ElementScanner14;

import java.io.*;
import Graph.voidmain;
import Graph.Table;

public class Server extends Thread
{
    Socket socket=null;
    public DataOutputStream out=null;
    public String message_server = "";
    public voidmain mytable=null;
    
    // constructor with port
    public Server(int port)
    {
        // starts server and waits for a connection
        try
        {
           ServerSocket server = new ServerSocket(port);
            System.out.println("Server started");
 
            System.out.println("Waiting for a client ...");
 
            this.socket = server.accept();
            System.out.println("Client accepted");
            
            //interface graphique pong
            Table t=new Table(this);
            this.mytable=new voidmain(t,this);
            this.mytable.add(t);
            
           

            //create an outpout stream for your message
            this.out = new DataOutputStream(socket.getOutputStream());
                
            //take the message you wrote on the terminal
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 
            
            
 
            // reads message from client until "Over" is sent
            
            Thread thread=new Thread(this);
            thread.start();
            while (!message_server.equals("Over"))
            {
                try
                {
                    this.message_server=br.readLine();
                    this.out.writeUTF("Server:"+message_server);
                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");
 
            // close connection
            this.socket.close();
            this.out.close();
        }
        catch(IOException i)
        {
            i.printStackTrace();
        }
    }

    public void run()
    {
        System.out.println("Connected");
        try {
            // take server message
            DataInputStream input = new DataInputStream(this.socket.getInputStream());
            String message_client = "";
            // keep reading until "Over" is input
            while (!message_client.equals("Over"))
            {
                try
                {
                    message_client=input.readUTF();
                    this.check_message_client(message_client);
                    System.out.println(message_client);
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

    public void check_message_client(String message_client)
    {
        if(message_client.equals("client_left"))//misaka gauche ny pl2
        {
            this.mytable.getTabletennis().getPl2().setX(this.mytable.getTabletennis().getPl2().getX()-5);
        }
        else if(message_client.equals("client_right"))//misaka droite ny client
        {
            this.mytable.getTabletennis().getPl2().setX(this.mytable.getTabletennis().getPl2().getX()+5);
        }
        else if(message_client.equals("ball_left"))//frappe pl2
        {
            if(this.mytable.getTabletennis().getBall().getDirection()==-1)
                {
                    this.mytable.getTabletennis().getBall().setDirectionx(-1);
                }
        }
        else if(message_client.equals("ball_right"))//frappe pl2
        {
            if(this.mytable.getTabletennis().getBall().getDirection()==-1)
                {
                    this.mytable.getTabletennis().getBall().setDirectionx(1);
                }
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

    public String getMessage_server() {
        return message_server;
    }

    public void setMessage_server(String message_server) {
        this.message_server = message_server;
    }

    public voidmain getMytable() {
        return mytable;
    }

    public void setMytable(voidmain mytable) {
        this.mytable = mytable;
    }


    
    
}