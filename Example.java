package Library;
import java.sql.*;
public class Example {
    static final String DB_URL="jdbc:mysql://localhost/Library";
    static final String USER = "root";
    static final String PASS = "1234";

    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
            String query = "Select * from librarian";
            ResultSet resultSet =  statement.executeQuery(query);
            while(resultSet.next()){
                String id = resultSet.getString(1);
                String name = resultSet.getString("Name");
                String password = resultSet.getString("Password");
                String email = resultSet.getString("Email");
                String address = resultSet.getString("Address");
                String city = resultSet.getString("City");
                String contact = resultSet.getString("Contact");

                System.out.println("ID: "+id);
                System.out.println("Name: "+name);
                System.out.println("Password: "+password);
                System.out.println("Email: "+email);
                System.out.println("Address: "+address);
                System.out.println("City: "+city);
                System.out.println("Contact: "+contact);
                System.out.println();
            }
        }
        catch (SQLException se){
            se.printStackTrace();
        }
    }
}
