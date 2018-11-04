package service;

import enity.Model;
import exception.NameExistException;

import java.util.List;

public interface ContactService {
    void insertContact(Model model) throws  NameExistException;
    void updateContact(Model model);
    void deleteContact(int id);
    List<Model> listContact();
    Model getContact(int id);
}
