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
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import login.Observer;
import model.building.BuInfo;
import model.building.Building;
import model.userData.User;

public class BuildingForm extends JFrame implements Observer {

    JLabel titleLabel;
    JLabel buildingImageLabel;
    JTextArea descriptionTextArea;
    JTable bulletinBoardTable;
    DefaultTableModel boardTableModel;
    JButton postButton;
    Building building;
    int buNo;
    User user;

    public BuildingForm(Building building, User user) {
        super(building.getBuName() + " 건물 정보");
        this.buNo = buNo;
        this.building = building;
        this.user = user;
        setSize(1150, 600);

        getContentPane().setBackground(new Color(255, 255, 255));
        // Set the layout to null
        setLayout(null);

        // Create and add the title label to the top
        titleLabel = new JLabel(building.getBuName() + "(" + building.getBuNo() + ")");
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0, 0, 1150, 40);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(103, 78, 167));
        add(titleLabel);

        // Create and add the building image label
        buildingImageLabel = new JLabel();
        buildingImageLabel.setBounds(100, 70, 600, 300);
        try {
            URL imageUrl = new URL(building.getBuImage());
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            Image image = imageIcon.getImage();
            Image scaledImage = image.getScaledInstance(600, 300, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImage);
            buildingImageLabel.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        add(buildingImageLabel);

        //게시글 작성 버튼
        postButton = new JButton("게시글 작성");
        postButton.setBounds(970, 520, 150, 30);
        postButton.setBackground(new Color(125, 105, 167)); // 연한 보라색
        postButton.setForeground(Color.WHITE);
        postButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreatePostForm();
            }
        });

        add(postButton);

        // Create and add the description text area
        descriptionTextArea = new JTextArea();
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setWrapStyleWord(true);
        descriptionTextArea.setText(setExpalain());

        JScrollPane descriptionScrollPane = new JScrollPane(descriptionTextArea);
        descriptionScrollPane.setBounds(100, 400, 600, 150);
        add(descriptionScrollPane);

        //게시글
        String[] boardColums = {"작성자", "제목", "작성일"};
        boardTableModel = new DefaultTableModel(null, boardColums);
        bulletinBoardTable = new JTable(boardTableModel);
        bulletinBoardTable.setEnabled(false);
        bulletinBoardTable.setBackground(Color.WHITE);
        JScrollPane bulletinBoardScrollPane = new JScrollPane(bulletinBoardTable);
        bulletinBoardScrollPane.setBounds(720, 70, 400, 440);
        bulletinBoardScrollPane.setBorder(BorderFactory.createTitledBorder("최근 게시물"));
        add(bulletinBoardScrollPane);

        // Set the default close operation and make the frame visible
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private String setExpalain() {
        StringBuilder expalain = new StringBuilder();
        expalain.append(building.getBuExplain())
                .append("\n\n");

        for (BuInfo buInfo : building.getBuInfos()) {
            expalain.append(buInfo.getBiFloor()).append(" : ").append(buInfo.getBiName()).append("\n\n");
        }
        return expalain.toString();
    }

    @Override
    public void update(User user) {
        this.user = user;
    }
}
