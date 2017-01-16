package com.dasha.equipment.command.impl.shop;

import com.dasha.equipment.command.Command;
import com.dasha.equipment.service.ShopService;
import com.dasha.equipment.service.exception.ServiceException;
import com.dasha.equipment.service.factory.ServiceFactory;

/**
 * Created by Даша on 13.01.2017.
 */
public class GetEquipmentByTitleCommand implements Command{
    @Override
    public String execute(String request) {
        String response;
        String[] parameters=request.split(" ");
        String title=parameters[1];

        ServiceFactory serviceFactory=ServiceFactory.getInstance();
        ShopService shopService=serviceFactory.getShopService();
        try {
            shopService.getEquipmentByTitle(title);
            response="Equipment with title"+ title+" was received";
        } catch (ServiceException e) {
            response="Error during get procedure";
        }
        return response;
    }
}
