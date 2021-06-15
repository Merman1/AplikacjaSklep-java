package projekt;

import java.sql.Connection;
import java.sql.DriverManager;

public class Polaczenie {
    public Connection databaseLink;

    public Connection getConnection()
    {


        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            databaseLink  = DriverManager.getConnection("jdbc:mysql://localhost:3306/skleprtv", "root","");

        } catch(Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
        return databaseLink;


    }


}
