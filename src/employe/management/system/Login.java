package employe.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {

    JTextField tusername;
    JPasswordField tpassword;
    JButton login,back;

    Login(){

        setLayout(null);

        JLabel Username = new JLabel("Username");
        Username.setBounds(40,20,100,30);
        Username.setForeground(Color.WHITE);
        add(Username);

        tusername = new JTextField();
        tusername.setBounds(150,20,150,30);
        add(tusername);

        JLabel Password = new JLabel("Password");
        Password.setBounds(40,70,100,30);
        Password.setForeground(Color.WHITE);
        add(Password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150,70,150,30);
        add(tpassword);


        login  = new JButton("Login");
        login.setBounds(150,140,150,30);
        login.addActionListener(this);
        add(login);

        back  = new JButton("Back");
        back.setBounds(150,180,150,30);
        back.addActionListener(this);
        add(back);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image i22 = i11.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image1 = new JLabel(i33);
        image1.setBounds(0,0,730,230);
        add(image1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,600,300);
        add(image);

        setSize(600,300);
        setLocation(380,200);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==login){

            try {
                String Username = tusername.getText();
                String Password = tpassword.getText();

                Conn Connection = new Conn();
                String query = "Select * from login where Username ='"+Username+"' and Password = '"+Password+"'";
                ResultSet resultSet=Connection.statement.executeQuery(query);

                if(resultSet.next()){
                    setVisible(false);
                    new Main_page();
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Username and Password");
                }

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        } else if (e.getSource()==back) {
            System.exit(90);

        }

    }

    public static void main(String[] args) {
        new Login();
    }
}
