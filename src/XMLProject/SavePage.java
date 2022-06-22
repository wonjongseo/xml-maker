package XMLProject;


import javax.swing.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class SavePage {

    SavePage(String xmlFilePath){

        // 아무것도 로드 되어있지 않다면

        int ok =JOptionPane.showConfirmDialog(null,"새로운 이름으로 파일을 생성하시겠습니까?");


        if(ok ==JOptionPane.YES_OPTION || MainPage.filePath == null){
            xmlFilePath = JOptionPane.showInputDialog("파일이름을 입력해주세요");
            if(!xmlFilePath.endsWith(".xml")){
                    xmlFilePath += ".xml";
            }
        }

        try{
            // Dom Object를 File로 생성하기 위한 작업
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(MainPage.document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));

            transformer.transform(domSource, streamResult);

            // MainPage message 변경
            MainPage.mainPageMessage.setText(xmlFilePath + "가 생성되었습니다.");

        } catch (TransformerConfigurationException transformerConfigurationException) {
            transformerConfigurationException.printStackTrace();
        } catch (TransformerException transformerException) {
            transformerException.printStackTrace();
        }
    }
}
