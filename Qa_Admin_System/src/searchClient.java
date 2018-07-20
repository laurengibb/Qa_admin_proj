import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class searchClient {
    JPanel searchClient=new JPanel();

    JButton b1=new JButton("<- Back");
    JButton b2=new JButton("Search");
    JButton b3=new JButton("Clear");

    JLabel l1 =new JLabel("Name");
    JLabel l2 =new JLabel("Client ID");
    JLabel l3 =new JLabel("Address");
    JLabel l4 =new JLabel("Postcode");
    JLabel l5 =new JLabel("Contact No");

    JTextField t1 = new JTextField("");
    JTextField t2 = new JTextField("");
    JTextField t3 = new JTextField("");
    JTextField t4 = new JTextField("");
    JTextField t5 = new JTextField("");

    public searchClient(JFrame F3) {
        F3.setTitle("Search for Clients");

        searchClient.setBounds(0,0,600,800);
        searchClient.setBackground(Color.white);
        searchClient.setLayout(null);
        searchClient.setVisible(true);

        b1.setBounds(10, 10, 100, 30);
        b2.setBounds(375, 150, 100, 30);
        b3.setBounds(125, 400, 100, 30);

        searchClient.add(b1);
        searchClient.add(b2);
        searchClient.add(b3);

        l1.setBounds(125,100,100,30);
        l2.setBounds(125,200,100,30);
        l3.setBounds(125,250,100,30);
        l4.setBounds(125,300,100,30);
        l5.setBounds(125,350,100,30);

        searchClient.add(l1);
        searchClient.add(l2);
        searchClient.add(l3);
        searchClient.add(l4);
        searchClient.add(l5);

        t1.setBounds(275,100,200,30);
        t2.setBounds(275,200,200,30);
        t3.setBounds(275,250,200,30);
        t4.setBounds(275,300,200,30);
        t5.setBounds(275,350,200,30);

        searchClient.add(t1);
        searchClient.add(t2);
        searchClient.add(t3);
        searchClient.add(t4);
        searchClient.add(t5);

        F3.add(searchClient);

        b1.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {
                        searchClient.setVisible(false);
                        new reports(F3);
                    }
                });

        b2.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {

                        String name= "";

                        name= t1.getText();

                        String query = "select * from clients WHERE name = '" + name + "'";
                        try {
                            ResultSet result = databaseConnect.St.executeQuery(query);

                            if (result.next()) {
                                String clientID = result.getString("clientID");
                                t2.setText(clientID);

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

        b3.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {
                        t1.setText("");
                        t2.setText("");
                        t3.setText("");
                        t4.setText("");
                        t5.setText("");
                    }
                });
    }
}
