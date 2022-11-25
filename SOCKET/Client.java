// A Java program for a Client
import java.net.*;
import java.io.*;
 
public class Client extends Thread
{
    Socket socket=null;
 
    // constructor to put ip address and port
    public Client(String address, int port)
    {
        // establish a connection
        try
        {
            this.socket = new Socket(address, port);
            System.out.println("Connected");
 
            // create an outpout stream for this socket
            DataOutputStream out = new DataOutputStream(this.socket.getOutputStream());

            //take the message you wrote on terminal
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
            String message_client = "";
            
            //877keep reading until "Over" is input
           
            Thread thread=new Thread(this);
            thread.start();
            while (!message_client.equals("Over"))
            {
                try
                {
                    message_client = br.readLine();//mila mtaper entrer de raha tsy te hitaper entrer de tokony tonga de out.write no atsoina fa tsy manao readline() tsony
                    out.writeUTF("Client:"+message_client);
                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            // close the connection
                out.close();
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
      
     
    
  
    
 }