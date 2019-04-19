package com.stqa.pft.addressbook.appmanager;

import com.stqa.pft.addressbook.model.GroupMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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

    public void selectGroupByIndex(int selectedGroupIndex) {
        driver.findElements(By.name("selected[]")).get(selectedGroupIndex).click();

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

    public List<GroupMap> getGroupList() {
        List<GroupMap> groups = new ArrayList<GroupMap>();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String groupId = element.findElement(By.tagName("input")).getAttribute("value");
            String groupName = element.getText();
            GroupMap group = new GroupMap(groupId, groupName, null, null);
            groups.add(group);
        }
        return groups;
    }
}
