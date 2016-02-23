package org.home.spring.mvc.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
    private int id;
    @NotNull(message = "{NotNull.userFormBean.firstName}")
    @Size(min = 2, max = 20)
    private String firstName;
    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User [ id=" + id + ", firstName = " + firstName + ", lastName = " + lastName + " ]";
    }
}
