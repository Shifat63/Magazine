package com.shifat63.magazine.Controllers;

import com.shifat63.magazine.Model.User;
import com.shifat63.magazine.Model.UserType;
import com.shifat63.magazine.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;

@Controller
@RequestMapping({"/user"})
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping({"","/"})
    public String index(Model model) throws Exception{
        model.addAttribute("users", userService.findAll());
        return "user/userList";
    }

    @RequestMapping({"/view/{userId}"})
    public String viewUser(@PathVariable("userId") Integer userId, Model model) throws Exception
    {
        model.addAttribute("user", userService.findById(userId));
        return "user/viewUser";
    }

    @RequestMapping({"/add"})
    public String addUser(Model model) throws Exception
    {
        User user = new User();
        UserType userType = new UserType();
        userType.setUserTypeId(2);
        user.setUserType(userType);
        model.addAttribute("user", user);
        return "user/addUser";
    }

    @RequestMapping(value = {"/addOrEditUser"}, method = RequestMethod.POST)
    public String addOrEditUserPost(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) throws Exception
    {
        if(bindingResult.hasErrors())
        {
            return "user/addUser";
        }
        User savedUser = userService.save(user);
        return "redirect:/user/view/"+savedUser.getUserId();
    }

    @RequestMapping({"/edit/{userId}"})
    public String editUser(@PathVariable("userId") Integer userId, Model model) throws Exception
    {
        model.addAttribute("user", userService.findById(userId));
        return "user/addUser";
    }
}
