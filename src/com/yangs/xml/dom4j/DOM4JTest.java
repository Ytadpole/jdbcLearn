package com.yangs.xml.dom4j;

import com.yangs.xml.bean.Book;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ytadpole on 2018/2/19.
 */
public class DOM4JTest {
    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();

        SAXReader saxReader = new SAXReader();
        try {
            //加载文件
            Document document = saxReader.read(new File("src/com/yangs/xml/Books.xml"));
            //root节点
            Element root = (Element) document.getRootElement();
            Iterator books = root.elementIterator();
            while (books.hasNext()){
                //新书
                Book book = new Book();
                list.add(book);
                Element b = (Element) books.next();

                //属性
                Iterator<Attribute> attrs = b.attributeIterator();
                while(attrs.hasNext()){
                    //某个属性
                    Attribute attr = attrs.next();
                    if("id".equals(attr.getName())){
                        book.setId(attr.getValue());
                    }else if("att".equals(attr.getName())){
                        book.setAtt(attr.getValue());
                    }
                }

                //子节点
                Iterator children = b.elementIterator();
                while(children.hasNext()){
                    //某个子节点
                    Element child = (Element) children.next();
                    if("name".equals(child.getName())){
                        book.setName(child.getStringValue());
                    }else if("author".equals(child.getName())){
                        book.setAuthor(child.getStringValue());
                    }else if("date".equals(child.getName())){
                        book.setDate(child.getStringValue());
                    }else if("price".equals(child.getName())){
                        book.setPrice(child.getStringValue());
                    }
                }
            }

            //展示
            for(Book b : list){
                System.out.println(b.toString());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
