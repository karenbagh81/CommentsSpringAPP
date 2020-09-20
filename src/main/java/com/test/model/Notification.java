package com.test.model;

import javax.persistence.*;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "comment_id")
    private int commentId;

    private String time;

    private  boolean delivered;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int comment_id) {
        this.commentId = comment_id;
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
                ", comment_id=" + commentId +
                ", time='" + time + '\'' +
                ", delivered=" + delivered +
                '}';
    }
}
