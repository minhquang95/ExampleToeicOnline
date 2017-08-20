package vn.myclass.admin;

import vn.myclass.command.UserCommand;
import vn.myclass.core.web.common.WebConstant;
import vn.myclass.core.web.utils.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-user-list.html","/admin-user-edit.html"})
public class UserController extends HttpServlet{
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
     UserCommand userCommand = FormUtil.populate(UserCommand.class,request);
     if(userCommand !=null){
         if(userCommand.getTypeUrl().equals(WebConstant.URL_LIST)){
             RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/list.jsp");
             rd.forward(request,response);
         }
     }
    }
}
