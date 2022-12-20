package Graph;
import java.awt.*;
import javax.swing.*;
public class Score2 extends JPanel{
    
    int score=0;

    public Score2()
    {
        this.setBounds(420,0,200,80);
        this.setBackground(Color.blue);
    }

    public void paint(Graphics g)
    {
        Graphics2D g2d=(Graphics2D) g;
        g2d.setColor(Color.white);
        g2d.fillRect(410,620,200,80);
        g2d.setColor(Color.gray);
        g2d.drawString("PLAYER2 :"+Integer.toString(this.score),430,650);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    
}
