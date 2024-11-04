package ATM;

import java.awt.*;
import javax.swing.*;

public class GUI {
    public static Color backgroundColor = Color.decode("#FFCC99");
    public static Color color2 = Color.decode("#2C3359");      
    public static Color mainColor = Color.decode("#99CCFF");  
    public static Color foregroundColor = Color.decode("#E8F8F9");

    public static JButton JButton(String content, Color backgroundColor) {
        JButton btn = new JButton(content);
        btn.setBackground(backgroundColor);  
        btn.setFont(new Font("SansSerif", Font.BOLD, 23));
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        return btn;
    }

    public static JTextField jTextField() {
        JTextField textField = new JTextField();
        textField.setFont(new Font("SansSerif", Font.BOLD, 23));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setForeground(color2);
        return textField;
    }

    public static JPasswordField jPasswordField() {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font("SansSerif", Font.BOLD, 23));
        passwordField.setHorizontalAlignment(JTextField.CENTER);
        passwordField.setForeground(color2);
        return passwordField;
    }

    public static JLabel jLabel(String content, int textSize) {
        JLabel label = new JLabel(content);
        label.setFont(new Font("SansSerif", Font.BOLD, textSize));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(color2);
        return label;
    }
}
