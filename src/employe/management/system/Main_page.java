package employe.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_page extends JFrame {


    Main_page(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);


        JLabel heading = new JLabel("StaffSphere");
        heading.setBounds(480,155,400,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Roboto",Font.BOLD,30));
        image.add(heading);

        JButton add = new JButton("Add staff");
        add.setBounds(480,270,150,40);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Addstaff();
                setVisible(false);

            }
        });
        image.add(add);

        JButton remove = new JButton("Remove staff");
        remove.setBounds(480,320,150,40);
        remove.setBackground(Color.black);
        remove.setForeground(Color.WHITE);
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        image.add(remove);


        JButton view = new JButton("View staff");
        view.setBounds(480,370,150,40);
        view.setBackground(Color.black);
        view.setForeground(Color.WHITE);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new View();
                setVisible(false);
            }
        });
        image.add(view);



        setLayout(null);
        setSize(1120,630);
        setLocation(70,40);
        setVisible(true);
    }
    public static void main(String[] args) {

        new Main_page();
    }
}
