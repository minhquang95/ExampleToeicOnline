package vn.myclass.core.ultils;

import vn.myclass.core.dto.RoleDTO;
import vn.myclass.core.persistence.RoleEntity;

public class RoleBeanUtil {
    public static RoleDTO entitytoDTO(RoleEntity roleEntity){
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleId(roleEntity.getRoleId());
        roleDTO.setName(roleEntity.getName());
        return roleDTO;
    }

    public static RoleEntity DTOtoentity(RoleDTO roleDTO){
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleId(roleDTO.getRoleId());
        roleEntity.setName(roleDTO.getName());
        return roleEntity;
    }
}
