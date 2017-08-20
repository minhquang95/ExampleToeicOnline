package vn.myclass.admin;

import org.omg.CORBA.Request;
import vn.myclass.command.ListenGuidelineCommand;
import vn.myclass.core.dto.ListenGuidelineDTO;
import vn.myclass.core.web.common.WebConstant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin-guideline-listen-list.html")
public class ListenGuideineController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest resquest, HttpServletResponse response) throws ServletException, IOException {
        ListenGuidelineCommand command = new ListenGuidelineCommand();
        List<ListenGuidelineDTO> listenGuidelineDTOList = new ArrayList<ListenGuidelineDTO>();
        for(int i=0; i<2; i++){
            ListenGuidelineDTO listenGuidelineDTO = new ListenGuidelineDTO();
            listenGuidelineDTO.setTitle("bài hướng dẫn nghe " +(i+1));
            listenGuidelineDTO.setContent(" Nội Dung bài hướng dẫn nghe "+(i+1));
            listenGuidelineDTOList.add(listenGuidelineDTO);
        }
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
