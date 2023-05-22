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
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MainForm extends JFrame {
    private JComboBox<String> searchCategoryComboBox;
    private JTextField searchField;
    private JButton searchButton;
    private JLabel mapArea;
    private JList<String> popularPostsList;
    private JList<String> buildingInfoList;

    public MainForm() {
        super("Main");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Search Components
        String[] searchCategories = {"Category", "Name"};
        searchCategoryComboBox = new JComboBox<>(searchCategories);
        searchCategoryComboBox.setBounds(30, 30, 100, 25);

        searchField = new JTextField();
        searchField.setBounds(140, 30, 300, 25);

        searchButton = new JButton("Search");
        searchButton.setBounds(450, 30, 80, 25);
        searchButton.setBackground(Color.BLUE);
        searchButton.setForeground(Color.WHITE);

        // Map Area
        mapArea = new JLabel();
        mapArea.setBounds(30, 70, 505, 400);
        mapArea.setBackground(Color.WHITE);
        mapArea.setOpaque(true);

        // Popular Posts List
        String[] popularPosts = {"Post 1", "Post 2", "Post 3"};
        popularPostsList = new JList<>(popularPosts);
        JScrollPane popularPostsScrollPane = new JScrollPane(popularPostsList);
        popularPostsScrollPane.setBounds(30, 480, 250, 200);

        // Building Info List
        String[] buildingInfo = {"Building 1", "Building 2", "Building 3"};
        buildingInfoList = new JList<>(buildingInfo);
        JScrollPane buildingInfoScrollPane = new JScrollPane(buildingInfoList);
        buildingInfoScrollPane.setBounds(285, 480, 250, 200);

        add(searchCategoryComboBox);
        add(searchField);
        add(searchButton);
        add(mapArea);
        add(popularPostsScrollPane);
        add(buildingInfoScrollPane);

        setSize(1280, 720);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainForm frame = new MainForm();
            }
        });
    }
}