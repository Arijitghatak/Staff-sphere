package employe.management.system;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View extends JFrame implements ActionListener {

    JTable table;
    Choice choiceemp;
    JButton Search,Print,Back,update;

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

        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
            table.setBackground(new Color(30, 30, 30));      // table body
            table.setForeground(Color.WHITE);               // text
            table.setGridColor(new Color(70, 70, 70));       // grid lines
            table.setRowHeight(28);

        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(100, 200, 900, 350);
        image.add(jp);


        Search =new JButton("Search");
        Search.setBounds(300,570,80,30);
        Search.setBackground(Color.black);
        Search.setForeground(Color.white);
        Search.addActionListener(this);
        image.add(Search);


        update =new JButton("Update");
        update.setBounds(400,570,80,30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        image.add(update);

        Print =new JButton("Print");
        Print.setBounds(500,570,80,30);
        Print.setBackground(Color.black);
        Print.setForeground(Color.white);
        Print.addActionListener(this);
        image.add(Print);

        Back =new JButton("Back");
        Back.setBounds(600,570,80,30);
        Back.setBackground(Color.black);
        Back.setForeground(Color.white);
        Back.addActionListener(this);
        image.add(Back);

        setLayout(null);
        setBounds(70,50,1120,650);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Search){
            String query = "select * from employee where id = '"+choiceemp.getSelectedItem()+"'";
            try{
                Conn c = new Conn();
                ResultSet resultSet=c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        else if (e.getSource()==Print) {
            try {
                table.print();

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        } else if (e.getSource()==update) {
            setVisible(false);
            new Updateemp(choiceemp.getSelectedItem());


        }else {
            setVisible(false);
            new Main_page();
        }

    }

    public static void main(String[] args) {
        new View();

    }
}
