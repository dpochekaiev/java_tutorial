package com.stqa.pft.addressbook.model;

import java.util.Objects;

public class AccountMap {
    private final String first;
    private final String middleName;
    private final String surname;
    private final String company;
    private final String address;
    private final String homePhoneNumber;
    private final String emailFirst;
    private final String dayOfBirth;
    private final String monthOfBirth;
    private final String yearOfBirth;
    private final String group;

    public AccountMap(String first, String middleName, String surname, String company, String address, String homePhoneNumber, String emailFirst, String dayOfBirth, String monthOfBirth, String yearOfBirth, String group) {
        this.first = first;
        this.middleName = middleName;
        this.surname = surname;
        this.company = company;
        this.address = address;
        this.homePhoneNumber = homePhoneNumber;
        this.emailFirst = emailFirst;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.group = group;
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
    public String toString() {
        return "AccountMap{" +
                "surname='" + surname + '\'' +
                ", first='" + first + '\'' +
                ", address='" + address + '\'' +
                ", emailFirst='" + emailFirst + '\'' +
                ", homePhoneNumber='" + homePhoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountMap that = (AccountMap) o;
        return Objects.equals(first, that.first) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(address, that.address) &&
                Objects.equals(homePhoneNumber, that.homePhoneNumber) &&
                Objects.equals(emailFirst, that.emailFirst);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, surname, address, homePhoneNumber, emailFirst);
    }
}
