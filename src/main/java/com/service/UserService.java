package com.service;

import com.dao.UserDAO;
import com.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private UserDAO userDAO;
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

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
}
