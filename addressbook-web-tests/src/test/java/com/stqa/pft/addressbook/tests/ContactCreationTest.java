package com.stqa.pft.addressbook.tests;

        import com.stqa.pft.addressbook.model.AccountMap;
        import com.stqa.pft.addressbook.model.Accounts;
        import com.stqa.pft.addressbook.model.GroupMap;
        import com.thoughtworks.xstream.XStream;
        import org.testng.annotations.*;

        import java.io.BufferedReader;
        import java.io.File;
        import java.io.FileReader;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.Iterator;
        import java.util.List;
        import java.util.stream.Collectors;

        import static org.hamcrest.CoreMatchers.equalTo;
        import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

    @BeforeMethod
    public void ensurePreConditions() {
        app.goTo().groupPage();
        List<GroupMap> groups = app.group().list();
        int i = 0;
        for (GroupMap group : groups) {
            if (group.getGroupName().equals("test1")) {
                break;
            } else {
                i++;
            }
        }
        if (i == app.group().all().size()) {
            app.group().create(new GroupMap().withGroupName("test1").withGroupHeader("Some Dummy Group"));
        }
    }

    @DataProvider
    public Iterator<Object[]> validAccounts() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/accounts.xml")));
        String xml = "";
        String line = reader.readLine();
        while (line != null) {
            xml += line;
            line = reader.readLine();
        }
        XStream xstream = new XStream();
        xstream.processAnnotations(AccountMap.class);
        List<AccountMap> accounts = (List<AccountMap>) xstream.fromXML(xml);
        return accounts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }

    @Test(dataProvider = "validAccounts") //(enabled = false)
    public void testContactCreation(AccountMap newContact) throws Exception {
// preparation part
        System.out.println("================================================");
        System.out.println("Running testContactCreation");
        /*
        File photo = new File("src/test/resources/warrior_logo.png");
        //TODO: remove the block after debugging
        AccountMap newContact = new AccountMap()
                .withFirstName("Neko Name")
                .withMiddleName("S")
                .withSurname("Family Name")
                .withCompany("Some Company")
                .withAddress(" \n   Some address \n \n with several rows")
                .withHomePhoneNumber("123456789")
                .withMobilePhoneNumber("380666442211")
                .withWorkPhoneNumber("05726680254")
                .withEmailFirst("email@mail.com")
                .withEmailSecond("Second_email@some.domain")
                .withEmailThird("Email_No_3@mail.ru")
                .withDayOfBirth("13")
                .withMonthOfBirth("January")
                .withYearOfBirth("1988")
                .withGroup("test1")
                .withPhoto(photo);
                // D:\!-Projects\Cengage\Automation\2-Java tutorial\java_tutorial\addressbook-web-tests\src\test\resources\warrior_logo.png
         */
// test part
        app.goTo().homePage();
        Accounts beforeTestContactsList = app.contact().all();
        app.contact().create(newContact, true);

// outcoming part
        assertThat(app.contact().count(), equalTo(beforeTestContactsList.size() + 1));
        Accounts afterTestContactsList = app.contact().all();
        System.out.println("Contacts before test: " + beforeTestContactsList.size());
        System.out.println("Contacts after test: " + afterTestContactsList.size());
        assertThat(afterTestContactsList, equalTo(beforeTestContactsList.withAdded(newContact.
                withContactID(afterTestContactsList.stream().mapToInt((c) -> c.getContactID()).max().getAsInt()))));
    }

    @Test (enabled = false)
    public void testCurrentDirectory() {
        File photo = new File("src/test/resources/warrior_logo.png");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }

}
