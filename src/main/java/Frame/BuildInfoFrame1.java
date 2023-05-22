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
import java.io.IOException;
import java.net.URL;

public class BuildInfoFrame1 extends JFrame {
    JLabel titleLabel;
    JLabel buildingImageLabel;
    JTextArea descriptionTextArea;
    
    public BuildInfoFrame1(String buildingName) {
        super("건물 정보 - " + buildingName);
        
        // Set the size of the frame to 800x600
        setSize(800, 600);
        
        getContentPane().setBackground(new Color(255, 255, 255));
        // Set the layout to null
        setLayout(null);
        
        // Create and add the title label to the top
        titleLabel = new JLabel("건물 정보 - " + buildingName);
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0, 0, 800, 40);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(103, 78, 167));
        add(titleLabel);
        
        // Create and add the building image label
        buildingImageLabel = new JLabel();
        buildingImageLabel.setBounds(100, 70, 600, 300);
        try {
            URL imageUrl = new URL("https://www.deu.ac.kr/site/resource/www/images/campus-img01.jpg");
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
        
        // Set the default close operation and make the frame visible
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
