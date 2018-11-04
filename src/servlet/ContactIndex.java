package servlet;

import enity.Model;
import org.dom4j.DocumentException;
import service.ContactService;
import service.impl.ContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "ContactIndex" ,urlPatterns = "/ContactIndex")
public class ContactIndex extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html;charset=GBK");
        ContactService contactService=new ContactServiceImpl();
            List<Model> models =contactService.listContact();
            request.setAttribute("models",models);
            request.getRequestDispatcher("/index.jsp").forward(request,response);

    }
}
