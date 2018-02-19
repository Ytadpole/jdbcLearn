package com.yangs.xml.sax;

import com.sun.org.apache.xml.internal.resolver.readers.SAXParserHandler;
import com.yangs.xml.bean.Book;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ytadpole on 2018/2/19.
 */
public class MySAXHandler extends SAXParserHandler{
    //private int bookIndex;//指向第几本书
    private Book book;
    private List<Book> list = new ArrayList<>();

    private String tmpVlaue;//用于记录book每一个属性的值

    public List<Book> getList() {
        return list;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        tmpVlaue = new String(ch, start, length);

    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        super.endElement(namespaceURI, localName, qName);
        if("book".equals(qName)){
            book = null;//一次book信息遍历完成吗，清缓存
        }
        //设置参数
        else if("name".equals(qName)){
            book.setName(tmpVlaue);
        }else if("author".equals(qName)){
            book.setAuthor(tmpVlaue);
        }else if("date".equals(qName)){
            book.setDate(tmpVlaue);
        }else if("price".equals(qName)){
            book.setPrice(tmpVlaue);
        }else{
            //System.out.println("bad");
        }



    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        super.startElement(namespaceURI, localName, qName, atts);
        if("book".equals(qName)){
            //bookIndex++;
            //添加新书
            book = new Book();
            list.add(book);

            //book标签上的属性
            for(int i =0; i < atts.getLength(); i++){
                String attrName = atts.getQName(i);
                if("id".equals(attrName)){
                    book.setId(atts.getValue(i));
                }else if("att".equals(attrName)){
                    book.setAtt(atts.getValue(i));
                }else{
                    System.out.println("非法的属性"+ atts.getQName(i));
                }
            }
        }
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("解析开始-----");
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("解析结束-----");
    }
}
