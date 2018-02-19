package com.yangs.xml.jdom;

import com.yangs.xml.bean.Book;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ytadpole on 2018/2/19.
 */
public class JDOMTest {


    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();//存储查询到的对象

        try {
            InputStream inputStream = new FileInputStream("src/com/yangs/xml/Books.xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputStream);
            Element root = document.getRootElement();
            List<Element> books = root.getChildren("book");
            for(Element b : books){
                //新book
                Book book = new Book();
                list.add(book);

                //属性
                List<Attribute> attributes = b.getAttributes();
                for(Attribute a : attributes){
                    if("id".equals(a.getName())){
                        book.setId(a.getValue());
                    }else if("att".equals(a.getValue())){
                        book.setAtt(a.getValue());
                    }
                }

                //子节点
                List<Element> elements = b.getChildren();
                for(Element e : elements){
                    if("name".equals(e.getName())) {
                        book.setName(e.getValue());
                    }else if("author".equals(e.getName())) {
                        book.setAuthor(e.getValue());
                    }else if("date".equals(e.getName())) {
                        book.setDate(e.getValue());
                    }else if("price".equals(e.getName())) {
                        book.setPrice(e.getValue());
                    }
                }

            }

            //输出结果
            for(Book b : list){
                System.out.println(b.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
