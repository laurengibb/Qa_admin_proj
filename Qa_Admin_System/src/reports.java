import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reports{

    JPanel reports=new JPanel();

    JButton b1=new JButton("View Trainees by Client");
    JButton b2=new JButton("Search for a Trainee");
    JButton b3=new JButton("Search for Staff");
    JButton b4=new JButton("Search for a Client");

    public reports(JFrame F1) {
        F1.setTitle("Reports");

        reports.setBounds(0,0,600,800);
        reports.setBackground(Color.white);
        reports.setLayout(null);
        reports.setVisible(true);

        b1.setBounds(200, 275, 200, 30);
        b2.setBounds(200, 325, 200, 30);
        b3.setBounds(200, 375, 200, 30);
        b4.setBounds(200, 425, 200, 30);

        reports.add(b1);
        reports.add(b2);
        reports.add(b3);
        reports.add(b4);
        F1.add(reports);
        b1.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {
                        reports.setVisible(false);
                        new traineesByClient(F1);
                    }
                });

        b2.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {
                        reports.setVisible(false);
                        new searchTrainee(F1);
                    }
                });

        b3.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {
                        reports.setVisible(false);
                        new searchStaff(F1);
                    }
                });

        b4.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {
                        reports.setVisible(false);
                        new searchClient(F1);
                    }
                });
    }
}
