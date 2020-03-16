package com.shifat63.magazine.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shifat63.magazine.Model.Content;
import com.shifat63.magazine.Service.ContentService;
import com.shifat63.magazine.Service.EventService;
import com.shifat63.magazine.Service.FrontMessageService;

@Controller
public class GenericController {
	
	private final ContentService contentService;
	private final EventService eventService;
	private final FrontMessageService frontMessageService;

    public GenericController(ContentService contentService, EventService eventService, FrontMessageService frontMessageService) {
        this.contentService = contentService;
        this.eventService = eventService;
        this.frontMessageService = frontMessageService;
    }
	
	@RequestMapping({"","/"})
    public String index(Model model) throws Exception{
		model.addAttribute("sliders", contentService.getSliderContents(true));
		model.addAttribute("frontContents", contentService.getFrontContents(true));
		model.addAttribute("frontEvents", eventService.getFrontEvents(true));
		model.addAttribute("activeFrontMessages", frontMessageService.getActiveFrontMessages(true));
        return "index";
    }
}
