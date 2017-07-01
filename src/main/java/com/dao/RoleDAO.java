package com.dao;

import com.model.Role;
import com.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDAO {
    SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

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

//    public void roleList(int id) {
//        Session session = this.sessionFactory.getCurrentSession();
//        User user = (User) session.load(User.class, new Integer(id));
//        for (Role r : user.getRoles()) {
//            Query query = session.createQuery("from Role where role=:r");
//            query.setParameter("r", r.getRole());
//        }
//    }
}
