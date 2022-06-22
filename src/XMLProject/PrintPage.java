package XMLProject;

import org.w3c.dom.Document;

import javax.swing.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import java.io.StringWriter;
import java.io.Writer;


public class PrintPage extends JFrame {


    PrintPage(){


        setTitle("Print Page");
        JTextArea textArea = new JTextArea();
        textArea.setSize(500,500);

        add(textArea);

        JScrollPane scrollableTextArea = new JScrollPane(textArea);

        // 상하좌우 스크롤 Plane
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        setSize(600,500);
        textArea.setText(prettyPrint(MainPage.document));
        getContentPane().add(scrollableTextArea);


        setLocationRelativeTo(null);
        setVisible(true);



    }

    // 로드된 XML 출력
    public static String  prettyPrint(Document xml){
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,"yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT,"Yes");
            Writer out = new StringWriter();
            transformer.transform(new DOMSource(xml),new StreamResult(out));

            return out.toString();
        }catch (Exception exception){ exception.printStackTrace();}
        return null;
    }
}
