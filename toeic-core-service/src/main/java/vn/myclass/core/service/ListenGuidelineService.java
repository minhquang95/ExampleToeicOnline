package vn.myclass.core.service;

import vn.myclass.core.dto.ListenGuidelineDTO;

import java.util.List;
import java.util.Map;

public interface ListenGuidelineService {

    Object[] findListenGuidelineByProperty(Map<String,Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);

}
