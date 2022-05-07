package Library;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AdminSuccess {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Admin Section");
        JLabel label = new JLabel("Admin Section");
        JButton button1 = new JButton("Add Librarian");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddLibrarian.main(new String[]{});

            }
        });

        JButton button2 = new JButton("View Librarians");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewLibrarian.main(new String[]{});
            }
        });

        JButton button3 = new JButton("Delete Librarian");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteLibrarian.main(new String[]{});

            }
        });

        JButton button4 = new JButton("Logout");
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(jf,"Do you want to logout?");
                if(response == JOptionPane.YES_OPTION){
                    AdminLogin.main(new String[]{});
                    jf.dispose();
                }

            }
        });

        label.setBounds(140,10,200,30);
        button1.setBounds(95,70,170,30);
        button2.setBounds(95,140,170,30);
        button3.setBounds(95,210,170,30);
        button4.setBounds(95,280,170,30);

        jf.add(label);
        jf.add(button1);
        jf.add(button2);
        jf.add(button3);
        jf.add(button4);
        jf.setSize(400,400);
        jf.setLayout(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
