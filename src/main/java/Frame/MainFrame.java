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
import java.awt.event.*;
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
    JButton loginButton;

    public MainFrame() {
        super("메인 화면");

        // Set the layout to null
        setLayout(null);

        setSize(1300, 750);

        // 배경색
        getContentPane().setBackground(new Color(255, 255, 255));

        // 화면 상단 라벨
        titleLabel = new JLabel("메인 화면");
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 35));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0, 0, 1280, 40);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(103, 78, 167));
        add(titleLabel);

        
        searchField = new JTextField();
        searchField.setBounds(390, 60, 500, 30);
        add(searchField);

        
        searchButton = new JButton("검색");
        searchButton.setBounds(910, 60, 100, 30);
        searchButton.setBackground(new Color(125, 105, 167)); // 약간 연한 보라색
        searchButton.setForeground(Color.WHITE);
        add(searchButton);

        // 로그인 버튼
        loginButton = new JButton("로그인");
        loginButton.setBounds(1170, 60, 100, 30);
        loginButton.setBackground(new Color(174, 155, 197)); // 연한 보라색
        loginButton.setForeground(Color.WHITE);
        add(loginButton);
        
        // 로그인 화면으로 이동
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the login frame here
                dispose(); // Close the main frame
                new LoginFrame();
            }
        });

        // 예시 테이블 생성 (건물 정보)
        String[] buildingInfoColumns = {"건물명", "위치"};
        Object[][] buildingInfoData = {{"대학본관", "위치1"}, {"법정관", "위치2"}};
        DefaultTableModel buildingInfoModel = new DefaultTableModel(buildingInfoData, buildingInfoColumns);
        buildingInfoTable = new JTable(buildingInfoModel);
        buildingInfoTable.addMouseListener(this);

        // 인기글 게시판 생성(스크롤 기능)
        popularPostsScrollPane = new JScrollPane(popularPostsTable);
        popularPostsScrollPane.setBounds(1020, 100, 250, 300);
        popularPostsScrollPane.setBorder(BorderFactory.createTitledBorder("인기글 게시판"));
        add(popularPostsScrollPane);

        // 건물 정보 목록(스크롤 기능)
        buildingInfoScrollPane = new JScrollPane(buildingInfoTable);
        buildingInfoScrollPane.setBounds(1020, 400, 250, 300);
        buildingInfoScrollPane.setBorder(BorderFactory.createTitledBorder("건물 정보"));
        add(buildingInfoScrollPane);

        // 캠퍼스 맵 이미지 추가
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

        // 마커 아이콘 추가
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

            
            if (row < buildingInfoTable.getRowCount() && row >= 0 && column < buildingInfoTable.getColumnCount() && column >= 0) {
               
                Object cellValue = buildingInfoTable.getValueAt(row, column);


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
