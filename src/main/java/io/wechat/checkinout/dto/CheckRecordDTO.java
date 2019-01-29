package io.wechat.checkinout.dto;

import io.wechat.checkinout.po.CheckInOutRecord;
import io.wechat.checkinout.po.User;

public class CheckRecordDTO extends CheckInOutRecord {

    private Long timestamp;
    private User user;

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
