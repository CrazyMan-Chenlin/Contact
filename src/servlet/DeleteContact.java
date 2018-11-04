package servlet;

import dao.ContactDao;
import org.dom4j.DocumentException;
import service.ContactService;
import service.impl.ContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteContact",urlPatterns = "/DeleteContact")
public class DeleteContact extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int id = Integer.parseInt(request.getParameter("id"));
         ContactService contactService=new ContactServiceImpl();
         contactService.deleteContact(id);
         response.sendRedirect(request.getContextPath()+"/ContactIndex");
    }
}
