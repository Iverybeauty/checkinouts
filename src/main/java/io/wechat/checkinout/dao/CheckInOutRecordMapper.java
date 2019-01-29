package io.wechat.checkinout.dao;

import com.github.pagehelper.Page;
import io.wechat.checkinout.po.CheckInOutRecord;

public interface CheckInOutRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CheckInOutRecord record);

    int insertSelective(CheckInOutRecord record);

    CheckInOutRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CheckInOutRecord record);

    int updateByPrimaryKey(CheckInOutRecord record);

    Page<CheckInOutRecord> selectWithPage();


}