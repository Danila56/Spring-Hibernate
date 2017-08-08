package com.dao.impl;

import com.dao.UserDAO;
import com.model.Role;
import com.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(User user){
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
    }

    public List<User> list(){
        Session session = this.sessionFactory.getCurrentSession();
        List<User> list = session.createQuery("from com.model.User").list();
        return list;
    }

    public void deleteUser(int id){
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from com.model.User where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public User searchUser(int id){
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, new Integer(id));
        user.getUsername();
        return user;
    }

    public void updateUser(User user){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
    }

    public List<Role> roleList(int id){
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        List<Role> roles = user.getRoles();
        List<Role> list = new ArrayList<>(roles);
        return list;
    }


    public User findByUsername(String username){
        Session session = this.sessionFactory.getCurrentSession();
        List<User> list = new ArrayList<>();
        list = session.createQuery("from com.model.User where username=?").setParameter(0, username).list();
        if (list.size()>0){
            return list.get(0);
        }
        else return null;
    }
}