package com.dao;

import com.model.TimeEx;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TimeDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<TimeEx> time(){
        Session session = this.sessionFactory.getCurrentSession();
        List<TimeEx> time = session.createQuery("from TimeEx").list();
        return time;
    }

    public void addTime(TimeEx timeEx){
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(timeEx);
    }

    public void deleteTime(TimeEx timeEx){
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from TimeEx where time=:t");
        query.setParameter("t", timeEx.getTime());
        query.executeUpdate();
    }

    public TimeEx searchTime(TimeEx timeEx){
        Session session = this.sessionFactory.getCurrentSession();
        return timeEx;
    }

    public void updateTime(TimeEx timeEx){
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from TimeEx where time=:t");
        query.setParameter("t", timeEx.getTime());

        session.update(timeEx);

    }
}
