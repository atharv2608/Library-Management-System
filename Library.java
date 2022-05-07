package Library;
import javax.swing.*;
import java.awt.event.*;

public class Library {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Library Management");
        JLabel label = new JLabel("Library Management");
        JButton button1 = new JButton("Admin Login");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminLogin.main(new String[]{});
                jf.dispose();
            }
        });
        JButton button2 = new JButton("Librarian Login");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LibrarianLogin.main(new String[]{});
                jf.dispose();
            }
        });

        label.setBounds(125,10,200,30);
        button1.setBounds(95,70,170,30);
        button2.setBounds(95,140,170,30);

        jf.add(label);
        jf.add(button1);
        jf.add(button2);

        jf.setSize(400,300);
        jf.setLayout(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
