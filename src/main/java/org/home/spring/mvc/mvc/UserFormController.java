package org.home.spring.mvc.mvc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.home.spring.mvc.domain.User;
import org.home.spring.mvc.mvc.form.bean.UserFormBean;
import org.home.spring.mvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

import static org.home.spring.mvc.domain.User.Builder.anUser;

@Controller
@RequestMapping("/adduser.form")
public class UserFormController {
    private final static Log LOG = LogFactory.getLog(UserFormController.class);

    private final UserService userService;

    @Inject
    public UserFormController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userFormBean")
    public UserFormBean getUserFormBean() {
        return new UserFormBean();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "adduserform";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processSubmit(@Valid UserFormBean userFormBean, Errors errors) {
        if (errors.hasErrors()) {
            LOG.info("Adduserform validation failed.");

            return new ModelAndView("adduserform");
        }

        User user = anUser()
                .withFirstName(userFormBean.getFirstName())
                .withLastName(userFormBean.getLastName())
                .create();

        LOG.info("Adding new " + user);

        userService.saveUser(user);

        List<User> userList = userService.loadAllUsers();

        ModelAndView modelAndView = new ModelAndView("userlistview");
        modelAndView.addObject("userList", userList);

        return modelAndView;
    }
}