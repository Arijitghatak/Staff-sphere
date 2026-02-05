package employe.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Random;


public class Addstaff extends JFrame implements ActionListener {

    JTextField tname,tfname,taddress,tphone,taadhar,temail,tsalary,tdesignation;
    JDateChooser tdob;
    JComboBox teducation;
    JLabel empid;
    Random ran = new Random();
    int num = ran.nextInt(99999999);

    JButton add,back;

    Addstaff(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/add page.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1120,650);
        add(image);

        JLabel heading = new JLabel("Add employee detail");
        heading.setForeground(Color.white);
        heading.setBounds(430,-80,500,400);
        heading.setFont(new Font("Roboto",Font.BOLD,25));
        image.add(heading);

        // name

        JLabel name = new JLabel("Name");
        name.setBounds(200,200,400,50);
        name.setForeground(Color.white);
        name.setFont(new Font("Roboto",Font.BOLD,15));
        image.add(name);

        tname = new JTextField();
        tname.setBounds(350,210,200,30);
        tname.setBackground(Color.white);
        image.add(tname);

        //father

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(200,250,400,50);
        fname.setForeground(Color.white);
        fname.setFont(new Font("Roboto",Font.BOLD,15));
        image.add(fname);

        tfname = new JTextField();
        tfname.setBounds(350,260,200,30);
        tfname.setBackground(Color.white);
        image.add(tfname);

        //date
        JLabel date = new JLabel("DOB");
        date.setBounds(700,195,400,50);
        date.setForeground(Color.white);
        date.setFont(new Font("Roboto",Font.BOLD,15));
        image.add(date);

        tdob = new JDateChooser();
        tdob.setBounds(810,205,150,30);
        image.add(tdob);

        //salary
        JLabel salary = new JLabel("Salary");
        salary.setBounds(700,250,400,50);
        salary.setForeground(Color.white);
        salary.setFont(new Font("Roboto",Font.BOLD,15));
        image.add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(810,260,200,30);
        tsalary.setBackground(Color.white);
        image.add(tsalary);



        // address

        JLabel adress = new JLabel("Address");
        adress.setBounds(200,300,400,50);
        adress.setForeground(Color.white);
        adress.setFont(new Font("Roboto",Font.BOLD,15));
        image.add(adress);

        taddress = new JTextField();
        taddress.setBounds(350,310,200,30);
        taddress.setBackground(Color.white);
        image.add(taddress);


        //addhaar

        JLabel adhar = new JLabel("Aadhaar Details");
        adhar.setBounds(200,350,400,50);
        adhar.setForeground(Color.white);
        adhar.setFont(new Font("Roboto",Font.BOLD,15));
        image.add(adhar);

        taadhar = new JTextField();
        taadhar.setBounds(350,350,200,30);
        taadhar.setBackground(Color.white);
        image.add(taadhar);

        //email

        JLabel email = new JLabel("Email address");
        email.setBounds(700,300,400,50);
        email.setForeground(Color.white);
        email.setFont(new Font("Roboto",Font.BOLD,15));
        image.add(email);

        temail = new JTextField();
        temail.setBounds(810,310,200,30);
        temail.setBackground(Color.white);
        image.add(temail);


        //phone

        JLabel phone = new JLabel("Phone no");
        phone.setBounds(700,350,400,50);
        phone.setForeground(Color.white);
        phone.setFont(new Font("Roboto",Font.BOLD,15));
        image.add(phone);

        tphone = new JTextField();
        tphone.setBounds(810,360,200,30);
        tphone.setBackground(Color.white);
        image.add(tphone);


        //designation
        JLabel deg = new JLabel("Designation");
        deg.setBounds(700,400,400,50);
        deg.setForeground(Color.white);
        deg.setFont(new Font("Roboto",Font.BOLD,15));
        image.add(deg);

        tdesignation = new JTextField();
        tdesignation.setBounds(810,410,200,30);
        tdesignation.setBackground(Color.white);
        image.add(tdesignation);


        //education

        JLabel edu = new JLabel("Education");
        edu.setBounds(200,400,400,50);
        edu.setForeground(Color.white);
        edu.setFont(new Font("Roboto",Font.BOLD,15));
        image.add(edu);

        String items [] = {"BBA","B TECH","M TECH","PHD","MA","MBA","BSC","BCOM","MCA"};

        teducation = new JComboBox(items);
        teducation.setBounds(350,410,200,30);
        image.add(teducation);


        // id

        JLabel id = new JLabel("Employee ID");
        id.setBounds(700,450,400,50);
        id.setForeground(Color.white);
        id.setFont(new Font("Roboto",Font.BOLD,15));
        image.add(id);

        empid = new JLabel(""+num);
        empid.setBounds(850,460,200,30);
        empid.setBackground(new Color(74,71,69));
        empid.setFont(new Font("Roboto",Font.BOLD,15));
        empid.setForeground(Color.red);
        image.add(empid);

//add

        add= new JButton("ADD");
        add.setBounds(300,510,100,50);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.setFont(new Font("Roboto",Font.BOLD,15));
        add.addActionListener(this);
        image.add(add);

        //back

        back= new JButton("Back");
        back.setBounds(410,510,100,50);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFont(new Font("Roboto",Font.BOLD,15));
        back.addActionListener(this);
        image.add(back);


        setLayout(null);
        setBounds(70,50,1120,650);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String name = tname.getText();
            String fname = tfname.getText();
            String date = ((JTextField)tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String adress = taddress.getText();
            String adhar = taadhar.getText();
            String phone = tphone.getText();
            String deg = tdesignation.getText();
            String edu = (String) teducation.getSelectedItem();
            String email = temail.getText();
            String id = empid.getText();


            try{
                Conn c = new Conn();
                String query = "insert into employee values('id','name','fname','dob',)"
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        }
    }

    public static void main(String[] args) {
        new Addstaff();
    }
}
