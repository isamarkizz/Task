package com.example.task.model;

import javax.xml.bind.annotation.XmlElement;

public class CountryListModel {
    private String country;
    private String lastName;
    private String givenName;
    private int schedule;
    private String dateOfBirth;
    private int item;
    private String Entity;

    @XmlElement(name = "Country")
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    @XmlElement(name = "LastName")
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlElement(name = "GivenName")
    public String getGivenName() {
        return givenName;
    }
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    @XmlElement(name = "DateOfBirth")
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @XmlElement(name = "Schedule")
    public int getSchedule() {
        return schedule;
    }
    public void setSchedule(int schedule) {
        this.schedule = schedule;
    }

    @XmlElement(name = "Item")
    public int getItem() {return item;}
    public void setItem(int item) {
        this.item = item;
    }

    @XmlElement(name = "Entity")
    public String getEntity() {
        return Entity;
    }
    public void setEntity(String Entity) {
        this.Entity = Entity;
    }



}
