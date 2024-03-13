package com.project.ecommerceAPI.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerceAPI.dto.OrderInterfaceDTO;
import com.project.ecommerceAPI.repository.PesananRepository;

@Service
public class OrderService {
    @Autowired PesananRepository pesananRepository;

    public List<OrderInterfaceDTO> getAllOrder(){
        return pesananRepository.getAllOrder();
    }

    public Double getEarningsCurrentMonth() {
        int currentMonth = LocalDate.now().getMonthValue();
        return pesananRepository.getEarningsMonthly(currentMonth);
    }

    public Double getEarningsCurrentYear() {
        int currentYear = LocalDate.now().getYear();
        return pesananRepository.getEarningsAnnual(currentYear);
    }

    public Long getTotalOrderCurrentMonth() {
        int currentMonth = LocalDate.now().getMonthValue();
        return pesananRepository.getTotalOrderMonthly(currentMonth);
    }

    public Long getTotalOrderCurrentYear() {
        int currentYear = LocalDate.now().getYear();
        return pesananRepository.getTotalOrderAnnual(currentYear);
    }

}
