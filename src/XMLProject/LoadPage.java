package XMLProject;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class LoadPage {
    LoadPage(JFileChooser jFileChooser){
        int i = jFileChooser.showOpenDialog(new JFrame("Choice any file"));

        if (i == JFileChooser.APPROVE_OPTION) {
            int ok=JOptionPane.showConfirmDialog(new JFrame(),"Are you sure?");

            if(ok == JOptionPane.YES_OPTION){

                File file = jFileChooser.getSelectedFile();

                // 로드한 파일 정보를 Main Page에서 사용할 수 있도록 설정
                MainPage.filePath = file.getPath();
                MainPage.document = getDocument(file.getPath());

                if(MainPage.document !=null){
                    JOptionPane.showMessageDialog(null,file.getName() + " 이 로드 되었습니다.");
                    MainPage.mainPageMessage.setText(file.getName() + " 이 로드 되었습니다.");
                }else {
                    MainPage.mainPageMessage.setText(file.getName()+ "의 로드가 실패했습니다.");
                }

            }

            return ;
        }
        jFileChooser.setLayout(null);
        jFileChooser.setSize(500, 500);
        jFileChooser.setVisible(true);

    }


    // 입력 받은 패스 파일을 XML DOM OJBECT로 변환한다.
    public static Document getDocument(String uri){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);

            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(uri);

            return doc;
        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (SAXException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
