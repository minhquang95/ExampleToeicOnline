package vn.myclass.core.service;

import vn.myclass.core.dto.UserDTO;
import vn.myclass.core.persistence.UserEntity;

import java.io.IOException;
import java.util.Map;

public interface UserService {
    UserDTO isUserExist(UserDTO dto);
    UserDTO FindRoleByUser(UserDTO dto);
    Object[] findListenGuidelineByProperty(Map<String,Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);
    void ImportExcel(UserDTO userDTO);
}
