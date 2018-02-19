package com.yangs.xml.dom;

import com.yangs.xml.bean.Book;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ytadpole on 2018/2/19.
 */
public class DOMTest2 {
    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("src/com/yangs/xml/Books.xml");

            NodeList books = document.getElementsByTagName("book");
            for(int i = 0; i < books.getLength(); i++){
                //某个书
                Book book = new Book();
                list.add(book);

                Node itemBook = books.item(i);
                //属性
                NamedNodeMap attrs = itemBook.getAttributes();
                for(int j = 0; j < attrs.getLength(); j++){
                    //某个属性
                    Node attr = attrs.item(j);
                    if("id".equals(attr.getNodeName())){
                        book.setId(attr.getNodeValue());
                    }else if("att".equals(attr.getNodeName())){
                        book.setAtt(attr.getNodeValue());
                    }
                }

                //子节点
                NodeList children = itemBook.getChildNodes();
                for(int j = 0; j < children.getLength(); j++){
                    //某个节点
                    Node child = children.item(j);
                    if(child.getNodeType() == Node.ELEMENT_NODE) {//过滤空格，换行这些人为添加的 有助于展示查看的东西
                        if ("name".equals(child.getNodeName())){
                            book.setName(child.getTextContent());
                        }else if ("author".equals(child.getNodeName())){
                            book.setAuthor(child.getTextContent());
                        }else if ("price".equals(child.getNodeName())){
                            book.setPrice(child.getTextContent());
                        }else if ("date".equals(child.getNodeName())){
                            book.setDate(child.getTextContent());
                        }
                    }
                }
            }

            //展示
            for(Book b : list){
                System.out.println(b.toString());
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
