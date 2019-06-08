/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioaxaca.tutorials.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Israel
 */
@Controller
public class Index {
    
    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("message", "Hellow Spring!!");
        return "index";
    }
    
}
