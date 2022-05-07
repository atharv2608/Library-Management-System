package Library;
import javax.swing.*;
import java.sql.*;
public class ViewIssuedBooks {
    static final String DB_URL="jdbc:mysql://localhost/Library";
    static final String USER = "root";
    static final String PASS = "1234";
    public static void main(String[] args) {
        JFrame jf = new JFrame("Issued Books");
        try{
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
            String query1 = "Select count(*) from issuebooks";
            ResultSet resultSet1 = statement.executeQuery(query1);
            while (resultSet1.next()){
                int rowNumber = resultSet1.getInt("count(*)");
                String[] columnName = {"Issue Date", "Book ID", "Book Name", "Issued to", "Library ID"};
                String data[][] = new String[rowNumber][5];
                String query2 = "Select * from issuebooks";
                ResultSet resultSet2 = statement.executeQuery(query2);
                int i=0;
                while(resultSet2.next())  {
                    for(int j=0;j<5;j++) {
                        data[i][j]=resultSet2.getString(j+1);
                    }
                    i=i+1;
                    JTable table = new JTable(data,columnName);
                    table.setBounds(30, 40, 200, 300);
                    JScrollPane sp = new JScrollPane(table);
                    jf.add(sp);
                }
            }
        }
        catch (SQLException se){
        }
        jf.setSize(700,200);
        jf.setVisible(true);
//        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
