package com.dao.impl;

import com.dao.RoleDAO;
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
public class RoleDAOImpl implements RoleDAO {
    @Autowired
    SessionFactory sessionFactory;

    public void addRole(Role role){
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(role);
    }

    public List<Role> list(){
        Session session = this.sessionFactory.getCurrentSession();
        List<Role> list = session.createQuery("from Role").list();
        return list;
    }

    public void deleteRole(int id){
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Role where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public Role searchRole(int id){
        Session session = this.sessionFactory.getCurrentSession();
        Role role = (Role) session.get(Role.class, new Integer(id));
        role.getRole();
        return role;
    }

    public void updateRole(Role role){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(role);
    }

    public List<User> roleList(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Role role = (Role) session.load(Role.class, new Integer(id));
        Set<User> users = role.getUsers();
        List<User> list = new ArrayList<>(users);
        return list;
    }
}
