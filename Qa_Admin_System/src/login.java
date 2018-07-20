import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login{

    JFrame F = new JFrame("QA Admin System");
    JMenuBar Bar = new JMenuBar();
    JMenu menu1 = new JMenu("File");
    JMenuItem M1 = new JMenuItem("Sign Out");
    JMenuItem M2 = new JMenuItem("Change Password");

    JPanel login=new JPanel();

    JLabel l1=new JLabel("Username:");
    JLabel l2=new JLabel("Password:");
    JTextField t1 = new JTextField("");
    JTextField t2 = new JTextField("");
    JButton b1 = new JButton("Log-in");

    JLabel l3=new JLabel("You have entered an incorrect username or password!");

    ImageIcon imageIcon = new ImageIcon("C:\\Users\\Admin\\IdeaProjects\\Qa_Admin_System\\src\\QALogo.jpg");
    JLabel QALogo = new JLabel();


    public static void main(String[] args) {
        new login();
    }

    public login() {
        menu1.add(M1);
        menu1.add(M2);
        Bar.add(menu1);
        F.setJMenuBar(Bar);

        login.setBounds(0,0,600,800);
        login.setBackground(Color.white);
        login.setLayout(null);

        QALogo.setIcon(imageIcon);

        QALogo.setBounds(235,250, 134,43);
        l1.setBounds(170,300, 100,30);
        l2.setBounds(170,350, 100,30);
        t1.setBounds(270,300, 150,30);
        t2.setBounds(270,350, 150,30);
        b1.setBounds(225, 400, 150,50);

        login.add(QALogo);
        login.add(t1);
        login.add(t2);
        login.add(l1);
        login.add(l2);
        login.add(b1);
        login.add(l3);
        l3.setVisible(false);
        F.add(login);
        b1.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent tt){
                        String user = "";
                        String pass = "";

                        user = t1.getText();
                        pass = t2.getText();

                        String query="select * from staff WHERE username = '"+ user +"' AND password = '"+ pass +"'";
                        try{
                            ResultSet r = databaseConnect.St.executeQuery(query);

                            if (r.next()) {
                                String dbuser = "";
                                String dbpass = "";
                                Integer dbadmin = 0;

                                dbuser = r.getString("username");
                                dbpass = r.getString("password");
                                dbadmin = r.getInt("admin");

                                if (user.equals(dbuser) && pass.equals(dbpass) && dbadmin.equals(1)) {
                                    login.setVisible(false);
                                    new adminMenu(F);
                                }
                                if (user.equals(dbuser) && pass.equals(dbpass) && dbadmin.equals(0)) {
                                    login.setVisible(false);
                                    new reports(F);
                                }
                            }
                                else{
                                    l3.setBounds(35,500,400,50);
                                    l3.setVisible(true);
                                }
                        }
                        catch(Exception T){
                            System.out.println(T.toString());
                        }
                    }
                });
        M1.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent tt){
                    }
                });

        l3.setForeground(Color.red);
        F.setSize(600, 800);
        F.setLayout(null);
        F.setVisible(true);
        F.setResizable(false);
        F.addWindowListener(new windowCloser());
    }
}






