package com.stqa.pft.addressbook.model;

import java.util.Objects;

public class AccountMap {

    private int contactID = 0;
    private  String first;
    private  String middleName;
    private  String surname;
    private  String company;
    private  String address;
    private  String homePhoneNumber;
    private  String emailFirst;
    private  String dayOfBirth;
    private  String monthOfBirth;
    private  String yearOfBirth;

    public AccountMap withContactID(int contactID) {
        this.contactID = contactID;
        return this;
    }

    public AccountMap withFirstName(String first) {
        this.first = first;
        return this;
    }

    public AccountMap withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public AccountMap withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public AccountMap withCompany(String company) {
        this.company = company;
        return this;
    }

    public AccountMap withAddress(String address) {
        this.address = address;
        return this;
    }

    public AccountMap withHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
        return this;
    }

    public AccountMap withEmailFirst(String emailFirst) {
        this.emailFirst = emailFirst;
        return this;
    }

    public AccountMap withDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
        return this;
    }

    public AccountMap withMonthOfBirth(String monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
        return this;
    }

    public AccountMap withYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
        return this;
    }

    public AccountMap withGroup(String group) {
        this.group = group;
        return this;
    }

    private  String group;

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    public String getFirst() {
        return first;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSurname() {
        return surname;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public String getEmailFirst() {
        return emailFirst;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }


    public String getMonthOfBirth() {
        return monthOfBirth;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountMap that = (AccountMap) o;
        return Objects.equals(contactID, that.contactID) &&
                Objects.equals(first, that.first) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(address, that.address) &&
                Objects.equals(homePhoneNumber, that.homePhoneNumber) &&
                Objects.equals(emailFirst, that.emailFirst);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactID, first, surname, address, homePhoneNumber, emailFirst);
    }

    @Override
    public String toString() {
        return "AccountMap{" +
                "contactID='" + contactID + '\'' +
                "surname='" + surname + '\'' +
                ", first='" + first + '\'' +
                ", address='" + address + '\'' +
                ", emailFirst='" + emailFirst + '\'' +
                ", homePhoneNumber='" + homePhoneNumber + '\'' +
                '}';
    }

}
