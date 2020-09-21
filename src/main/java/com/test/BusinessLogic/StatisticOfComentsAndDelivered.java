package com.test.BusinessLogic;

import com.test.model.Comment;

public class StatisticOfComentsAndDelivered {
    private Comment comment;

    private boolean isDelivered;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }
}
