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
