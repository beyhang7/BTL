package ATM;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserData {

    private int ID;

    public UserData(boolean  newAcc, Database database){
        if (newAcc) ID = UsersDatabase.getNextID(database);

        JFrame frame = new JFrame("ATM");
        frame.setLayout(new BorderLayout());

        JLabel title = GUI.jLabel("Welcome to ATM", 30);
        title.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        frame.add(title, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(9, 2 , 15 , 15));
        panel.setBackground(null);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 30, 30 , 30));

        JLabel lb1 =GUI.jLabel("ID:", 23);
        panel.add(lb1);
        JLabel id =GUI.jLabel(String.valueOf(ID), 23);
        panel.add(id);
        JLabel lb2 =GUI.jLabel("Họ:", 23);
        panel.add(lb2);
        JTextField ho =GUI.jTextField();
        panel.add(ho);
        JLabel lb3 =GUI.jLabel("Tên:", 23);
        panel.add(lb3);
        JTextField ten =GUI.jTextField();
        panel.add(ten);
        JLabel lb4 =GUI.jLabel("Ngày Sinh:", 23);
        panel.add(lb4);
        JTextField ns = GUI.jTextField();
        panel.add(ns);
        JLabel lb5 =GUI.jLabel("Email:", 23);
        panel.add(lb5);
        JTextField email = GUI.jTextField();
        panel.add(email);
        JLabel lb6 =GUI.jLabel("Số điện thoại:", 23);
        panel.add(lb6);
        JTextField sdt = GUI.jTextField();
        panel.add(sdt);
        JLabel lb7 =GUI.jLabel("Mã pin:", 23);
        panel.add(lb7);
        JPasswordField pincode = GUI.jPasswordField();
        panel.add(pincode);
        JLabel lb8 =GUI.jLabel("Nhập lại mã pin:", 23);
        panel.add(lb8);
        JPasswordField confirmpincode = GUI.jPasswordField();
        panel.add(confirmpincode);

        JButton confirm = GUI.JButton("Continue", GUI.mainColor);
        
        if (newAcc){
            JButton login = GUI.JButton("Đăng Nhập", GUI.mainColor);
            login.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    new login(database);
                    frame.dispose();

                }

            });
            panel.add(login);

            confirm.addActionListener(new ActionListener() {
                @SuppressWarnings("deprecation")
                @Override
                public void actionPerformed(ActionEvent e){
                    
                    String hoin = ho.getText();
                    String tenin = ten.getText();
                    String nsin = ns.getText();
                    String emailin = email.getText();
                    String sdtin = sdt.getText();
                    int PINcodeIn, confirmPINcodeIn;
                    
                    if(hoin.equals("")){
                        JOptionPane.showMessageDialog(frame, "Vui lòng nhập Họ");
                        return;
                    }
                    if(tenin.equals("")){
                        JOptionPane.showMessageDialog(frame, "Vui lòng nhập Tên");
                        return;
                    }
                    if(nsin.equals("")){
                        JOptionPane.showMessageDialog(frame, "Vui lòng nhập Ngày Sinh");
                        return;
                    }
                    try {
                        LocalDate.parse(ns.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(frame, "Ngày Sinh không hợp lệ");
                        return;
                    }
                    if(emailin.equals("")){
                        JOptionPane.showMessageDialog(frame, "Vui lòng nhập Email");
                        return;
                    }
                    if(sdtin.equals("")){
                        JOptionPane.showMessageDialog(frame, "Vui lòng nhập Số Điện Thoại");
                        return;
                    }
                    try{
                        PINcodeIn = Integer.parseInt(pincode.getText());
                        confirmPINcodeIn = Integer.parseInt(confirmpincode.getText());
                    } catch (Exception e2){
                        JOptionPane.showMessageDialog(frame, "Vui lòng nhập Mã pin");
                        return;
                    }
                    

                    if (PINcodeIn!=confirmPINcodeIn){
                        JOptionPane.showMessageDialog(frame, "Mã pin không khớp");
                        return;
                    }

                    User user = new User();
                    user.setID(ID);
                    user.setHo(hoin);
                    user.setTen(tenin);
                    user.setns(nsin);
                    user.setEmail(emailin);
                    user.setSdt(sdtin);
                    user.setPINcode( PINcodeIn);
                    user.setBalance(0);
                    UsersDatabase.CreateNewAcc(user, database);

                    new List();
                    frame.dispose();

                }
            });
        }
        else{
            JButton cancel = GUI.JButton("HUY", GUI.mainColor);
            cancel.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e){
                    frame.dispose();

                }
                
                
            });
            panel.add(cancel);

            confirm.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
  //                  String 
                }
            });

        }
        panel.add(confirm);
        frame.add(panel, BorderLayout.CENTER);

        frame.setSize(750, 720);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(GUI.backgroundColor);
        frame.setVisible(true);
    }
}