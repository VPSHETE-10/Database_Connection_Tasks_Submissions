import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.util.function.Predicate;

public class Task4_Update_Students_Marks {
    public static void main(String[] args) {
        try{
            Connection con=Property_Loader.getConnection();
            Scanner sc=new Scanner(System.in);
            System.out.println("Name :- Vaishnavi Shete  \t Batch id :- Batch 1 CSE 4R");

            System.out.println("******** UPDATE RECORDS ********");

            System.out.print("Enter student id: ");
            int id=sc.nextInt();
            System.out.print("Enter students marks: ");
            int marks=sc.nextInt();

            PreparedStatement stmt=con.prepareStatement("update students set marks=? where id=?");
            stmt.setInt(1,marks);
            stmt.setInt(2,id);
            int count=stmt.executeUpdate();
            System.out.println(count+ " : Record Updated Successfully!");
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
