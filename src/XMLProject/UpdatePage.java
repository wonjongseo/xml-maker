package XMLProject;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdatePage extends JFrame {
   UpdatePage(){
       setTitle("Update Page");
       setLayout(null);
       setSize(200,100);
       setLocationRelativeTo(null);
       setVisible(true);

        JButton insert = new JButton("Insert");
        JButton delete = new JButton("Delete");



        insert.setBounds(10, 20, 70,20);
        delete.setBounds(100,20,70,20);
        add(insert);
        add(delete);

        insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InsertPage();
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeletePage();
            }
        });

//       int ok =JOptionPane.showConfirmDialog(null,"파일을 새로 업로드 하시겠습니까?");
//
//       if(ok == JOptionPane.YES_OPTION){
//           MainPage.document = MainPage.document;
//           MainPage.mainPageMessage.setText(MainPage.filePath + " 가 새로 로드 되었습니다");
//       }

   }


}
