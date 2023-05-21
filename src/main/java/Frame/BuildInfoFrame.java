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
    private JLabel buildingImageTextField; // Changed to JLabel
    private JTextArea buildingInfoTextArea;
    private JComboBox<String> ratingComboBox;
    private JTextArea postTextArea;
    private JButton submitButton;
    private JLabel buildingImageLabel; // Updated: Declare buildingImageLabel as an instance variable

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
        buildingImageTextField.setBounds(160, 70, 200, 25);
        buildingImageTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // Add border to the label

        // Building Info
        JLabel buildingInfoLabel = new JLabel("Building Info:");
        buildingInfoLabel.setBounds(30, 110, 120, 25);
        buildingInfoTextArea = new JTextArea(buildingInfo);
        buildingInfoTextArea.setBounds(160, 110, 200, 100);
        buildingInfoTextArea.setBackground(new Color(240, 240, 240)); // Set light yellow background color
        buildingInfoTextArea.setForeground(Color.BLACK); // Set font color
        buildingInfoTextArea.setEditable(false); // Make the text area non-editable

        // Rating
        JLabel ratingLabel = new JLabel("Rating:");
        ratingLabel.setBounds(30, 230, 60, 25);
        String[] ratingValues = { "★", "★★", "★★★", "★★★★", "★★★★★" };
        ratingComboBox = new JComboBox<>(ratingValues);
        ratingComboBox.setBounds(160, 230, 100, 25);

        // Post
        JLabel postLabel = new JLabel("Post:");
        postLabel.setBounds(30, 270, 60, 25);
        postTextArea = new JTextArea();
        postTextArea.setBounds(160, 270, 260, 150);
        postTextArea.setBackground(new Color(255, 255, 235)); // Set light yellow background color
        postTextArea.setForeground(Color.BLACK); // Set font color

        // Submit Button
        submitButton = new JButton("Submit");
        submitButton.setBounds(200, 440, 100, 30);

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
        setSize(500, 520);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String buildingName = "건물 이름";
            String buildingInfo = "건물에 대한 정보.";
            BuildInfoFrame frame = new BuildInfoFrame(buildingName, buildingInfo);
            try {
                // Load the image from the file
                BufferedImage image = ImageIO.read(new File("Frame/src/image/campus-img00.jpg"));

                // Update the image size if desired
                int width = 200; // Specify the desired width
                int height = 200; // Specify the desired height
                Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                // Set the scaled image to the label
                frame.setBuildingImage(scaledImage);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    public void setBuildingImage(Image image) {
        buildingImageTextField.setIcon(new ImageIcon(image));
    }
}
