package Library;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class IssueBooks {
    static final String DB_URL="jdbc:mysql://localhost/Library";
    static final String USER = "root";
    static final String PASS = "1234";
    public static void main(String[] args) {
        JFrame jf = new JFrame("Issue Books");
        JLabel label1 = new JLabel("Book ID");
        JTextField textField1 = new JTextField();
        label1.setBounds(10, 5, 100, 25);
        textField1.setBounds(110, 5, 100, 25);
        jf.add(label1);
        jf.add(textField1);

        JLabel label2 = new JLabel("Issued to");
        JTextField textField2 = new JTextField();
        label2.setBounds(10, 35, 100, 25);
        textField2.setBounds(110, 35, 100, 25);
        jf.add(label2);
        jf.add(textField2);

        JLabel label3 = new JLabel("Library ID");
        JTextField textField3 = new JTextField();
        label3.setBounds(10, 65, 100, 25);
        textField3.setBounds(110, 65, 100, 25);
        jf.add(label3);
        jf.add(textField3);
        
        JLabel label4 = new JLabel();
        label4.setBounds(10,170,200,25);
        label4.setFont(new Font("Serif", Font.BOLD, 18));
        label4.setForeground(Color.RED);
        jf.add(label4);

        JLabel label5 = new JLabel();
        label5.setForeground(Color.RED);
        label5.setBounds(220,5,200,25);
        jf.add(label5);

        JLabel label6 = new JLabel();
        label6.setBounds(10,170,200,25);
        label6.setFont(new Font("Serif", Font.BOLD, 18));
        label6.setForeground(Color.BLUE);
        jf.add(label6);

        JLabel label7 = new JLabel();
        label7.setBounds(10,170,200,25);
        label7.setFont(new Font("Serif", Font.BOLD, 18));
        label7.setForeground(Color.RED);
        jf.add(label7);

        JButton button = new JButton("Issue Book");
        button.setBounds(10,110,130,25);
        jf.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String book_id = textField1.getText();
                String issued_to = textField2.getText();
                String library_id = textField3.getText();
                try{
                    Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
                    Statement statement = connection.createStatement();
                    String query1 = "Select * from books where Book_ID='"+book_id+"'";
                    ResultSet resultSet = statement.executeQuery(query1);

                    if(book_id.equals("")  || issued_to.equals("") || library_id.equals("")){
                        label4.setText("Please Fill All Details");
                        label5.setText("");
                        label6.setText("");
                    }
                    else {
                        if (!resultSet.next()) {
                            label5.setText("No such book in the record");
                            label4.setText("");
                            label6.setText("");
                        }
                        else {
                            int numberOfCopies = resultSet.getInt("No_of_copies");
                            if(numberOfCopies == 0){
                                label7.setText("Currently Unavailable");
                                label4.setText("");
                                label5.setText("");
                                label6.setText("");
                            }
                            else{
                                String book_name = resultSet.getString("Book_Name");
                                String query2 = "Insert into IssueBooks values(now(), '" + book_id + "', '" + book_name + "', '" + issued_to + "', '" + library_id + "')";
                                statement.executeUpdate(query2);
                                String query3 = "Update books set No_of_copies = No_of_copies-1 where Book_ID='"+book_id+"'";
                                statement.executeUpdate(query3);
                                label5.setText("");
                                label4.setText("");
                                label6.setText("Book Issued");
                            }
                        }
                    }
                }
                catch (SQLException se){
                    se.printStackTrace();
                }
            }
        });
        jf.setSize(450, 300);
        jf.setLayout(null);
        jf.setVisible(true);
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
