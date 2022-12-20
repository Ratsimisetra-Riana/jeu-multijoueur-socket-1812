package Graph_c;
import java.awt.*;
import javax.swing.*;

import socket_c.Client;
public class Table extends JPanel {
    int x=10;
    int y=10;
    int width=400;
    int height=700;
    Player1 pl1;
    Player2 pl2;
    Ball ball;
    Score1 point1;
    Score2 point2;
    Client c=null;

    public Table(Client client){
        this.pl1=new Player1((this.width)/2,0,50,20);
        this.pl2=new Player2((this.width)/2,680,50,20);
        this.ball=new Ball((((this.width)/2)+(this.pl1.width/2)),(this.pl1.height),10,10);
        this.setBounds(10,10,700,800);
        this.setBackground(Color.darkGray);
        this.setFocusable(true);
        this.point1=new Score1();
        this.point2=new Score2();
    }

    public void paint(Graphics g)
    {   
        super.paint(g);
        Graphics2D g2d=(Graphics2D) g;
        g2d.setColor(Color.red);
        g2d.fillRect(0,0,this.width,this.height);
        g2d.setColor(Color.white);
        g2d.drawLine(0,(this.height)/2,this.width,(this.height)/2);
        
        this.pl1.paint(g);
        this.pl2.paint(g);
        this.ball.paint(g);
        this.point1.paint(g);
        this.point2.paint(g);
        repaint();
    }

    public Player1 getPl1() {
        return pl1;
    }

    public void setPl1(Player1 pl1) {
        this.pl1 = pl1;
    }

    public Player2 getPl2() {
        return pl2;
    }

    public void setPl2(Player2 pl2) {
        this.pl2 = pl2;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Score1 getPoint1() {
        return point1;
    }

    public void setPoint1(Score1 point1) {
        this.point1 = point1;
    }

    public Score2 getPoint2() {
        return point2;
    }

    public void setPoint2(Score2 point2) {
        this.point2 = point2;
    }
}
