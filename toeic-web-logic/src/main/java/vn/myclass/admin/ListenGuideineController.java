package vn.myclass.admin;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.log4j.Logger;
import org.omg.CORBA.Request;
import vn.myclass.command.ListenGuidelineCommand;
import vn.myclass.core.common.util.UploadUtil;
import vn.myclass.core.dto.ListenGuidelineDTO;
import vn.myclass.core.service.ListenGuidelineService;
import vn.myclass.core.service.impl.ListenGuidelineServiceImpl;
import vn.myclass.core.web.common.WebConstant;
import vn.myclass.core.web.utils.FormUtil;
import vn.myclass.core.web.utils.RequestUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(urlPatterns = {"/admin-guideline-listen-list.html","/admin-guideline-listen-edit.html"})
public class ListenGuideineController extends HttpServlet{
    private final Logger log = Logger.getLogger(this.getClass());
    private ListenGuidelineService listenGuidelineService = new ListenGuidelineServiceImpl();
    ResourceBundle resourceBundle = ResourceBundle.getBundle("ApplicationResources");
    ListenGuidelineCommand listenGuidelineCommand = new ListenGuidelineCommand();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ListenGuidelineCommand command = FormUtil.populate(ListenGuidelineCommand.class, request);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("ApplicationResources");
        HttpSession session = request.getSession();
        ListenGuidelineService listenGuidelineService = new ListenGuidelineServiceImpl();
        if(session != null) {
            request.setAttribute(WebConstant.ALERT, session.getAttribute(WebConstant.ALERT));
            request.setAttribute(WebConstant.MESSAGE_RESPONSE, session.getAttribute(WebConstant.MESSAGE_RESPONSE));
        }

        command.setMaxPageItems(2);
        RequestUtil.initSearchBean(request, command);
        Map<String,Object> map = new HashMap<String,Object>();
        Object[] objects = listenGuidelineService.findListenGuidelineByProperty(map, command.getSortExpression(), command.getSortDirection(),command.getFirstItem(),command.getMaxPageItems());
        command.setListResult((List<ListenGuidelineDTO>) objects[1]);
        command.setTotalItems(Integer.parseInt(objects[0].toString()));
        request.setAttribute(WebConstant.ALERT, WebConstant.TYPE_SUCCESS);
        request.setAttribute(WebConstant.MESSAGE_RESPONSE, resourceBundle.getString("label.guideline.listen.add.success"));
        request.setAttribute(WebConstant.LIST_ITEMS, command);
        if (command.getTypeUrl() != null && command.getTypeUrl().equals(WebConstant.URL_LIST)) {
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/listenguideline/list.jsp");
            rd.forward(request, response);
        } else if (command.getTypeUrl() !=null && command.getTypeUrl().equals(WebConstant.URL_EDIT)) {
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/listenguideline/edit.jsp");
            rd.forward(request, response);
        }
        session.removeAttribute(WebConstant.ALERT);
        session.removeAttribute(WebConstant.MESSAGE_RESPONSE);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ListenGuidelineCommand command = new ListenGuidelineCommand();
        ResourceBundle bundle = ResourceBundle.getBundle("ApplicationResources");
        UploadUtil uploadUtil = new UploadUtil();
        HttpSession session = request.getSession();
        Set<String> valueTitle = buildSetValueListenGuideline();
        Map<String,String> mapValue = new HashMap<String, String>();

        try {
           Object [] objects = uploadUtil.writeOrUpdateFile(request,valueTitle,WebConstant.LISTENGUIDELINE);
           mapValue = (Map<String, String>) objects[3];
           command = returnValueListenGuidelineCommand(valueTitle,command,mapValue);

            session.setAttribute(WebConstant.ALERT,WebConstant.TYPE_SUCCESS);
            session.setAttribute(WebConstant.MESSAGE_RESPONSE,bundle.getString("label.guideline.listen.add.success"));
        } catch (FileUploadException e) {
            log.error(e.getMessage(),e);
            session.setAttribute(WebConstant.ALERT,WebConstant.TYPE_ERROR);
            session.setAttribute(WebConstant.MESSAGE_RESPONSE,bundle.getString("lable.error"));
        } catch (Exception e){
            log.error(e.getMessage(),e);
            session.setAttribute(WebConstant.ALERT,WebConstant.TYPE_ERROR);
            session.setAttribute(WebConstant.MESSAGE_RESPONSE,bundle.getString("lable.error"));
        }
         response.sendRedirect("/admin-guideline-listen-list.html?typeUrl=url_list");

    }

    private ListenGuidelineCommand returnValueListenGuidelineCommand(Set<String> valueTitle, ListenGuidelineCommand command,Map<String,String> mapValue) {
        for(String item: valueTitle){
            if(mapValue.containsKey(item)){
                if(item.equals("pojo.title")){
                    command.getPojo().setTitle(mapValue.get(item));
                }else if(item.equals("pojo.context")){
                    command.getPojo().setContext(mapValue.get(item));
                }

            }
        }
        return command;
    }

    private Set<String> buildSetValueListenGuideline() {
        Set<String> returnValue = new HashSet<String>();
        returnValue.add("pojo.title");
        returnValue.add("pojo.context");
        return  returnValue;
    }

}