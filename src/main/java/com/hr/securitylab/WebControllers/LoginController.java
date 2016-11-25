package com.hr.securitylab.WebControllers;

import com.hr.securitylab.database.models.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController
{
    @RequestMapping(method = RequestMethod.GET)
    public String returnView(Model model)
    {
        model.addAttribute("login", new User());
        return "login";
    }
}
