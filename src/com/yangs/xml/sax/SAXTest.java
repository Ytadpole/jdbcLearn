package com.yangs.xml.sax;

import com.yangs.xml.bean.Book;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

/**
 * Created by Ytadpole on 2018/2/19.
 */
public class SAXTest {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MySAXHandler handler = new MySAXHandler();
            saxParser.parse("src/com/yangs/xml/Books.xml", handler);
            List<Book> list = handler.getList();
            for(Book book : list){
                System.out.println(book.toString());
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
