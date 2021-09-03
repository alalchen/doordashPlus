package com.mycompany.doordashPlus.service;

import com.mycompany.doordashPlus.dao.MenuInfoDao;
import com.mycompany.doordashPlus.entity.MenuItem;
import com.mycompany.doordashPlus.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuInfoService {

    @Autowired
    private MenuInfoDao menuInfoDao;


    public List<Restaurant> getRestaurants() {
        return menuInfoDao.getRestaurants();
    }

    public List<MenuItem> getAllMenuItem(int restaurantId) {
        return menuInfoDao.getAllMenuItem(restaurantId);
    }

    public MenuItem getMenuItem(int id) {
        return menuInfoDao.getMenuItem(id);
    }
}

