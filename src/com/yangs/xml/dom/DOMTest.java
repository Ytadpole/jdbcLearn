package com.yangs.xml.dom;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by Ytadpole on 2018/2/19.
 */
public class DOMTest {
    public static void main(String[] args) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("src/com/yangs/xml/Books.xml");
            NodeList books = document.getElementsByTagName("book");
            for(int i = 0; i < books.getLength(); i++){
                System.out.println("第"+ (i+1)+"本书解析开始");
                Node book = books.item(i);

                //获取属性信息
                System.out.println("解析节点"+ book.getNodeName() +"属性开始");
                NamedNodeMap attrs = book.getAttributes();
                for(int attrNum = 0; attrNum < attrs.getLength(); attrNum++){
                    Node attr = attrs.item(attrNum);
                    System.out.println("属性名：" + attr.getNodeName() + "---属性值："+attr.getNodeValue());
                }
                System.out.println("解析节点"+ book.getNodeName() +"属性结束");

                System.out.println("解析节点"+ book.getNodeName() +"参数开始");
                NodeList elements = book.getChildNodes();
//                System.out.println(elements.getLength());
                for(int elementNum = 0; elementNum < elements.getLength(); elementNum++){
                    //因为dom会把空格换行认为是自己的子节点所以判断下
                    Node element = elements.item(elementNum);
                    if(element.getNodeType() == Node.ELEMENT_NODE) {
                        System.out.println("参数名:"+ element.getNodeName() +"----参数值："+ element.getTextContent());
                    }
                }
                System.out.println("解析节点"+ book.getNodeName() +"参数结束");

                System.out.println("第"+ (i+1)+"本书解析结束");
                System.out.println();
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
