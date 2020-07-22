# 用户登录界面模块开发~编程小哥

# 一.采用技术栈

`JavaBean`+`Jsp`+`Servlet`

- 需求分析;
  1. 让用户在网页中输入用户名和密码
  2. 对用户名和密码进行验证，判断用户名是否合法，最后选择将登陆成功与否的结果返回给用户
  3. 假定合法的用户名和密码都为：admin
- 开发思路
  1. ​	这里采用 `Jsp`模式二的方法来实现，先编写一个 `JavaBean`作为模型，封装验证合法的用户的代码
  2. 编写一个 `Servlet`作为控制器，处理用户的请求
  3. 编写一个 `Jsp`页面作为 **视图**，显示用户的输入界面和登录结果界面

```java
package code1205;

public class UserBean {
    private String validUserName;
    private String validUserPassword;

    public String getValidUserName(){
        return validUserName;
    }

    public void setValidUserName(String validUserName){
        this.validUserName=validUserName;
    }

    public String getValidUserPassword(){
        return validUserPassword;
    }

    public void setValidUserPassword(String validUserPassword){
        this.validUserPassword=validUserPassword;
    }
    //验证账户密码
    public  boolean isValidUser(String name,String password){
        boolean result=false;
        if(validUserName.equals(name)&&validUserPassword.equals(password)){
            result=true;
        }
        return result;
    }

}

```

```java
package code1205;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;

@WebServlet("/userLogin")
public class UserLogin extends HttpServlet {
    private static final long serialVersionUID=1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException {
       /*
       * request.getParameter就是把jsp里的内容读取出来进行封装
       * */
        String name=request.getParameter("name");
       String password=request.getParameter("password");

       //设置合法的用户信息
        UserBean user=new UserBean();
        user.setValidUserName("admin");
        user.setValidUserPassword("admin");

        response.setCharacterEncoding("gb2312");
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out=response.getWriter();
        if(user.isValidUser(name,password)){//调用javaBean的方法来验证用户
            out.println("登录成功");
        }else {
            out.println("用户登录名或者密码错误，<a href='login.jsp'>请重试</a>");
        }

    }
    protected void doPost(HttpServletRequest request, HttpResponse
            response)throws IOException{
        doGet(request, (HttpServletResponse) response);
    }

}

```

```jsp
<%--
  Created by IntelliJ IDEA.
  User: 编程小哥令狐
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

```

| 登录页面                                        |
| ----------------------------------------------- |
| ![](Jsp与Servlet技术.assets/20200722160324.png) |

| 登录成功                                        |
| ----------------------------------------------- |
| ![](Jsp与Servlet技术.assets/20200722160325.png) |

| 登录失败                                        |
| ----------------------------------------------- |
| ![](Jsp与Servlet技术.assets/20200722160326.png) |

