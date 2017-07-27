package com.service;

import com.dao.RoleDAO;
import com.model.Role;
import com.model.User;
import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleService {
    RoleDAO roleDAO;
    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Transactional
    public void addRole(Role role){
        roleDAO.addRole(role);
    }

    @Transactional
    public List<Role> list(){
        return roleDAO.list();
    }

    @Transactional
    public void deleteRole(int id){
        roleDAO.deleteRole(id);
    }

    @Transactional
    public void updateRole(Role role){
        roleDAO.updateRole(role);
    }

    @Transactional
    public Role searchRole(int id){
        return roleDAO.searchRole(id);
    }

    @Transactional
    public List<User> roleList(int id){
        return roleDAO.roleList(id);
    }
}
