package util;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class XMLUtil {
    public static Document getDocuemnt(){
        try {
            SAXReader reader = new SAXReader();
            Document doc=reader.read("C:\\Users\\chenlin\\IdeaProjects2\\web\\Contact.xml");
            return  doc;
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public static void writeDocument(Document doc){
        try {
            OutputStream out=new FileOutputStream("C:\\Users\\chenlin\\IdeaProjects2\\web\\Contact.xml");
            OutputFormat outputFormat=OutputFormat.createPrettyPrint();
            outputFormat.setEncoding("GBK");
            XMLWriter writer=new XMLWriter(out,outputFormat);
            writer.write(doc);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
