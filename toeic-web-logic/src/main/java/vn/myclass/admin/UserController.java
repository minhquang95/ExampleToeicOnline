package vn.myclass.admin;

import vn.myclass.command.ListenGuidelineCommand;
import vn.myclass.command.UserCommand;
import vn.myclass.core.dto.UserDTO;
import vn.myclass.core.service.RoleService;
import vn.myclass.core.service.UserService;
import vn.myclass.core.service.impl.RoleServiceImpl;
import vn.myclass.core.service.impl.UserServiceImpl;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/admin-user-list.html","/admin-user-edit.html"})
public class UserController extends HttpServlet{
    private UserService userService = new UserServiceImpl();
    private RoleService roleService = new RoleServiceImpl();
    ResourceBundle resourceBundle = ResourceBundle.getBundle("ApplicationResources");
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
     UserCommand userCommand = FormUtil.populate(UserCommand.class,request);
     UserDTO pojo = userCommand.getPojo();
     Map<String,Object> map = new HashMap<String,Object>();
     Object [] objects = userService.findListenGuidelineByProperty(map,userCommand.getSortExpression(),userCommand.getSortExpression(),userCommand.getFirstItem(),userCommand.getMaxPageItems());
     userCommand.setListResult((List<UserDTO>) objects[1]);
     userCommand.setTotalItems((Integer.parseInt(objects[0].toString())));
     request.setAttribute(WebConstant.LIST_ITEMS, userCommand);
     if (userCommand.getTypeUrl() != null && userCommand.getTypeUrl().equals(WebConstant.URL_LIST)) {
         RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/list.jsp");
         rd.forward(request, response);
     } else if (userCommand.getTypeUrl() !=null && userCommand.getTypeUrl().equals(WebConstant.URL_EDIT)) {
         if(userCommand.getCrudaction() != null && userCommand.getCrudaction().equals(WebConstant.INSERT_UPDATE)){

         } else if(pojo != null && pojo.getUserId() !=null){
             userCommand.setPojo(userService.findById(pojo.getUserId()));
         }
         userCommand.setRoleList(roleService.findAll());
         request.setAttribute(WebConstant.FORM_ITEM, userCommand);
         RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/edit.jsp");
         rd.forward(request, response);
     }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}
