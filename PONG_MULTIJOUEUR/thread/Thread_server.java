package thread;
import socket.Server;
public class Thread_server extends Thread {

    public Thread_server()
    {
        
    }

    public void run()
    {
        Server server=new Server(5000);
    } 
    
}
