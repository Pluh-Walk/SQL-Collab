package colinaapp2b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class ColinaApp2B {

 public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); // Load the SQLite JDBC driver
            con = DriverManager.getConnection("jdbc:sqlite:testapp.db"); // Establish connection
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }
 
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        connectDB();
        System.out.println("Enter First Name: ");
        String fn = sc.nextLine();
        System.out.println("Enter Last Name: ");
        String ln = sc.nextLine();
        System.out.println("Enter Email: ");
        String em = sc.nextLine();
        System.out.println("Status: ");
        String sts = sc.nextLine();
        
       String sql = "INSERT INTO Students (s_name, s_lname, s_email, s_status) VALUES (?, ?, ?, ?)";
       
      try{
          Connection con = connectDB();
          PreparedStatement pst = con.prepareStatement(sql);
          pst.setString(1, fn);
          pst.setString(2, ln);
          pst.setString(3, em);
          pst.setString(4, sts);
          pst.executeUpdate();
          System.out.println("Inserted Successfully! ");
    }catch(SQLException ex){
          System.out.println("Connection Error: " + ex.getMessage());   
          
    }
    

    }
}
