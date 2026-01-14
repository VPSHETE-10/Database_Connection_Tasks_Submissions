import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Task2_Employee_Table_All_Operation {
    static Connection con=Property_Loader.getConnection();
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        try{
            int choice=0;
            System.out.println("Name:- Vaishnavi Shete \nBatch id:- Batch 1 CSE 4R");
            do{
                System.out.println("1.Insert Operation");
                System.out.println("2.Update Operation");
                System.out.println("3.Delete Operation");
                System.out.println("4.Exit");
                System.out.print("Enter your choice: ");
                choice=sc.nextInt();
                switch (choice){
                    case 1:insertData();break;
                    case 2:updateData();break;
                    case 3:deleteData();break;
                    case 4:System.out.println("Thank You........!");break;
                    default:
                        System.out.println("Invalid choice");

                }

            }while(choice !=4);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void insertData(){
        try {
            PreparedStatement stmt=con.prepareStatement("insert into employee values(9,'Sakshi','sakshi@gmail.com','Pune',8576894674)");
            int count=stmt.executeUpdate();
            System.out.println(count+ ":record inserted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void updateData(){
        try{
            PreparedStatement stmt=con.prepareStatement("update employee set city='Pune' where id=1");
            int count=stmt.executeUpdate();
            System.out.println(count+ ": record updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteData(){
        try{
            PreparedStatement stmt=con.prepareStatement("delete from employee where id=9");
            int count=stmt.executeUpdate();
            System.out.println(count+ ": record deleted successfully");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }



}
