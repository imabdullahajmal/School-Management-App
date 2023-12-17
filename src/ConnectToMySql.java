import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ConnectToMySql
{
    public java.sql.Statement s;
    public Connection c;

    ConnectToMySql()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=  DriverManager.getConnection("jdbc:mysql://localhost/SchoolManagementsystem","root","aA2015421001");
            s= (java.sql.Statement) c.createStatement();
            ResultSet rs;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}