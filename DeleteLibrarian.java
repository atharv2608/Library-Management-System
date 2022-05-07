package Library;
import  javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class DeleteLibrarian {
    static final String DB_URL="jdbc:mysql://localhost/Library";
    static final String USER = "root";
    static final String PASS = "1234";
    public static void main(String[] args) {
        JFrame jf = new JFrame("Delete Librarian");
        JLabel name = new JLabel("Enter the name to be deleted");
        name.setFont(new Font("Times New Roman", Font.BOLD, 18));
        JTextField textField1 = new JTextField();
        textField1.setFont(new Font("Serif", Font.BOLD, 15));
        JButton button = new JButton("Delete");

        name.setBounds(65,25,250,25);
        textField1.setBounds(130,70,100,25);
        button.setBounds(130,110,100,25);

        JLabel label1 = new JLabel();
        label1.setFont(new Font("Serif", Font.BOLD, 18));
        label1.setForeground(Color.red);
        label1.setBounds(50,150,300,25);

        JLabel label2 = new JLabel();
        label2.setFont(new Font("Serif", Font.BOLD, 18));
        label2.setForeground(Color.blue);
        label2.setBounds(110,150,300,25);

        JLabel label3 = new JLabel();
        label3.setFont(new Font("Serif", Font.BOLD, 18));
        label3.setForeground(Color.red);
        label3.setBounds(130,150,300,25);

        jf.add(label1);
        jf.add(label2);
        jf.add(label3);
        jf.add(name);
        jf.add(textField1);
        jf.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                try{
                    Connection connection=DriverManager.getConnection(DB_URL,USER,PASS);
                    Statement statement=connection.createStatement();
                    String query1 = "Select * from librarian where Name='"+name+"'";
                    ResultSet resultSet = statement.executeQuery(query1);
                    if(name.equals("")) {
                        label3.setText("Enter Name");
                        label1.setText("");
                        label2.setText("");
                    }
                    else {
                        if(!resultSet.next()){
                            label1.setText("Librarian doesn't exist in the record");
                            label2.setText("");
                            label3.setText("");
                        }
                        else {
                            String query2 = "Delete from librarian where name='"+name+"'";
                            statement.executeUpdate(query2);
                            label2.setText("Librarian Deleted");
                            label1.setText("");
                            label3.setText("");
                        }
                    }
                }
                catch (SQLException se){
                    se.printStackTrace();
                }
            }
        });

        jf.setSize(400,300);
        jf.setLayout(null);
        jf.setVisible(true);
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
