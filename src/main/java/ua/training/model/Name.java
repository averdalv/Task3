package ua.training.model;

import ua.training.GlobalConst;

public class Name {
    private String lastName;
    private String firstName;
    private String middleName;

    public Name(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public Name() {

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getFullName() {
        return lastName+ GlobalConst.SPACE+firstLetterOfFirstName()+GlobalConst.POINT;
    }
    public String toString() {
        return getFullName();
    }
    public char firstLetterOfFirstName() {
        return firstName.charAt(0);
    }
}
