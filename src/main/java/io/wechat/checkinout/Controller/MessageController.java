package io.wechat.checkinout.Controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/message")
public class MessageController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @PostMapping(value = "/receive2",produces = MediaType.APPLICATION_XML_VALUE)
    public Object receive2 (@RequestBody JSONObject messageReceiveDTO){
        logger.info("{}", JSON.toJSONString(messageReceiveDTO));
        return "";
    }


}
