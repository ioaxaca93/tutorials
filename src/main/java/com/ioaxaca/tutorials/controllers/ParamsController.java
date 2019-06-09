/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioaxaca.tutorials.controllers;

import com.ioaxaca.tutorials.dao.CustomerDao;
import com.ioaxaca.tutorials.entities.Customer;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Israel
 */
@Controller
@RequestMapping("/params")
public class ParamsController {
    
    @Autowired
    private CustomerDao customerDao;
    
    @GetMapping("/string")
    public String getString(@RequestParam(name = "id",required = false) Long id, Model model){
        /*
            También se puede inyectar HttpServeñetRequest en vez de la anotación @RequestParam y usar el metodo getParam
        */
        if(id!=null){
           model.addAttribute("cliente", customerDao.findById(id));
        }
        return "params/params";
    }
}
