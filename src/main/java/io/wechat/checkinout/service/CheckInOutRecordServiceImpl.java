package io.wechat.checkinout.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.wechat.checkinout.dao.CheckInOutRecordMapper;
import io.wechat.checkinout.dto.CheckRecordDTO;
import io.wechat.checkinout.po.CheckInOutRecord;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class CheckInOutRecordServiceImpl implements CheckInOutRecordService{

   @Autowired
   private CheckInOutRecordMapper checkInOutRecordMapper;

    @Override
    public PageInfo<CheckInOutRecord> getWithPage(Integer pageNum) {
        PageHelper.startPage(pageNum,3);
        Page<CheckInOutRecord> checkInOutRecords = checkInOutRecordMapper.selectWithPage();
        PageInfo<CheckInOutRecord> checkInOutRecordPageInfo =checkInOutRecords.toPageInfo();
        return checkInOutRecordPageInfo;
    }


    @Override
    public List<CheckRecordDTO> getWithTime(Date time) {

        return null;
    }



}
