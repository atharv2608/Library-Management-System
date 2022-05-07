package Library;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminLogin {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Admin Login");
        JLabel label1 = new JLabel("Admin Login");
        JLabel label2 = new JLabel("Enter Username");
        JLabel label3 = new JLabel("Enter Password");
        JLabel label4 = new JLabel();
        label4.setForeground(Color.red);
        label4.setFont(new Font("Serif", Font.BOLD, 18 ));

        JLabel label5 = new JLabel();
        label5.setForeground(Color.red);
        label5.setFont(new Font("Serif", Font.BOLD, 18 ));

        JTextField textField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton button = new JButton("Login");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                String password = String.valueOf(passwordField.getPassword());
                if(name.equals("") && password.equals("")){
                    label5.setText("Please fill all details");
                    label4.setText("");
                }
                else if(name.equals("Admin") && password.equals("@Admin123")){
                    AdminSuccess.main(new String[]{});
                    jf.dispose();
                }
                else {
                    label4.setText("Invalid username or password");
                    label5.setText("");
                    textField.setText("");
                    passwordField.setText("");
                }
            }
        });

        label1.setBounds(140,10,200,30);
        label2.setBounds(10,50,180,30);
        textField.setBounds(140,50,120,25);
        label3.setBounds(10,100,180,30);
        passwordField.setBounds(140,100,120,25);
        button.setBounds(135,160,80,30);
        label4.setBounds(90,200,400,30);
        label5.setBounds(110,200,400,30);

        jf.add(label1);
        jf.add(label2);
        jf.add(textField);
        jf.add(label3);
        jf.add(label4);
        jf.add(label5);
        jf.add(passwordField);
        jf.add(button);

        jf.setSize(400,300);
        jf.setLayout(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
