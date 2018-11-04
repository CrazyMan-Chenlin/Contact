package servlet;

import enity.Model;
import org.apache.commons.beanutils.BeanUtils;
import service.ContactService;
import service.impl.ContactServiceImpl;
import util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "UpdateServlet" ,urlPatterns = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("GBK");
        String id = request.getParameter("id");
        response.setContentType("text/html;charset=GBK");
        Model model = WebUtil.copyRequestToBean(request, Model.class);
        /*model.setId(Integer.parseInt(id));
        String name=request.getParameter("name");
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
            contactService.updateContact(model);
        System.out.println(model.toString());
        response.sendRedirect(request.getContextPath()+"/ContactIndex");
    }
}
