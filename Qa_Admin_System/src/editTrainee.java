import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class editTrainee {
    JPanel editTrainee=new JPanel();

    JButton b1=new JButton("<- Back");
    JButton b2=new JButton("Search");
    JButton b3=new JButton("Clear");
    JButton b4=new JButton("Create");
    JButton b5=new JButton("Save");
    JButton b6=new JButton("Delete");

    JLabel l0 = new JLabel("");
    JLabel l1 =new JLabel("First Name");
    JLabel l2 =new JLabel("Last Name");
    JLabel l3 =new JLabel("Contact No");
    JLabel l4 =new JLabel("Address");
    JLabel l5 =new JLabel("Postcode");
    JLabel l6 =new JLabel("Company ID");
    JLabel l7 =new JLabel("");
    JLabel l8 =new JLabel("Error");

    JTextField t1 = new JTextField("");
    JTextField t2 = new JTextField("");
    JTextField t3 = new JTextField("");
    JTextField t4 = new JTextField("");
    JTextField t5 = new JTextField("");
    JTextField t6 = new JTextField("");

    public editTrainee(JFrame F3) {
        F3.setTitle("Edit Trainee");

        editTrainee.setBounds(0,0,600,800);
        editTrainee.setBackground(Color.white);
        editTrainee.setLayout(null);
        editTrainee.setVisible(true);

        b1.setBounds(10, 10, 100, 30);
        b2.setBounds(375, 200, 100, 30);
        b3.setBounds(485, 10, 100, 30);
        b4.setBounds(125, 500, 100, 30);
        b5.setBounds(250, 500, 100, 30);
        b6.setBounds(375, 500, 100, 30);

        editTrainee.add(b1);
        editTrainee.add(b2);
        editTrainee.add(b3);
        editTrainee.add(b4);
        editTrainee.add(b5);
        editTrainee.add(b6);

        //l0.setBounds(125,50,100,30);
        l1.setBounds(125,100,100,30);
        l2.setBounds(125,150,100,30);
        l3.setBounds(125,250,100,30);
        l4.setBounds(125,300,100,30);
        l5.setBounds(125,350,100,30);
        l6.setBounds(125,400,100,30);

        editTrainee.add(l0);
        editTrainee.add(l1);
        editTrainee.add(l2);
        editTrainee.add(l3);
        editTrainee.add(l4);
        editTrainee.add(l5);
        editTrainee.add(l6);
        editTrainee.add(l7);
        editTrainee.add(l8);

        t1.setBounds(275,100,200,30);
        t2.setBounds(275,150,200,30);
        t3.setBounds(275,250,200,30);
        t4.setBounds(275,300,200,30);
        t5.setBounds(275,350,200,30);
        t6.setBounds(275,400,200,30);

        editTrainee.add(t1);
        editTrainee.add(t2);
        editTrainee.add(t3);
        editTrainee.add(t4);
        editTrainee.add(t5);
        editTrainee.add(t6);

        F3.add(editTrainee);

        //Back Button//
        b1.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {
                        editTrainee.setVisible(false);
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

                        String query = "select * from trainee WHERE fName = '" + firstname + "' AND  lName = '" + lastname + "'";
                        System.out.println(query);
                        try {
                            ResultSet result = databaseConnect.St.executeQuery(query);

                            if (result.next()) {
                                String id = result.getString("traineeID");
                                l0.setText(id);
                                String contactNo = result.getString("contactNo");
                                t3.setText(contactNo);
                                String address = result.getString("address");
                                t4.setText(address);
                                String postcode = result.getString("postcode");
                                t5.setText(postcode);
                                String companyID = result.getString("companyID");
                                t6.setText(companyID);
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
                        l0.setText("");
                        t1.setText("");
                        t2.setText("");
                        t3.setText("");
                        t4.setText("");
                        t5.setText("");
                        t6.setText("");
                    }
                });

        //Create Button//
        b4.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {
                        String ffname = "", flname = "", fcontactNo="", faddress="", fpostcode="", fcompanyID="";

                        ffname= t1.getText();
                        flname= t2.getText();
                        fcontactNo= t3.getText();
                        faddress= t4.getText();
                        fpostcode= t5.getText();
                        fcompanyID= t6.getText();


                        String query="insert into trainee (fName, lName, contactNo, address, postcode, companyID) values('"+ffname+"','"+flname+"','"+fcontactNo+"','"+faddress+"','"+fpostcode+"','"+fcompanyID+"')";
                        try{
                            databaseConnect.St.executeUpdate(query);
                            l7.setText("'" +ffname +flname +"'" +" added successfully!");
                            l7.setBounds(125,600,400,30);
                            l7.setForeground(Color.green);
                            l7.setVisible(true);
                            t1.setText("");
                            t2.setText("");
                            t3.setText("");
                            t4.setText("");
                            t5.setText("");
                            t6.setText("");
                        }
                        catch(Exception T){
                            System.out.println(T.toString());
                            l8.setBounds(125,600,400,30);
                            l8.setForeground(Color.red);
                            l8.setVisible(true);
                        }
                    }
                });

        //Save Button//
        b5.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {
                        String traineeID = "", ffname = "", flname = "", fcontactNo="", faddress="", fpostcode="", fcompanyID;

                        traineeID = l0.getText();
                        ffname= t1.getText();
                        flname= t2.getText();
                        fcontactNo= t3.getText();
                        faddress= t4.getText();
                        fpostcode= t5.getText();
                        fcompanyID= t6.getText();

                        String query="UPDATE trainee SET fName = '"+ffname+"', lName = '"+flname+"', address = '"+faddress+"', postcode = '"+fpostcode+"', contactNo = '"+fcontactNo+"', companyId = '" +fcompanyID+"' WHERE traineeId = '" + traineeID +"'";
                        System.out.println(query);
                        try{
                            databaseConnect.St.executeUpdate(query);
                            l7.setText("'" +ffname +" " +flname +"'" +" edited successfully!");
                            l7.setBounds(125,600,400,30);
                            l7.setForeground(Color.green);
                            l7.setVisible(true);
                            t1.setText("");
                            t2.setText("");
                            t3.setText("");
                            t4.setText("");
                            t5.setText("");
                            t6.setText("");
                        }
                        catch(Exception T){
                            System.out.println(T.toString());
                            l8.setBounds(125,600,100,30);
                            l8.setForeground(Color.red);
                            l8.setVisible(true);
                        }
                    }
                });

        //Delete Button//
        b6.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {

                        String traineeID ="", firstname= "", lastname= "";

                        traineeID= l0.getText();
                        firstname= t1.getText();
                        lastname= t2.getText();

                        String query = "DELETE from trainee WHERE traineeId = '" +traineeID +"'";

                        try{
                            databaseConnect.St.executeUpdate(query);
                            l7.setText("'" +firstname +" " +lastname +"'" +" deleted successfully!");
                            l7.setBounds(125,600,400,30);
                            l7.setForeground(Color.green);
                            l7.setVisible(true);
                            t1.setText("");
                            t2.setText("");
                            t3.setText("");
                            t4.setText("");
                            t5.setText("");
                            t6.setText("");
                        }
                        catch(Exception T){
                            System.out.println(T.toString());
                            l7.setBounds(125,600,100,30);
                            l7.setForeground(Color.red);
                            l7.setVisible(true);
                        }
                    }
                });
    }
}
