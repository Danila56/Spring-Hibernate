package com.dao;

import com.model.Role;
import com.model.User;

import java.util.List;

/**
 * Created by User on 28.07.2017.
 */
public interface RoleDAO {
    void addRole(Role role);
    List<Role> list();
    void deleteRole(int id);
    Role searchRole(int id);
    void updateRole(Role role);
    List<User> roleList(int id);
}
