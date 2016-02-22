package org.home.spring.mvc.mvc.form.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CountryFormBean {
    @NotNull
    @Size(min = 2, max = 30)
    private String name;

    public CountryFormBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CountryFormBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
