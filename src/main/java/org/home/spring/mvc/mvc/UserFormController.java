package org.home.spring.mvc.mvc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.home.spring.mvc.domain.User;
import org.home.spring.mvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/adduser.form")
public class UserFormController {
    private final static Log LOG = LogFactory.getLog(UserFormController.class);

    private final UserService userService;

    @Inject
    public UserFormController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userBean")
    public User anUserBean() {
        return new User();
    }

    @RequestMapping(method = GET)
    public String get() {
        return "adduserform";
    }

    @RequestMapping(method = POST)
    public ModelAndView processSubmit(@ModelAttribute("userBean") @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            LOG.info("Adduserform validation failed.");

            return new ModelAndView("adduserform");
        }

        LOG.info("Adding new " + user);

        userService.saveUser(user);

        List<User> userList = userService.loadAllUsers();

        ModelAndView modelAndView = new ModelAndView("userlistview");
        modelAndView.addObject("userList", userList);

        return modelAndView;
    }
}