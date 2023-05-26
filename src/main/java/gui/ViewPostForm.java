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
import model.boardData.Board;
import model.boardData.BoardDAO;
import model.userData.User;

public class ViewPostForm extends JFrame {

    private JLabel titleLabel, viewCountNameLabel, viewCountNumberLabel, authorNameLabel,
            authorTextLabel, userIdNameLabel, userIdTextLabel, dateNameLabel, dateTextLabel;
    private JTextArea contentArea;
    private JButton closeButton, editButton, deleteButton;
    private Font font1 = new Font("맑은 고딕", Font.BOLD, 16);
    private Font font2 = new Font("맑은 고딕", Font.PLAIN, 16);
    private Board board;
    private BoardDAO boardDao;
    private User user;

    public ViewPostForm(Board b) {
        setTitle("게시물 조회");
        setSize(610, 600);
        setLayout(new BorderLayout(0, 5));
        getContentPane().setBackground(Color.WHITE);
        this.board = b;
        boardDao = new BoardDAO();
        titleLabel = new JLabel("게시물 조회");
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 35));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(125, 105, 167));
        add(titleLabel, BorderLayout.NORTH);

        titleLabel = new JLabel("게시물 제목");
        titleLabel.setFont(font1);
        titleLabel.setHorizontalAlignment(SwingConstants.LEFT);

        contentArea = new JTextArea("게시물 내용", 10, 50); // 게시물 내용 출력 칸 늘리기
        contentArea.setFont(font2);
        contentArea.setEditable(false);
        contentArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(contentArea);

        viewCountNameLabel = new JLabel(" 조회수: ");
        viewCountNameLabel.setFont(font1);
        viewCountNumberLabel = new JLabel("0");
        viewCountNumberLabel.setFont(font2);

        authorNameLabel = new JLabel("작성자: ");
        authorNameLabel.setFont(font1);
        authorTextLabel = new JLabel("홍길동");
        authorTextLabel.setFont(font2);

        userIdNameLabel = new JLabel("유저아이디: ");
        userIdNameLabel.setFont(font1);
        userIdTextLabel = new JLabel("userId");
        userIdTextLabel.setFont(font2);

        dateNameLabel = new JLabel("작성일: ");
        dateNameLabel.setFont(font1);
        dateTextLabel = new JLabel("2022-10-01");
        dateTextLabel.setFont(font2);

        closeButton = new JButton("닫기");
        closeButton.setFont(font1);
        closeButton.setBackground(new Color(125, 105, 167));
        closeButton.setForeground(Color.WHITE);
        closeButton.setFocusPainted(false);
        closeButton.setPreferredSize(new Dimension(80, 30));
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (closeButton.getText().equals("닫기")) {
                    dispose();
                } else {
                    board.setBdContent(contentArea.getText());
                    boardDao.update(board.getBdNo(), board);
                    DataPool.getInstance().getBoardData().setStatus(boardDao.findAll());
                    closeButton.setText("닫기");
                }
            }
        });

        editButton = new JButton("수정");
        editButton.setFont(font1);
        editButton.setBackground(new Color(125, 105, 167));
        editButton.setForeground(Color.WHITE);
        editButton.setFocusPainted(false);
        editButton.setPreferredSize(new Dimension(80, 30));
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contentArea.setEditable(true);
                editButton.setVisible(false);
                closeButton.setText("저장");
            }
        });

        deleteButton = new JButton("삭제");
        deleteButton.setFont(font1);
        deleteButton.setBackground(new Color(125, 105, 167));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFocusPainted(false);
        deleteButton.setPreferredSize(new Dimension(80, 30));
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boardDao.deleteById(board.getBdNo());
                DataPool.getInstance().getBoardData().setStatus(boardDao.findAll());
                dispose();
            }
        });

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        infoPanel.setBackground(Color.WHITE);
        infoPanel.add(titleLabel);
        infoPanel.add(scrollPane);
        infoPanel.add(Box.createVerticalStrut(2));

        JPanel viewCountPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        viewCountPanel.add(viewCountNameLabel);
        viewCountPanel.add(viewCountNumberLabel);
        viewCountPanel.setBackground(Color.WHITE);
        infoPanel.add(viewCountPanel);

        JPanel authorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        authorPanel.add(authorNameLabel);
        authorPanel.add(authorTextLabel);
        authorPanel.setBackground(Color.WHITE);
        infoPanel.add(authorPanel);

        JPanel userIdPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        userIdPanel.add(userIdNameLabel);
        userIdPanel.add(userIdTextLabel);
        userIdPanel.setBackground(Color.WHITE);
        infoPanel.add(userIdPanel);

        JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        datePanel.add(dateNameLabel);
        datePanel.add(dateTextLabel);
        datePanel.setBackground(Color.WHITE);
        infoPanel.add(datePanel);

        JPanel closeButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        closeButtonPanel.setBackground(Color.WHITE);
        closeButtonPanel.add(editButton);
        closeButtonPanel.add(deleteButton);
        closeButtonPanel.add(closeButton);

        add(infoPanel, BorderLayout.CENTER);
        add(closeButtonPanel, BorderLayout.SOUTH);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        initPost();
        setVisible(true);
    }

    private void initPost() {
        user = DataPool.getInstance().getLoginData().getUser();
        board.setBdViewCnt(board.getBdViewCnt() + 1);
        titleLabel.setText(board.getBdTitle());
        contentArea.setText(board.getBdContent());
        viewCountNumberLabel.setText(Integer.toString(board.getBdViewCnt()));
        authorTextLabel.setText(board.getUserName());
        userIdTextLabel.setText(board.getUserId());
        dateTextLabel.setText(board.getBdDate().toString());
        boardDao.update(board.getBdNo(), board);

        DataPool.getInstance().getBoardData().setStatus(boardDao.findAll());
        if (user != null && (user.getId().equals(board.getUserId()) || user.getId().equals("admin"))) {
            deleteButton.setVisible(true);
            editButton.setVisible(true);
            System.out.println("true");
        } else {
            deleteButton.setVisible(false);
            editButton.setVisible(false);
            System.out.println("false");
        }
    }
}
