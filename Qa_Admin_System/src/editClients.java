import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class editClients {
    JPanel editClients=new JPanel();

    JButton b1=new JButton("<- Back");
    JButton b2=new JButton("Search");
    JButton b3=new JButton("Clear");
    JButton b4=new JButton("Create");
    JButton b5=new JButton("Save");
    JButton b6=new JButton("Delete");

    JLabel l1 =new JLabel("Name");
    //JLabel l2 =new JLabel("Client ID");
    JLabel l3 =new JLabel("Address");
    JLabel l4 =new JLabel("Postcode");
    JLabel l5 =new JLabel("Contact No");
    JLabel l6=new JLabel("");
    JLabel l7=new JLabel("Error");

    JTextField t1 = new JTextField("");
    //JTextField t2 = new JTextField("");
    JTextField t3 = new JTextField("");
    JTextField t4 = new JTextField("");
    JTextField t5 = new JTextField("");

    public editClients(JFrame F3) {
        F3.setTitle("Search for Clients");

        editClients.setBounds(0,0,600,800);
        editClients.setBackground(Color.white);
        editClients.setLayout(null);
        editClients.setVisible(true);

        b1.setBounds(10, 10, 100, 30);
        b2.setBounds(375, 150, 100, 30);
        b3.setBounds(485, 10, 100, 30);
        b4.setBounds(125, 400, 100, 30);
        b5.setBounds(250, 400, 100, 30);
        b6.setBounds(375, 400, 100, 30);

        editClients.add(b1);
        editClients.add(b2);
        editClients.add(b3);
        editClients.add(b4);
        editClients.add(b5);
        editClients.add(b6);

        l1.setBounds(125,100,100,30);
        //l2.setBounds(125,200,100,30);
        l3.setBounds(125,250,100,30);
        l4.setBounds(125,300,100,30);
        l5.setBounds(125,350,100,30);

        editClients.add(l1);
        //editClients.add(l2);
        editClients.add(l3);
        editClients.add(l4);
        editClients.add(l5);
        editClients.add(l6);
        editClients.add(l7);

        t1.setBounds(275,100,200,30);
        //t2.setBounds(275,200,200,30);
        t3.setBounds(275,250,200,30);
        t4.setBounds(275,300,200,30);
        t5.setBounds(275,350,200,30);

        editClients.add(t1);
        //editClients.add(t2);
        editClients.add(t3);
        editClients.add(t4);
        editClients.add(t5);

        F3.add(editClients);

        //Back Button//
        b1.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {
                        editClients.setVisible(false);
                        new adminMenu(F3);
                    }
                });

        //Search Button//
        b2.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {

                        String name= "";

                        name= t1.getText();

                        String query = "select * from clients WHERE name = '" + name + "'";
                        try {
                            ResultSet result = databaseConnect.St.executeQuery(query);

                            if (result.next()) {
                                //String clientID = result.getString("clientID");
                                //t2.setText(clientID);

                                String address = result.getString("address");
                                t3.setText(address);

                                String postcode = result.getString("postcode");
                                t4.setText(postcode);

                                String companyId = result.getString("contactNo");
                                t5.setText(companyId);
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
                        //t2.setText("");
                        t3.setText("");
                        t4.setText("");
                        t5.setText("");
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

                        String query="UPDATE clients SET name = '"+fname+"', address = '"+faddress+"', postcode = '"+fpostcode+"', contactNo = '"+fcontactNo+"' WHERE name = '" + fname + "'";
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
