package org.home.spring.mvc.domain;

public class User {
    private final int id;
    private final String firstName;
    private final String lastName;

    public User(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "User [ id=" + id + ", firstName = " + firstName + ", lastName = " + lastName + " ]";
    }

    public static class Builder {
        private int id;
        private String firstName;
        private String lastName;

        public static Builder anUser() {
            return new Builder();
        }

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public User create() {
            return new User(id, firstName, lastName);
        }
    }
}
