import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class editStaff {
    JPanel editStaff=new JPanel();

    JButton b1=new JButton("<- Back");
    JButton b2=new JButton("Search");
    JButton b3=new JButton("Clear");
    JButton b4=new JButton("Create");
    JButton b5=new JButton("Save");
    JButton b6=new JButton("Delete");

    JLabel l1 =new JLabel("First Name");
    JLabel l2 =new JLabel("Last Name");
    JLabel l3 =new JLabel("Contact No");
    JLabel l4 =new JLabel("Address");
    JLabel l5 =new JLabel("Postcode");
    JLabel l6 =new JLabel("Date of Birth");
    JLabel l7 =new JLabel("Admin");

    JTextField t1 = new JTextField("");
    JTextField t2 = new JTextField("");
    JTextField t3 = new JTextField("");
    JTextField t4 = new JTextField("");
    JTextField t5 = new JTextField("");
    JTextField t6 = new JTextField("");
    JTextField t7 = new JTextField("");

    public editStaff(JFrame F3) {
        F3.setTitle("Search for Clients");

        editStaff.setBounds(0,0,600,800);
        editStaff.setBackground(Color.white);
        editStaff.setLayout(null);
        editStaff.setVisible(true);

        b1.setBounds(10, 10, 100, 30);
        b2.setBounds(375, 150, 100, 30);
        b3.setBounds(485, 10, 100, 30);
        b4.setBounds(125, 500, 100, 30);
        b5.setBounds(250, 500, 100, 30);
        b6.setBounds(375, 500, 100, 30);

        editStaff.add(b1);
        editStaff.add(b2);
        editStaff.add(b3);
        editStaff.add(b4);
        editStaff.add(b5);
        editStaff.add(b6);

        l1.setBounds(125,100,100,30);
        l2.setBounds(125,200,100,30);
        l3.setBounds(125,250,100,30);
        l4.setBounds(125,300,100,30);
        l5.setBounds(125,350,100,30);
        l6.setBounds(125,400,100,30);
        l7.setBounds(125,450,100,30);

        editStaff.add(l1);
        editStaff.add(l2);
        editStaff.add(l3);
        editStaff.add(l4);
        editStaff.add(l5);
        editStaff.add(l6);
        editStaff.add(l7);

        t1.setBounds(275,100,200,30);
        t2.setBounds(275,200,200,30);
        t3.setBounds(275,250,200,30);
        t4.setBounds(275,300,200,30);
        t5.setBounds(275,350,200,30);
        t6.setBounds(275,400,200,30);
        t7.setBounds(275,450,200,30);

        editStaff.add(t1);
        editStaff.add(t2);
        editStaff.add(t3);
        editStaff.add(t4);
        editStaff.add(t5);
        editStaff.add(t6);
        editStaff.add(t7);

        F3.add(editStaff);

        //Back Button//
        b1.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {
                        editStaff.setVisible(false);
                        new adminMenu(F3);
                    }
                });

        //Search Button//
        b2.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {

                        String firstname= "", lastname= "";

                        firstname= t1.getText();
                        lastname= t2.getText();

                        String query = "select * from clients WHERE fName = '" + firstname + "', AND  lName = '" + lastname + "'";
                        try {
                            ResultSet result = databaseConnect.St.executeQuery(query);

                            if (result.next()) {
                                String contactNo = result.getString("contactNo");
                                t3.setText(contactNo);

                                String address = result.getString("address");
                                t4.setText(address);

                                String postcode = result.getString("postcode");
                                t5.setText(postcode);

                                String dob = result.getString("dob");
                                t6.setText(dob);

                                String admin = result.getString("admin");
                                t7.setText(admin);
                            }
                        } catch (Exception T) {
                            System.out.println(T.toString());
                        }
                    }
                });

        //Clear Button//
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
                    }
                });

        //Create Button//
        b4.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {
                        String fname = "", faddress="", fpostcode="", fcontactNo="";

                        fname= t1.getText();
                        faddress= t3.getText();
                        fpostcode= t4.getText();
                        fcontactNo= t5.getText();

                        String query="insert into clients (name, address, postcode, contactNo) values('"+fname+"','"+faddress+"','"+fpostcode+"','"+fcontactNo+"')";
                        try{
                            databaseConnect.St.executeUpdate(query);
                            l6.setText("'" + fname + "'" + " added successfully!");
                            l6.setBounds(125,450,400,30);
                            l6.setForeground(Color.green);
                            l6.setVisible(true);
                            t1.setText("");
                            t3.setText("");
                            t4.setText("");
                            t5.setText("");
                        }
                        catch(Exception T){
                            System.out.println(T.toString());
                            l7.setBounds(125,450,400,30);
                            l7.setForeground(Color.red);
                            l7.setVisible(true);
                        }
                    }
                });

        //Save Button//
        b5.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {
                        String fname = "", faddress="", fpostcode="", fcontactNo="";

                        fname= t1.getText();
                        faddress= t3.getText();
                        fpostcode= t4.getText();
                        fcontactNo= t5.getText();

                        String query="UPDATE clients SET name = '"+fname+"', address = '"+faddress+"', postcode = '"+fpostcode+"', contactNo = '"+fcontactNo+"'";
                        System.out.println(query);
                        try{
                            databaseConnect.St.executeUpdate(query);
                            l6.setText("'" + fname + "'" + " updated successfully!");
                            l6.setBounds(125,450,400,30);
                            l6.setForeground(Color.green);
                            l6.setVisible(true);
                            t1.setText("");
                            t3.setText("");
                            t4.setText("");
                            t5.setText("");
                        }
                        catch(Exception T){
                            System.out.println(T.toString());
                            l7.setBounds(125,450,100,30);
                            l7.setForeground(Color.red);
                            l7.setVisible(true);
                        }
                    }
                });

        //Delete Button//
        b6.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {

                        String name= "";

                        name= t1.getText();

                        String query = "DELETE FROM clients WHERE name = '" + name + "'";

                        try{
                            databaseConnect.St.executeUpdate(query);
                            l6.setText("'" + name + "'" + " deleted successfully!");
                            l6.setBounds(125,450,400,30);
                            l6.setForeground(Color.green);
                            l6.setVisible(true);
                            t1.setText("");
                            t3.setText("");
                            t4.setText("");
                            t5.setText("");
                        }
                        catch(Exception T){
                            System.out.println(T.toString());
                            l7.setBounds(125,450,100,30);
                            l7.setForeground(Color.red);
                            l7.setVisible(true);
                        }
                    }
                });
    }
}
