package com.stqa.pft.addressbook.model;

import java.io.File;
import java.util.Objects;

public class AccountMap {

    private int contactID = 0;
    private String details;
    private  String first;
    private  String middleName;
    private  String surname;
    private  String company;
    private  String address;
    private  String phones;
    private  String homePhoneNumber;
    private  String mobilePhoneNumber;
    private  String workPhoneNumber;
    private  String emails;
    private  String emailFirst;
    private  String emailSecond;
    private  String emailThird;
    private  String dayOfBirth;
    private  String monthOfBirth;
    private  String yearOfBirth;
    private  String group;
    private File photo;


    public AccountMap withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public AccountMap withDetials(String details) {
        this.details = details;
        return this;
    }

    public AccountMap withEmails(String emails) {
        this.emails = emails;
        return this;
    }

    public AccountMap withEmailSecond(String emailSecond) {
        this.emailSecond = emailSecond;
        return this;
    }

    public AccountMap withEmailThird(String emailThird) {
        this.emailThird = emailThird;
        return this;
    }

    public AccountMap withPhones(String phones) {
        this.phones = phones;
        return this;
    }

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

    public AccountMap withMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
        return this;
    }

    public AccountMap withWorkPhoneNumber(String workPhoneNumber) {
        this.workPhoneNumber = workPhoneNumber;
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


    public int getContactID() {
        return contactID;
    }

    public String getDetails() {
        return details;
    }

    public String getPhones() {
        return phones;
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

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public String getWorkPhoneNumber() {
        return workPhoneNumber;
    }

    public String getEmails() {
        return emails;
    }

    public String getEmailFirst() {
        return emailFirst;
    }

    public String getEmailSecond() {
        return emailSecond;
    }

    public String getEmailThird() {
        return emailThird;
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

    public File getPhoto() {
        return photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountMap that = (AccountMap) o;
        return Objects.equals(contactID, that.contactID) &&
                Objects.equals(first, that.first) &&
                Objects.equals(surname, that.surname) ;
//                Objects.equals(address, that.address) &&
//                Objects.equals(homePhoneNumber, that.homePhoneNumber) &&
//                Objects.equals(mobilePhoneNumber, that.mobilePhoneNumber) &&
//                Objects.equals(workPhoneNumber, that.workPhoneNumber) &&
//                Objects.equals(emailFirst, that.emailFirst);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactID, first, surname /*, address, homePhoneNumber, mobilePhoneNumber, workPhoneNumber, emailFirst*/);
    }

    @Override
    public String toString() {
        return "AccountMap{" +
                "contactID='" + contactID + '\'' +
                "surname='" + surname + '\'' +
                ", first='" + first + '\'' +
//                ", address='" + address + '\'' +
//                ", homePhoneNumber='" + homePhoneNumber + '\'' +
//                ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' +
//                ", workPhoneNumber='" + workPhoneNumber + '\'' +
//                ", emailFirst='" + emailFirst + '\'' +
                '}';
    }

}
