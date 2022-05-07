package Library;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ReturnBook {
    static final String DB_URL="jdbc:mysql://localhost/Library";
    static final String USER = "root";
    static final String PASS = "1234";
    public static void main(String[] args) {
        JFrame jf = new JFrame("Return Book");
        JLabel label1 = new JLabel("Book ID");
        JTextField textField1 = new JTextField();
        label1.setBounds(10, 5, 100, 25);
        textField1.setBounds(110, 5, 100, 25);
        jf.add(label1);
        jf.add(textField1);

        JLabel label2 = new JLabel("Returned by");
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

        JButton button = new JButton("Return Book");
        button.setBounds(10,110,130,25);
        jf.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String book_id = textField1.getText();
                String returned_by = textField2.getText();
                String library_id = textField3.getText();
                try {
                    Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
                    Statement statement = connection.createStatement();
                    String query1 = "Select * from issuebooks where Book_Id='"+book_id+"'"+"and Issued_To='"+returned_by+"' and Library_ID='"+library_id+"'";
                    ResultSet resultSet = statement.executeQuery(query1);
                    if(book_id.equals("")  || returned_by.equals("") || library_id.equals("")) {
                        label4.setText("Please Fill All Details");
                    }
                    else{
                        if(!resultSet.next()){
                            label5.setText("No such data in the record");
                            label4.setText("");
                            label6.setText("");
                        }
                        else {
                            label5.setText("");
                            label4.setText("");
                            label6.setText("Book Returned");
                            String query2 = "Delete from issuebooks where Book_Id='"+book_id+"'"+"and Issued_To='"+returned_by+"' and Library_ID='"+library_id+"'";
                            String query3 = "Update books set no_of_copies = no_of_copies+1 where book_id='"+book_id+"'";
                            String book_name = resultSet.getString("Boook_name");
                            String query4 = "Insert into returnbook values(now(), '" + book_id + "', '" + book_name + "', '" + returned_by + "', '" + library_id + "')";
                            statement.executeUpdate(query2);
                            statement.executeUpdate(query3);
                            statement.executeUpdate(query4);

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
