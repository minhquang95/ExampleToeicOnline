package vn.myclass.core.ultils;

import vn.myclass.core.dto.ListenGuidelineDTO;
import vn.myclass.core.dto.RoleDTO;
import vn.myclass.core.persistence.ListenGuideLineEntity;
import vn.myclass.core.persistence.RoleEntity;

public class ListenGuidelineBeanUtil {
    public static ListenGuidelineDTO entity2dto(ListenGuideLineEntity listenGuideLineEntity){
        ListenGuidelineDTO listenGuidelineDTO = new ListenGuidelineDTO();
        listenGuidelineDTO.setCreattedDate(listenGuideLineEntity.getCreattedDate());
        listenGuidelineDTO.setContext(listenGuideLineEntity.getContext());
        listenGuidelineDTO.setImage(listenGuideLineEntity.getImage());
        listenGuidelineDTO.setTitle(listenGuideLineEntity.getTitle());
        listenGuidelineDTO.setModifiedDate(listenGuideLineEntity.getModifiedDate());
        listenGuidelineDTO.setListenGuideLineId(listenGuideLineEntity.getListenGuideLineId());
        return listenGuidelineDTO;
    }

    public static ListenGuideLineEntity dto2entity(ListenGuidelineDTO listenGuideLineDTO){
        ListenGuideLineEntity listenGuideLineEntity = new ListenGuideLineEntity();
        listenGuideLineEntity.setCreattedDate(listenGuideLineDTO.getCreattedDate());
        listenGuideLineEntity.setContext(listenGuideLineDTO.getContext());
        listenGuideLineEntity.setImage(listenGuideLineDTO.getImage());
        listenGuideLineEntity.setTitle(listenGuideLineDTO.getTitle());
        listenGuideLineEntity.setModifiedDate(listenGuideLineDTO.getModifiedDate());
        listenGuideLineEntity.setListenGuideLineId(listenGuideLineDTO.getListenGuideLineId());
        return listenGuideLineEntity;
    }
}
