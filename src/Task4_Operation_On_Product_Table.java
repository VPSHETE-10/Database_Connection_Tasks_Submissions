import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Task4_Operation_On_Product_Table {
    static Connection con=Property_Loader.getConnection();
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Name:- Vaishnavi Shete \nBatch id:- Batch 1 CSE 4R");

        try{

            PreparedStatement stmt=con.prepareStatement("select table_name from information_schema.tables where table_name='Product'");
            ResultSet rs=stmt.executeQuery();
            boolean isExists=false;
            while (rs.next()){
                isExists=true;
            }
            if(!isExists){
                PreparedStatement stmt1=con.prepareStatement("create table Product(id int primary key,name varchar(20),price int,quantity int)");
                int count=stmt1.executeUpdate();
                System.out.println("Table is created........!");
            }
            else{
                System.out.println("Table Exists...........!");
            }
            int choice=0;
            do{
                System.out.println("1. Insert product details");
                System.out.println("2. Update product details");
                System.out.println("3. Delete product details by id");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice=sc.nextInt();
                switch (choice){
                    case 1:insertData();break;
                    case 2:updateData();break;
                    case 3:deleteData();break;
                    case 4:System.out.println("Thank you for visiting.........!!");break;
                    default:
                        System.out.println("Invalid choice");
                }
            }while(choice !=4);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void insertData(){
        try{
            System.out.print("Enter Product id: ");
            int id=sc.nextInt();
            System.out.print("Enter Product Name: ");
            String pname=sc.next();
            System.out.print("Enter Product Price: ");
            int price=sc.nextInt();
            System.out.print("Enter Product Quantity: ");
            int quantity=sc.nextInt();
           PreparedStatement stmt=con.prepareStatement("insert into Product values(?,?,?,?)");
           stmt.setInt(1,id);
           stmt.setString(2,pname);
           stmt.setInt(3, price);
           stmt.setInt(4,quantity);
           int count=stmt.executeUpdate();
            System.out.println(count+ ": record inserted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void updateData()
    {
        try {
            System.out.print("Enter product id: ");
            int id=sc.nextInt();
            System.out.print("Enter product quantity: ");
            int quantity=sc.nextInt();
            PreparedStatement stmt=con.prepareStatement("update Product set quantity=? where id=?");
            stmt.setInt(1,quantity);
            stmt.setInt(2,id);
            int count=stmt.executeUpdate();
            System.out.println(count+ ": record updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteData()
    {
        try {
            System.out.print("Enter product id: ");
            int id=sc.nextInt();
            PreparedStatement stmt=con.prepareStatement("delete from employee where id=?");
            stmt.setInt(1,id);
            int count=stmt.executeUpdate();
            System.out.println(count+ ": record deleted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
