package com.shifat63.magazine.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GenericController {
	
	@RequestMapping({"","/"})
    public String index(Model model) throws Exception{
        return "index";
    }
}
