package com.shifat63.magazine.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shifat63.magazine.Model.Content;
import com.shifat63.magazine.Service.ContentService;

@Controller
public class GenericController {
	
	private final ContentService contentService;

    public GenericController(ContentService contentService) {
        this.contentService = contentService;
    }
	
	@RequestMapping({"","/"})
    public String index(Model model) throws Exception{
		model.addAttribute("sliders", contentService.getSliderContents(true));
        return "index";
    }
}
