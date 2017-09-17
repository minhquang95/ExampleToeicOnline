package vn.myclass.web;


import vn.myclass.command.SlideCommand;
import vn.myclass.core.dto.SlideDTO;
import vn.myclass.core.service.SlideService;
import vn.myclass.core.service.impl.SlideServiceImpl;
import vn.myclass.core.web.common.WebConstant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/home.html")
public class HomeController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SlideService slideService = new SlideServiceImpl();

        List<SlideDTO> list = slideService.FindAll();
        request.setAttribute(WebConstant.LIST_SLIDE_BANNER,list);
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
        rd.forward(request, response);
    }
}
