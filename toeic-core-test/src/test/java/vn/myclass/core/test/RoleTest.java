package vn.myclass.core.test;

import org.junit.Test;
import vn.myclass.core.dao.RoleDao;
import vn.myclass.core.daoimpl.RoleDaoImpl;
import vn.myclass.core.persistence.RoleEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 6/7/2017.
 */
public class RoleTest {
    @Test
    public void checkFindAll(){
        RoleDao roleDao = new RoleDaoImpl();
        List<RoleEntity> list = roleDao.findAll();
    }

    @Test
    public void checkUpdateRole(){
        RoleDao roleDao =  new RoleDaoImpl();
        RoleEntity entity = new RoleEntity();
        entity.setRoleId(1);
        entity.setName("ADMIN");
        roleDao.Update(entity);

    }

    @Test
    public void checkSaveRole(){
        RoleDao roleDao =  new RoleDaoImpl();
        RoleEntity entity = new RoleEntity();
        entity.setRoleId(1);
        entity.setName("ADMIN");
        RoleEntity entity1 = new RoleEntity();
        entity1.setRoleId(2);
        entity1.setName("USER");
        roleDao.Update(entity);
        roleDao.Update(entity1);

    }

    @Test
    public void checkFindId(){
        RoleDao roleDao =  new RoleDaoImpl();
        RoleEntity entity = roleDao.FindID(1);
    }

    @Test
    public void checkDelete(){
        List<Integer> listID = new ArrayList<Integer>();
        listID.add(1);
        listID.add(2);
        RoleDao roleDao =  new RoleDaoImpl();
        Integer counnt = roleDao.Delete(listID);

    }
}
