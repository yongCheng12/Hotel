package com.beihua.hotel.test;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author 小虫
 */
public class TestFrame extends JFrame{
    static JTextField TextField;
    static TestFrame testFrame;
    
    public static void main(String args[]){
        testFrame=new TestFrame();
        TextField=new JTextField("                                                                       ");
        JButton button=new JButton("选择文件");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                //--核心代码
                JFileChooser chooser = new JFileChooser("./");
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "文本文档", "txt");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(testFrame);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    TextField.setText(chooser.getSelectedFile().getAbsolutePath());
                }
                //--核心代码结束
            }
        });
        Container contentPane=testFrame.getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(button);
        contentPane.add(TextField);
        testFrame.setSize(300,100);
        testFrame.setVisible(true);
    }
   
}