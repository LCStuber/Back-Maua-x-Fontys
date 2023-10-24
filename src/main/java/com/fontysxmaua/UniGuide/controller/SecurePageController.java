// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.fontysxmaua.UniGuide.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurePageController {

    @RequestMapping("/secure_page")
    public ModelAndView securePage(){
        ModelAndView mav = new ModelAndView("secure_page");

        return mav;
    }
    
    // Added just to be able to frindly connect to the API
    @RequestMapping("/")
    public ModelAndView indexPage() {
        ModelAndView mav = new ModelAndView("index");

        return mav;
    }
}

