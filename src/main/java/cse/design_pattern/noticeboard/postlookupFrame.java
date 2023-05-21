package cse.design_pattern.noticeboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class postlookupFrame extends JFrame {
    private JButton cancel;
    private JLabel date, lookup, title, username,views;
    private JTextField dateTextField, titleTextField, usernameTextField, viewsTextField ;
    private JScrollPane jScrollPane3;
    private JTextArea contentTextArea;
    
    public postlookupFrame() {
        initComponents();
    }

    private void initComponents() {
        jScrollPane3 = new JScrollPane();
        contentTextArea = new JTextArea();
        title = new JLabel();
        username = new JLabel();
        date = new JLabel();
        views = new JLabel();
        lookup = new JLabel();
        titleTextField = new JTextField();
        cancel = new JButton();
        usernameTextField = new JTextField();
        dateTextField = new JTextField();
        viewsTextField = new JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contentTextArea.setColumns(20);
        contentTextArea.setRows(5);
        jScrollPane3.setViewportView(contentTextArea);

        title.setText("글 제목:");

        username.setText("사용자 이름:");

        date.setText("작성일자: ");

        views.setText("조회수:");

        lookup.setText("글 조회");

        cancel.setText("닫기");
        
        
        Font font1 = new Font("맑은 고딕", Font.BOLD,13);
        Font font2 = new Font("맑은 고딕", Font.PLAIN,13);
        
        title.setFont(font1);
        username.setFont(font1);
        date.setFont(font1);
        views.setFont(font1);
        lookup.setFont(font1);
        cancel.setFont(font1);
        dateTextField.setFont(font2);
        titleTextField.setFont(font2);
        usernameTextField.setFont(font2);
        contentTextArea.setFont(font2);
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(date).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 99,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(views).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(viewsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 72,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup().addComponent(lookup)
                                                        .addGap(228, 228, 228))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup().addComponent(cancel)
                                                        .addGap(15, 15, 15))))
                .addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addGroup(layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane3)
                        .addGroup(layout.createSequentialGroup().addComponent(username)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup().addComponent(title)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 410,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(22, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap().addComponent(lookup)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(title).addComponent(titleTextField,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(username).addComponent(usernameTextField,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 334,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(date).addComponent(dateTextField,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(views).addComponent(viewsTextField,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancel).addGap(10, 10, 10)));

        pack();
        setVisible(true);
    }
    
    private void cancelActionPerformed(ActionEvent evt) {
        dispose();
    }
}



                            


                       

        
