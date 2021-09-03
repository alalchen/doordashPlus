package com.mycompany.doordashPlus.controller;

import com.mycompany.doordashPlus.service.ItemOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ItemOrderController {

    @Autowired
    private ItemOrderService itemOrderService;


    @RequestMapping(value = "/order/{menuId}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addMenuItemToCart(@PathVariable("menuId") int menuId) {
        itemOrderService.saveItem(menuId);


    }
}
