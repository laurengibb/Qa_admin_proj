import java.sql.*;

public class databaseConnect {

        static Connection Con=null;
        static Statement St=null;

        static{
            try {
                 Con = DriverManager.getConnection("jdbc:mysql://localhost/qa_admin", "root", "");
                 St = Con.createStatement();
            }
            catch (SQLException e){
                System.out.println("...."+e.toString());
            }
        }
}
