// A Java program for a Server
import java.net.*;
import java.io.*;
 
public class Server extends Thread
{
    Socket socket=null;
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
 
           
           

            //create an outpout stream for your message
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                
            //take the message you wrote on the terminal
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 
            //messages
            String message_server="";
 
            // reads message from client until "Over" is sent
            
            Thread thread=new Thread(this);
            thread.start();
            while (!message_server.equals("Over"))
            {
                try
                {
                    message_server=br.readLine();
                    out.writeUTF("Server:"+message_server);
                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");
 
            // close connection
            socket.close();
            out.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
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
 
}