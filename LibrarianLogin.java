package Library;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LibrarianLogin {
    static final String DB_URL="jdbc:mysql://localhost/Library";
    static final String USER = "root";
    static final String PASS = "1234";
    public static void main(String[] args) {
        JFrame jf = new JFrame("Librarian Login");
        JLabel label1 = new JLabel("Librarian Login");
        JLabel label2 = new JLabel("Enter Username");
        JLabel label3 = new JLabel("Enter Password");
        JLabel label4 = new JLabel();
        label4.setFont(new Font("Serif", Font.BOLD, 18));
        label4.setForeground(Color.RED);

        JLabel label5 = new JLabel();
        label5.setFont(new Font("Serif", Font.BOLD, 18));
        label5.setForeground(Color.RED);

        JLabel label6 = new JLabel();
        label6.setFont(new Font("Serif", Font.BOLD, 18));
        label6.setForeground(Color.RED);

        JTextField textField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton button = new JButton("Login");
        label1.setBounds(140,10,200,30);
        label2.setBounds(10,50,180,30);
        textField.setBounds(140,50,120,25);
        label3.setBounds(10,100,180,30);
        passwordField.setBounds(140,100,120,25);
        button.setBounds(135,160,80,30);
        label4.setBounds(100,200,400,30);
        label5.setBounds(90,200,400,30);
        label6.setBounds(90,200,400,30);

        jf.add(label1);
        jf.add(label2);
        jf.add(textField);
        jf.add(label3);
        jf.add(passwordField);
        jf.add(button);
        jf.add(label4);
        jf.add(label5);
        jf.add(label6);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField.getText();
                String password = passwordField.getText();
                try{
                    Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
                    Statement statement = connection.createStatement();
                    String query = "Select * from librarian where name='"+username+"'";
                    ResultSet resultSet = statement.executeQuery(query);

                    if(username.equals("") || password.equals("")){
                        label4.setText("Please fill all details");
                        label6.setText("");
                    }

                    while (resultSet.next()){
                        String usName = resultSet.getString("Name");
                        String pass = resultSet.getString("Password");
                        if (username.equals(usName) && password.equals(pass)) {
                            LibrarianSuccess.main(new String[]{});
                            jf.dispose();
                        }
                        else{
                            label6.setText("Invalid Username or password");
                            label4.setText("");
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
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
