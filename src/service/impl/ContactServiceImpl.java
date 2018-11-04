package service.impl;

import dao.ContactDao;
import dao.impl.ContactDaoMySQLImpl;
import enity.Model;
import exception.NameExistException;
import service.ContactService;

import java.util.List;

public class ContactServiceImpl implements ContactService {
    ContactDao contactDao=new ContactDaoMySQLImpl();
    @Override
    public void insertContact(Model model) throws NameExistException {
   //添加业务逻辑  当姓名出现重复的时候，提示用户不能添加
           if (contactDao.checkNameExist(model.getName())){
               throw new NameExistException("姓名重复，请重复输入");
           }else {
               contactDao.insertContact(model);
           }
    }

    @Override
    public void updateContact(Model model) {
          contactDao.updateContact(model);
    }

    @Override
    public void deleteContact(int id) {
          contactDao.deleteContact(id);
    }

    @Override
    public List<Model> listContact() {
        List<Model> listModel = contactDao.listContact();
        return  listModel;
    }

    @Override
    public Model getContact(int id) {
        Model contact = contactDao.getContact(id);
        return contact;
    }


}
