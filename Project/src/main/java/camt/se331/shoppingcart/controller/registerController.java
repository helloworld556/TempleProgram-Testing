package camt.se331.shoppingcart.controller;

import camt.se331.shoppingcart.entity.User;
import camt.se331.shoppingcart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Created by KalumDog on 18/5/2558.
 */
@RestController
@RequestMapping("/")
public class registerController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public @ResponseBody
    User add(@RequestBody User user, BindingResult bindingResult){
        return userService.addUser(user);
    }
}
