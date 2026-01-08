import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Property_Loader {
    public static final String DRIVER;
    public static final String URL;
    public static final String USER;
    public static final String PASSWORD;
    static{
        Properties properties=new Properties();
        try{
            properties.load(new FileInputStream("resources/db.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        DRIVER=properties.getProperty("db.driver");
        URL= properties.getProperty("db.url");
        USER= properties.getProperty("db.user");
        PASSWORD=properties.getProperty("db.password");
    }
    public static final Connection getConnection()
    {
        Connection con=null;
        try{
            Class.forName(Property_Loader.DRIVER);
            con= DriverManager.getConnection(Property_Loader.URL,Property_Loader.USER,Property_Loader.PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

}
