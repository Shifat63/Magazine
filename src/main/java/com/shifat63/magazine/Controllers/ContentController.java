package com.shifat63.magazine.Controllers;

import com.shifat63.magazine.Model.Content;
import com.shifat63.magazine.Service.ContentCategoryService;
import com.shifat63.magazine.Service.ContentService;
import com.shifat63.magazine.Service.GenericApplicationService;
import com.shifat63.magazine.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping({"/content"})
public class ContentController {
    private final ContentService contentService;
    private final GenericApplicationService genericApplicationService;
    private final ContentCategoryService contentCategoryService;
    private final UserService userService;

    public ContentController(ContentService contentService, GenericApplicationService genericApplicationService, ContentCategoryService contentCategoryService, UserService userService) {
        this.contentService = contentService;
        this.genericApplicationService = genericApplicationService;
        this.contentCategoryService = contentCategoryService;
        this.userService = userService;
    }

    @RequestMapping({"","/"})
    public String index(Model model) throws Exception{
        model.addAttribute("contents", contentService.findAll());
        return "content/contentList";
    }

    @RequestMapping({"/view/{contentId}"})
    public String viewContent(@PathVariable("contentId") Integer contentId, Model model) throws Exception
    {
        Content content = contentService.findById(contentId);
        model.addAttribute("content", content);
        if(content.getTranslationOf() != null)
        {
            model.addAttribute("translationOf", contentService.findById(content.getTranslationOf()));
        }
        return "content/viewContent";
    }

    @RequestMapping({"/add"})
    public String addContent(Model model) throws Exception
    {
        Content content = new Content();
        model.addAttribute("content", content);
        model.addAttribute("contentCategories", contentCategoryService.findAll());
        return "content/addContent";
    }

    @RequestMapping(value = {"/addOrEditContent"}, method = RequestMethod.POST)
    public String addOrEditContentPost(@Valid @ModelAttribute("content") Content content, BindingResult bindingResult, Model model) throws Exception
    {
        if(bindingResult.hasErrors())
        {
            return "content/addContent";
        }

        if(content.getContentId() == 0) {
            content.setCreationDate(LocalDate.now());
            content.setUser(userService.findById(1));
        }

        Content savedContent = contentService.save(content);

        return "redirect:/content/view/"+savedContent.getContentId();
    }

    @RequestMapping({"/edit/{contentId}"})
    public String editContent(@PathVariable("contentId") Integer contentId, Model model) throws Exception
    {
        model.addAttribute("content", contentService.findById(contentId));
        model.addAttribute("contentCategories", contentCategoryService.findAll());
        return "content/addContent";
    }

    @RequestMapping({"/delete/{contentId}"})
    public String deleteContent(@PathVariable("contentId") Integer contentId, Model model) throws Exception
    {
        Content content = contentService.findById(contentId);
        if(content.getTranslationOf() != null)
        {
            contentService.deleteById(contentId);
        }
        else
        {
            for (Content translatedContent : contentService.getTranslatedContents(contentId)) {
                contentService.delete(translatedContent);
            }
            contentService.deleteById(contentId);
            genericApplicationService.DeleteFile(genericApplicationService.GetStorageLocation() + "contentImage/" + contentId);
        }
        return "redirect:/content";
    }
}
