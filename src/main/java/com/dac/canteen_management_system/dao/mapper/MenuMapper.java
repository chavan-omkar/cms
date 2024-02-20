package com.dac.canteen_management_system.dao.mapper;

import com.dac.canteen_management_system.model.Menu;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuMapper implements ResultSetExtractor<List<Menu>> {
    @Override
    public List<Menu> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<Menu> menu = new ArrayList<>();
        while (rs.next()) {
            Menu menu1 = new Menu();
            long id = rs.getLong("id");
            String dishName = rs.getString("dishName");
            double price = rs.getDouble("price");

            menu1.setId(id);
            menu1.setDishName(dishName);
            menu1.setPrice(price);
            menu1.setAvailable(true);

            menu.add(menu1);
        }
        return menu;
    }
}
