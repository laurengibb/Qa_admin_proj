import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class searchStaff {
    JPanel searchStaff=new JPanel();

    JButton b1=new JButton("<- Back");
    JButton b2=new JButton("Search");
    JButton b3=new JButton("Clear");

    JLabel l1 =new JLabel("First Name");
    JLabel l2 =new JLabel("Last Name");
    JLabel l3 =new JLabel("Employee ID");
    JLabel l4 =new JLabel("Contact No");
    JLabel l5 =new JLabel("Address");
    JLabel l6 =new JLabel("Postcode");
    JLabel l7 =new JLabel("Date of Birth");
    JLabel l8 =new JLabel("Admin");


    JTextField t1 = new JTextField("");
    JTextField t2 = new JTextField("");
    JTextField t3 = new JTextField("");
    JTextField t4 = new JTextField("");
    JTextField t5 = new JTextField("");
    JTextField t6 = new JTextField("");
    JTextField t7 = new JTextField("");
    JTextField t8 = new JTextField("");

    public searchStaff(JFrame F3) {
        F3.setTitle("Search for Staff");

        searchStaff.setBounds(0,0,600,800);
        searchStaff.setBackground(Color.white);
        searchStaff.setLayout(null);
        searchStaff.setVisible(true);

        b1.setBounds(10, 10, 100, 30);
        b2.setBounds(375, 200, 100, 30);
        b3.setBounds(125, 550, 100, 30);

        searchStaff.add(b1);
        searchStaff.add(b2);
        searchStaff.add(b3);

        l1.setBounds(125,100,100,30);
        l2.setBounds(125,150,100,30);
        l3.setBounds(125,250,100,30);
        l4.setBounds(125,300,100,30);
        l5.setBounds(125,350,100,30);
        l6.setBounds(125,400,100,30);
        l7.setBounds(125,450,100,30);
        l8.setBounds(125,500,100,30);

        searchStaff.add(l1);
        searchStaff.add(l2);
        searchStaff.add(l3);
        searchStaff.add(l4);
        searchStaff.add(l5);
        searchStaff.add(l6);
        searchStaff.add(l7);
        searchStaff.add(l8);

        t1.setBounds(275,100,200,30);
        t2.setBounds(275,150,200,30);
        t3.setBounds(275,250,200,30);
        t4.setBounds(275,300,200,30);
        t5.setBounds(275,350,200,30);
        t6.setBounds(275,400,200,30);
        t7.setBounds(275,450,200,30);
        t8.setBounds(275,500,200,30);

        searchStaff.add(t1);
        searchStaff.add(t2);
        searchStaff.add(t3);
        searchStaff.add(t4);
        searchStaff.add(t5);
        searchStaff.add(t6);
        searchStaff.add(t7);
        searchStaff.add(t8);

        F3.add(searchStaff);

        b1.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {
                        searchStaff.setVisible(false);
                        new reports(F3);
                    }
                });

        b2.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {

                        String first= "", last="";

                        first= t1.getText();
                        last= t2.getText();

                        String query = "select * from staff WHERE fName = '" + first + "' AND lName = '" + last + "'";
                        try {
                            ResultSet result = databaseConnect.St.executeQuery(query);

                            if (result.next()) {
                                String staffId = result.getString("staffId");
                                t3.setText(staffId);

                                String contactNo = result.getString("contactNo");
                                t4.setText(contactNo);

                                String address = result.getString("address");
                                t5.setText(address);

                                String postcode = result.getString("postcode");
                                t6.setText(postcode);

                                String dob = result.getString("dob");
                                t7.setText(dob);

                                String admin = result.getString("admin");
                                if (admin.equals("1")){
                                    t8.setText("Yes");
                                }
                                else {
                                    t8.setText("No");
                                }
                            }
                        } catch (Exception T) {
                            System.out.println(T.toString());
                        }
                    }
                });

        b3.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {
                        t1.setText("");
                        t2.setText("");
                        t3.setText("");
                        t4.setText("");
                        t5.setText("");
                        t6.setText("");
                        t7.setText("");
                        t8.setText("");
                    }
                });
    }
}
