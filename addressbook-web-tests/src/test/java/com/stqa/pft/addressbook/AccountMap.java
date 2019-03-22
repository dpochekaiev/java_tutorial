package com.stqa.pft.addressbook;

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

    public AccountMap(String first, String middleName, String surname, String company, String address, String homePhoneNumber, String emailFirst, String dayOfBirth, String monthOfBirth, String yearOfBirth) {
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
}
