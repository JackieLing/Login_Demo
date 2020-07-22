<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/22
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>用户登录</title>
  </head>
  <body>
  <form action="userLogin" method="get">
    <table>
      <tr>
        <td>用户名：</td>
        <td><input type="text" name="name"></td>
      </tr>
      <tr>
        <td>密码：</td>
        <td><input type="password" name="password"/></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="登录"/></td>
      </tr>
    </table>
  </form>
  </body>
</html>
