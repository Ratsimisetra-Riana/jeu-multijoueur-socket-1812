package thread;

import socket_c.Client;
public class Thread_client extends Thread{

    String a_ip=null;
    
    public Thread_client(String a)
    {
        this.a_ip=a;
    }
    public void run()
    {
        Client client=new Client(this.a_ip,5000);
    } 
}
