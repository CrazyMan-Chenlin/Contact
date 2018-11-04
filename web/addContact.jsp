<!DOCTYPE html>
<%@ page contentType="text/html;charset=utf-8" language="java"  isErrorPage="true" %>
<html>
<head>
    <meta content="text/html;charset=utf-8">
    <script type="text/javascript" src="js/CheckInput.js" charset="GBK" ></script>
    <title>添加联系人</title>
</head>
<body>
<h2 style="text-align: center">添加联系人</h2>
<hr>
<form method="get" action="${pageContext.request.contextPath}/Contact" onsubmit="return checkAll()">
    <input type="hidden" name="action" value="addContact" />
<table border="1px" width="400px" align="center">
    <tbody>
    <tr>
        <th>姓名</th>
        <td><input id="name" name="name" type="text" onblur="checkName()" />
            <font color="red">${message}</font>
        <span id="nameTip"></span>
        </td>
    </tr>
    <tr>
        <th>性别</th>
        <td ><input type="radio"  name="gender" value="男" onclick="checkGender()"/>男<input type="radio" name="gender" value="女" onclick="checkGender()"/>女
        <span id="genderTip"></span>
        </td>
    </tr>
    <tr>
        <th>年龄</th>
        <td><input type="text" id="age" name="age" onblur="checkAge()"/>
        <span id="ageTip"></span>
        </td>
    </tr>
    <tr>
        <th>电话</th>
        <td><input type="text" id="phone" name="phone" onblur="checkPhone()"/>
        <span id="phoneTip"></span>
        </td>
    </tr>
    <tr>
        <th>邮箱</th>
    <td><input type="text" id="email" name="email" onblur="checkMail()"/>
    <span id="emailTip"></span>
    </td>
    </tr>
    <tr>
    <th>QQ</th>
        <td><input type="text" id="QQ" name="QQ" onblur="checkQQ()"/>
        <span id="QQTip"></span>
        </td>
    </tr>
    </tbody>
    <tr>
        <td colspan="2" style="text-align: center"><input type="submit" /><input type="reset"/></td>
    </tr>
</table>
</form>
</body>
</html>