package com.service;

import com.dao.impl.RoleDAOImpl;
import com.model.Role;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleDAOImpl roleDAOImpl;

    @Transactional
    public void addRole(Role role){
        roleDAOImpl.addRole(role);
    }

    @Transactional
    public List<Role> list(){
        return roleDAOImpl.list();
    }

    @Transactional
    public void deleteRole(int id){
        roleDAOImpl.deleteRole(id);
    }

    @Transactional
    public void updateRole(Role role){
        roleDAOImpl.updateRole(role);
    }

    @Transactional
    public Role searchRole(int id){
        return roleDAOImpl.searchRole(id);
    }

    @Transactional
    public List<User> roleList(int id){
        return roleDAOImpl.roleList(id);
    }
}
