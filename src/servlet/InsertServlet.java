package servlet;
import exception.NameExistException;
import enity.Model;
import org.apache.commons.beanutils.BeanUtils;
import service.ContactService;
import service.impl.ContactServiceImpl;
import util.WebUtil;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@javax.servlet.annotation.WebServlet(name = "InsertServlet",urlPatterns ="/InsertServlet")
public class InsertServlet extends javax.servlet.http.HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("GBK");
        response.setContentType("text/html;charset=GBK");
        Model model = WebUtil.copyRequestToBean(request, Model.class);
       /* String name=request.getParameter("name");
        model.setName(name);
        String gender = request.getParameter("gender");
        model.setGender(gender);
        String age=request.getParameter("age");
        model.setAge(Integer.parseInt(age));
        String phone=request.getParameter("phone");
        model.setPhone(Long.parseLong(phone));
        String email = request.getParameter("email");
        model.setEmail(email);
        String qq = request.getParameter("QQ");
        model.setQQ(Integer.parseInt(qq));*/
        ContactService contactService=new ContactServiceImpl();
        System.out.println(model.toString());
        try {
            contactService.insertContact(model);
        } catch (NameExistException e) {
            request.setAttribute("message",e.getMessage());
            request.getRequestDispatcher("/addContact.jsp").forward(request, response);

        }
        response.sendRedirect(request.getContextPath()+"/ContactIndex");
            }
    }

