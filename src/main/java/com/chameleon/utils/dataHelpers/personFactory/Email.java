package com.chameleon.utils.dataHelpers.personFactory;

import com.chameleon.utils.Randomness;

public class Email {
    private boolean isPrimary = false;
    private String country = "";
    private String type = "";
    private String emailAddress = "";
    private boolean optIn = false;

    public Email() {
        this.country = "USA";
        this.type = "Personal";
        this.emailAddress = Randomness.randomString(1).substring(0, 1).toUpperCase() + Randomness.randomString(11).substring(1).toLowerCase() + "@test.com";
        this.optIn = false;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return emailAddress;
    }

    public void setEmail(String email) {
        this.emailAddress = email;
    }

    public boolean isOptIn() {
        return optIn;
    }

    public void setOptIn(boolean optIn) {
        this.optIn = optIn;
    }
}
