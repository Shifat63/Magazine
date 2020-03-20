package com.shifat63.magazine.Controllers;

import com.shifat63.magazine.Model.ContentCategory;
import com.shifat63.magazine.Service.ContentCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping({"/contentCategory"})
public class ContentCategoryController {

    private final ContentCategoryService contentCategoryService;

    public ContentCategoryController(ContentCategoryService contentCategoryService) {
        this.contentCategoryService = contentCategoryService;
    }

    @RequestMapping({"","/"})
    public String index(Model model) throws Exception{
        model.addAttribute("contentCategories", contentCategoryService.findAll());
        return "contentCategory/contentCategoryList";
    }

    @RequestMapping({"/add"})
    public String addContentCategory(Model model) throws Exception
    {
        ContentCategory contentCategory = new ContentCategory();
        model.addAttribute("contentCategory", contentCategory);
        return "contentCategory/addContentCategory";
    }

    @RequestMapping(value = {"/addOrEdit"}, method = RequestMethod.POST)
    public String addOrEditContentCategoryPost(@Valid @ModelAttribute("contentCategory") ContentCategory contentCategory, BindingResult bindingResult, Model model) throws Exception
    {
        if(bindingResult.hasErrors())
        {
            return "contentCategory/addContentCategory";
        }
        ContentCategory savedContentCategory = contentCategoryService.save(contentCategory);
        return "redirect:/contentCategory";
    }

    @RequestMapping({"/edit/{contentCategoryId}"})
    public String editContentCategory(@PathVariable("contentCategoryId") Integer contentCategoryId, Model model) throws Exception
    {
        model.addAttribute("contentCategory", contentCategoryService.findById(contentCategoryId));
        return "contentCategory/addContentCategory";
    }
}
