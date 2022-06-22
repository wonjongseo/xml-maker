package XMLProject;

import org.w3c.dom.*;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InsertPage extends JFrame {


    InsertPage(){
        // 아무것도 로드 되어있지 않다면


        // JFrame 설정
        setSize(500,300);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);

        String option[]= { "Element","Attribute","Text","Comment"};
        JComboBox comboBox = new JComboBox(option);
        comboBox.setBounds(10, 20,150,30);
        add(comboBox);

        //입력 받은 Root의 정보를 이용해 Root Element 생성


        // Make Page Message 출력
        JLabel message = new JLabel("Insert할 정보를 입력해주세요");
        message.setBounds(10, 160 ,  490, 20);
        add(message);

        // 부모 Element 입력 받을 Text field 와 Label
        JLabel parent = new JLabel("Parent node");
        parent.setBounds(13,60, 150,10);
        add(parent);

        JTextField parentNodeName = new JTextField("");
        parentNodeName.setBounds(10,75,150,30);
        add(parentNodeName);

        // 자식 Element 입력 받을 Text field 와 Label
        JLabel child = new JLabel("Child node");
        child.setBounds(13, 110, 150,10);
        add(child);

        JTextField childNodeName = new JTextField();
        childNodeName.setBounds(10,125,150,30);
        add(childNodeName);

        // 현재까지 삽입한 Node들의 정보를 Tree 형태로 출력
        JButton showTreeBtn= new JButton("Show Tree");
        showTreeBtn.setBounds(200,60, 100, 30);
        add(showTreeBtn);

        showTreeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new JFrame(parentNodeName.getText());
                DefaultMutableTreeNode root =new DefaultMutableTreeNode("ROOT");
                traverseToMakeTree(MainPage.document.getDocumentElement(),root);
                JTree jt=new JTree(root);
                f.add(jt);
                f.setLocationRelativeTo(null);
                f.setSize(400,1000);
                f.setVisible(true);
            }
        });

        // 현재까지 삽입한 Node들의 정보의 Xml file 을 재로드.
        JButton reLoadBtn = new JButton("ReLoad");
        reLoadBtn.setBounds(200, 100 ,100,30);
        add(reLoadBtn);

        reLoadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPage.document = MainPage.document;
                MainPage.mainPageMessage.setText(MainPage.filePath + " 가 새로 로드 되었습니다");
                setVisible(false);
            }
        });

        // Element , Attribute , Text 를 삽입하는 버튼
        JButton makeButton = new JButton("Insert");
        makeButton.setBounds(200, 20, 75,30);
        add(makeButton);

        makeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ok ;
                String number;
                Element nodeElement;
                NodeList nodelist;

                nodelist = MainPage.document.getElementsByTagName(parentNodeName.getText());

                // 부모노드로 입력한 값이 존재하지 않을 경우
                if(nodelist.getLength()==0){
                    JOptionPane.showMessageDialog(null,parentNodeName.getText() +  " 를 먼저 만들어 주세요");
                    return;
                }

                if(nodelist.getLength() == 1){
                    nodeElement = (Element) nodelist.item(0);
                }
                // 부모노드가 1개 이상일 경우
                else{
                    number = JOptionPane.showInputDialog(parentNodeName.getText()+ " 가 "+ nodelist.getLength() +"개 존재합니다. 몇 번째 노드의 자식 노드로 삽입 하실겁니까?");

                    // 0 이하 입력에 대한 예외처리
                    while(Integer.parseInt(number) < 1 ){
                        number = JOptionPane.showInputDialog("1이하는 안됩니다, 다시 입력해주세요");
                    }

                    while(Integer.parseInt(number) > nodelist.getLength()){
                        number = JOptionPane.showInputDialog(nodelist.getLength()+ "개 존재합니다. 다시 입력해주세요");
                    }

                    nodeElement = (Element) nodelist.item(Integer.parseInt(number)-1);
                }


                // Element ? Attribute ? Text ?
                switch (comboBox.getSelectedIndex()){
                    case 0:
                        //if(Element)
                        // 확인 메시지
                        ok= JOptionPane.showConfirmDialog(null,parentNodeName.getText() + " Element의 자식으로 " + childNodeName.getText() + " 을 만드시겠습니까?","Alert",JOptionPane.WARNING_MESSAGE);

                        if(ok == JOptionPane.YES_OPTION) {
                            Element newElement =   MainPage.document.createElement(childNodeName.getText());
                            nodeElement.appendChild(newElement);
                            message.setText(parentNodeName.getText()+ "의 자식노드로 "+newElement.getNodeName() + " 이 삽입되었습니다.");
                            JOptionPane.showMessageDialog(null,parentNodeName.getText()+ "의 자식노드로 "+newElement.getNodeName() + " 이 삽입되었습니다. Print 버튼을 눌러 확인해주세요");
                        }
                        break;

                    case 1:
                        //if(Attribute)

                        // Attribute value 입력
                        String AttributeValue = JOptionPane.showInputDialog(parentNodeName.getText() + " Element" + "에 삽입할 Attribute 값을 입력하시오");

                        // Attribute name과 value 생성
                        Attr attr = MainPage.document.createAttribute(childNodeName.getText());
                        attr.setValue(AttributeValue);

                        nodeElement.setAttributeNode(attr);
                        message.setText(nodeElement.getNodeName()+ " Element에 " +attr.getNodeName() +":" + attr.getNodeValue() +" 가 삽입되었습니다");
                        JOptionPane.showMessageDialog(null,nodeElement.getNodeName()+ " Element에 " +attr.getNodeName() +":" + attr.getNodeValue() +" 가 삽입되었습니다 Print 버튼을 눌러 확인해주세요");
                        break;

                    case 2:
                        //if(text)
                        ok= JOptionPane.showConfirmDialog(null,parentNodeName.getText() + " Element의 자식으로 text " + childNodeName.getText() + "를 만드시겠습니까?","Alert",JOptionPane.WARNING_MESSAGE);
                        if(ok == JOptionPane.YES_OPTION){
                            nodeElement.appendChild(MainPage.document.createTextNode(childNodeName.getText()));
                            message.setText(nodeElement.getNodeName()+ " Element에 text \"" + childNodeName.getText() + "\" 가 삽입되었습니다");
                            JOptionPane.showMessageDialog(null,nodeElement.getNodeName()+ " Element에 text \"" + childNodeName.getText() + "\" 가 삽입되었습니다 버튼을 눌러 확인해주세요");
                        }

                        break;

                    case 3:
                        ok= JOptionPane.showConfirmDialog(null,parentNodeName.getText() + " Element 자식으로 " + childNodeName.getText() + " Comment 을 만드시겠습니까?","Alert",JOptionPane.WARNING_MESSAGE);
                        if(ok == JOptionPane.YES_OPTION) {
                            Comment comment = MainPage.document.createComment(childNodeName.getText());
                            nodeElement.appendChild(comment);

                            message.setText(parentNodeName.getText()+ "의 자식노드로 "+comment.getNodeValue() + " 이 삽입되었습니다.");
                        }

                        break;

                }
            }
        });
    }

    public static void traverseToMakeTree(Node node, DefaultMutableTreeNode child ){
        if(node == null || child == null) return;
        DefaultMutableTreeNode visualTreeNode = null;
        int type = node.getNodeType();

        switch (type){
            case Node.ELEMENT_NODE:
                visualTreeNode =new DefaultMutableTreeNode(node.getNodeName());
                child.add(visualTreeNode);
                break;
            case  Node.ATTRIBUTE_NODE:
                visualTreeNode =new DefaultMutableTreeNode(node.getNodeValue());
                child.add(visualTreeNode);
                break;
            case Node.TEXT_NODE:
                visualTreeNode =new DefaultMutableTreeNode(node.getNodeValue());
                child.add(visualTreeNode);
                break;
        }

        NodeList children = node.getChildNodes();

        if(children != null){
            for(int i = 0 ; i < children.getLength() ; i++){
                traverseToMakeTree(children.item(i),visualTreeNode);
            }
        }
    }

}
