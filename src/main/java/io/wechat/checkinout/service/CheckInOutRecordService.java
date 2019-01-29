package io.wechat.checkinout.service;

import com.github.pagehelper.PageInfo;
import io.wechat.checkinout.dto.CheckRecordDTO;
import io.wechat.checkinout.po.CheckInOutRecord;

import java.util.Date;
import java.util.List;

public interface CheckInOutRecordService {
    PageInfo<CheckInOutRecord> getWithPage(Integer pageNum);
    List<CheckRecordDTO> getWithTime(Date time);

}
