package servlet;

import enity.Model;
import service.ContactService;
import service.impl.ContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdatePage" ,urlPatterns = "/UpdatePage")
public class UpdatePage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        String id = request.getParameter("id");
        ContactService contactService=new ContactServiceImpl();
        Model contact =contactService.getContact(Integer.parseInt(id));
        request.setAttribute("contact",contact);
        request.getRequestDispatcher("/UpdatePage.jsp").forward(request,response);

    }
}
