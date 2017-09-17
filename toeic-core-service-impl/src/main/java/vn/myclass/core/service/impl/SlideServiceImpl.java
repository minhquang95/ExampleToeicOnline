package vn.myclass.core.service.impl;

import vn.myclass.core.dao.SlideDao;
import vn.myclass.core.daoimpl.SlideDaoImpl;
import vn.myclass.core.dto.SlideDTO;
import vn.myclass.core.persistence.SlideEntity;
import vn.myclass.core.service.SlideService;
import vn.myclass.core.ultils.SlideBeanUtil;

import java.util.ArrayList;
import java.util.List;

public class SlideServiceImpl implements SlideService{
    public List<SlideDTO> FindAll() {
        List<SlideEntity> list1 = new ArrayList<SlideEntity>();
        List<SlideDTO> list = new ArrayList<SlideDTO>();
        SlideDao slideDao = new SlideDaoImpl();
        list1 = slideDao.findAll();
        for(int i =0; i< list1.size(); i++){
            list.add(SlideBeanUtil.entity2dto(list1.get(i)));
        }
        return list;
    }
}
