/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author LG
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import login.SignUpSystem;
import model.userData.User;
import model.userData.UserDAO;

public class SignUpForm extends JFrame {

    JLabel titleLabel, idLabel, pwLabel, nameLabel, infoLabel;
    JTextField idText, nameText;
    JPasswordField pwText, pwCheckText;
    JButton registerButton, backButton, idDuplicateButton;
    SignUpSystem signUpSystem;
    JOptionPane jOptionPane;

    public SignUpForm() {
        super("회원가입");

        signUpSystem = new SignUpSystem();
        // Set the layout to null
        setLayout(null);

        // Set the size of the frame to 800x600
        setSize(800, 600);

        // 배경색
        getContentPane().setBackground(new Color(255, 255, 255));
        jOptionPane = new JOptionPane();
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
        idText.setBorder(BorderFactory.createTitledBorder("ID"));
        panel.add(idText);

        idDuplicateButton = new JButton("ID 중복확인");
        idDuplicateButton.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        idDuplicateButton.setForeground(Color.WHITE);
        idDuplicateButton.setBackground(new Color(125, 105, 167));
        idDuplicateButton.setBounds(350, 90, 100, 30);
        idDuplicateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the login frame here
                if (idText.getText().equals("")) {
                    jOptionPane.showMessageDialog(null, "아이디를 입력해 주세요!");
                } else {
                    if (signUpSystem.cheackInfo(idText.getText())) {
                        jOptionPane.showMessageDialog(null, "사용 가능한 아이디 입니다!");
                    } else {
                        jOptionPane.showMessageDialog(null, "이미 사용중인 아이디 입니다!");
                    }
                }
            }
        });

        panel.add(idDuplicateButton);

        // Create and add the PW password field
        pwText = new JPasswordField();
        pwText.setBounds(135, 150, 200, 40);
        pwText.setBorder(BorderFactory.createTitledBorder("PW"));
        panel.add(pwText);

        pwCheckText = new JPasswordField();
        pwCheckText.setBounds(135, 220, 200, 40);
        pwCheckText.setBorder(BorderFactory.createTitledBorder("PW확인"));
        panel.add(pwCheckText);

        nameText = new JTextField();
        nameText.setBounds(135, 290, 200, 40);
        nameText.setBorder(BorderFactory.createTitledBorder("이름")); // Add title to the text field
        panel.add(nameText);

        //가입
        registerButton = new JButton("등록");
        registerButton.setFont(new Font("맑은 고딕", Font.PLAIN, 16)); // 맑은 고딕 폰트
        registerButton.setBounds(290, 350, 120, 40);
        registerButton.setBackground(new Color(125, 105, 167)); // 약간 연한 보라색
        registerButton.setForeground(Color.WHITE);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the login frame here
                String id = idText.getText();
                String pw = pwText.getText();
                String name = nameText.getText();
                if (id.equals("") || pw.equals("") || name.equals("")) {
                    jOptionPane.showMessageDialog(null, "정보를 입력해 주세요!");
                } else if (!pw.equals(pwCheckText.getText())) {
                    jOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다!");
                } else {
                    signUpSystem.registerUser(new User(id, pw, name));
                    jOptionPane.showMessageDialog(null, "가입 성공!");
                    dispose();
                }
            }
        });
        panel.add(registerButton);

        // Create and add the back button
        backButton = new JButton("닫기");
        backButton.setFont(new Font("맑은 고딕", Font.PLAIN, 16)); // 맑은 고딕 폰트
        backButton.setBounds(70, 350, 120, 40);
        backButton.setBackground(new Color(125, 105, 167)); // 약간 연한 보라색
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(backButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

}
