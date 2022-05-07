package Library;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarianSuccess {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Librarian Section");
        JLabel label = new JLabel("Librarian Section");
        JButton button1 = new JButton("Add Books");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBooks.main(new String[]{});
            }
        });

        JButton button2 = new JButton("View Books");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewBooks.main(new String[]{});
            }
        });

        JButton button3 = new JButton("Issue Books");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IssueBooks.main(new String[]{});
            }
        });

        JButton button4 = new JButton("View Issued Books");
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewIssuedBooks.main(new String[]{});
            }
        });

        JButton button5 = new JButton("Return Book");
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReturnBook.main(new String[]{});
            }
        });

        JButton button6 = new JButton("Logout");
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(jf,"Do you want to logout?");
                if(response == JOptionPane.YES_OPTION){
                    LibrarianLogin.main(new String[]{});
                    jf.dispose();
                }

            }
        });

        label.setBounds(140,10,200,30);
        button1.setBounds(95,60,170,30);
        button2.setBounds(95,110,170,30);
        button3.setBounds(95,160,170,30);
        button4.setBounds(95,210,170,30);
        button5.setBounds(95,260,170,30);
        button6.setBounds(95,310,170,30);

        jf.add(label);
        jf.add(button1);
        jf.add(button2);
        jf.add(button3);
        jf.add(button4);
        jf.add(button5);
        jf.add(button6);

        jf.setSize(400,400);
        jf.setLayout(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
