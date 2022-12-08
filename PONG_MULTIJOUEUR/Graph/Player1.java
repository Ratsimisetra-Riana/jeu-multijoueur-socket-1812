package Graph;
import java.awt.*;
import javax.swing.*;
public class Player1 extends JPanel{
    
    int x;
    int y;
    int width;
    int height;
    int score;

    public Player1(int X,int Y, int w,int h){
        
        this.x=X;
        this.y=Y;
        this.width=w;
        this.height=h;
        this.setBounds(this.x,this.y,this.width,this.height);/* dimension this panel*/
        this.setBackground(Color.blue);
    }
    public void paint(Graphics g)
    {
        Graphics2D g2d=(Graphics2D) g;
        g2d.setColor(Color.blue);
        g2d.fillRect(this.x,this.y,this.width,this.height);/*dimension player1*/
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
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    
    
}
