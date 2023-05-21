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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BuildInfoFrame extends JFrame {
    private JLabel buildingNameTextField;
    private JLabel buildingImageTextField;
    private JTextArea buildingInfoTextArea;
    private JComboBox<String> ratingComboBox;
    private JTextArea postTextArea;
    private JButton submitButton;
    private JLabel buildingImageLabel;

    public BuildInfoFrame(String buildingName, String buildingInfo) {
        super("Building Information");
        setLayout(null);

        // Building Name
        JLabel buildingNameLabel = new JLabel("Building Name:");
        buildingNameLabel.setBounds(30, 30, 120, 25);
        buildingNameTextField = new JLabel(buildingName);
        buildingNameTextField.setBounds(160, 30, 200, 25);

        // Building Image
        JLabel buildingImageLabel = new JLabel("Building Image:");
        buildingImageLabel.setBounds(30, 70, 120, 25);
        buildingImageTextField = new JLabel();
        buildingImageTextField.setBounds(160, 70, 400, 300); // Update the bounds to increase the size
        buildingImageTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // Building Info
        JLabel buildingInfoLabel = new JLabel("Building Info:");
        buildingInfoLabel.setBounds(30, 380, 120, 25);
        buildingInfoTextArea = new JTextArea(buildingInfo);
        buildingInfoTextArea.setBounds(160, 380, 200, 100);
        buildingInfoTextArea.setBackground(new Color(240, 240, 240));
        buildingInfoTextArea.setForeground(Color.BLACK);
        buildingInfoTextArea.setEditable(false);

        // Rating
        JLabel ratingLabel = new JLabel("Rating:");
        ratingLabel.setBounds(30, 500, 60, 25);
        String[] ratingValues = { "★", "★★", "★★★", "★★★★", "★★★★★" };
        ratingComboBox = new JComboBox<>(ratingValues);
        ratingComboBox.setBounds(160, 500, 100, 25);

        // Post
        JLabel postLabel = new JLabel("Post:");
        postLabel.setBounds(30, 540, 60, 25);
        postTextArea = new JTextArea();
        postTextArea.setBounds(160, 540, 260, 150);
        postTextArea.setBackground(new Color(255, 255, 235));
        postTextArea.setForeground(Color.BLACK);

        // Submit Button
        submitButton = new JButton("Submit");
        submitButton.setBounds(200, 700, 100, 30);

        add(buildingNameLabel);
        add(buildingNameTextField);
        add(buildingImageLabel);
        add(buildingImageTextField);
        add(buildingInfoLabel);
        add(buildingInfoTextArea);
        add(ratingLabel);
        add(ratingComboBox);
        add(postLabel);
        add(postTextArea);
        add(submitButton);

        Color b = new Color(255, 255, 255);
        getContentPane().setBackground(b);
        setSize(600, 800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void setBuildingImage(Image image) {
        buildingImageTextField.setIcon(new ImageIcon(image));
    }
}

