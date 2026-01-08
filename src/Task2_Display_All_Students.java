import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Task2_Display_All_Students {
    public static void main(String[] args) {
        try
        {
            //estalish  connection
            Connection con=Property_Loader.getConnection();
            //create statement
            PreparedStatement stmt=con.prepareStatement("select * from students");
            //execute statement
            ResultSet rs=stmt.executeQuery();
            System.out.println("Name :- Vaishnavi Shete  \t Batch id :- Batch 1 CSE 4R");

            System.out.println("******** DISPLAYING ALL RECORDS ********");

            System.out.println("________________________________________");
            System.out.println("| ID |   Stud Name   | Age |   Marks |");
            while(rs.next())
            {

                System.out.println("____________________________________");
                System.out.println("| " +rs.getInt("id") + "  | " +rs.getString("name") +
                        "     | " +rs.getInt("age") + "  | " +rs.getInt("marks") + "  |");
            }
            System.out.println("______________________________________");
            //close connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
