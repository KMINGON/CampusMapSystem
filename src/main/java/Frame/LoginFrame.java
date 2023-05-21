/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frame;

/**
 *
 * @author kiano
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;

public class LoginFrame extends JFrame {
    JLabel idLabel, pwLabel;
    JTextField idText;
    JPasswordField pwText;
    JButton loginButt, signUpButt;
    Font font = new Font("Aharoni 굵게", Font.BOLD, 15);
    public static String userName;
    
    public LoginFrame() {
        super("LOGIN");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        this.setLayout(null);
        
        ImageIcon logo = new ImageIcon("../Frame/src/image/campus-image00.jpg");
        
        idLabel = new JLabel("ID");
        idLabel.setFont(font);
        pwLabel = new JLabel("PW");
        pwLabel.setFont(font);
        idText = new JTextField(20);
        pwText = new JPasswordField(20);
        loginButt = new JButton("로그인");
        loginButt.setFont(font);
        signUpButt = new JButton("회원가입");
        signUpButt.setFont(font);
        
        add(idLabel);
        add(idText);
        add(pwLabel);
        add(pwText);
        add(loginButt);
        add(signUpButt);
        
        Color b = new Color(255, 255, 255);
        getContentPane().setBackground(b);
        setSize(440, 330);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        idLabel.setBounds(50, 50, 50, 25);
        idText.setBounds(100, 50, 220, 25);
        pwLabel.setBounds(50, 100, 50, 25);
        pwText.setBounds(100, 100, 220, 25);
        loginButt.setBounds(100, 170, 100, 30);
        signUpButt.setBounds(220, 170, 100, 30);
    }
        
}
