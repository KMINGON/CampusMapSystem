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

public class LoginFrame extends JFrame {
    JLabel titleLabel, idLabel, pwLabel;
    JTextField idText;
    JPasswordField pwText;
    JButton loginButton, signUpButton;

    public LoginFrame() {
        super("로그인");

        // Set the layout to null
        setLayout(null);

        // Set the size of the frame to 800x600
        setSize(800, 600);

        // 배경색
        getContentPane().setBackground(new Color(255, 255, 255));

        // Create and add the title label to the top
        titleLabel = new JLabel("로그인");
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 35)); // 맑은 고딕 폰트
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0, 0, 800, 40);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(103, 78, 167));
        add(titleLabel);

        JPanel panel = new JPanel();
        panel.setBounds(160, 200, 480, 200);
        panel.setBorder(BorderFactory.createLineBorder(new Color(103, 78, 167), 4)); // Set border color and thickness
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        add(panel);

        // Create and add the ID text field
        idText = new JTextField();
        idText.setBounds(70, 40, 200, 40);
        idText.setBorder(BorderFactory.createTitledBorder("ID")); // Add title to the text field
        panel.add(idText);

        // Create and add the PW password field
        pwText = new JPasswordField();
        pwText.setBounds(70, 90, 200, 40);
        pwText.setBorder(BorderFactory.createTitledBorder("PW")); // Add title to the password field
        panel.add(pwText);

        // Create and add the login button
        loginButton = new JButton("로그인");
        loginButton.setFont(new Font("맑은 고딕", Font.PLAIN, 16)); // 맑은 고딕 폰트
        loginButton.setBounds(300, 45, 110, 40);
        loginButton.setBackground(new Color(125, 105, 167)); // 약간 연한 보라색
        loginButton.setForeground(Color.WHITE);
        panel.add(loginButton);

        // Create and add the sign-up button
        signUpButton = new JButton("회원가입");
        signUpButton.setFont(new Font("맑은 고딕", Font.PLAIN, 16)); // 맑은 고딕 폰트
        signUpButton.setBounds(300, 95, 110, 40);
        signUpButton.setBackground(new Color(125, 105, 167)); // 약간 연한 보라색
        signUpButton.setForeground(Color.WHITE);
        panel.add(signUpButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Add action listener to the sign-up button
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the sign-up frame here
                dispose(); // Close the login frame
                new SignUpFrame();
            }
        });
        
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the sign-up frame here
                dispose(); // Close the login frame
                new MainFrame();
            }
        });
    }
}

