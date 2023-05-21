package cse.design_pattern.noticeboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class writepostFrame extends JFrame {
    private JButton write, cancel;
    private JTextArea content;
    private JScrollPane jScrollPane2;
    private JLabel title, writing;
    private JTextField titlewrite;

    public writepostFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")                       
    private void initComponents() {

        title = new JLabel();
        titlewrite = new JTextField();
        write = new JButton();
        cancel = new JButton();
        writing = new JLabel();
        jScrollPane2 = new JScrollPane();
        content = new JTextArea();

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        title.setText("제목: ");

        titlewrite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titlewriteActionPerformed(evt);
            }
        });

        write.setText("작성");

        cancel.setText("취소");

        writing.setText("글 쓰기");

        content.setColumns(20);
        content.setRows(5);
        jScrollPane2.setViewportView(content);
        
        Font font1 = new Font("맑은 고딕", Font.BOLD,13);
        Font font2 = new Font("맑은 고딕", Font.PLAIN,13);
        title.setFont(font1);
        titlewrite.setFont(font2);
        write.setFont(font1);
        cancel.setFont(font1);
        writing.setFont(font1);
        jScrollPane2.setFont(font1);
        content.setFont(font2);
        

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(title)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titlewrite, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(writing)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 467, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(write)
                        .addGap(18, 18, 18)
                        .addComponent(cancel)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(writing)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(titlewrite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(title))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(write)
                    .addComponent(cancel))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
        setVisible(true);
        
    }                     

    private void titlewriteActionPerformed(java.awt.event.ActionEvent evt) {                                               
    }  
    
    private void cancelActionPerformed(ActionEvent evt) {
    dispose();
    }
    
}




