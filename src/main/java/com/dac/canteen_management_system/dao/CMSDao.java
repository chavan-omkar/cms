package com.dac.canteen_management_system.dao;

import com.dac.canteen_management_system.dao.mapper.MenuMapper;
import com.dac.canteen_management_system.dto.OrderDetailsRequest;
import com.dac.canteen_management_system.dto.OrderDetailsResponse;
import com.dac.canteen_management_system.model.Menu;
import com.dac.canteen_management_system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreatorFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CMSDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public User registerUser(User user) {
        String query = "INSERT INTO \"User\" (username, password, mobileno, created_at) VALUES (?, ?, ?, now())";
        Object[] params = {user.getUserName(), user.getPassword(), user.getMobileNo()};
        int affected = jdbcTemplate.update(query, params);
        if (affected > 0) {
            return user;
        } else {
            return null;
        }
    }

    public List<Menu> getTodaysMenu(String day) {
        String query = "SELECT id,dishname,price from \"Menu\" where day = ? and available = true";
        return jdbcTemplate.query(query, new MenuMapper(), day);
    }

    public OrderDetailsResponse placeOrder(OrderDetailsRequest request) {
        String procCall = "{call placeOrder(?, ?, ?, ?, ?)}";

        List<SqlParameter> parameters = new ArrayList<>();
        parameters.add(new SqlParameter(Types.BIGINT));
        parameters.add(new SqlParameter(Types.VARCHAR));
        parameters.add(new SqlParameter(Types.INTEGER));
        parameters.add(new SqlParameter(Types.INTEGER));
        parameters.add(new SqlParameter(Types.BOOLEAN));

        // Create a CallableStatementCreatorFactory
        CallableStatementCreatorFactory factory = new CallableStatementCreatorFactory(procCall, parameters);
//        factory.setReturnGeneratedKeys(true);
        int length = request.getOrderDetails().size();
        // Iterate over the map entries and execute the stored procedure for each entry
//        for (Map.Entry<Integer, Integer> entry : request.getOrderDetails().entrySet()) {
//            boolean lastCall = length == 0 ? true : false;
//            namedParameterJdbcTemplate..update(factory.newCallableStatementCreator(request.getUserId(),request.getOrderId(),entry.getKey(), entry.getValue(),lastCall));
//            length =  length -1;
//        }
//        jdbcTemplate.
        return null;
    }
}
