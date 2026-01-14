import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Locale;
import java.util.Scanner;

public class Task7_Login_System {
    public static void main(String[] args) {
        try {
            Connection con=Property_Loader.getConnection();
            System.out.println("Name:- Vaishnavi Shete \nBatch id:- Batch 1 CSE 4R");
            System.out.println("---------- Login to Application ----------");
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter Username: ");
            String uname=sc.next();
            System.out.print("Enter Password: ");
            String pass=sc.next();

            PreparedStatement stmt=con.prepareStatement("select * from user");
            ResultSet rs=stmt.executeQuery();
            boolean isValid=false;
            while (rs.next()){
                if(rs.getString("Username").equals(uname) &&
                        rs.getString("password").equals(pass)) {
                    isValid = true;
                }
            }
            if(isValid)
                System.out.println("Login Successful.......!");
            else
                System.out.println("Invalid Credentials......!!");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
