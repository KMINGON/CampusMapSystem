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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SignUpFrame extends JFrame {
    JLabel titleLabel, idLabel, pwLabel, nameLabel, infoLabel;
    JTextField idText, nameText;
    JPasswordField pwText;
    JButton registerButton, backButton;

    public SignUpFrame() {
        super("회원가입");

        // Set the layout to null
        setLayout(null);

        // Set the size of the frame to 800x600
        setSize(800, 600);

        // 배경색
        getContentPane().setBackground(new Color(255, 255, 255));

        // Create and add the title label to the top
        titleLabel = new JLabel("회원가입");
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 35)); // 맑은 고딕 폰트
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0, 0, 800, 40);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(103, 78, 167));
        add(titleLabel);

        JPanel panel = new JPanel();
        panel.setBounds(160, 100, 480, 400);
        panel.setBorder(BorderFactory.createLineBorder(new Color(103, 78, 167), 4)); // Set border color and thickness
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        add(panel);

        // Add the info label at the top
        infoLabel = new JLabel("정보를 기입해 주세요");
        infoLabel.setFont(new Font("맑은 고딕", Font.BOLD, 28)); // 맑은 고딕 폰트
        infoLabel.setForeground(new Color(103, 78, 167));
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        infoLabel.setBounds(0, 20, 480, 40);
        panel.add(infoLabel);

        // Create and add the ID text field
        idText = new JTextField();
        idText.setBounds(135, 80, 200, 40);
        idText.setBorder(BorderFactory.createTitledBorder("ID")); // Add title to the text field
        panel.add(idText);

        // Create and add the PW password field
        pwText = new JPasswordField();
        pwText.setBounds(135, 150, 200, 40);
        pwText.setBorder(BorderFactory.createTitledBorder("PW")); // Add title to the password field
        panel.add(pwText);

        // Create and add the Name text field
        nameText = new JTextField();
        nameText.setBounds(135, 220, 200, 40);
        nameText.setBorder(BorderFactory.createTitledBorder("이름")); // Add title to the text field
        panel.add(nameText);

        // Create and add the register button
        registerButton = new JButton("등록");
        registerButton.setFont(new Font("맑은 고딕", Font.PLAIN, 16)); // 맑은 고딕 폰트
        registerButton.setBounds(290, 300, 120, 40);
        registerButton.setBackground(new Color(125, 105, 167)); // 약간 연한 보라색
        registerButton.setForeground(Color.WHITE);
        panel.add(registerButton);

        // Create and add the back button
        backButton = new JButton("뒤로 가기");
        backButton.setFont(new Font("맑은 고딕", Font.PLAIN, 16)); // 맑은 고딕 폰트
        backButton.setBounds(70, 300, 120, 40);
        backButton.setBackground(new Color(125, 105, 167)); // 약간 연한 보라색
        backButton.setForeground(Color.WHITE);
        panel.add(backButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the sign-up frame here
                dispose(); // Close the login frame
                new LoginFrame();
            }
        });

    }
}
