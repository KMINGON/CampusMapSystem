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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import javax.swing.table.DefaultTableModel;

class MainFrame extends JFrame implements MouseListener {
    JLabel titleLabel;
    JTextField searchField;
    JButton searchButton;
    JTable popularPostsTable;
    JTable buildingInfoTable;
    JScrollPane popularPostsScrollPane;
    JScrollPane buildingInfoScrollPane;
    JLabel imageLabel;
    ImageIcon markerIcon;
    JLabel markerLabel;
    JButton boardButton;

    public MainFrame() {
        super("메인 화면");

        // Set the layout to null
        setLayout(null);

        // Set the size of the frame to 1280x720
        setSize(1300, 750);

        // 배경색
        getContentPane().setBackground(new Color(255, 255, 255));

        // Create and add the title label to the top
        titleLabel = new JLabel("메인 화면");
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 35));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0, 0, 1280, 40);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(103, 78, 167));
        add(titleLabel);

        // Create and add the search field
        searchField = new JTextField();
        searchField.setBounds(390, 60, 500, 30);
        add(searchField);

        // Create and add the search button
        searchButton = new JButton("검색");
        searchButton.setBounds(910, 60, 100, 30);
        searchButton.setBackground(new Color(125, 105, 167)); // 약간 연한 보라색
        searchButton.setForeground(Color.WHITE);
        add(searchButton);

        // Create board button
        boardButton = new JButton("게시판");
        boardButton.setBounds(1170, 60, 100, 30);
        boardButton.setBackground(new Color(174, 155, 197)); // 연한 보라색
        boardButton.setForeground(Color.WHITE);
        add(boardButton);

        // Create the building info table
        String[] buildingInfoColumns = {"건물명", "위치"};
        Object[][] buildingInfoData = {{"대학본관", "위치1"}, {"법정관", "위치2"}};
        DefaultTableModel buildingInfoModel = new DefaultTableModel(buildingInfoData, buildingInfoColumns);
        buildingInfoTable = new JTable(buildingInfoModel);
        buildingInfoTable.addMouseListener(this);

        // Create and add the popular posts scroll pane
        popularPostsScrollPane = new JScrollPane(popularPostsTable);
        popularPostsScrollPane.setBounds(1020, 100, 250, 300);
        popularPostsScrollPane.setBorder(BorderFactory.createTitledBorder("인기글 게시판"));
        add(popularPostsScrollPane);

        // Create and add the building info scroll pane
        buildingInfoScrollPane = new JScrollPane(buildingInfoTable);
        buildingInfoScrollPane.setBounds(1020, 400, 250, 300);
        buildingInfoScrollPane.setBorder(BorderFactory.createTitledBorder("건물 정보"));
        add(buildingInfoScrollPane);

        // Create and add the image label
        imageLabel = new JLabel();
        imageLabel.setBounds(10, 100, 1000, 600);
        imageLabel.addMouseListener(this);
        try {
            URL imageUrl = new URL("https://www.deu.ac.kr/site/resource/www/images/campus-img00.jpg");
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            Image image = imageIcon.getImage();
            Image scaledImage = image.getScaledInstance(1000, 600, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImage);
            imageLabel.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        add(imageLabel);

        // Create marker icon
        try {
            URL markerUrl = new URL("https://maps.google.com/mapfiles/kml/shapes/placemark_circle_highlight.png");
            markerIcon = new ImageIcon(markerUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == buildingInfoTable) {
            int column = buildingInfoTable.getColumnModel().getColumnIndexAtX(e.getX());
            int row = e.getY() / buildingInfoTable.getRowHeight();

            // Check if the clicked area is within the table bounds
            if (row < buildingInfoTable.getRowCount() && row >= 0 && column < buildingInfoTable.getColumnCount() && column >= 0) {
                // Get the value of the clicked cell
                Object cellValue = buildingInfoTable.getValueAt(row, column);

                // Perform an action based on the clicked cell value
                if (cellValue != null && cellValue.equals("대학본관")) {
                    // Open Building1Frame
                    SwingUtilities.invokeLater(() -> {
            new BuildInfoFrame1("대학본관");
        });
       
                } else if (cellValue != null && cellValue.equals("법정관")) {
                    // Open Building2Frame
                    SwingUtilities.invokeLater(() -> {
            new BuildInfoFrame2("법정관");
        });
                }
            }
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            int x = e.getX();
            int y = e.getY();

            markerLabel = new JLabel(markerIcon);
            markerLabel.setBounds(x - 10, y - 25, 20, 25);
            imageLabel.add(markerLabel);
            imageLabel.repaint();
        } else if (e.getButton() == MouseEvent.BUTTON1) {
            if (markerLabel != null) {
                imageLabel.remove(markerLabel);
                imageLabel.repaint();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}



    



