package org.home.spring.mvc.domain;

public class Country {
    private final int id;
    private final String name;

    public Country(String name) {
        this(0, name);
    }

    public Country(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Country { id=" + id + ", name='" + name + '\'' + '}';
    }
}
