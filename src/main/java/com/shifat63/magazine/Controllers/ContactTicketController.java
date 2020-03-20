package com.shifat63.magazine.Controllers;

import com.shifat63.magazine.Service.ContactTicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/contactTicket"})
public class ContactTicketController {
    private final ContactTicketService contactTicketService;

    public ContactTicketController(ContactTicketService contactTicketService) {
        this.contactTicketService = contactTicketService;
    }

    @RequestMapping({"","/"})
    public String index(Model model) throws Exception{
        model.addAttribute("contactTickets", contactTicketService.findAll());
        return "contactTicket/contactTicketList";
    }

    @RequestMapping({"/delete/{contactTicketId}"})
    public String deleteMessage(@PathVariable("contactTicketId") Integer contactTicketId, Model model) throws Exception
    {
        contactTicketService.deleteById(contactTicketId);
        return "redirect:/contactTicket";
    }
}
