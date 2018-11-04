package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

//具体业务的基类
@WebServlet(name = "BaseServlet",urlPatterns = "/BaseServlet")
public class BaseServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //使用action来判断动作，减少servlet的数量
        String action = request.getParameter("action");
        System.out.println(action);
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        /*if ("addContact".equals(action)){
            addContact(request, response);
        }else if ("updateContact".equals(action)){
            updateContact(request, response);
        }else if("delContact".equals(action)){
            delContact(request, response);
        }else if("queryContact".equals(action)){
            queryContact(request, response);
        }else if("getContact".equals(action)){
            getContact(request, response);
        }else if ("batchDel".equals(action)){
            batchDel(request, response);
    }*/
        try {
            //参数一方法名
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            //调用方法
            method.setAccessible(true);
            method.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
