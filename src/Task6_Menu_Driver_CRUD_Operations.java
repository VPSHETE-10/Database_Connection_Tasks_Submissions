import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Task6_Menu_Driver_CRUD_Operations {
    static Connection con=Property_Loader.getConnection();
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        try {
            int choice=0;
            System.out.println("Name:- Vaishnavi Shete \nBatch id:- Batch 1 CSE 4R");
            do{
                System.out.println("1.Insert Student Record");
                System.out.println("2.Update Student Record");
                System.out.println("3.Delete Student Record");
                System.out.println("4.View all Student records");
                System.out.println("5.Exit");
                System.out.print("Enter your choice: ");
                choice=sc.nextInt();
                switch (choice){
                    case 1:insertData();break;
                    case 2:updateData();break;
                    case 3:deleteData();break;
                    case 4:viewData();break;
                    case 5:System.out.println("Thank You........!");break;
                    default:
                        System.out.println("Invalid choice");

                }

            }while(choice !=4);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void insertData(){
        try{
            System.out.print("Enter student id: ");
            int id=sc.nextInt();
            System.out.print("Enter Student name:  ");
            String name=sc.next();
            System.out.print("Enter course name: ");
            String course_name=sc.next();
            System.out.print("Enter your age: ");
            int age=sc.nextInt();
            PreparedStatement stmt=con.prepareStatement("insert into Student values(?,?,?,?)");
            stmt.setInt(1,id);
            stmt.setString(2,name);
            stmt.setString(3,course_name);
            stmt.setInt(4,age);
            int count=stmt.executeUpdate();
            System.out.println(count+ ": record inserted successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void updateData(){
        try {
            System.out.print("Enter student id: ");
            int id=sc.nextInt();
            System.out.print("Enter updated name: ");
            String name=sc.next();
            PreparedStatement stmt=con.prepareStatement("update Student set name=? where student_id=?");
            stmt.setString(1,name);
            stmt.setInt(2,id);
            int count=stmt.executeUpdate();
            System.out.println(count+ ": record updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteData(){
        try {
            System.out.print("Enter student id: ");
            int id=sc.nextInt();
            PreparedStatement stmt=con.prepareStatement("delete from Student where student_id=?");
            stmt.setInt(1,id);
            int count=stmt.executeUpdate();
            System.out.println(count+" : record deleted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void viewData(){
        try {
            PreparedStatement stmt=con.prepareStatement("select * from Student");
            ResultSet rs=stmt.executeQuery();
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.printf("%-10s %-15s %-15s %-10s%n","ID","Student_Name","Course_Name","Age");
            System.out.println("----------------------------------------------------------------------------------------");
            while(rs.next()){
                System.out.printf("%-10s %-15s %-15s %-10s%n",rs.getInt("student_id"),
                        rs.getString("name") ,rs.getString("course"),
                        rs.getInt("age"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
