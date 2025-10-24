package entity;

import javax.persistence.Embeddable;

@Embeddable
public class CustomerFullName {
    private String firstName;
    private String lastName;

    public CustomerFullName() {
    }
    public CustomerFullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
