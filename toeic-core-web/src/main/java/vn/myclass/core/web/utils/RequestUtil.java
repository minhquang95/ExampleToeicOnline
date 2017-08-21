package vn.myclass.core.web.utils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;
import vn.myclass.core.web.command.AbstractCommand;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
    private final Logger log = Logger.getLogger(this.getClass());
    public static void initSearchBean(HttpServletRequest request, AbstractCommand bean) {
        if(bean !=null){
            String sortExpression = request.getParameter(new ParamEncoder(bean.getTableId()).encodeParameterName(TableTagParameters.PARAMETER_SORT));
            String sortDirection = request.getParameter(new ParamEncoder(bean.getTableId()).encodeParameterName(TableTagParameters.PARAMETER_ORDER));
            String pageStr = request.getParameter(new ParamEncoder(bean.getTableId()).encodeParameterName(TableTagParameters.PARAMETER_PAGE));
            Integer page = 1;

            if(StringUtils.isNotBlank(pageStr)){
                try{
                    page = Integer.valueOf(pageStr);
                } catch(Exception e){
                    System.out.println(e);
                }

            }
            bean.setPage(page);
            bean.setSortDirection(sortDirection);
            bean.setSortDirection(sortExpression);
            bean.setFirstItem((bean.getPage()-1) * bean.getMaxPageItems());
        }
    }
}