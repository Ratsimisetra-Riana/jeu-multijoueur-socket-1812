package thread;
import socket.Server;
public class Thread_server extends Thread {

    int port=0;

    public Thread_server(String p)
    {
        this.port=Integer.parseInt(p);
    }

    public void run()
    {
        Server server=new Server(this.port);
    } 
    
}
