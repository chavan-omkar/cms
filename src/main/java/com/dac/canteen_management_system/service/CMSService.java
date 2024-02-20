package com.dac.canteen_management_system.service;

import com.dac.canteen_management_system.dao.CMSDao;
import com.dac.canteen_management_system.dto.OrderDetailsRequest;
import com.dac.canteen_management_system.dto.OrderDetailsResponse;
import com.dac.canteen_management_system.model.Menu;
import com.dac.canteen_management_system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CMSService {

    @Autowired
   private CMSDao dao;

    public User registerNewUser(User user) {
        return dao.registerUser(user);
    }

    public List<Menu> getTodaysMenu(String day) {
       return dao.getTodaysMenu(day);
    }

    public OrderDetailsResponse placeOrder(OrderDetailsRequest request) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        // Take the first 10 characters and return
        String orderId =  uuid.substring(0, 8);
        request.setOrderId(orderId);
        return dao.placeOrder(request);
    }
}
