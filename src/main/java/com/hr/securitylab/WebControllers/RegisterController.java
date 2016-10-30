package com.hr.securitylab.WebControllers;

import com.hr.securitylab.database.models.RegisterDB;
import com.hr.securitylab.database.models.entities.NewUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController
{
    @RequestMapping(method = RequestMethod.GET)
    public String returnView(Model model)
    {
        model.addAttribute("newuser", new NewUser());
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("newuser") @Valid NewUser newUser, Errors errors)
    {
        RegisterDB registerDB = new RegisterDB();
        if(!errors.hasErrors())
        {
            registerDB.createNewAccount(newUser);
            return "redirect:/login.html";
        }

        return "register";
    }
}
