package employe.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class View extends JFrame {

    Choice choiceemp;

    View(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1120,650);
        add(image);

        JLabel heading = new JLabel("View employee detail");
        heading.setForeground(Color.white);
        heading.setBounds(430,-100,500,400);
        heading.setFont(new Font("Roboto",Font.BOLD,25));
        image.add(heading);

        JLabel search = new JLabel("Search by ID");
        search.setForeground(Color.white);
        search.setBounds(200,-28,100,400);
        search.setFont(new Font("Roboto",Font.BOLD,15));
        image.add(search);

        choiceemp= new Choice();
        choiceemp.setBounds(320,160,200,20);
        image.add(choiceemp);

        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()){
                choiceemp.add(resultSet.getString("id"));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        setLayout(null);
        setBounds(70,50,1120,650);
        setVisible(true);
    }
    public static void main(String[] args) {
        new View();

    }
}
