import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Task5_Delete_Student_Record {
    public static void main(String[] args) {
        try{
            Connection con=Property_Loader.getConnection();
            Scanner sc=new Scanner(System.in);
            System.out.println("Name :- Vaishnavi Shete  \t Batch id :- Batch 1 CSE 4R");

            System.out.println("******** DELETE RECORDS ********");
            System.out.print("Enter student id : ");
            int id=sc.nextInt();
            PreparedStatement stmt=con.prepareStatement("delete from students where id=?");
            stmt.setInt(1,id);
            int count=stmt.executeUpdate();
            System.out.println(count+ " : Records deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
