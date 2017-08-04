package com.service;

import com.dao.UserDAO;
import com.model.Role;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    @Transactional
    public void add(User user){
        userDAO.addUser(user);
    }

    @Transactional
    public List<User> list(){
        return userDAO.list();
    }

    @Transactional
    public void deleteUser(int id){
        userDAO.deleteUser(id);
    }

    @Transactional
    public void updateUser(User user){
        userDAO.updateUser(user);
    }

    @Transactional
    public User searchUser(int id){
        return userDAO.searchUser(id);
    }

    @Transactional
    public List<Role> roleList(int id){
        return userDAO.roleList(id);
    }
}
