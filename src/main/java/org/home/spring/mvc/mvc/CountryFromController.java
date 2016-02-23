package org.home.spring.mvc.mvc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.home.spring.mvc.domain.Country;
import org.home.spring.mvc.service.CountryService;
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
@RequestMapping("/addcountry.form")
public class CountryFromController {
    private final static Log LOG = LogFactory.getLog(CountryFromController.class);

    private final CountryService countryService;

    @Inject
    public CountryFromController(CountryService countryService) {
        this.countryService = countryService;
    }

    @ModelAttribute("countryBean")
    public Country aCountryBean() {
        return new Country();
    }

    @RequestMapping(method = GET)
    public String get() {
        return "addcountryform";
    }

    @RequestMapping(method = POST)
    public ModelAndView processSubmit(@Valid Country country, Errors errors) {
        if (errors.hasErrors()) {
            LOG.info("Addcountryform validation failed.");

            return new ModelAndView("addcountryform");
        }

        LOG.info("Adding new " + country);

        countryService.saveCountry(country);

        List<Country> countries = countryService.loadAllCountries();

        ModelAndView modelAndView = new ModelAndView("countrylistview");
        modelAndView.addObject("countryList", countries);

        return modelAndView;
    }
}