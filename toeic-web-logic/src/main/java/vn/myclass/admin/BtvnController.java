package vn.myclass.admin;

import vn.myclass.command.ListenGuidelineCommand;
import vn.myclass.command.UserCommand;
import vn.myclass.core.dto.ListenGuidelineDTO;
import vn.myclass.core.dto.UserDTO;
import vn.myclass.core.service.ListenGuidelineService;
import vn.myclass.core.service.UserService;
import vn.myclass.core.service.impl.ListenGuidelineServiceImpl;
import vn.myclass.core.service.impl.UserServiceImpl;
import vn.myclass.core.web.common.WebConstant;
import vn.myclass.core.web.utils.FormUtil;
import vn.myclass.core.web.utils.RequestUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

@WebServlet("/admin-btvn.html")
public class BtvnController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserCommand command = new UserCommand();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("ApplicationResources");

        UserService userService = new UserServiceImpl();
        command.setMaxPageItems(2);
        Map<String,Object> map = new HashMap<String,Object>();
        Object[] objects = userService.findUserProperty(map,null,null,command.getFirstItem(),command.getMaxPageItems());
        command.setListResult((List<UserDTO>) objects[1]);
        command.setTotalItems(Integer.parseInt(objects[0].toString()));
//        request.setAttribute(WebConstant.ALERT, WebConstant.TYPE_SUCCESS);
//        request.setAttribute(WebConstant.MESSAGE_RESPONSE, resourceBundle.getString("label.guideline.listen.add.success"));
        request.setAttribute(WebConstant.LIST_ITEMS, command);
        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/btvn/btvn.jsp");
        rd.forward(request, response);


    }
}