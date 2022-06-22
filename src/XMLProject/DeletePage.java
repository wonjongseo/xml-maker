package XMLProject;

import org.w3c.dom.*;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DeletePage extends JFrame {
    static Node root = MainPage.document.getDocumentElement();

    DeletePage(){


        // JFrame 설정
        setSize(500,300);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);

        String option[]= { "Element","Attribute","Text"};
        JComboBox comboBox = new JComboBox(option);
        comboBox.setBounds(10, 20,150,30);
        add(comboBox);



        // Delete Page Message 출력
        JLabel message = new JLabel("Delete할 정보를 입력해주세요");
        message.setBounds(10, 160 ,  490, 20);
        add(message);

        // 부모 Element 입력 받을 Text field 와 Label
        JLabel parent = new JLabel("Delete node");
        parent.setBounds(13,60, 150,10);
        add(parent);

        JTextField parentNodeName = new JTextField("");
        parentNodeName.setBounds(10,75,150,30);
        add(parentNodeName);


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



        // Element , Attribute , Text 를 삽입하는 버튼
        JButton makeButton = new JButton("Delete");
        makeButton.setBounds(200, 20, 75,30);
        add(makeButton);


        makeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ok ;
                String number = null;
                Element nodeElement;
                NodeList nodelist;

                switch (comboBox.getSelectedIndex()) {
                    case 0:

                        nodelist = MainPage.document.getElementsByTagName(parentNodeName.getText());

                        // 삭제할 Elem가 존재하지 않을 경우
                        if (nodelist.getLength() == 0) {
                            JOptionPane.showMessageDialog(null, parentNodeName.getText() + " 가 존재하지 않습니다");
                            return;
                        }

                        if (nodelist.getLength() == 1) {
                            nodeElement = (Element) nodelist.item(0);
                        }
                        // 부모노드가 1개 이상일 경우
                        else {
                            number = JOptionPane.showInputDialog(parentNodeName.getText() + " 가 " + nodelist.getLength() + "개 존재합니다. 몇 번째 노드를 삭제 하실겁니까?");
                            // 0 이하 입력에 대한 예외처리
                            {

                                while (Integer.parseInt(number) < 1) {
                                    number = JOptionPane.showInputDialog("1이하는 안됩니다, 다시 입력해주세요");
                                }

                                while (Integer.parseInt(number) > nodelist.getLength()) {
                                    number = JOptionPane.showInputDialog(nodelist.getLength() + "개 존재합니다. 다시 입력해주세요");
                                }
                            }
                            nodeElement = (Element) nodelist.item(Integer.parseInt(number) - 1);
                        }


                        ok = JOptionPane.showConfirmDialog(null, parentNodeName.getText() + " 를 정말 삭제하시겠습니까?", "Alert", JOptionPane.WARNING_MESSAGE);

                        if (ok == JOptionPane.YES_OPTION) {
                            Node parentOfDelete = nodeElement.getParentNode();
                            parentOfDelete.removeChild(nodeElement);
                            message.setText(nodeElement.getNodeName() + " 가 삭제되었습니다");
                        }
                        break;

                    case 1:
                        String attributeOfParent = JOptionPane.showInputDialog(parentNodeName.getText() + "를 삭제할 Element를 입력 해 주세요");
                        nodelist = MainPage.document.getElementsByTagName(attributeOfParent);

                        // Attr를 갖고 있는 Elem값이 존재하지 않을 경우
                        if (nodelist.getLength() == 0) {
                            JOptionPane.showMessageDialog(null, "삭제할 " + attributeOfParent + " 가 존재하지 않습니다.");
                            return;
                        }

                        if (nodelist.getLength() == 1) {
                            nodeElement = (Element) nodelist.item(0);
                        }
                        // 부모노드가 1개 이상일 경우
                        else {
                            number = JOptionPane.showInputDialog(parentNodeName.getText() + " 가 " + nodelist.getLength() + "개 존재합니다. 몇 번째 노드의 Attribute를 삭제 하실겁니까?");

                            // 0 이하 입력에 대한 예외처리
                            while (Integer.parseInt(number) < 1) {
                                number = JOptionPane.showInputDialog("1이하는 안됩니다, 다시 입력해주세요");
                            }

                            while (Integer.parseInt(number) > nodelist.getLength()) {
                                number = JOptionPane.showInputDialog(nodelist.getLength() + "개 존재합니다. 다시 입력해주세요");
                            }

                            nodeElement = (Element) nodelist.item(Integer.parseInt(number) - 1);
                        }

                        boolean hasAttribute = nodeElement.hasAttribute(parentNodeName.getText());

                        if (!hasAttribute) {
                            JOptionPane.showMessageDialog(null, nodeElement.getNodeName() + "의 " + parentNodeName.getText() + " 가 존재하지 않습니다.");
                            return;
                        }

                        nodeElement.removeAttribute(parentNodeName.getText());

                        message.setText(nodeElement.getNodeName() + "의 " + parentNodeName.getText() + "를 제거하였습니다");


                        break;
                    case 2:
                        String parentOfText = JOptionPane.showInputDialog("삭제할 text의 부모 Element를 입력해주세요");
                        nodelist = MainPage.document.getElementsByTagName(parentOfText);

                        if (nodelist.getLength() == 0) {
                            JOptionPane.showMessageDialog(null, parentOfText + " 가 존재하지 않습니다");
                            return;
                        }

                        if (nodelist.getLength() == 1) {
                            nodeElement = (Element) nodelist.item(0);
                        }
                        // 부모노드가 1개 이상일 경우
                        else {
                            number = JOptionPane.showInputDialog(parentOfText + " 가 " + nodelist.getLength() + "개 존재합니다. 몇 번째 노드를 삭제 하실겁니까?");
                            // 0 이하 입력에 대한 예외처리
                            {

                                while (Integer.parseInt(number) < 1) {
                                    number = JOptionPane.showInputDialog("1이하는 안됩니다, 다시 입력해주세요");
                                }

                                while (Integer.parseInt(number) > nodelist.getLength()) {
                                    number = JOptionPane.showInputDialog(nodelist.getLength() + "개 존재합니다. 다시 입력해주세요");
                                }
                            }
                            nodeElement = (Element) nodelist.item(Integer.parseInt(number) - 1);
                        }
                        nodeElement.getParentNode().removeChild(nodeElement);

                        message.setText(parentNodeName.getText() + " 가 삭제되었습니다.");


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
                System.out.println("HELLO");
                NamedNodeMap aaaa = node.getAttributes();
                for(int i = 0 ; i< aaaa.getLength() ; i++){
                    Node bbb= aaaa.item(i);
                    System.out.println(bbb.getNodeName());
                    System.out.println(bbb.getNodeValue());

                }
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
