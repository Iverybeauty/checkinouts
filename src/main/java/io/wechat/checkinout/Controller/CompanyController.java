package io.wechat.checkinout.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.stream.Location;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Value("${checkInOut.longitude}")
    private Double longitude;

    @Value("${checkInOut.latitude}")
    private Double latitude;

    @GetMapping("/getCheckInOutLocation")
   public Location getCheckInOutLocation(){


return null;


    }
}
