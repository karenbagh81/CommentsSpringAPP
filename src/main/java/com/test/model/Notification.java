package com.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int comment_id;

    private String time;

    private  boolean delivered;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", comment_id=" + comment_id +
                ", time='" + time + '\'' +
                ", delivered=" + delivered +
                '}';
    }
}
