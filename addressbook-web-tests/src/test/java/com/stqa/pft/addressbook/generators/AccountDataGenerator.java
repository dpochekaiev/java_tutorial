package com.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.stqa.pft.addressbook.model.AccountMap;
import com.stqa.pft.addressbook.model.GroupMap;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AccountDataGenerator {

    private String months[] = {"January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December"};

    @Parameter(names = "-c", description = "Accounts count")
    public int accountsDataCount;

    @Parameter(names = "-f", description = "Accounts data target filename")
    public String accountsDataFileName;

    @Parameter(names = "-d", description = "Accounts data target file format: csv, xml, json")
    public String accountsDataFileFormat;


    public static void main(String[] args) throws IOException {
        AccountDataGenerator generator = new AccountDataGenerator();
        JCommander jCommender = new JCommander(generator);
        try {
            jCommender.parse(args);
        } catch (ParameterException ex) {
            jCommender.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<AccountMap> accounts = generateAccounts(accountsDataCount);
        if (accountsDataFileFormat.equals("csv")) {
            saveAsCsv(accounts, new File(accountsDataFileName + "." + accountsDataFileFormat));
        } else if  (accountsDataFileFormat.equals("xml")) {
            saveAsXml(accounts, new File(accountsDataFileName + "." + accountsDataFileFormat));
        } else {
            System.out.println("Unknown file format: " + accountsDataFileFormat);
        }
    }

    private void saveAsXml(List<AccountMap> accounts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(AccountMap.class);
        String xml = xstream.toXML(accounts);
        Writer writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }

    private void saveAsCsv(List<AccountMap> accounts, File accountsFile) throws IOException {
        Writer writer = new FileWriter(accountsFile);
        for (AccountMap account : accounts) {
            writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n",
                    account.getFirst(),
                    account.getMiddleName(),
                    account.getSurname(),
                    account.getCompany(),
                    account.getAddress(),
                    account.getHomePhoneNumber(),
                    account.getMobilePhoneNumber(),
                    account.getWorkPhoneNumber(),
                    account.getEmailFirst(),
                    account.getEmailSecond(),
                    account.getEmailThird(),
                    account.getDayOfBirth(),
                    account.getMonthOfBirth(),
                    account.getYearOfBirth(),
                    account.getGroup(),
                    account.getPhoto().getAbsolutePath()
            ));
        }
        writer.close();
    }

    private List<AccountMap> generateAccounts(int amountOfAccounts) {
        List<AccountMap> accounts = new ArrayList<AccountMap>();
        File photo = new File("src/test/resources/warrior_logo.png");
        String middleNames[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
                "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Random randomMiddleName = new Random();
        Random randomMonthOfBirth = new Random();
        Random randomYearOfBirth = new Random();
        int dayOfBirthIndex;
        for (int i = 0; i < amountOfAccounts; i++) {
            int middleNameIndex = randomMiddleName.nextInt(middleNames.length);
            int monthOfBirthIndex = randomMonthOfBirth.nextInt(months.length);
            int yearOfBirth = randomYearOfBirth.nextInt(100);
            dayOfBirthIndex = middleNameIndex + 1;
            accounts.add(new AccountMap()
                    .withFirstName(String.format("Name %s", i))
                    .withMiddleName(String.format(middleNames[middleNameIndex]))
                    .withSurname(String.format("Surname %s", i))
                    .withCompany(String.format("Company name %s", i))
                    .withAddress(refactorBackSlash(String.format(" \n   Some address \n \n with several rows %s", i)))
                    .withHomePhoneNumber(String.format("123456789%s", i))
                    .withMobilePhoneNumber(String.format("+38(066)644 22 1%s", i))
                    .withWorkPhoneNumber(""+i+i+i+i+i+i+i+i+i+i)
                    .withEmailFirst(String.format("first_email_%s@mail.com", i))
                    .withEmailSecond(String.format("Second_email_%s@some.domain", i))
                    .withEmailThird(String.format("%s_Email_No_3@mail.ru", i))
                    .withDayOfBirth(String.format("%s", dayOfBirthIndex))
                    .withMonthOfBirth(String.format("%s", months[monthOfBirthIndex]))
                    .withYearOfBirth(String.format("%s", yearOfBirth + 1910))
                    .withGroup("test1")
                    .withPhoto(photo)
            );
        }
        return accounts;
    }

    public static String refactorBackSlash (String phoneNumber) {
        return phoneNumber.replaceAll("\\n", "\\\\n");
    }

}
