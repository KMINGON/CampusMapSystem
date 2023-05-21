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

public class SignUpFrame extends JFrame {
    private JLabel idLabel;
    private JTextField idText;
    private JButton duplicateCheckButton;
    private JLabel pwLabel;
    private JPasswordField pwText;
    private JLabel nameLabel;
    private JTextField nameText;
    private JButton registerButton;
    
    public SignUpFrame() {
        super("회원가입");
        setLayout(null); // Using absolute positioning
        
        idLabel = new JLabel("ID:");
        idText = new JTextField(20);
        duplicateCheckButton = new JButton("중복확인");
        pwLabel = new JLabel("PW:");
        nameLabel = new JLabel("이름");
        nameText = new JTextField(20);
        pwText = new JPasswordField(20);
        registerButton = new JButton("회원가입");
        
        idLabel.setBounds(70, 50, 50, 25);
        idText.setBounds(110, 50, 200, 25);
        duplicateCheckButton.setBounds(320, 50, 95, 25);
        pwLabel.setBounds(70, 100, 50, 25);
        pwText.setBounds(110, 100, 200, 25);
        nameLabel.setBounds(70, 150, 50, 25);
        nameText.setBounds(110, 150, 200, 25);
        registerButton.setBounds(150, 220, 120, 25);

        
        add(idLabel);
        add(idText);
        add(duplicateCheckButton);
        add(pwLabel);
        add(pwText);
        add(nameLabel);
        add(nameText);
        add(registerButton);
        
        Color b = new Color(255, 255, 255);
        getContentPane().setBackground(b);
        setSize(440, 330);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
}
    
    