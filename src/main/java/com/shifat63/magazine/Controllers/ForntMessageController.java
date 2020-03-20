package com.shifat63.magazine.Controllers;

import com.shifat63.magazine.Model.FrontMessage;
import com.shifat63.magazine.Service.FrontMessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping({"/message"})
public class ForntMessageController {
    private final FrontMessageService frontMessageService;

    public ForntMessageController(FrontMessageService frontMessageService) {
        this.frontMessageService = frontMessageService;
    }

    @RequestMapping({"","/"})
    public String index(Model model) throws Exception{
        model.addAttribute("messages", frontMessageService.findAll());
        return "message/messageList";
    }

    @RequestMapping({"/add"})
    public String addMessage(Model model) throws Exception
    {
        FrontMessage frontMessage = new FrontMessage();
        model.addAttribute("message", frontMessage);
        return "message/addMessage";
    }

    @RequestMapping(value = {"/addOrEditMessage"}, method = RequestMethod.POST)
    public String addOrEditMessagePost(@Valid @ModelAttribute("message") FrontMessage message, BindingResult bindingResult, Model model) throws Exception
    {
        if(bindingResult.hasErrors())
        {
            return "message/addMessage";
        }
        FrontMessage savedMessage = frontMessageService.save(message);
        return "redirect:/message";
    }

    @RequestMapping({"/edit/{frontMessageId}"})
    public String editMessage(@PathVariable("frontMessageId") Integer frontMessageId, Model model) throws Exception
    {
        model.addAttribute("message", frontMessageService.findById(frontMessageId));
        return "message/addMessage";
    }

    @RequestMapping({"/delete/{frontMessageId}"})
    public String deleteMessage(@PathVariable("frontMessageId") Integer frontMessageId, Model model) throws Exception
    {
        frontMessageService.deleteById(frontMessageId);
        return "redirect:/message";
    }
}
