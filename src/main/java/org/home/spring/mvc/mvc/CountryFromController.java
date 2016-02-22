package org.home.spring.mvc.mvc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.home.spring.mvc.domain.Country;
import org.home.spring.mvc.mvc.form.bean.CountryFormBean;
import org.home.spring.mvc.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/addcountry.form")
public class CountryFromController {
    private static Log log = LogFactory.getLog(CountryFromController.class);

    private CountryService countryService;

    @ModelAttribute("countryFormBean")
    public CountryFormBean getCountryFormBean() {
        return new CountryFormBean();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "addcountryform";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processSubmit(@Valid CountryFormBean countryFormBean, Errors errors) {
        if (errors.hasErrors()) {
            log.info("Addcountryform validation failed.");
            return new ModelAndView("addcountryform");
        } else {
            Country country = new Country();
            country.setName(countryFormBean.getName());

            log.info("Adding new " + country + "");

            countryService.saveCountry(country);
            List<Country> countries = countryService.loadAllCountries();

            ModelAndView mav = new ModelAndView("countrylistview");
            mav.addObject("countryList", countries);

            return mav;
        }
    }

    @Autowired
    @Required
    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }

}