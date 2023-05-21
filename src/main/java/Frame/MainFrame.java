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

public class MainFrame extends JFrame {
    private JComboBox<String> searchCategoryComboBox;
    private JTextField searchField;
    private JButton searchButton;
    private JLabel mapArea;
    private JTable popularPostsTable;
    private JTable buildingInfoTable;
    private JScrollPane popularPostsScrollPane;
    private JScrollPane buildingInfoScrollPane;

    public MainFrame() {
        super("main");
        setLayout(null);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        this.setLayout(null);

        ImageIcon logo = new ImageIcon("../Frame/src/image/campus-img00.jpg");


        // Search Components
        String[] searchCategories = {"Category", "Name"};
        searchCategoryComboBox = new JComboBox<>(searchCategories);
        searchCategoryComboBox.setBounds(30, 30, 100, 25);

        searchField = new JTextField();
        searchField.setBounds(140, 30, 300, 25);

        searchButton = new JButton("Search");
        searchButton.setBounds(450, 30, 80, 25);

        // Map Area
        mapArea = new JLabel();
        mapArea.setBounds(30, 70, 505, 400);
        
        

        // Popular Posts Table
        popularPostsTable = new JTable();
        popularPostsScrollPane = new JScrollPane(popularPostsTable);
        popularPostsScrollPane.setBounds(30, 480, 250, 200);

        // Building Info Table
        buildingInfoTable = new JTable();
        buildingInfoScrollPane = new JScrollPane(buildingInfoTable);
        buildingInfoScrollPane.setBounds(285, 480, 250, 200);

        add(searchCategoryComboBox);
        add(searchField);
        add(searchButton);
        add(mapArea);
        add(popularPostsScrollPane);
        add(buildingInfoScrollPane);
        
        Color b = new Color(255, 255, 255);
        getContentPane().setBackground(b);
        setSize(580, 730);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame frame = new MainFrame();
            }
        });
    }
}

