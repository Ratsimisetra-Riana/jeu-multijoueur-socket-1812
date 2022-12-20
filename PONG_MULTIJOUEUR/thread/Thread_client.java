package thread;

import socket_c.Client;
public class Thread_client extends Thread{

    String a_ip=null;
    int port=0;
    
    public Thread_client(String a,String b)
    {
        this.a_ip=a;
        this.port=Integer.parseInt(b); 
    }
    public void run()
    {
        Client client=new Client(this.a_ip,this.port);
    } 
}
