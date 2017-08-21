package vn.myclass.admin;

import org.omg.CORBA.Request;
import vn.myclass.command.ListenGuidelineCommand;
import vn.myclass.core.dto.ListenGuidelineDTO;
import vn.myclass.core.service.ListenGuidelineService;
import vn.myclass.core.service.impl.ListenGuidelineServiceImpl;
import vn.myclass.core.web.common.WebConstant;
import vn.myclass.core.web.utils.RequestUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/admin-guideline-listen-list.html")
public class ListenGuideineController extends HttpServlet{
    private ListenGuidelineService listenGuidelineService = new ListenGuidelineServiceImpl();
    @Override
    protected void doGet(HttpServletRequest resquest, HttpServletResponse response) throws ServletException, IOException {
        ListenGuidelineCommand command = new ListenGuidelineCommand();
        command.setMaxPageItems(2);
        Map<String,Object> property = new HashMap<String,Object>();
        property.put("context","1");
        RequestUtil.initSearchBean(resquest,command);
        Object [] objects = listenGuidelineService.findListenGuidelineByProperty(property,command.getSortExpression(),command.getSortDirection(),command.getFirstItem(),command.setMaxPageItems());
//        for(int i=0; i<2; i++){
//            ListenGuidelineDTO listenGuidelineDTO = new ListenGuidelineDTO();
//            listenGuidelineDTO.setTitle("bài hướng dẫn nghe " +(i+1));
//            listenGuidelineDTO.setContext(" Nội Dung bài hướng dẫn nghe "+(i+1));
//            listenGuidelineDTOList.add(listenGuidelineDTO);
//        }

        command.setListResult(listenGuidelineDTOList);
        command.setMaxPageItems(1);
        command.setTotalItems(listenGuidelineDTOList.size());
        resquest.setAttribute(WebConstant.LIST_ITEMS,command);


        RequestDispatcher rd = resquest.getRequestDispatcher("/views/admin/listenguideline/list.jsp");
        rd.forward(resquest,response);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
