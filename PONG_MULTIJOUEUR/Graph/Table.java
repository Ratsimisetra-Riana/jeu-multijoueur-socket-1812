package Graph;
import java.awt.*;
import java.io.IOException;

import javax.swing.*;
import socket.Server;
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
    Server server=null;
    int player_actuel=0;


    public Table(Server ser){
        this.pl1=new Player1((this.width)/2,0,50,20);
        this.pl2=new Player2((this.width)/2,680,50,20);
        this.ball=new Ball((((this.width)/2)+(this.pl1.width/2)),(this.pl1.height),10,10);
        this.setBounds(10,10,700,800);
        this.setBackground(Color.darkGray);
        this.setFocusable(true);
        this.point1=new Score1();
        this.point2=new Score2();
        this.server=ser;
    }

    public void paint(Graphics g)
    {   
        super.paint(g);
        Graphics2D g2d=(Graphics2D) g;
        g2d.setColor(Color.red);
        g2d.fillRect(0,0,this.width,this.height);
        g2d.setColor(Color.white);
        g2d.drawLine(0,(this.height)/2,this.width,(this.height)/2);
        taperlaballe();
        pl1.paint(g);
        pl2.paint(g);
        ball.paint(g);
        point1.paint(g);
        point2.paint(g);
        //condition an'ny mandefa ny position an'ny ball
        if(this.player_actuel==1)//mandefa ny position an'ny ball
        {
            try {//mandefa ny position anle ball
                this.server.getOut().writeUTF("position"+" "+Integer.toString(this.ball.getX())+" "+Integer.toString(this.ball.getY()));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        
        //taperlaballe();
        repaint();
    }

    public void taperlaballe()
    {
        if((this.ball.y==this.pl1.y+this.pl1.height)&&(this.ball.x+this.ball.width>=this.pl1.x)&&(this.ball.x<=this.pl1.x+this.pl1.width))/*intercepter ball pl1*/
        {
            this.ball.direction=0;
            this.ball.directionx=0;
            this.player_actuel=1;
        }
        if((this.ball.y+this.ball.height==this.pl2.y)&&(this.ball.x+this.ball.width>=this.pl2.x)&&(this.ball.x<=this.pl2.x+this.pl2.width))/*intercepter ball pl2*/
        {
            System.out.println("nidona server");
            this.ball.direction=0;
            this.ball.directionx=0;
            this.player_actuel=2;
        }
        if(this.ball.y<this.pl1.y+this.pl1.height)/*replacer ball */
        {
            this.ball.direction=0;
            this.ball.directionx=0;
            this.ball.y=this.pl2.y-this.ball.height;
            this.ball.x=this.pl2.x+(this.pl2.width)/2;
            this.point2.score++;
        }
        if(this.ball.y+this.ball.height>this.pl2.y)/*replacer ball */
        {
            this.ball.direction=0;
            this.ball.directionx=0;
            this.ball.y=this.pl1.y+this.pl1.height;
            this.ball.x=this.pl1.x+(this.pl1.width/2);
            this.point1.score++;
        }
        if (this.ball.x==0)/*collision mur gauche */
        {
            this.ball.directionx=1;
            System.out.println("gauche");
        }
        if(this.ball.x+this.ball.width==this.width)/*collision mur droit */
        {
            System.out.println("droite");
            this.ball.directionx=-1;
        }
        if(this.pl1.x<=0)/*collision player1 mur gauche */
        {
            this.pl1.x=0;
        }
        if(this.pl1.x+this.pl1.width>=this.width)/*collision player1 mur droit */
        {
            this.pl1.x=this.width-this.pl1.width;
        }
        if(this.pl2.x<=0)/*collision player2 mur gauche */
        {
            this.pl2.x=0;
        }
        if(this.pl2.x+this.pl2.width>=this.width)/*collision player2 mur droit */
        {
            this.pl2.x=this.width-this.pl2.width;
        }
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
