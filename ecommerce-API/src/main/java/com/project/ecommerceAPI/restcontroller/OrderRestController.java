package com.project.ecommerceAPI.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerceAPI.dto.OrderInterfaceDTO;
import com.project.ecommerceAPI.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderRestController {
    @Autowired OrderService os;

    @GetMapping("/order")
    public List<OrderInterfaceDTO> getAllOrder(){
        return os.getAllOrder();
    }

    @GetMapping("/order/earnings/monthly")
    public Double getEarningsMonthly() {
        return os.getEarningsCurrentMonth();
    }

    @GetMapping("/order/earnings/annual")
    public Double getEarningsAnnual() {
        return os.getEarningsCurrentYear();
    }

    @GetMapping("/order/totalorder/monthly")
    public Long getTotalOrderMonthly() {
        return os.getTotalOrderCurrentMonth();
    }

    @GetMapping("/order/totalorder/annual")
    public Long getTotalOrderAnnual() {
        return os.getTotalOrderCurrentYear();
    }
}
