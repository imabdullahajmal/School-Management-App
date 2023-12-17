import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Studentupdate extends JFrame implements ActionListener {

    JTextField tfcourse, tfaddress, tfphone, tfemail, tfbranch;
    JLabel labelrollno;
    Validation check = new Validation();
    JButton submit, cancel;
    Choice crollno;

    Studentupdate() {

        setSize(900, 650);
        setLocation(350, 50);

        setLayout(null);

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 35));
        add(heading);

        JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(50, 100, 200, 20);
        lblrollnumber.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblrollnumber);

        crollno = new Choice();
        crollno.setBounds(250, 100, 200, 20);
        add(crollno);

        try {
            ConnectToMySql c = new ConnectToMySql();
            ResultSet rs = c.s.executeQuery("select * from student_inf");
            while (rs.next()) {
                crollno.add(rs.getString("roll_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(200, 150, 150, 30);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);

        JLabel labelfname = new JLabel();
        labelfname.setBounds(600, 150, 150, 30);
        labelfname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelfname);

        JLabel lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(50, 200, 200, 30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollno);

        labelrollno = new JLabel();
        labelrollno.setBounds(200, 200, 200, 30);
        labelrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelrollno);


        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 260, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 260, 150, 30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 200, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 200, 150, 30);
        add(tfphone);

        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 320, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 320, 150, 30);
        add(tfemail);

        JLabel cnic = new JLabel("CNIC Number");
        cnic.setBounds(400, 260, 200, 30);
        cnic.setFont(new Font("serif", Font.BOLD, 20));
        add(cnic);

        JLabel labelcnic = new JLabel();
        labelcnic.setBounds(600, 260, 150, 30);
        labelcnic.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelcnic);

        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(400, 320, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);

        tfcourse = new JTextField();
        tfcourse.setBounds(600, 320, 150, 30);
        add(tfcourse);

        try {
            ConnectToMySql c = new ConnectToMySql();
            String query = "select * from student_inf where roll_no='" + crollno.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("father_name"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                cnic.setText(rs.getString("cnic"));
                labelrollno.setText(rs.getString("roll_no"));
                tfcourse.setText(rs.getString("course"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        crollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    ConnectToMySql c = new ConnectToMySql();
                    String query = "select * from student_inf where roll_no='" + crollno.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("father_name"));
                        labelrollno.setText(rs.getString("roll_no"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        cnic.setText(rs.getString("cnic"));
                        tfcourse.setText(rs.getString("course"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        submit = new JButton("Update");
        submit.setBounds(230, 480, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(420, 480, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }



    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {

            String rollno = labelrollno.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String course = tfcourse.getText();


            if(!check.validated(email, phone, address)){
                return;
            }
            else{
                try {
                    String query = "update student_inf set address='" + address + "', phone='" + phone + "', email='" + email + "', course='" + course + "' where roll_no='" + rollno + "'";
                    ConnectToMySql con = new ConnectToMySql();
                    con.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Student Details Updated Successfully");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            setVisible(false);
        }
    }
}