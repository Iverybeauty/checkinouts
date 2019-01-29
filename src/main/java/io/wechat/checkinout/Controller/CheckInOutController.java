package io.wechat.checkinout.Controller;

import com.github.pagehelper.PageInfo;
import io.wechat.checkinout.dto.CheckRecordDTO;
import io.wechat.checkinout.po.CheckInOutRecord;
import io.wechat.checkinout.service.CheckInOutRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/checkinout")
public class CheckInOutController {

    @Autowired
    private CheckInOutRecordService checkInOutRecordService;


    @GetMapping("/getWithTime")
    public PageInfo<CheckInOutRecord> getWithPage(@RequestParam(required = false,defaultValue = "1")Integer pageNum){
        PageInfo<CheckInOutRecord> withPage = checkInOutRecordService.getWithPage(pageNum);
        return withPage;
    }

    @GetMapping("/getWithTime")
    public List<CheckRecordDTO> getWithTime(@RequestParam(required = false)Long timestamp){
        Date date = new Date();
        if(timestamp!=null){
            date=new Date(timestamp);
        }
        List<CheckRecordDTO> withTime = checkInOutRecordService.getWithTime(date);
        return withTime;
    }

}
