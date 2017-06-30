package com.model;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by User on 29.06.2017.
 */
@Entity
@Table(name = "time_ex", schema = "registration", catalog = "")
public class TimeEx {
    private int id;
    private Time time;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "time", nullable = true)
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeEx timeEx = (TimeEx) o;

        if (id != timeEx.id) return false;
        if (time != null ? !time.equals(timeEx.time) : timeEx.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
