package employe.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Updateemp extends JFrame implements ActionListener {

    JTextField tname,tfname,taddress,tphone,taadhar,temail,tsalary,tdesignation;
    JLabel empid;
    JButton add,back;
    JDateChooser tdob;
    JComboBox teducation;

    String employeeid;

    Updateemp(String employeeid){
        this.employeeid=employeeid;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Update.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1120,650);
        add(image);

        JLabel heading = new JLabel("Update employee detail");
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

        JLabel tname = new JLabel();
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

       JLabel tdob = new JLabel();
        tdob.setBounds(810,205,150,30);
        date.setForeground(Color.white);
        date.setFont(new Font("Roboto",Font.BOLD,15));
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

       JLabel taadhar = new JLabel();
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

        JLabel teducation = new JLabel();
        teducation.setBounds(350,400,200,30);
        teducation.setBackground(Color.white);
        image.add(teducation);


        // id

        JLabel id = new JLabel("Employee ID");
        id.setBounds(700,450,400,50);
        id.setForeground(Color.white);
        id.setFont(new Font("Roboto",Font.BOLD,15));
        image.add(id);

        empid = new JLabel();
        empid.setBounds(850,460,200,30);
        empid.setBackground(new Color(74,71,69));
        empid.setFont(new Font("Roboto",Font.BOLD,15));
        empid.setForeground(Color.red);
        image.add(empid);



        try{
            Conn c = new Conn();
            String query = "select * from employee where id ='"+employeeid+"'";
            ResultSet resultSet= c.statement.executeQuery(query);
            while (resultSet.next()){
                tname.setText(resultSet.getString("name"));
                tfname.setText(resultSet.getString("fname"));
                tdob.setText(resultSet.getString("dob"));
                taddress.setText(resultSet.getString("address"));
                tsalary.setText(resultSet.getString("salary"));
                tphone.setText(resultSet.getString("phone"));
                temail.setText(resultSet.getString("email"));
                teducation.setText(resultSet.getString("edu"));
                taadhar.setText(resultSet.getString("aadhaar"));
                empid.setText(resultSet.getString("id"));
                tdesignation.setText(resultSet.getString("deg"));




            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }



//add

        add= new JButton("Update");
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

            String fname = tfname.getText();
            String address = taddress.getText();
            String email = temail.getText();
            String phone = tphone.getText();
            String deg = tdesignation.getText();
            String salary = tsalary.getText();


            try {
                Conn c = new Conn();
                String query =
                        "UPDATE employee SET " +
                                "fname = '" + fname + "', " +
                                "address = '" + address + "', " +
                                "email = '" + email + "', " +
                                "phone = '" + phone + "', " +
                                "deg = '" + deg + "', " +
                                "salary = '" + salary + "' " +
                                "WHERE id = '" + employeeid + "'";

                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(this, "Employee updated successfully");
                setVisible(false);
                new Main_page();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }else {
            setVisible(false);
            new View();
        }

    }

    public static void main(String[] args) {
        new Updateemp("");
    }
}
