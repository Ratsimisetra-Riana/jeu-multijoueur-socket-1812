package Graph;
import java.awt.*;
import javax.swing.*;
public class Ball extends JPanel {
    
    int x;
    int y;
    int width;
    int height;
    int direction=1;
    int directionx=0;

    public Ball(int X,int Y, int w,int h){
        
        this.x=X;
        this.y=Y;
        this.width=w;
        this.height=h;
        this.setBounds(10,10,1000,800);
        this.setBackground(Color.blue);
    }
    
    public void paint(Graphics g)
    {
        Graphics2D g2d=(Graphics2D) g;
        g2d.setColor(Color.white);
        g2d.fillRect(this.x,this.y,this.width,this.height);
        
        try{
            Thread.sleep(2);
        }catch (Exception e){
            e.printStackTrace();
        }

        this.y=this.y+this.direction;
        this.x=this.x+this.directionx;
        repaint();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDirectionx() {
        return directionx;
    }

    public void setDirectionx(int directionx) {
        this.directionx = directionx;
    }
    
}

