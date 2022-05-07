package Library;
import javax.swing.*;
import java.sql.*;
public class ViewLibrarian {
    static final String DB_URL="jdbc:mysql://localhost/Library";
    static final String USER = "root";
    static final String PASS = "1234";

    public static void main(String[] args) {
        JFrame jf = new JFrame("Librarians");

        try{
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
            String query1 = "Select count(*) from librarian";
            ResultSet resultSet1 = statement.executeQuery(query1);

            while (resultSet1.next()){
                 int rowNumber = resultSet1.getInt("count(*)");
                 String[][] data = new String[rowNumber][7];
                 String[] columns = {"ID", "Name", "Password", "Email", "Address", "City", "Contact"};
                String query2 = "Select * from librarian";
                ResultSet resultSet2 = statement.executeQuery(query2);
                int i=0;
                while(resultSet2.next())  {
                    for(int j=0;j<7;j++) {
                        data[i][j]=resultSet2.getString(j+1);
                    }
                    i=i+1;
                    JTable table = new JTable(data,columns);
                    table.setBounds(30, 40, 200, 300);
                    JScrollPane sp = new JScrollPane(table);
                    jf.add(sp);
                }
            }
        }
        catch (SQLException se){
        }
        jf.setSize(1000,500);
        jf.setVisible(true);
//        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
