
package servlet;
import util.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

@WebServlet(name = "JDBCServlet",urlPatterns ="/JDBCServlet.html")
public class JDBCServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection=null;
        CallableStatement callableStatement=null;
        //1.创建连接
        try {
            connection = JdbcUtil.getConnection();
            //2.准备sql
            String sql="CALL pro_GetName(?,?)";
            //3.预编译
            callableStatement=connection.prepareCall(sql);
            //4.参数赋值
            //输入参数
            callableStatement.setInt(1,1);
            //输出参数
            callableStatement.registerOutParameter(2, Types.VARCHAR);
            //5.执行命令sql
            callableStatement.executeUpdate();
            //结果在输出参数中，从输出参数查看结果
            //这里的参数和设置输出参数位置一样
            String name=callableStatement.getString(2);
            System.out.println(name);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(callableStatement,connection);
        }

    }
}
