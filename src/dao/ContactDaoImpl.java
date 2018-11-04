package dao;
import enity.Model;
import org.dom4j.*;
import util.XMLUtil;

import java.io.*;
import java.util.*;

/*
public class ContactDaoImpl implements ContactDao {
        public void insertContact(Model model){
        Document doc = XMLUtil.getDocuemnt();
        Element rootlement = doc.getRootElement();
        Element conelement = rootlement.addElement("contact");
        conelement.addAttribute("id", Integer.toString(model.getId()));
        conelement.addElement("name").setText(model.getName());
        conelement.addElement("gender").setText(model.getGender());
        conelement.addElement("age").setText(Integer.toString(model.getAge()));
        conelement.addElement("phone").setText(Long.toString(model.getPhone()));
        conelement.addElement("email").setText(model.getEmail());
        conelement.addElement("QQ").setText(Integer.toString(model.getQQ()));
        XMLUtil.writeDocument(doc);
    }

    public  void updateContact(int id, Model model)  {
        Document doc = XMLUtil.getDocuemnt();
        Element element = (Element) doc.selectSingleNode("//contact[@id='" + id + "']");
        element.element("name").setText(model.getName());
        element.element("gender").setText(model.getGender());
        element.element("age").setText(Integer.toString(model.getAge()));
        element.element("phone").setText(Long.toString(model.getPhone()));
        element.element("email").setText(model.getEmail());
        element.element("QQ").setText(Integer.toString(model.getQQ()));
        XMLUtil.writeDocument(doc);
    }

    public void deleteContact(int id)  {
        Document doc = XMLUtil.getDocuemnt();
        Element element = (Element) doc.selectSingleNode("//contact[@id='" + id + "']");
        element.detach();
        XMLUtil.writeDocument(doc);
    }

    public  List<Model> listContact()  {
        Document doc = XMLUtil.getDocuemnt();
        List<Model> list = new ArrayList();
        Model model = null;
        List<Element> elelist = doc.getRootElement().elements("contact");
        for (Element e : elelist
                ) {
            model = new Model();
            model.setId(Integer.parseInt(e.attributeValue("id")));
            model.setName(e.elementText("name"));
            model.setGender(e.elementText("gender"));
            model.setAge(Integer.parseInt(e.elementText("age")));
            model.setPhone(Long.parseLong(e.elementText("phone")));
            model.setEmail(e.elementText("email"));
            model.setQQ(Integer.parseInt(e.elementText("QQ")));
            list.add(model);
        }
        return list;
    }

    public  Model getContact(int id) {
        Document doc = XMLUtil.getDocuemnt();
        Model model = new Model();
        Element element = (Element) doc.selectSingleNode("//contact[@id='"+id +"']");
        model.setId(Integer.parseInt(element.attributeValue("id")));
        model.setName(element.elementText("name"));
        model.setGender(element.elementText("gender"));
        model.setAge(Integer.parseInt(element.elementText("age")));
        model.setEmail(element.elementText("email"));
        model.setPhone(Long.parseLong(element.elementText("phone")));
        model.setQQ(Integer.parseInt(element.elementText("QQ")));
        return model;
    }
   public  void updateId(int id)  {
       List<Model> models = listContact();
       Collections.sort(models);
       for (Model model: models
            ) {
           System.out.println(model.getId());
           if (model.getId()>id){
               Document doc = XMLUtil.getDocuemnt();
               Element element = (Element) doc.selectSingleNode("//contact[@id='"+model.getId() +"']");
               element.attribute("id").setValue(Integer.toString(model.getId()-1));
               XMLUtil.writeDocument(doc);
           }
       }
   }

}*/
