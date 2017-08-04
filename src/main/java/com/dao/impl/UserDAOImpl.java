package com.dao;

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
public class UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(User user){
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
    }

    public List<User> list(){
        Session session = this.sessionFactory.getCurrentSession();
        List<User> list = session.createQuery("from User").list();
        return list;
    }

    public void deleteUser(int id){
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from User where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

//    public void updateUser(User user){
//        Session session = this.sessionFactory.getCurrentSession();
////        user.setId(user.getId());
////        user.setUsername(user.getUsername());
////        user.setPassword(user.getPassword());
////        user.setRoles(user.getRoles());
//        User user1 = searchUser(user.getId());
//        user1.setUsername(user.getUsername());
//        user1.setPassword(user.getPassword());
//        user1.setId(user.getId());
//        user1.setRoles(user.getRoles());
//        System.out.println(user.getRoles()+" "+user.getUsername());
//        System.out.println(user.getId());
//        session.update(user1);
//    }
//
//    public User searchUser(int id){
//        Session session = this.sessionFactory.getCurrentSession();
////        User user = (User) session.load(User.class, new Integer(id));
//        User user = (User) session.get(User.class, id);
//        System.out.println("Search by id"+user.getRoles());
//        for (Role r: user.getRoles()){
//            System.out.println(r.getRole());
//        }
//        user.getUsername();
//        return user;
//    }

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
        Set<Role> roles = user.getRoles();
        List<Role> list = new ArrayList<>(roles);
        return list;
    }
}