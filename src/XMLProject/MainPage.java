package XMLProject;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame {
    static  String basePath ;
    static Document document;
    static String filePath;
    static JLabel mainPageMessage;

    MainPage(){

        basePath = JOptionPane.showInputDialog("디렉토리 Path를 입력해주세요");

        // 아무것도 입력 안할 시 Root Page로 설정
        if(basePath.equals("")){
            System.out.println("Root Page "  + System.getProperty("user.home"));
            basePath =System.getProperty("user.home");
        }

        // 버튼 출력 메세지를 나타내는 Label
        mainPageMessage= new JLabel("디렉토리 Path가 \"" + basePath +"\" 로 지정되었습니다.");


        // Load Button
        JButton load = new JButton("Load");
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 맨 처음 입력한 디렉토리 Bath를 화면에 출력.
                new LoadPage(new JFileChooser(basePath));
            }
        });

        // Save Button
        JButton save = new JButton("Save");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(document==null){
                    JOptionPane.showMessageDialog(null, "파일을 로드 해 주세요");
                    return;
                }
                new SavePage(filePath);
            }
        });

        JButton update = new JButton("Update");

        //
       update.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               if(document == null){
                   JOptionPane.showMessageDialog(null, "파일을 로드 해 주세요");
                   return;
               }
               new UpdatePage();
           }
       });
        // Make Button
        JButton make = new JButton("Make");
        make.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MakePage();
            }
        });

        JButton find = new JButton("Find");
        find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 로드를 하지 않았다면
                if(document == null){
                    JOptionPane.showMessageDialog(null, "파일을 로드 해 주세요");
                    return;
                }

                new FindPage(document);
            }
        });


        JButton print = new JButton("Print");
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(document == null){
                    JOptionPane.showMessageDialog(null, "파일을 로드 해 주세요");
                    return;
                }

                new PrintPage();
            }
        });


        JButton delete = new JButton("Delete");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 아무것도 로드 되어있지 않다면
                if(MainPage.document == null){
                    JOptionPane.showMessageDialog(null, "파일을 로드 해 주세요");
                    return;
                }
                new DeletePage();
            }
        });
        JButton insert = new JButton("Insert");
        insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(MainPage.document == null){
                    JOptionPane.showMessageDialog(null, "파일을 로드 해 주세요");
                    return;
                }
                new InsertPage();
            }
        });



        JButton exit = new JButton("Exit");

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a=JOptionPane.showConfirmDialog(null,"프로그램을 종료 하시겠습니까?");

                if(a==JOptionPane.YES_OPTION ){
                    int ok =JOptionPane.showConfirmDialog(null,"파일을 저장하시겠습니까 ?");
                    if(ok ==JOptionPane.YES_OPTION ) {

                        if(document == null){
                            JOptionPane.showMessageDialog(null,   "로드된 파일이 존재해야 저장할 수 있습니다.");
                            return;
                        }
                        new SavePage(filePath);
                        mainPageMessage.setText(filePath + "가 저장되었습니다.");
                    }
                    try {
                        Thread.sleep(1500);
                        System.exit(1);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }

            }
        });
//        add(tree);
        add(load); add(make); add(find); add(save); add(print);
        add(insert); add(update); add(delete); add(exit);



        mainPageMessage.setBounds(200,200,300,50);
        add(mainPageMessage);

        setTitle("Main Page");
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setLocationRelativeTo(null);

        setSize(800,100);
        setVisible(true);

    }



    public static void main(String[] args){
        new MainPage();
    }


}
