package vn.myclass.core.service.impl;

import vn.myclass.core.dao.UserDao;
import vn.myclass.core.daoimpl.UserDaoImpl;
import vn.myclass.core.dto.UserDTO;
import vn.myclass.core.persistence.UserEntity;
import vn.myclass.core.service.UserService;
import vn.myclass.core.ultils.UserBeanUtil;

public class UserServiceImpl implements UserService {
    public UserDTO isUserExist(UserDTO dto) {
        UserDao userDao = new UserDaoImpl();
        UserEntity userEntity = userDao.isUserExist(dto.getName(), dto.getPassword());

        return UserBeanUtil.entity2Dto(userEntity);
    }

    public UserDTO FindRoleByUser(UserDTO dto) {
        UserDao userDao = new UserDaoImpl();
        UserEntity userEntity = userDao.FindRoleByUser(dto.getName(), dto.getPassword());
        return UserBeanUtil.entity2Dto(userEntity);
    }



}
