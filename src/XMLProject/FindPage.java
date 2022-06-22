package XMLProject;

import org.w3c.dom.*;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindPage extends JFrame implements ActionListener {

    JButton findButton;
    JComboBox comboBox;
    static JTextField foundItem;

    FindPage(Document document) {


        setTitle("Find");
        JLabel label = new JLabel();

        foundItem = new JTextField();

        findButton = new JButton("Find");
        findButton.setBounds(200,10,75,30);


        String option[]= { "Element","Attribute","Text"};

        // 속성, 원소, 값 아이템의 콤보박스 생성
        comboBox = new JComboBox(option);
        comboBox.setBounds(10, 10,120,30);

        // Frame 설정
        foundItem.setBounds(10, 50, 120 ,30);
        add(comboBox);add(findButton); add(foundItem);
        findButton.addActionListener(this);
        setLocationRelativeTo(null);
        setSize(300,150);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String number = null;
        Element nodeElement;
        NodeList nodelist;

        // 공백 노드 입력의 예외처리
        if(foundItem.getText().equals("")){
            JOptionPane.showMessageDialog(this, "찾고 싶은 노드를 입력해주세요");
            return ;
        }


        switch (comboBox.getSelectedIndex()){
            case 0:
                // Element를 검색 시

                nodelist = MainPage.document.getElementsByTagName(foundItem.getText());

                // 찾는 노드가 없다면
                if(nodelist.getLength() == 0 ){
                    JOptionPane.showMessageDialog(null,foundItem.getText() +  "를 찾지 못했습니다");
                    break;
                }

                if(nodelist.getLength() == 1){
                    nodeElement = (Element) nodelist.item(0);
                }
                // 찾는 노드가 1개 이상이라면
                else{
                    number = JOptionPane.showInputDialog(foundItem.getText()+ " 가 "+ nodelist.getLength() +"개 존재합니다. 몇 번째 노드를 검색 하실 겁니까?");

                    // 0 이하 입력에 대한 예외처리
                    while(Integer.parseInt(number) < 1 ){
                        number = JOptionPane.showInputDialog("1이하는 안됩니다, 다시 입력해주세요");
                    }

                    while(Integer.parseInt(number) > nodelist.getLength()){
                        number = JOptionPane.showInputDialog(nodelist.getLength()+ "개 존재합니다. 다시 입력해주세요");
                    }

                    nodeElement = (Element) nodelist.item(Integer.parseInt(number)-1);
                }


                // 검색된 Element 를 트리 형식으로 보여줌
                JFrame f = new JFrame();
                DefaultMutableTreeNode root =new DefaultMutableTreeNode("ROOT");
                MakePage.traverseToMakeTree(nodeElement,root);
                JTree jt=new JTree(root);
                f.add(jt);
                f.setLocationRelativeTo(null);
                f.setSize(400,600);
                f.setVisible(true);
                break;
            case 1:
                // Attribute에 대한 검색 시

                // 어느 노드의 Attribute를 찾는지 물어봄
                String elemtOfattr = JOptionPane.showInputDialog("어느 노드의 Attribute를 검색하는지 입력해주세요");



                nodelist = MainPage.document.getElementsByTagName(elemtOfattr);

                // 입력 받은 Attribute의 이름을 갖은 Element 가 없다면
                if(nodelist.getLength() == 0 ){
                    JOptionPane.showMessageDialog(null,foundItem.getText() +  "를 찾지 못했습니다");
                    break;
                }

                if(nodelist.getLength() == 1){
                    nodeElement = (Element) nodelist.item(0);
                }
                // 입력 받은 Attribute의 이름을 갖은 Element 가 한개 이상이라면
                else{
                    number = JOptionPane.showInputDialog(foundItem.getText()+ " 가 "+ nodelist.getLength() +"개 존재합니다. 몇 번째 노드를 검색 하실 겁니까?");

                    // 0 이하 입력에 대한 예외처리
                    while(Integer.parseInt(number) < 1 ){
                        number = JOptionPane.showInputDialog("1이하는 안됩니다, 다시 입력해주세요");
                    }

                    while(Integer.parseInt(number) > nodelist.getLength()){
                        number = JOptionPane.showInputDialog(nodelist.getLength()+ "개 존재합니다. 다시 입력해주세요");
                    }

                    nodeElement = (Element) nodelist.item(Integer.parseInt(number)-1);
                }

                // 어느, 몇번째 노드의 Attribute Value를 검색
                NamedNodeMap elementOfAttribute =  nodeElement.getAttributes();

                Node foundAttri = elementOfAttribute.getNamedItem(foundItem.getText());

                // 찾은 attribute 의 값을 화면에 출력
                JOptionPane.showMessageDialog(null, foundAttri.getNodeName()+ " 값은 \""
                +foundAttri.getNodeValue() + "\" 입니다");

                break;
            case 2:

                String parentOfText = JOptionPane.showInputDialog("검색할 text의 부모 Element를 입력해주세요");
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

                System.out.println("1 " +nodeElement.getTextContent());
                System.out.println("2 "+ foundItem.getText());
                if(!nodeElement.getTextContent().equals(foundItem.getText())){
                    JOptionPane.showMessageDialog(null, "해당 번호 Element에 맞는 TEXT가 존재하지 않습니다. 번호를 다시 입력해주세요");
                    break;
                }
                Node grandFather = nodeElement.getParentNode().getParentNode();
                JFrame f1 = new JFrame();
                DefaultMutableTreeNode root1 =new DefaultMutableTreeNode("ROOT");
                MakePage.traverseToMakeTree(grandFather,root1);
                JTree jt1=new JTree(root1);
                f1.add(jt1);
                f1.setLocationRelativeTo(null);
                f1.setSize(400,600);
                f1.setVisible(true);
                break;
        }



    }
}
