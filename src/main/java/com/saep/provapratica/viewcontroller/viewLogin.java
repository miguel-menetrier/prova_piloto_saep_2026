package com.saep.provapratica.viewcontroller;

import com.saep.provapratica.dto.LoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class viewLogin {

    @GetMapping("/login")
    public String viewLogin(Model model) {

        LoginDto loginDto = new LoginDto();

        model.addAttribute("loginDto", loginDto);

        return "login";
    }
}
