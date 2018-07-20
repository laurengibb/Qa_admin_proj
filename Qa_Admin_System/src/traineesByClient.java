import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class traineesByClient {
    JPanel traineesByClient=new JPanel();

    JButton b1 =new JButton("<- Back");
    JButton b2 =new JButton("Search");

    JComboBox<String> cb1 = new JComboBox<String>();

    JLabel l1 =new JLabel("Client");

    String data[][]={ {"101","Amit","670000"},
            {"102","Jai","780000"},
            {"101","Sachin","700000"}};
    String column[]={"ID","NAME","SALARY"};
    JTable table = new JTable(data,column);

    public traineesByClient(JFrame F2) {
        F2.setTitle("View Trainees by Client");

        traineesByClient.setBounds(0,0,600,800);
        traineesByClient.setBackground(Color.white);
        traineesByClient.setLayout(null);
        traineesByClient.setVisible(true);

        b1.setBounds(10, 10, 100, 30);
        b2.setBounds(375, 150, 100, 30);
        traineesByClient.add(b1);
        traineesByClient.add(b2);

        l1.setBounds(125,100,100,30);
        traineesByClient.add(l1);

        cb1.setBounds(275,100,200,30);
        traineesByClient.add(cb1);

        //Creating combobox list options//
        String query = "select name from clients";
        try {
            ResultSet result = databaseConnect.St.executeQuery(query);

            while (result.next()) {
                cb1.addItem(result.getString(1));
            }
        } catch (Exception T) {
            System.out.println(T.toString());
        }

        //Creating table//
        JScrollPane sp=new JScrollPane(table);
        sp.setBounds(125,300,200,300);
        traineesByClient.add(sp);

        //Adding panel to frame//
        F2.add(traineesByClient);

        //Button action listeners//
        b1.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {
                        traineesByClient.setVisible(false);
                        new reports(F2);
                    }
                });

        b2.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {
                        System.out.println(cb1.getSelectedItem());
                    }
                });
    }
}