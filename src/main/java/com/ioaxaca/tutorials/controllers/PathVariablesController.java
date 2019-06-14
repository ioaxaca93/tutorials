/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioaxaca.tutorials.controllers;

import com.ioaxaca.tutorials.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Israel
 */
@Controller
@RequestMapping("/params")
public class PathVariablesController {
    
    @Autowired
    @Qualifier("customerDao")//en caso de que haya varias implementaciones de un Bean se puede usar qualifier para inyectar uno en espesifico
    private CustomerDao customerDao;
    
    @GetMapping("/customer/{email}")
    public String getByEmail(@PathVariable(name = "email", required = false) String email,Model model){
        if(email!=null){
            model.addAttribute("cliente", customerDao.findByEmail(email));
        }
        return "params/path";
    }
}
