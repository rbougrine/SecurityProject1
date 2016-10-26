package com.hr.securitylab.WebControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testdbController
{

    @RequestMapping("/test")
    public String greeting()
    {
        return "test";
    }


}
