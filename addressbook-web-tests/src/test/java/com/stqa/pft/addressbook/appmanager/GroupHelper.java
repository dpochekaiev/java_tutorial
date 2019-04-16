package com.stqa.pft.addressbook.appmanager;

import com.stqa.pft.addressbook.model.GroupMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase{

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupMap groupMap) {
        type(By.name("group_name"), groupMap.getGroupName());
        type(By.name("group_header"), groupMap.getGroupHeader());
        type(By.name("group_footer"), groupMap.getGroupFooter());
    }

    public void fillGroupForm(String groupName) {
        type(By.name("group_name"), groupName);
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroups() {
     //   click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='test1'])[1]/following::input[2]"));
        click(By.xpath("//input[@type='submit' and @name='delete' and @value='Delete group(s)']"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void initGroupModification() {
        click(By.xpath("(//input[@name='edit' and @value='Edit group'])[1]"));
    }

    public void submitGroupUpate() {
        click(By.name("update"));
    }

    public void createGroup(GroupMap testGroup) {
        initGroupCreation();
        fillGroupForm(testGroup);
        submitGroupCreation();
        returnToGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
        return driver.findElements(By.name("selected[]")).size();
    }
}
