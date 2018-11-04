<%@ page import="enity.Model" %><%--
  Created by IntelliJ IDEA.
  User: chenlin
  Date: 2018.7.11
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <script type='text/javascript' src='js/CheckInput.js' charset='utf-8'></script>
    <title>UpdateContactIndex</title>
</head>
<body>
    <h2 style='text-align: center'>修改联系人</h2>
    <hr>
    <form method='get' action=${pageContext.request.contextPath}/Contact onsubmit='return checkAll()' >
    <input type="hidden" name="action" value="updateContact"/>
    <table border='1px' width='350px' align='center'>
        <input type="hidden" name="id" value="${contact.id}"/>
        <tr><th>姓名 </th>
            <td><input type='text' id='name' name='name' value=${contact.name} onblur='checkName()' readonly="readonly"/>
                <input type='hidden' name='id' value=${contact.id} />
                <span id='nameTip'></span></td></tr>
       <tr><th>性别</th>

           <td onclick='checkGender()'><input type='radio' name='gender' value='男' <c:if test="${contact.gender=='男'}">checked="checked"</c:if>/>男
                       <input type='radio' value='女' name='gender'  <c:if test="${contact.gender=='女'}">checked="checked"</c:if>/>女
                   </td>
       </tr>
        <tr>
            <th>年龄</th>
           <td><input type='text'id='age' name='age' value=${contact.age} onblur='checkAge()'/>
                <span id='ageTip'></span></td>
        </tr>
      <tr>
          <th>电话</th>
          <td><input type='text' id='phone' name='phone' value=${contact.phone} onblur='checkPhone()'/>
              <span id='phoneTip'></span></td>
      </tr>
       <tr>
           <th>邮箱</th>
            <td><input type='text' id='email' name='email' value=${contact.email} onblur='checkMail()'/>
                <span id='emailTip'></span></td>
       </tr>
      <tr>
          <th>QQ</th>
            <td><input type='text' id='QQ' name='QQ' value=${contact.QQ} onblur='checkQQ()'/>
                  <span id='QQTip'></span></td>
      </tr>
        <tr>
            <td colspan='2' style='text-align: center'>
                <input type='submit'/><input type='reset'/></td>
        </tr>
        </table>
    </form>
</body>
</html>
