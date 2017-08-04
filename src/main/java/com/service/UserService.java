package com.service;

import com.model.Role;
import com.model.User;

import java.util.List;

/**
 * Created by User on 28.07.2017.
 */
public interface UserService {
    void add(User user);
    List<User> list();
    void deleteUser(int id);
    User searchUser(int id);
    void updateUser(User user);
    List<Role> roleList(int id);
}
