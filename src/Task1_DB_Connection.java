import java.sql.Connection;
import java.sql.DriverManager;

public class Task1_DB_Connection {

    public static void main(String args[])
    {
        try
        {
            //1. Register Driver
            Class.forName(Property_Loader.DRIVER);
            //2. Establish Connection
            Connection con= DriverManager.getConnection(Property_Loader.URL,Property_Loader.USER,Property_Loader.PASSWORD);
            System.out.println("Name :- Vaishnavi Shete");
            System.out.println("Batch id :- Batch 1 CSE 4R");
            System.out.println("Connection Successful");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
