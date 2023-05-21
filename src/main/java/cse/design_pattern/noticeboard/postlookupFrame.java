package cse.design_pattern.noticeboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class postlookupFrame extends JFrame {
     private JLabel titleLabel = new JLabel("게시물 제목");
    private JTextArea contentArea = new JTextArea("게시물 내용");
    private JLabel viewCountLabel = new JLabel("조회수: 0");
    private JLabel authorLabel = new JLabel("작성자 이름");
    private JLabel dateLabel = new JLabel("작성 일자");
    private JButton closeButton = new JButton("닫기");
    public postlookupFrame() {
        initComponents();
    }

    private void initComponents() {
        setTitle("게시물 조회");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(245, 245, 245));

        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setBounds(20, 20, 560, 30);
        panel.add(titleLabel);

        contentArea.setEditable(false);
        contentArea.setWrapStyleWord(true);
        contentArea.setLineWrap(true);
        contentArea.setFont(new Font("Arial", Font.PLAIN, 20));
        contentArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentArea.setBounds(20, 70, 560, 140);
        contentArea.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));

        JScrollPane scroll = new JScrollPane(contentArea);
        scroll.setBorder(null);
        scroll.setBounds(20, 70, 560, 140);
        panel.add(scroll);

        viewCountLabel.setBounds(20, 240, 100, 20);
        panel.add(viewCountLabel);

        authorLabel.setBounds(200, 240, 100, 20);
        panel.add(authorLabel);

        dateLabel.setBounds(380, 240, 200, 20);
        panel.add(dateLabel);

        closeButton.setBounds(260, 300, 80, 30);
        closeButton.setBorder(null);
        closeButton.setBackground(new Color(50, 150, 255));
        closeButton.setForeground(Color.WHITE);
        panel.add(closeButton);

        getContentPane().add(panel);
        setVisible(true);
    }
}



                            


                       

        
