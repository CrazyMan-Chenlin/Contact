package servlet;

import enity.Model;
import exception.NameExistException;
import service.ContactService;
import service.impl.ContactServiceImpl;
import util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Contact",urlPatterns = "/Contact")
public class Contact extends BaseServlet {
    private void batchDel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ids[]=request.getParameterValues("item");
        ContactService contactService=new ContactServiceImpl();
        for (String id: ids
                ) {
            contactService.deleteContact(Integer.parseInt(id));
        }
        response.sendRedirect(request.getContextPath()+"/Contact?action=queryContact");
    }

    private void getContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ContactService contactService=new ContactServiceImpl();
        Model contact =contactService.getContact(Integer.parseInt(id));
        request.setAttribute("contact",contact);
        request.getRequestDispatcher("/UpdatePage.jsp").forward(request,response);
    }

    private void queryContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContactService contactService=new ContactServiceImpl();
        List<Model> models =contactService.listContact();
        request.setAttribute("models",models);
        System.out.println("a");
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    private void delContact(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ContactService contactService=new ContactServiceImpl();
        contactService.deleteContact(id);
        response.sendRedirect(request.getContextPath()+"/Contact?action=queryContact");
    }

    private void updateContact(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Model model = WebUtil.copyRequestToBean(request, Model.class);
        ContactService contactService=new ContactServiceImpl();
        System.out.println(model);
        contactService.updateContact(model);
        response.sendRedirect(request.getContextPath()+"/Contact?action=queryContact");
    }

    private void addContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = WebUtil.copyRequestToBean(request, Model.class);
        ContactService contactService=new ContactServiceImpl();
        try {
            contactService.insertContact(model);
        } catch (NameExistException e) {
            request.setAttribute("message",e.getMessage());
            request.getRequestDispatcher("/addContact.jsp").forward(request, response);
        }
        response.sendRedirect(request.getContextPath()+"/Contact?action=queryContact");
    }
    }
