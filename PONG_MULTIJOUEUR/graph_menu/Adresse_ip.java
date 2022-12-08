package graph_menu;
import java.awt.Color;

import javax.swing.*;

import menu_listener.Adresse_ip_listener;

public class Adresse_ip extends JPanel {
    JTextField field=null;
    JButton button=null;

    public Adresse_ip()
    {
        this.setBounds(0,0,500,500);
        SpringLayout layout=new SpringLayout();
        this.setLayout(layout);

        JLabel label=new JLabel();
        label.setText("Entrez l'adresse IP de l'hote");
        this.add(label);
        layout.putConstraint(SpringLayout.WEST,label,150,SpringLayout.WEST,this);
        layout.putConstraint(SpringLayout.NORTH,label,100,SpringLayout.NORTH,this);

        this.field=new JTextField(10);
        this.add(this.field);
        layout.putConstraint(SpringLayout.WEST,this.field,150,SpringLayout.WEST,this);
        layout.putConstraint(SpringLayout.NORTH,this.field,150,SpringLayout.NORTH,this);

        this.button=new JButton("Entrer");
        this.button.setSize(50,50);// any amn choose_menu listener vo asina listener ty bouton ty amzay afaka alefa any amn le listener le jframe
        this.add(this.button);
        layout.putConstraint(SpringLayout.WEST,this.button,50,SpringLayout.EAST,this.field);
        layout.putConstraint(SpringLayout.NORTH,this.button,150,SpringLayout.NORTH,this);

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

    
}
