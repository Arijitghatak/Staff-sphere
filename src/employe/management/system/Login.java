package employe.management.system;

import javax.swing.*;

public class Login extends JFrame {

    JTextField tusername;
    JPasswordField tpassword;

    Login(){

        JLabel Username = new JLabel("Username");
        Username.setBounds(40,20,100,30);
        add(Username);

        tusername = new JTextField();
        tusername.setBounds(150,20,150,30);
        add(tusername);

        JLabel Password = new JLabel("Password");
        Password.setBounds(40,70,100,30);
        add(Password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150,70,150,30);
        add(tpassword);


        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
        setLayout(null);

    }

    public static void main(String[] args) {
        new Login();
    }
}
