// A Java program for a Server
package socket;
import java.net.*;
import java.io.*;
import Graph.voidmain;
import Graph.Table;

public class Server extends Thread
{
    Socket socket=null;
    public DataOutputStream out=null;
    public DataInputStream input=null;
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
            this.input = new DataInputStream(this.socket.getInputStream());
            String message_client = "";
            // keep reading until "Over" is input
            while (!message_client.equals("Over"))
            {
                try
                {
                    message_client=this.input.readUTF();
                    this.check_message_client(message_client);
                    System.out.println(message_client);
                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            this.input.close();
            this.socket.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void check_message_client(String message_client)
    {
        if(message_client.equals("client_left"))
        {
            this.mytable.getTabletennis().getPl2().setX(this.mytable.getTabletennis().getPl2().getX()-5);
        }
        else if(message_client.equals("client_ball_left"))
        {
            this.mytable.getTabletennis().getBall().setX(this.mytable.getTabletennis().getPl2().getX()+(this.mytable.getTabletennis().getPl2().getWidth()/2));
        }
        else if(message_client.equals("client_right"))
        {
            this.mytable.getTabletennis().getPl2().setX(this.mytable.getTabletennis().getPl2().getX()+5);
        }
        else if(message_client.equals("client_ball_right"))
        {
            this.mytable.getTabletennis().getBall().setX(this.mytable.getTabletennis().getPl2().getX()+(this.mytable.getTabletennis().getPl2().getWidth()/2));
        }
        else if(message_client.equals("frappe_client"))
        {
            this.mytable.getTabletennis().getBall().setY(this.mytable.getTabletennis().getBall().getY()-2);
            this.mytable.getTabletennis().getBall().setDirection(-1);
        }
        else if(message_client.split(" ")[0].equals("position"))
        {
            this.mytable.getTabletennis().getBall().setX(Integer.parseInt(message_client.split(" ")[1]));
            this.mytable.getTabletennis().getBall().setY(Integer.parseInt(message_client.split(" ")[2]));
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

    public DataInputStream getInput() {
        return input;
    }

    public void setInput(DataInputStream input) {
        this.input = input;
    }


    
    
}