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
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.building.Building;
import model.building.BuildingDAO;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.DataPool;
import model.boardData.Board;
import model.boardData.BoardDAO;
import observer.Observer;
import model.building.FindByNameBuildingDAO;
import model.userData.User;

public class MainForm extends JFrame implements Observer {

    JLabel titleLabel;
    JLabel userLabel;
    JTextField searchField;
    JButton searchButton;
    JButton viewBuilngButton;
    JTable popularPostsTable;
    DefaultTableModel popularPostsModel;
    JTable buildingInfoTable;
    DefaultTableModel buildingInfoModel;
    JScrollPane popularPostsScrollPane;
    JScrollPane buildingInfoScrollPane;
    JLabel imageLabel;
    ImageIcon markerIcon;
    JLabel markerLabel;
    JButton loginButton;
    JOptionPane jOptionPane;
    BuildingDAO buildingDao;
    List<Building> buildings;
    User user;
    Building building;
    ArrayList<Board> boards;
    BoardDAO boardDao;

    public MainForm() {
        super("메인 화면");

        // Set the layout to null
        setLayout(null);

        setSize(1300, 750);

        //건물 DAO 객체 생성
        buildingDao = new BuildingDAO();
        boardDao = new BoardDAO();
        jOptionPane = new JOptionPane();

        //로그인 옵저버 등록
        DataPool.getInstance().getLoginData().registerObserver(this);
        DataPool.getInstance().getBoardData().registerObserver(this);

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

        userLabel = new JLabel("Guest Mode");
        userLabel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        userLabel.setBounds(1030, 60, 200, 30);
        add(userLabel);

        //검색
        searchField = new JTextField();
        searchField.setBounds(280, 60, 500, 30);
        add(searchField);

        searchButton = new JButton("검색");
        searchButton.setBounds(800, 60, 100, 30);
        searchButton.setBackground(new Color(125, 105, 167)); // 약간 연한 보라색
        searchButton.setForeground(Color.WHITE);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the login frame here
                Building building = new FindByNameBuildingDAO(buildingDao).findByName(searchField.getText());
                if (building == null) {
                    jOptionPane.showMessageDialog(null, "존재하지 않는 건물입니다!");
                } else {
                    int row;
                    if (building.getBuNo() > 4) {
                        row = building.getBuNo() - 2;
                    } else {
                        row = building.getBuNo() - 1;
                    }
                    buildingInfoTable.setRowSelectionInterval(row, row);
                }
            }
        });
        add(searchButton);

        //건물 정보 버튼
        viewBuilngButton = new JButton("건물 정보");
        viewBuilngButton.setBounds(910, 60, 100, 30);
        viewBuilngButton.setBackground(new Color(125, 105, 167)); // 약간 연한 보라색
        viewBuilngButton.setForeground(Color.WHITE);
        viewBuilngButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BuildingForm(building, user);
            }
        });
        add(viewBuilngButton);

        // 로그인 버튼
        loginButton = new JButton("로그인");
        loginButton.setBounds(1170, 60, 100, 30);
        loginButton.setBackground(new Color(125, 105, 167)); // 연한 보라색
        loginButton.setForeground(Color.WHITE);
        add(loginButton);

        // 로그인 화면으로 이동
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the login frame here
                if (user == null) {
                    new SignInForm();
                } else {
                    DataPool.getInstance().getLoginData().setStatus(null);
                }
            }
        });

        // 캠퍼스 맵 이미지 추가
        imageLabel = new JLabel();
        imageLabel.setBounds(10, 100, 1000, 600);
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

        // 테이블 생성 (건물 정보)
        String[] buildingInfoColumns = {"건물명", "건물 번호"};
        buildingInfoModel = new DefaultTableModel(null, buildingInfoColumns);
        showBuildingList();
        buildingInfoTable = new JTable(buildingInfoModel) {
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        //건물 선택 이벤트
        buildingInfoTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = buildingInfoTable.getSelectedRow();
                    if (selectedRow != -1) {
                        building = buildings.get(selectedRow);
                        if (markerLabel != null) {
                            imageLabel.remove(markerLabel);
                            imageLabel.repaint();
                        }
                        int x = building.getBuLocateX();
                        int y = building.getBuLocateY();
                        markerLabel = new JLabel(markerIcon);
                        markerLabel.setBounds(x, y,
                                markerIcon.getIconWidth(), markerIcon.getIconHeight());
                        imageLabel.add(markerLabel);
                        imageLabel.repaint();
                    }
                }
            }
        });
        buildingInfoTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    new BuildingForm(building, user);
                }
            }
        });
        // 인기글 게시판 생성(스크롤 기능)
        String[] popularPostsColumns = {"건물", "작성자", "제목"};
        popularPostsModel = new DefaultTableModel(null, popularPostsColumns);
        showBoard();
        popularPostsTable = new JTable(popularPostsModel) {
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        popularPostsTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = popularPostsTable.getSelectedRow();
                    new ViewPostForm(boards.get(row));
                }
            }
        });

        popularPostsScrollPane = new JScrollPane(popularPostsTable);
        popularPostsScrollPane.setBounds(1020, 100, 250, 300);
        popularPostsScrollPane.setBorder(BorderFactory.createTitledBorder("최근 게시물"));
        add(popularPostsScrollPane);

        // 건물 정보 목록(스크롤 기능)
        buildingInfoScrollPane = new JScrollPane(buildingInfoTable);
        buildingInfoScrollPane.setBounds(1020, 400, 250, 300);
        buildingInfoScrollPane.setBorder(BorderFactory.createTitledBorder("건물 정보"));
        add(buildingInfoScrollPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void showBoard() {
        boards = (ArrayList) boardDao.findAll();
        popularPostsModel.setNumRows(0);
        for (Board board : boards) {
            popularPostsModel.addRow(new Object[]{buildingDao.findById(board.getBdBuildNum()).getBuName(), board.getUserName(), board.getBdTitle()});
        }
    }

    public void showBuildingList() {
        buildings = buildingDao.findAll();
        for (Building building : buildings) {
            buildingInfoModel.addRow(new Object[]{building.getBuName(), building.getBuNo()});
        }
    }

    @Override
    public void update() {
        this.user = DataPool.getInstance().getLoginData().getUser();
        if (user != null) {
            loginButton.setText("로그아웃");
            loginButton.setBackground(new Color(170, 105, 167));
            userLabel.setText("User : " + user.getName());
        } else {
            loginButton.setText("로그인");
            loginButton.setBackground(new Color(125, 105, 167));
            userLabel.setText("Guest Mode");
        }
        showBoard();
        //revalidate();
        //repaint();
    }
}
