package com.service;

import com.dao.TimeDAO;
import com.model.TimeEx;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TimeService {
    private TimeDAO timeDAO;
    public void setTimeDAO(TimeDAO timeDAO) {
        this.timeDAO = timeDAO;
    }

    @Transactional
    public List<TimeEx> time(){
        return timeDAO.time();
    }

    @Transactional
    public void addTime(TimeEx timeEx){
        timeDAO.addTime(timeEx);
    }

    @Transactional
    public void deleteTime(TimeEx timeEx){
        timeDAO.deleteTime(timeEx);
    }

    @Transactional
    public TimeEx searchTime(TimeEx timeEx){
        return timeDAO.searchTime(timeEx);
    }

    @Transactional
    public void updateTime(TimeEx timeEx){
        timeDAO.updateTime(timeEx);
    }
}
