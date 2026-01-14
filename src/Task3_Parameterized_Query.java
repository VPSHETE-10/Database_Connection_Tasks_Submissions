import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Task3_Parameterized_Query
{
    static Connection con=Property_Loader.getConnection();
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Name:- Vaishnavi Shete \nBatch id:- Batch 1 CSE 4R");
        int choice=0;
        do{
            System.out.println("1.Insert employee details");
            System.out.println("2.View employee details");
            System.out.println("3.Update employee contact");
            System.out.println("4.Exit");
            Scanner sc1=new Scanner(System.in);
            System.out.print("Enter your choice: ");
            choice= sc1.nextInt();
            switch(choice)
            {
                case 1:insertData();break;
                case 2:viewData();break;
                case 3:updateData();break;
                case 4:System.out.println("Thank you...!");break;
                default:System.out.println("Invalid choice");
            }
        }while(choice != 4);

    }
    public static void insertData()
    {
        try {
            System.out.print("Enter id: ");
            int id=sc.nextInt();
            System.out.print("Enter name: ");
            String  name=sc.next();
            System.out.print("Enter email: ");
            String email=sc.next();
            System.out.print("Enter city: ");
            String city=sc.next();
            System.out.print("Enter contact no.: ");
            String cont=sc.next();

            PreparedStatement stmt = con.prepareStatement("insert into employee values(?,?,?,?,?)");

            stmt.setInt(1,id);
            stmt.setString(2,name);
            stmt.setString(3,email);
            stmt.setString(4,city);
            stmt.setString(5,cont);
            int count=stmt.executeUpdate();
            System.out.println(count+ " : record inserted");
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void viewData()
    {
        try{
            System.out.print("Enter the city: ");
            String city=sc.next();
            PreparedStatement stmt = con.prepareStatement("select * from employee where city = ?");
            stmt.setString(1,city);
            ResultSet rs= stmt.executeQuery();
            System.out.println("Emp ID || Emp Name || Emp Email || Emp City || Emp Contact");

            while(rs.next())
            {
                System.out.println(rs.getInt("id") + "  " +rs.getString("name") +"  "+rs.getString("email")
                        +"  " +rs.getString("city") +"  " +rs.getString("contact"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void updateData()
    {
        try{
            System.out.print("Enter id: ");
            int id=sc.nextInt();
            System.out.print("Enter contact no.: ");
            String contact=sc.next();

            PreparedStatement stmt=con.prepareStatement("update employee set contact=? where id=?");
            stmt.setString(1,contact);
            stmt.setInt(2,id);
            int count=stmt.executeUpdate();
            System.out.println(count+ ": record updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

