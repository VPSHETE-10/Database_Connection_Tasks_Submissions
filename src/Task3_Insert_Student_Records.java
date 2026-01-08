import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Task3_Insert_Student_Records {
    public static void main(String[] args) {
        try{
            Connection con=Property_Loader.getConnection();
            Scanner sc=new Scanner(System.in);
            System.out.println("Name :- Vaishnavi Shete  \t Batch id :- Batch 1 CSE 4R");
            System.out.println("******** INSERT RECORDS ********");

            System.out.print("Enter your ID: ");
            int id=sc.nextInt();
            System.out.print("Enter your name: ");
            String name=sc.next();
            System.out.print("Enter your age: ");
            int age=sc.nextInt();

            PreparedStatement stmt=con.prepareStatement("insert into students values(?,?,?)");
            stmt.setInt(1,id);
            stmt.setString(2,name);
            stmt.setInt(3,age);
            int count=stmt.executeUpdate();
            System.out.println(count + " : records inserted successfully");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
