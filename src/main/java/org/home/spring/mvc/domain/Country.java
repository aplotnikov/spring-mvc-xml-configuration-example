package org.home.spring.mvc.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Country {
    private int id;
    @NotNull
    @Size(min = 2, max = 30)
    private String name;

    public Country() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country { id=" + id + ", name='" + name + '\'' + '}';
    }
}
