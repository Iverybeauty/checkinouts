package io.wechat.checkinout.service;

import com.github.pagehelper.PageInfo;
import io.wechat.checkinout.po.User;


import java.util.Date;

public interface UserService {
        User getById(String openId);
        void create(User user);
        void checkInOut(String openId, Date time);
}
