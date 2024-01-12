package hotel.management.system;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    Conn(){  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem","root","AdritaDingo"); 
            
            s =c.createStatement();  
            
           
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}

/*JDBC Connectivity
5 steps
1. Register the driver class- Mysql driver using class.forName("driver_name");
mysql is an external entity so we have to use try-catch
2.Create connection - we use driver manager -  connection string created
3. Create statement - -we use statement interface this helps us to execute mySQL 
query statement.
4.Executing MySQL queries: c.s.executeQuery(q); 
5.Closing the connection(optional)
*/