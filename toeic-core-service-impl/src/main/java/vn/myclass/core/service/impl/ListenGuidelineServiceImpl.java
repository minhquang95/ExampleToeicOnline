package vn.myclass.core.service.impl;

import vn.myclass.core.dao.ListenGuidelineDao;
import vn.myclass.core.daoimpl.ListenGuidelineDaoImpl;
import vn.myclass.core.dto.ListenGuidelineDTO;
import vn.myclass.core.persistence.ListenGuideLineEntity;
import vn.myclass.core.service.ListenGuidelineService;
import vn.myclass.core.ultils.ListenGuidelineBeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListenGuidelineServiceImpl implements ListenGuidelineService {
    private ListenGuidelineDao listenGuidelineDao = new ListenGuidelineDaoImpl();
    public Object [] findListenGuidelineByProperty(Map<String, Object> property, Object value, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        List<ListenGuidelineDTO> result = new ArrayList<ListenGuidelineDTO>();
        Object [] objects = listenGuidelineDao.findProperty(property,value,sortExpression,sortDirection,offset,limit);
        for(ListenGuideLineEntity item : (List<ListenGuideLineEntity>)objects[1]){
            ListenGuidelineDTO listenGuidelineDTO = ListenGuidelineBeanUtil.entity2dto(item);
            result.add(listenGuidelineDTO);
        }
        objects[1] = result;
        return objects;
    }
}
