package com.fontysxmaua.UniGuide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/activities")
public class ActivitiesController {

    @GetMapping
    String getActivities(Model model){
        return "activities";
    }
}
