package com.shifat63.magazine.Controllers;

import com.shifat63.magazine.Model.Event;
import com.shifat63.magazine.Service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;

@Controller
@RequestMapping({"/event"})
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping({"","/"})
    public String index(Model model) throws Exception{
        model.addAttribute("events", eventService.findAll());
        return "event/eventList";
    }

    @RequestMapping({"/view/{eventId}"})
    public String viewEvent(@PathVariable("eventId") Integer eventId, Model model) throws Exception
    {
        model.addAttribute("event", eventService.findById(eventId));
        return "event/viewEvent";
    }

    @RequestMapping({"/add"})
    public String addEvent(Model model) throws Exception
    {
        Event event = new Event();
        model.addAttribute("event", event);
        return "event/addEvent";
    }

    @RequestMapping(value = {"/addOrEditEvent"}, method = RequestMethod.POST)
    public String addOrEditEventPost(@Valid @ModelAttribute("event") Event event, BindingResult bindingResult, Model model) throws Exception
    {
        if(bindingResult.hasErrors())
        {
            return "event/addEvent";
        }
        Event savedEvent = eventService.save(event);
        return "redirect:/event/view/"+savedEvent.getEventId();
    }

    @RequestMapping({"/edit/{eventId}"})
    public String editEvent(@PathVariable("eventId") Integer eventId, Model model) throws Exception
    {
        model.addAttribute("event", eventService.findById(eventId));
        return "event/addEvent";
    }

    @RequestMapping({"/delete/{eventId}"})
    public String deleteEvent(@PathVariable("eventId") Integer eventId, Model model) throws Exception
    {
        eventService.deleteById(eventId);
        return "redirect:/event";
    }
}
