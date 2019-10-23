package com.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@XStreamAlias("account")
@Entity
@Table(name = "addressbook")
public class AccountMap {

    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int contactID = 0;

    @Transient
    private String details;

    @Column(name = "firstname")
    private  String first;

    @Column(name = "middlename")
    private  String middleName;

    @Column(name = "lastname")
    private  String surname;

    @Column(name = "company")
    private  String company;

    @Column(name = "address")
    @Type(type = "text")
    private  String address;

    @Transient
    private  String phones;

    @Column(name = "home")
    @Type(type = "text")
    private  String homePhoneNumber;

    @Column(name = " mobile")
    @Type(type = "text")
    private  String mobilePhoneNumber;

    @Column(name = "work")
    @Type(type = "text")
    private  String workPhoneNumber;

    @Transient
    private  String emails;

    @Column(name = "email")
    @Type(type = "text")
    private  String emailFirst;

    @Column(name = "email2")
    @Type(type = "text")
    private  String emailSecond;

    @Column(name = "email3")
    @Type(type = "text")
    private  String emailThird;

    @Column(name = "bday")
    @Type(type = "byte")
    private  Byte dayOfBirth;

    @Column(name = " bmonth")
    private  String monthOfBirth;

    @Column(name = "byear")
    private  String yearOfBirth;

    @Transient
    private  String group;

    @Column(name = "photo")
    @Type(type = "text")
    private String photo;


    public AccountMap withPhoto(File photo) {
        this.photo = photo.getPath();
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
        if (dayOfBirth.equals("") | dayOfBirth.equals("-")) {
            this.dayOfBirth = null;
        } else {
            this.dayOfBirth = Byte.parseByte(dayOfBirth);
        }
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
        if (dayOfBirth == null) {
            return "";
        } else {
            return dayOfBirth.toString();
        }
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
        if (photo != null) {
            return new File(photo);
        }
        return null;
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
