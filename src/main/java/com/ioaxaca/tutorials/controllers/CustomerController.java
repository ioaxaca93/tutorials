/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioaxaca.tutorials.controllers;

import com.ioaxaca.tutorials.dao.CustomerDao;
import com.ioaxaca.tutorials.entities.Customer;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Israel
 */
@Controller
public class CustomerController {
    //@Qualifier(value = "customerDao") solo en caso de que haya mas implementaciones del mismo tipo
    @Autowired
    private CustomerDao customerDao;
    
    @GetMapping(value = "/customers" )
    public String all(Model model){
        model.addAttribute("clientes",customerDao.findAll());
        return "customers";
    }
    
    @GetMapping(value = "/add-customer")
    public String addCustomer(Map<String, Object> model){
        model.put("customer", new Customer());
        return "customer_format";
    }
    
    @PostMapping(value = "/add-customer")
    public String addCustomer(@Valid Customer c,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "customer_format";
        }
        customerDao.save(c);
        return "redirect:customers";
    }
}
