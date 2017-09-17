package vn.myclass.login;

import org.apache.log4j.Logger;
import vn.myclass.command.UserCommand;
import vn.myclass.core.dto.UserDTO;
import vn.myclass.core.service.UserService;
import vn.myclass.core.service.impl.UserServiceImpl;
import vn.myclass.core.web.common.WebConstant;
import vn.myclass.core.web.utils.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login.html")
public class LoginController extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/views/login/login.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserCommand command = FormUtil.populate(UserCommand.class, request);
        UserDTO pojo = command.getPojo();
        UserService userService = new UserServiceImpl();



        try {
            if (userService.isUserExist(pojo) != null) {
                if (userService.FindRoleByUser(pojo) != null && userService.FindRoleByUser(pojo).getRoleDTO() != null) {
                    session.setAttribute("user", pojo.getName());
                    if(session != null){
                        if(request.getParameter("rememberMe") != null){
                            Cookie username = new Cookie("username", pojo.getName());
                            Cookie password = new Cookie("password", pojo.getPassword());

                            username.setMaxAge(60*2);
                            password.setMaxAge(60*2);

                            response.addCookie( username );
                            response.addCookie( password );
                            response.setContentType("text/html");
                        }

                    }
                    if (userService.FindRoleByUser(pojo).getRoleDTO().getName().equals(WebConstant.ROLE_ADMIN)) {
                        response.sendRedirect("/admin-home.html");
                    } else if (userService.FindRoleByUser(pojo).getRoleDTO().getName().equals(WebConstant.ROLE_USER)) {
                        response.sendRedirect("/home.html");
                    }
                }
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("/views/login/login.jsp");
                rd.forward(request, response);
            }
        } catch (NullPointerException e) {
            log.error(e.getMessage(), e);
            request.setAttribute(WebConstant.ALERT, WebConstant.TYPE_ERROR);
            request.setAttribute(WebConstant.MESSAGE_RESPONSE, "Tên hoặc mật khẩu sai");
            RequestDispatcher rd = request.getRequestDispatcher("/views/login/login.jsp");
            rd.forward(request, response);
        }
    }
}