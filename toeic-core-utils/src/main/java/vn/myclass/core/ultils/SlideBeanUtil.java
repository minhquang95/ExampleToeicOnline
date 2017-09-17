package vn.myclass.core.ultils;

import vn.myclass.core.dto.RoleDTO;
import vn.myclass.core.dto.SlideDTO;
import vn.myclass.core.persistence.RoleEntity;
import vn.myclass.core.persistence.SlideEntity;

public class SlideBeanUtil {
    public static SlideDTO entity2dto(SlideEntity slideEntity){
        SlideDTO slideDTO = new SlideDTO();
        slideDTO.setSlidecontent(slideEntity.getSlidecontent());
        slideDTO.setSlideimage(slideEntity.getSlideimage());
        slideDTO.setSlidename(slideEntity.getSlidename());
        slideDTO.setSlideid(slideEntity.getSlideid());
        return slideDTO;
    }

    public static SlideEntity dto2entity(SlideDTO slideDTO){
        SlideEntity slideEntity = new SlideEntity();
        slideEntity.setSlidecontent(slideDTO.getSlidecontent());
        slideEntity.setSlideimage(slideDTO.getSlideimage());
        slideEntity.setSlidename(slideDTO.getSlidename());
        slideEntity.setSlideid(slideDTO.getSlideid());
        return slideEntity;
    }
}
