package XMLProject;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;

public class TreeExample {
    JFrame f;
    Document doc;
    TreeExample(){
        doc = getDocument("/Users/wonjongseo/Desktop/xml/miniProject2/miniProject4/XML001_MiniProject4_wonjongseo_18013181.xml");
        f=new JFrame();
        System.out.println(doc.getDocumentElement().getNodeName());
        DefaultMutableTreeNode root =new DefaultMutableTreeNode(doc.getDocumentElement().getNodeName());
        traverse(doc.getDocumentElement(),root);
        JTree jt=new JTree(root);
        f.add(jt);


        f.setLocationRelativeTo(null);
        f.setSize(200,1000);
        f.setVisible(true);
    }
    public static Document getDocument(String uri){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
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


    public static void traverse(Node node, DefaultMutableTreeNode child ){
        if(node == null || child == null) return;
        DefaultMutableTreeNode aa = null;
        int type = node.getNodeType();

        switch (type){
            case Node.ELEMENT_NODE:
                aa =new DefaultMutableTreeNode(node.getNodeName());
                child.add(aa);
                break;
            case  Node.ATTRIBUTE_NODE:
                aa =new DefaultMutableTreeNode(node.getNodeValue());
                child.add(aa);
                break;

        }

        NodeList children = node.getChildNodes();

        if(children != null){
            for(int i = 0 ; i < children.getLength() ; i++){
                traverse(children.item(i),aa);
            }
        }
    }
}