package com.shifat63.magazine.Controllers;

import com.shifat63.magazine.Service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.shifat63.magazine.Model.ContactTicket;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;

@Controller
public class GenericController {
	
	private final ContentService contentService;
	private final EventService eventService;
	private final FrontMessageService frontMessageService;
	private final ContactTicketService contactTicketService;
    private final ContentCategoryService contentCategoryService;

    public GenericController(ContentService contentService, EventService eventService, FrontMessageService frontMessageService, ContactTicketService contactTicketService, ContentCategoryService contentCategoryService) {
        this.contentService = contentService;
        this.eventService = eventService;
        this.frontMessageService = frontMessageService;
        this.contactTicketService = contactTicketService;
        this.contentCategoryService = contentCategoryService;
    }
	
	@RequestMapping({"","/"})
    public String index(Model model) throws Exception{
		model.addAttribute("sliders", contentService.getSliderContents(true));
		model.addAttribute("frontContents", contentService.getFrontContents(true));
		model.addAttribute("frontEvents", eventService.getFrontEvents(true));
		model.addAttribute("activeFrontMessages", frontMessageService.getActiveFrontMessages(true));
        ContactTicket contactTicket = new ContactTicket();
        model.addAttribute("contactTicket", contactTicket);
        return "index";
    }
	
	@RequestMapping(value = {"/contactTicket"}, method = RequestMethod.POST)
    public String postContactTicket(@Valid @ModelAttribute("contactTicket") ContactTicket contactTicket, BindingResult bindingResult, Model model) throws Exception
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("sliders", contentService.getSliderContents(true));
            model.addAttribute("frontContents", contentService.getFrontContents(true));
            model.addAttribute("frontEvents", eventService.getFrontEvents(true));
            model.addAttribute("activeFrontMessages", frontMessageService.getActiveFrontMessages(true));
            return "index";
        }
        ContactTicket savedContactTicket = contactTicketService.save(contactTicket);
        return "redirect:/";
    }

    @RequestMapping({"/contents"})
    public String contents(Model model) throws Exception{
        model.addAttribute("sliders", contentService.getSliderContents(true));
        model.addAttribute("contents", contentService.findAll());
        model.addAttribute("contentCategories", contentCategoryService.findAll());
        return "contents";
    }

    @RequestMapping({"/contents/contentCategories/{contentCategoryId}"})
    public String contentsBasedOnCategory(@PathVariable ("contentCategoryId") Integer contentCategoryId, Model model) throws Exception{
        model.addAttribute("sliders", contentService.getSliderContents(true));
        model.addAttribute("contents", contentCategoryService.findById(contentCategoryId).getContentSet());
        model.addAttribute("contentCategories", contentCategoryService.findAll());
        return "contents";
    }

    @RequestMapping(value = {"/contentByKeyword"}, method = RequestMethod.POST)
    public String contentByKeyword(@RequestParam("keyword") String keyword, Model model) throws Exception
    {
        model.addAttribute("sliders", contentService.getSliderContents(true));
        model.addAttribute("contents", contentService.getContentsSearchedByKeyword(keyword.toLowerCase()));
        model.addAttribute("contentCategories", contentCategoryService.findAll());
        return "contents";
    }

    @RequestMapping({"/contents/{contentId}"})
    public String contentDetails(@PathVariable ("contentId") Integer contentId, Model model) throws Exception{
        model.addAttribute("sliders", contentService.getSliderContents(true));
        model.addAttribute("content", contentService.findById(contentId));
        model.addAttribute("contentCategories", contentCategoryService.findAll());
        return "contentDetails";
    }

    @RequestMapping({"/events"})
    public String events(Model model) throws Exception{
        model.addAttribute("sliders", contentService.getSliderContents(true));
        model.addAttribute("events", eventService.findAll());
        return "events";
    }
}
