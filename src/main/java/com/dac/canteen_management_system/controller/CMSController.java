package com.dac.canteen_management_system.controller;

import com.dac.canteen_management_system.dto.OrderDetailsRequest;
import com.dac.canteen_management_system.model.User;
import com.dac.canteen_management_system.service.CMSService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cms")
@Slf4j
public class CMSController {

    @Autowired
    CMSService cmsService;


    @RequestMapping(method = RequestMethod.POST,value = "/register",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerUser(@RequestBody User user){
        if(user.getUserName() == null || user.getPassword() == null){
            ResponseEntity.badRequest().body("Please provide proper details");
        }
        return ResponseEntity.ok(cmsService.registerNewUser(user));
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getMenu/{day}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getMenu(@PathVariable String day){
        return ResponseEntity.ok(cmsService.getTodaysMenu(day));
    }

    @RequestMapping(method = RequestMethod.POST,value = "/order/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> takeOrder(@RequestBody OrderDetailsRequest request){
        if(request.getUserId() < 0 || request.getOrderDetails().isEmpty()){
           return ResponseEntity.badRequest().body("Something went wrong please try again");
        }
        return ResponseEntity.ok(cmsService.placeOrder(request));
    }
}
