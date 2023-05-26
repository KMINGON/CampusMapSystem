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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import observer.Observer;
import model.DataPool;
import model.boardData.Board;
import model.boardData.BoardDAO;
import model.building.BuInfo;
import model.building.Building;
import model.userData.User;

public class BuildingForm extends JFrame implements Observer {

    JLabel titleLabel;
    JLabel buildingImageLabel;
    JLabel userLabel;
    JTextArea descriptionTextArea;
    JTable bulletinBoardTable;
    DefaultTableModel boardTableModel;
    JButton postButton;
    JOptionPane jOptionPane;
    Building building;
    ArrayList<Board> boards;
    ArrayList<Integer> indexs;
    BoardDAO boardDao;
    int buNo;
    User user;

    public BuildingForm(Building building, User u) {
        super(building.getBuName() + " 건물 정보");
        this.buNo = buNo;
        this.building = building;
        this.user = u;
        boardDao = new BoardDAO();
        setSize(1150, 600);

        getContentPane().setBackground(new Color(255, 255, 255));
        // Set the layout to null
        setLayout(null);

        //옵저버 등록
        DataPool.getInstance().getLoginData().registerObserver(this);
        DataPool.getInstance().getBoardData().registerObserver(this);

        jOptionPane = new JOptionPane();
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

        //로그인 상태
        if (user == null) {
            userLabel = new JLabel("Guest Mode");
        } else {
            userLabel = new JLabel("User : " + user.getName());
        }
        userLabel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        userLabel.setBounds(770, 520, 200, 30);
        add(userLabel);

        //게시글 작성 버튼
        postButton = new JButton("게시글 작성");
        postButton.setBounds(970, 520, 150, 30);
        postButton.setBackground(new Color(125, 105, 167)); // 연한 보라색
        postButton.setForeground(Color.WHITE);
        postButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (user != null) {
                    new CreatePostForm(user, building.getBuNo());
                } else {
                    jOptionPane.showMessageDialog(null, "로그인을 해주세요!");
                    new SignInForm();
                }
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

        //게시글 조회
        String[] boardColums = {"작성자", "제목", "조회수", "작성일"};
        boardTableModel = new DefaultTableModel(null, boardColums);
        showBoard();
        bulletinBoardTable = new JTable(boardTableModel) {
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        bulletinBoardTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = bulletinBoardTable.getSelectedRow();
                    new ViewPostForm(boards.get(indexs.get(row)));
                }
            }
        });
        bulletinBoardTable.setBackground(Color.WHITE);
        JScrollPane bulletinBoardScrollPane = new JScrollPane(bulletinBoardTable);
        bulletinBoardScrollPane.setBounds(720, 70, 400, 440);
        bulletinBoardScrollPane.setBorder(BorderFactory.createTitledBorder("최근 게시물"));
        add(bulletinBoardScrollPane);

        // Set the default close operation and make the frame visible
        setVisible(true);
    }
    
    //게시글 출력
    private void showBoard() {
        boards = (ArrayList) boardDao.findAll();
        boardTableModel.setNumRows(0);
        indexs = new ArrayList();
        int index = 0;
        for (Board board : boards) {
            if (board.getBdBuildNum() == building.getBuNo()) {
                indexs.add(index);
                boardTableModel.addRow(new Object[]{board.getUserName(), board.getBdTitle(), board.getBdViewCnt(), board.getBdDate()});
                
            }
            index++;
        }
    }

    //건물 정보 출력
    private String setExpalain() {
        StringBuilder expalain = new StringBuilder();
        expalain.append(building.getBuExplain())
                .append("\n\n");

        for (BuInfo buInfo : building.getBuInfos()) {
            expalain.append(buInfo.getBiFloor()).append(" : ").append(buInfo.getBiName()).append("\n\n");
        }
        return expalain.toString();
    }
    
    //옵저버
    @Override
    public void update() {
        this.user = DataPool.getInstance().getLoginData().getUser();
        if (user != null) {
            userLabel.setText("User : " + user.getName());
        } else {
            userLabel.setText("Guest Mode");
        }

        showBoard();
    }
}
