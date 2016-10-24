package com.hr.securitylab.WebControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChangepasswordController {
    @RequestMapping("/changepassword")
    public String greeting() {
        return "changepassword";
    }

}
