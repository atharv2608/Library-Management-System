package Library;
import java .sql.*;
public class LibrarianTableCreate {
    static final String JDBC_DRIVER ="com.mysql.cj.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost/Library";
    static final String USER = "root";
    static final String PASS = "1234";
    public static void main(String[] args){
        Connection conn = null;
        Statement stmt = null;
        try
        {
            System.out.println("Connecting to the database...");
            conn=DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Connection Established!!!");
            System.out.println("Creating table in given database....");
            stmt=conn.createStatement();
            String sql = "CREATE TABLE Librarian_Table" + "(Id INTEGER not NULL AUTO_INCREMENT, " + "Name VARCHAR(255), " + "Password VARCHAR(255)," + "Email VARCHAR(255)," +
            "Address VARCHAR(255)," + "City VARCHAR(255)," + "Contact VARCHAR(255)," + "PRIMARY KEY(id))";
            stmt.executeUpdate(sql);
            System.out.println("Table creation successful!!!");
        }
        catch(SQLException se) {
            se.printStackTrace();
        }
        System.out.println("Thank You");
    }
}