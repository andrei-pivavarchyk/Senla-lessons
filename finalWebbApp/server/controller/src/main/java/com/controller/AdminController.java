package com.controller;



import com.model.Order;
import com.model.UserData;
import com.serviceAPI.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private IUserDataService userDataService;
    @Autowired
    private IUserDataDTOService userDataDTOService;
    @Autowired
    private IUserHandler userHandler;
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IOrderDTOService orderDTOService;

    @RequestMapping(
            value = {"/api/admin/get-all-users"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public List<UserData> getAllUserData(HttpServletResponse response) {
        List<UserData> userDataList = this.userDataService.getAllUserData();
        List<UserData> userDataDTOList = new ArrayList<>();
        for (UserData userData : userDataList) {
            UserData userDataDTO = this.userDataDTOService.getUserDataDTO(userData);
            userDataDTOList.add(userDataDTO);
        }
        if (userDataDTOList.isEmpty()) {
            response.setStatus(204);
            return new ArrayList<>();
        }

        return userDataDTOList;
    }

    @RequestMapping(
            value = {"/api/admin/get-all-orders"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public List<Order> getAllOrders(HttpServletResponse response) {
        List<Order> orderList = this.orderService.getAllOrders();
        List<Order> orderDTOList = new ArrayList<>();
        for (Order ordrer : orderList) {
           Order orderr=this.orderDTOService.getOrderDTO(ordrer);
           orderDTOList.add(orderr);
        }
        if (orderDTOList.isEmpty()) {
            response.setStatus(204);
            return new ArrayList<>();
        }

        return orderDTOList;
    }

}