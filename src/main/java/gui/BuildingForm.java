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
import java.io.IOException;
import java.net.URL;
import model.building.Building;

public class BuildingForm extends JFrame{
    JLabel titleLabel;
    JLabel buildingImageLabel;
    JTextArea descriptionTextArea;
    JTable bulletinBoardTable;
    Building building;
    int buNo;

    public BuildingForm(Building building) {
        super(building.getBuName() + " 건물 정보");
        this.buNo = buNo;
        this.building = building;
        setSize(1000, 600);

        getContentPane().setBackground(new Color(255, 255, 255));
        // Set the layout to null
        setLayout(null);

        // Create and add the title label to the top
        titleLabel = new JLabel(building.getBuName());
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0, 0, 1000, 40);
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

        // Create and add the description text area
        descriptionTextArea = new JTextArea();
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setWrapStyleWord(true);
        descriptionTextArea.setText("건물에 대한 설명.");

        JScrollPane descriptionScrollPane = new JScrollPane(descriptionTextArea);
        descriptionScrollPane.setBounds(100, 400, 600, 150);
        add(descriptionScrollPane);

       

        bulletinBoardTable = new JTable();
        bulletinBoardTable.setEnabled(false); 
        bulletinBoardTable.setBackground(Color.WHITE);
        JScrollPane bulletinBoardScrollPane = new JScrollPane(bulletinBoardTable);
        bulletinBoardScrollPane.setBounds(720, 70, 200, 470);
        add(bulletinBoardScrollPane);

        // Set the default close operation and make the frame visible
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
}
