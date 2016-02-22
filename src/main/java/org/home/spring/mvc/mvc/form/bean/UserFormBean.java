package org.home.spring.mvc.mvc.form.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserFormBean {

    @NotNull(message = "{NotNull.userFormBean.firstName}")
    @Size(min = 2, max = 20)
    private String firstName;

    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;

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
        return "User [firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}
