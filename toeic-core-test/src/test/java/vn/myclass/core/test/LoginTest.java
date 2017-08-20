package vn.myclass.core.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import vn.myclass.core.dao.UserDao;
import vn.myclass.core.daoimpl.UserDaoImpl;
import vn.myclass.core.persistence.UserEntity;

public class LoginTest {
    private final Logger log = Logger.getLogger(this.getClass());
    @Test
    public void CheckUserExist(){
        UserDao userDao = new UserDaoImpl();
        String name = "quang";
        String password = "123456";
        UserEntity userEntity = userDao.isUserExist(name,password);
        if(userEntity != null){
            log.error("login success");
        }else {
            log.error("fail");
        }
    }

    @Test
    public void CheckFindRoleByUser(){
        UserDao userDao = new UserDaoImpl();
        String name = "quang";
        String password = "123456";
        UserEntity userEntity = userDao.FindRoleByUser(name,password);

        log.error(userEntity.getRoleEntity().getRoleId() +"-"+ userEntity.getRoleEntity().getName());
    }
}
