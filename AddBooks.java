package Library;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class AddBooks {
    static final String DB_URL="jdbc:mysql://localhost/Library";
    static final String USER = "root";
    static final String PASS = "1234";
    public static void main(String[] args) {
        JFrame jf = new JFrame("Add Books");
        JLabel label1 = new JLabel("Book ID");
        JTextField textField1 = new JTextField();
        label1.setBounds(10, 5, 100, 25);
        textField1.setBounds(110, 5, 100, 25);
        jf.add(label1);
        jf.add(textField1);

        JLabel label2 = new JLabel("Book Name");
        JTextField textField2 = new JTextField();
        label2.setBounds(10, 35, 100, 25);
        textField2.setBounds(110, 35, 100, 25);
        jf.add(label2);
        jf.add(textField2);

        JLabel label3 = new JLabel("Author Name");
        JTextField textField3 = new JTextField();
        label3.setBounds(10, 65, 100, 25);
        textField3.setBounds(110, 65, 100, 25);
        jf.add(label3);
        jf.add(textField3);

        JLabel label4 = new JLabel("Price");
        JTextField textField4 = new JTextField();
        label4.setBounds(10, 95, 100, 25);
        textField4.setBounds(110, 95, 100, 25);
        jf.add(label4);
        jf.add(textField4);

        JLabel label5 = new JLabel("No. of Copies");
        JTextField textField5 = new JTextField();
        label5.setBounds(10,127,100,25);
        textField5.setBounds(110,127,50,25);
        jf.add(label5);
        jf.add(textField5);

        JLabel label6 = new JLabel();
        label6.setBounds(10,195,200,25);
        label6.setFont(new Font("Serif", Font.BOLD, 18));
        label6.setForeground(Color.RED);
        jf.add(label6);

        JLabel label7 = new JLabel();
        label7.setBounds(10,195,200,25);
        label7.setFont(new Font("Serif", Font.BOLD, 18));
        label7.setForeground(Color.BLUE);
        jf.add(label7);

        JLabel label8 = new JLabel();
        label8.setBounds(10,195,400,25);
        label8.setFont(new Font("Serif", Font.BOLD, 18));
        label8.setForeground(Color.RED);
        jf.add(label8);

        JButton button = new JButton("Add Book");
        button.setBounds(10,160,100,25);
        jf.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String book_id = textField1.getText();
                String book_name = textField2.getText();
                String author_name = textField3.getText();
                String price = textField4.getText();
                String noOfBooks = textField5.getText();
                try{
                    Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
                    Statement statement = connection.createStatement();
                    String query1 = "Select * from books where book_id='"+book_id+"'";
                    ResultSet resultSet = statement.executeQuery(query1);
                    String query2 = "Insert into books values('"+book_id+"', '"+book_name+"', '"+author_name+"', '"+price+"', '"+noOfBooks+"')";
                    if(book_id.equals("") || book_name.equals("") || author_name.equals("") || price.equals("") || noOfBooks.equals("")){
                        label6.setText("Please fill all the details");
                        label7.setText("");
                    }
                    else{
                        if (resultSet.next()){
                            label8.setText("Book with similar ID exist in record");
                            label6.setText("");
                            label7.setText("");
                        }
                        else {
                            statement.executeUpdate(query2);
                            label6.setText("");
                            label8.setText("");
                            label7.setText("Book Inserted");
                        }
                    }
                }
                catch (SQLException se){
                    se.printStackTrace();
                }
            }
        });
        jf.setSize(400,400);
        jf.setLayout(null);
        jf.setVisible(true);
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
