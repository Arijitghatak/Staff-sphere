package employe.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class Addstaff extends JFrame {


    Addstaff(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/add page.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1120,650);
        add(image);

        JLabel heading = new JLabel("Add employee detail");
        heading.setForeground(Color.white);
        heading.setBounds(450,-50,500,400);
        heading.setFont(new Font("Roboto",Font.BOLD,25));

        image.add(heading);


        setLayout(null);
        setBounds(70,50,1120,650);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Addstaff();
    }
}
