package ATM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class login {
    public login(Database database) {
        JFrame frame = new JFrame("ATM");
        frame.setLayout(new BorderLayout());

        JLabel title = GUI.jLabel("ATM", 40);
        title.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        frame.add(title, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(3, 2, 15, 15));
        panel.setBackground(null);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 30, 30, 30));

        JLabel lb1 = GUI.jLabel("ID:", 23);
        panel.add(lb1);
        JTextField id = GUI.jTextField();
        panel.add(id);

        JLabel lb2 = GUI.jLabel("MÃ PIN:", 23);
        panel.add(lb2);
        JPasswordField pincode = GUI.jPasswordField();
        panel.add(pincode);

        JButton newAcc = GUI.JButton("Tạo tài khoản", GUI.mainColor);
        newAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserData(true, database);
                frame.dispose();
            }
        });
        panel.add(newAcc);

        JButton login = GUI.JButton("Continue", GUI.mainColor); 
        login.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent e) {
                int idin =0, pincodein = 0;
                try {
                    idin =Integer.parseInt(id.getText());
                    pincodein = Integer.parseInt(pincode.getText());
                }
                catch (Exception e1){
                    JOptionPane.showMessageDialog(frame,"ID & PIN là dạng số");

                }
                
                if (UsersDatabase.login(idin, pincodein, database)){
                    new List();
                    frame.dispose();

                } else{
                    JOptionPane.showMessageDialog(frame,"Mã PIN không xem được");
                }
            }
        });
        panel.add(login);

        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(650, 350);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(GUI.backgroundColor);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
