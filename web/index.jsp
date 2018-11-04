<%@ page import="enity.Model" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: chenlin
  Date: 2018.6.15
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" isErrorPage="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>ContactIndex</title>
  </head>
  <body>
  <h2 style='text-align: center'>查询所有联系人</h2>
  <hr>
  <form action="${pageContext.request.contextPath}/Contact" method="get">
      <input type="hidden" name="action" value="batchDel"/>
      <table border='1px' width='1000px' align='center'>
          <thead>
          <tr>
              <th>
                  <input type="checkbox" id="all" onclick="checkDelete(this)"/>全选/反选
                  <input type="submit" value="批量删除"/>
              </th>
              <th>编号</th>
              <th>姓名</th>
              <th>性别</th>
              <th>年龄</th>
              <th>电话</th>
              <th>邮箱</th>
              <th>QQ</th>
              <th>操作</th></tr>
          </thead>
          <tbody>
          <c:forEach items="${models}" var="contact" varStatus="contactStatus">
              <tr>
                  <td><input type="checkbox" name="item" value="${contact.id}"/> </td>
                  <td>${contactStatus.count}</td>
                  <td>${contact.name}</td>
                  <td>${contact.gender}</td>
                  <td>${contact.age}</td>
                  <td>${contact.phone}</td>
                  <td>${contact.email}</td>
                  <td>${contact.QQ}</td>
                  <td><a href="${pageContext.request.contextPath}/Contact?action=getContact&id=${contact.id}">修改</a>
                      <a href="javascript:void(0)" onclick="deleteContact(${contact.id})">删除</a>
                  </td>
              </tr>
          </c:forEach>
          </tbody>
          <tfoot>
          <tr>
              <td colspan='9' style='text-align: center'><a href='addContact.jsp'>添加联系人</a></td>
          </tr>
          </tfoot>
      </table>
  </form>
  </body>
  <script type="text/javascript">
      function deleteContact(id) {
          if(window.confirm("是否继续删除，一旦删除不能恢复！")){
              var url="${pageContext.request.contextPath}/DeleteContact?id="+id;
              window.location.href=url;
          }
      }
      function checkDelete(obj) {
          var itemList=document.getElementsByName("item");
          for(var i=0; i<itemList.length;i++){
              itemList[i].checked=obj.checked;
          }
      }
  </script>
</html>
