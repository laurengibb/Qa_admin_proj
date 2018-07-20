import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class searchTrainee {
    JPanel searchTrainee=new JPanel();

    JButton b1=new JButton("<- Back");
    JButton b2=new JButton("Search");
    JButton b3=new JButton("Clear");

    JLabel l1 =new JLabel("First Name");
    JLabel l2 =new JLabel("Last Name");
    JLabel l3 =new JLabel("Trainee ID");
    JLabel l4 =new JLabel("Contact No");
    JLabel l5 =new JLabel("Address");
    JLabel l6 =new JLabel("Postcode");
    JLabel l7 =new JLabel("Company");

    JTextField t1 = new JTextField("");
    JTextField t2 = new JTextField("");
    JTextField t3 = new JTextField("");
    JTextField t4 = new JTextField("");
    JTextField t5 = new JTextField("");
    JTextField t6 = new JTextField("");
    JTextField t7 = new JTextField("");

    public searchTrainee(JFrame F3) {
        F3.setTitle("Search for Trainees");

        searchTrainee.setBounds(0,0,600,800);
        searchTrainee.setBackground(Color.white);
        searchTrainee.setLayout(null);
        searchTrainee.setVisible(true);

        b1.setBounds(10, 10, 100, 30);
        b2.setBounds(375, 200, 100, 30);
        b3.setBounds(125, 500, 100, 30);

        searchTrainee.add(b1);
        searchTrainee.add(b2);
        searchTrainee.add(b3);

        l1.setBounds(125,100,100,30);
        l2.setBounds(125,150,100,30);
        l3.setBounds(125,250,100,30);
        l4.setBounds(125,300,100,30);
        l5.setBounds(125,350,100,30);
        l6.setBounds(125,400,100,30);
        l7.setBounds(125,450,100,30);

        searchTrainee.add(l1);
        searchTrainee.add(l2);
        searchTrainee.add(l3);
        searchTrainee.add(l4);
        searchTrainee.add(l5);
        searchTrainee.add(l6);
        searchTrainee.add(l7);

        t1.setBounds(275,100,200,30);
        t2.setBounds(275,150,200,30);
        t3.setBounds(275,250,200,30);
        t4.setBounds(275,300,200,30);
        t5.setBounds(275,350,200,30);
        t6.setBounds(275,400,200,30);
        t7.setBounds(275,450,200,30);

        searchTrainee.add(t1);
        searchTrainee.add(t2);
        searchTrainee.add(t3);
        searchTrainee.add(t4);
        searchTrainee.add(t5);
        searchTrainee.add(t6);
        searchTrainee.add(t7);

        F3.add(searchTrainee);

        b1.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {
                        searchTrainee.setVisible(false);
                        new reports(F3);
                    }
                });

        b2.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {
                        String first= "", last="";

                        first= t1.getText();
                        last= t2.getText();

                        String query = "select * from trainee WHERE fName = '" + first + "' AND lName = '" + last + "'";
                        try {
                            ResultSet result = databaseConnect.St.executeQuery(query);

                            if (result.next()) {
                                String traineeId = result.getString("traineeId");
                                t3.setText(traineeId);

                                String contactNo = result.getString("contactNo");
                                t4.setText(contactNo);

                                String address = result.getString("address");
                                t5.setText(address);

                                String postcode = result.getString("postcode");
                                t6.setText(postcode);

                                String companyId = result.getString("companyId");
                                t7.setText(companyId);
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
                    }
                });
    }
}
