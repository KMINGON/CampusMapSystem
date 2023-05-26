/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author LG
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.DataPool;
import model.boardData.BoardBuilder;
import model.boardData.BoardDAO;
import model.userData.User;

public class CreatePostForm extends JFrame {

    private JLabel titleLabel, contentLabel;
    private JTextArea contentArea;
    private JTextField titleField;
    private JButton submitButton, cancelButton;
    private Font font1 = new Font("맑은 고딕", Font.BOLD, 16);
    private Font font2 = new Font("맑은 고딕", Font.PLAIN, 16);
    JOptionPane jOptionPane;
    BoardDAO boardDao;

    public CreatePostForm(User user, int buNo) {
        setTitle("게시물 작성");
        setSize(610, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        boardDao = new BoardDAO();
        jOptionPane = new JOptionPane();
        titleLabel = new JLabel("게시물 작성");
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 35));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0, 0, 600, 40);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(125, 105, 167));
        add(titleLabel);

        contentLabel = new JLabel("제목:");
        contentLabel.setFont(font1);
        contentLabel.setBounds(30, 60, 50, 20);
        add(contentLabel);

        titleField = new JTextField();
        titleField.setFont(font2);
        titleField.setBounds(80, 60, 440, 30);
        add(titleField);

        contentArea = new JTextArea();
        contentArea.setFont(font2);
        contentArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        JScrollPane scrollPane = new JScrollPane(contentArea);
        scrollPane.setBounds(10, 110, 580, 390);
        add(scrollPane);

        submitButton = new JButton("등록");
        submitButton.setFont(font1);
        submitButton.setBackground(new Color(125, 105, 167));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setBounds(410, 520, 80, 30);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (titleField.getText().equals("") && contentArea.getText().equals("")) {
                    jOptionPane.showMessageDialog(null, "내용을 입력해 주세요!");
                } else {
                    boardDao.insert(new BoardBuilder(
                            user.getId(),
                            user.getName(),
                            titleField.getText(),
                            contentArea.getText()).
                            bdBuildNum(buNo).build()
                    );
                    DataPool.getInstance().getBoardData().setStatus(boardDao.findAll());
                    dispose();
                }
            }
        });
        add(submitButton);

        cancelButton = new JButton("취소");
        cancelButton.setFont(font1);
        cancelButton.setBackground(new Color(125, 105, 167));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusPainted(false);
        cancelButton.setBounds(500, 520, 80, 30);
        add(cancelButton);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
