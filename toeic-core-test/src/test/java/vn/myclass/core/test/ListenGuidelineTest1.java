package vn.myclass.core.test;

import org.testng.annotations.Test;
import vn.myclass.core.dao.ListenGuidelineDao;
import vn.myclass.core.daoimpl.ListenGuidelineDaoImpl;

import java.util.HashMap;
import java.util.Map;

public class ListenGuidelineTest1 {
    @Test
    public void checkApiFindbyproperty() {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("context","2");
        ListenGuidelineDao listenGuidelineDao = new ListenGuidelineDaoImpl();
        Object [] result = listenGuidelineDao.findProperty(map,null,null,null,2,2);
    }
}
