package employe.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class Remove extends JFrame implements ActionListener {

    Choice choiceemp;
    JButton remove , Back;
    Remove(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1120,650);
        add(image);

        JLabel search = new JLabel("Employee ID");
        search.setForeground(Color.white);
        search.setBounds(200,-28,100,400);
        search.setFont(new Font("Roboto",Font.BOLD,15));
        image.add(search);

        JLabel heading = new JLabel("Remove employee detail");
        heading.setForeground(Color.white);
        heading.setBounds(430,-100,500,400);
        heading.setFont(new Font("Roboto",Font.BOLD,25));
        image.add(heading);

        remove =new JButton("Remove");
        remove.setBounds(500,500,110,30);
        remove.setBackground(Color.black);
        remove.setForeground(Color.white);
        remove.addActionListener(this);
        image.add(remove);

        Back =new JButton("Back");
        Back.setBounds(650,500,110,30);
        Back.setBackground(Color.black);
        Back.setForeground(Color.white);
        Back.addActionListener(this);
        image.add(Back);

        choiceemp= new Choice();
        choiceemp.setBounds(320,160,200,20);
        image.add(choiceemp);

        try{
            Conn c = new Conn();
            ResultSet resultSet=c.statement.executeQuery("select * from employee");

                    while(resultSet.next()){
                        choiceemp.add(resultSet.getString("id"));
                    }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //name

        JLabel name = new JLabel("Nmae");
        name.setForeground(Color.white);
        name.setBounds(200,70,100,400);
        name.setFont(new Font("Roboto",Font.BOLD,15));
        image.add(name);

        JLabel textname = new JLabel();
        textname.setForeground(Color.white);
        textname.setBounds(300,70,100,400);
        textname.setFont(new Font("Roboto",Font.BOLD,15));
        image.add(textname);

        //phone
        JLabel phone = new JLabel("Phone");
        phone.setForeground(Color.white);
        phone.setBounds(200,120,100,400);
        phone.setFont(new Font("Roboto",Font.BOLD,15));
        image.add(phone);

        JLabel textphone = new JLabel();
        textphone.setForeground(Color.white);
        textphone.setBounds(300,120,100,400);
        textphone.setFont(new Font("Roboto",Font.BOLD,15));
        image.add(textphone);

        //email

        JLabel email = new JLabel("Email");
        email.setForeground(Color.white);
        email.setBounds(200,170,100,400);
        email.setFont(new Font("Roboto",Font.BOLD,15));
        image.add(email);

        JLabel textemail = new JLabel();
        textemail.setForeground(Color.white);
        textemail.setBounds(300,170,100,400);
        textemail.setFont(new Font("Roboto",Font.BOLD,15));
        image.add(textemail);


        try{
            Conn c = new Conn();
            String query = "select * from employee where id = '"+choiceemp.getSelectedItem()+"'";
            ResultSet resultSet=c.statement.executeQuery(query);
            while (resultSet.next()){
                textname.setText(resultSet.getString("name"));
                textemail.setText(resultSet.getString("email"));
                textphone.setText(resultSet.getString("phone"));

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        choiceemp.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Conn c = new Conn();
                    String query = "select * from employee where id = '"+choiceemp.getSelectedItem()+"'";
                    ResultSet resultSet=c.statement.executeQuery(query);
                    while (resultSet.next()) {
                        textname.setText(resultSet.getString("name"));
                        textemail.setText(resultSet.getString("email"));
                        textphone.setText(resultSet.getString("phone"));

                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        setLayout(null);
        setBounds(70,50,1120,650);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == remove) {

            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to delete this employee?",
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    Conn c = new Conn();
                    String query =
                            "DELETE FROM employee WHERE id = '"
                                    + choiceemp.getSelectedItem() + "'";

                    int rows = c.statement.executeUpdate(query);

                    if (rows > 0) {
                        JOptionPane.showMessageDialog(this, "Employee deleted successfully");
                        setVisible(false);
                        new Main_page();
                    } else {
                        JOptionPane.showMessageDialog(this, "No employee found");
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        } else if (e.getSource() == Back) {
            setVisible(false);
            new Main_page();

        }
    }


    public static void main(String[] args) {
        new Remove();
    }
}
