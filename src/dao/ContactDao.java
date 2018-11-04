package dao;

import enity.Model;

import java.util.List;

public interface ContactDao {
    void insertContact(Model model);
    void updateContact(Model model);
    void deleteContact(int id);
    List<Model> listContact();
    Model getContact(int id);
    boolean checkNameExist(String name);
}
