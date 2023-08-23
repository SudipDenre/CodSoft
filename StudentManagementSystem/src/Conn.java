import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Conn {
    Connection con;
    PreparedStatement ps;
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementsystem", "root", "Sudip00719@140");
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
