package graph_menu;
import java.awt.Color;

import javax.swing.*;

import menu_listener.Adresse_ip_listener;

public class Adresse_ip extends JPanel {
    JTextField field=null;
    JTextField field2=null;
    JButton button=null;

    public Adresse_ip()
    {
        this.setBounds(0,0,500,500);
        SpringLayout layout=new SpringLayout();
        this.setLayout(layout);

        JLabel label=new JLabel();
        label.setText("Entrez l'adresse IP de l'hote puis le port");
        this.add(label);
        layout.putConstraint(SpringLayout.WEST,label,150,SpringLayout.WEST,this);
        layout.putConstraint(SpringLayout.NORTH,label,100,SpringLayout.NORTH,this);

        JLabel label1=new JLabel();
        label1.setText("adresse ip:");
        this.add(label1);
        layout.putConstraint(SpringLayout.WEST,label1,150,SpringLayout.WEST,this);
        layout.putConstraint(SpringLayout.NORTH,label1,50,SpringLayout.SOUTH,label);

        this.field=new JTextField(10);
        this.add(this.field);
        layout.putConstraint(SpringLayout.WEST,this.field,10,SpringLayout.EAST,label1);
        layout.putConstraint(SpringLayout.NORTH,this.field,50,SpringLayout.SOUTH,label);

        JLabel label2=new JLabel();
        label2.setText("port:");
        this.add(label2);
        layout.putConstraint(SpringLayout.WEST,label2,150,SpringLayout.WEST,this);
        layout.putConstraint(SpringLayout.NORTH,label2,50,SpringLayout.SOUTH,label1);

        this.field2=new JTextField(10);
        this.add(this.field2);
        layout.putConstraint(SpringLayout.WEST,this.field2,10,SpringLayout.EAST,label2);
        layout.putConstraint(SpringLayout.NORTH,this.field2,50,SpringLayout.SOUTH,this.field);


        this.button=new JButton("Entrer");
        this.button.setSize(50,50);// any amn choose_menu listener vo asina listener ty bouton ty amzay afaka alefa any amn le listener le jframe
        this.add(this.button);
        layout.putConstraint(SpringLayout.WEST,this.button,150,SpringLayout.WEST,this);
        layout.putConstraint(SpringLayout.NORTH,this.button,50,SpringLayout.SOUTH,label2);

        this.setVisible(true);
    }

    public JTextField getField() {
        return field;
    }

    public void setField(JTextField field) {
        this.field = field;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public JTextField getField2() {
        return field2;
    }

    public void setField2(JTextField field2) {
        this.field2 = field2;
    }

    
}
