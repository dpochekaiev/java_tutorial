package com.stqa.pft.addressbook.appmanager;

import com.stqa.pft.addressbook.model.GroupMap;
import com.stqa.pft.addressbook.model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private void selectGroupById(int groupForDeletionId) {
        driver.findElement(By.cssSelector("input[value='" + groupForDeletionId +  "']")).click();
    }

    public void initGroupModification() {
        click(By.xpath("(//input[@name='edit' and @value='Edit group'])[1]"));
    }

    public void submitGroupUpate() {
        click(By.name("update"));
    }

    /**
     * Creates a new group
     */
    public void create(GroupMap testGroup) {
        initGroupCreation();
        fillGroupForm(testGroup);
        submitGroupCreation();
        groupCache = null;
        returnToGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return driver.findElements(By.name("selected[]")).size();
    }

    private Groups groupCache = null;

    /**
     * @return a set of groups
     */
    public Groups all() {
        if (groupCache != null) {
            return new Groups(groupCache);
        }
        groupCache = new Groups();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            int groupId = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String groupName = element.getText();
            GroupMap group = new GroupMap().withGroupId(groupId).withGroupName(groupName);
            groupCache.add(group);
        }
        return new Groups(groupCache);
    }

    /**
     * Modifies a group
     */
    public void modify(GroupMap group) {
        selectGroupById(group.getGroupId());
        initGroupModification();
        fillGroupForm(group);
        submitGroupUpate();
        groupCache = null;
        returnToGroupPage();
    }

    public void delete(GroupMap groupForDeletion) {
        selectGroupById(groupForDeletion.getGroupId());
        deleteSelectedGroups();
        groupCache = null;
        returnToGroupPage();
    }

}
