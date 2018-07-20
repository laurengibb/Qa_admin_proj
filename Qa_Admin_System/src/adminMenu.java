import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminMenu {

    JPanel adminMenu=new JPanel();

    JButton b1=new JButton("Create/Edit/Delete Trainee");
    JButton b2=new JButton("Create/Edit/Delete Staff");
    JButton b3=new JButton("Create/Edit/Delete Clients");
    JButton b4=new JButton("Reports");

    public adminMenu(JFrame F1) {
        F1.setTitle("Admin Menu");

        adminMenu.setBounds(0,0,600,800);
        adminMenu.setBackground(Color.white);
        adminMenu.setLayout(null);
        adminMenu.setVisible(true);

        b1.setBounds(200, 275, 200, 30);
        b2.setBounds(200, 325, 200, 30);
        b3.setBounds(200, 375, 200, 30);
        b4.setBounds(200, 425, 200, 30);

        adminMenu.add(b1);
        adminMenu.add(b2);
        adminMenu.add(b3);
        adminMenu.add(b4);
        F1.add(adminMenu);
        b1.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {
                        adminMenu.setVisible(false);
                        new editTrainee(F1);
                    }
                });

        b2.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {
                        adminMenu.setVisible(false);
                        new editStaff(F1);
                    }
                });

        b3.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {
                        adminMenu.setVisible(false);
                        new editClients(F1);
                    }
                });

        b4.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tt) {
                        adminMenu.setVisible(false);
                        new reports(F1);
                    }
                });
    }
}
