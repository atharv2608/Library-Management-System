package Library;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddLibrarian {
    static final String DB_URL="jdbc:mysql://localhost/Library";
    static final String USER = "root";
    static final String PASS = "1234";
    public static void main(String[] args) {
        JFrame jf = new JFrame("Add Librarian");
        //Name field
        JLabel label1 = new JLabel("Enter Name");
        JTextField textField1 = new JTextField();
        label1.setBounds(10, 5, 100, 25);
        textField1.setBounds(110, 5, 100, 25);
        jf.add(label1);
        jf.add(textField1);

        //Password field
        JLabel label2 = new JLabel("Enter Password");
        JPasswordField textField2 = new JPasswordField();
        label2.setBounds(10, 35, 100, 25);
        textField2.setBounds(110, 35, 100, 25);
        jf.add(label2);
        jf.add(textField2);

        //Email field
        JLabel label3 = new JLabel("Enter email");
        JTextField textField3 = new JTextField();
        label3.setBounds(10, 65, 100, 25);
        textField3.setBounds(110, 65, 100, 25);
        jf.add(label3);
        jf.add(textField3);

        //Address field
        JLabel label4 = new JLabel("Enter Address");
        JTextArea textArea = new JTextArea(50, 50);
        label4.setBounds(10, 95, 100, 25);
        textArea.setBounds(110, 95, 150, 50);
        jf.add(label4);
        jf.add(textArea);

        //City field
        JLabel label5 = new JLabel("Enter City");
        JTextField textField5 = new JTextField();
        label5.setBounds(10, 160, 100, 25);
        textField5.setBounds(110, 160, 100, 25);
        jf.add(label5);
        jf.add(textField5);

        //Contact field
        JLabel label6 = new JLabel("Contact");
        JTextField textField6 = new JTextField();
        label6.setBounds(10, 190, 100, 25);
        textField6.setBounds(110, 190, 100, 25);
        jf.add(label6);
        jf.add(textField6);

        //Button
        JButton button = new JButton("Submit");
        button.setBounds(10, 230, 100, 25);
        jf.add(button);

        JLabel label7 = new JLabel("");
        label7.setForeground(Color.RED);
        label7.setFont(new Font("Serif", Font.BOLD,18 ));
        label7.setBounds(10,270,200,25);
        jf.add(label7);

        JLabel label8 = new JLabel("");
        label8.setForeground(Color.BLUE);
        label8.setFont(new Font("Serif", Font.BOLD,18 ));
        label8.setBounds(10,270,200,25);
        jf.add(label8);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String name = textField1.getText();
                final String password = textField2.getText();
                final String email = textField3.getText();
                final String address = textArea.getText();
                final String city = textField5.getText();
                final String contact = textField6.getText();
                try{
                    Connection connection=DriverManager.getConnection(DB_URL,USER,PASS);
                    Statement statement = connection.createStatement();
                    String query = "Insert into librarian(Name, Password, Email, Address, City, Contact) " + "values('" + name+"', '"+password+"', '"+email+"', '"+address+"', '"+city+"', '"+contact+"')";
                    if(name.equals("") || password.equals("") || email.equals("") || address.equals("") || city.equals("") || contact.equals(""))
                        label7.setText("Please fill all the details");
                    else {
                        label7.setText("");
                        statement.executeUpdate(query);
                        label8.setText("Librarian Inserted");
                    }
                }
                catch (SQLException se){
                    se.printStackTrace();
                }
            }
        });

        jf.setSize(400, 400);
        jf.setLayout(null);
        jf.setVisible(true);
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
