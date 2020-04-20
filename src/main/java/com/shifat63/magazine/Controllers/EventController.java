package com.shifat63.magazine.Controllers;

import com.shifat63.magazine.Model.Event;
import com.shifat63.magazine.Service.EventService;
import com.shifat63.magazine.Service.GenericApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.Valid;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping({"/event"})
public class EventController {
    private final EventService eventService;
    private final GenericApplicationService genericApplicationService;

    public EventController(EventService eventService, GenericApplicationService genericApplicationService) {
        this.eventService = eventService;
        this.genericApplicationService = genericApplicationService;
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
    public String addOrEditEventPost(@Valid @ModelAttribute("event") Event event, BindingResult bindingResult, @RequestParam("eventImageInp") MultipartFile eventImage, Model model) throws Exception
    {
        if(bindingResult.hasErrors())
        {
            return "event/addEvent";
        }
        Event savedEvent = eventService.save(event);

        if (!eventImage.isEmpty())
        {
            byte[] bytes = eventImage.getBytes();
            Path path = Paths.get(genericApplicationService.GetStorageLocation() + "eventImage/" + savedEvent.getEventId() + ".jpg");
            Files.write(path, bytes);
        }

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
        genericApplicationService.DeleteFile(genericApplicationService.GetStorageLocation() + "eventImage/" + eventId + ".jpg");
        return "redirect:/event";
    }
}
