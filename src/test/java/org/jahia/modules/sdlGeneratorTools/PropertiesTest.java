package org.jahia.modules.sdlGeneratorTools;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PropertiesTest extends GeneratorToolsRepository {

    @BeforeMethod()
    private void goToGeneratorTools() {
        goToTools("jahia", "password");
        getDriver().navigate().to(getPath("/modules/sdl-generator-tools/tools/sdlGeneratorTools.jsp"));
    }

    @Test(dataProvider = "propertiesList", alwaysRun = true)
    public void propertiesListTest(String typeName, String nodeType, int listSize) {
        addAType(typeName, nodeType);
        //findByXpath("//p[contains(.,'Node type')]/parent::ul/li[3]");

        clickOn(findByXpath("//span/p[contains(., 'Add a new property')]"));
        Assert.assertTrue(findByID("form-dialog-title").isDisplayed(), "Failed to display Add new property dialog box");

        clickOn(findByXpath("//div[contains(@class, 'MuiSelect-selectMenu-')]"));
        waitForElementToStopMoving(findByXpath("//ul[@role='listbox']"));
        //--check properties dropdown list
        Assert.assertEquals(findElementsByXpath("//ul[@role='listbox']/li").size(), listSize, "properties dropdown list is incorrect");
    }

    @Test(alwaysRun = true)
    public void addPropertyTest() {
        goToTools("jahia", "password");
        getDriver().navigate().to(getPath("/modules/sdl-generator-tools/tools/sdlGeneratorTools.jsp"));

        addAType("jnt:article", "Article");

        clickOn(findByXpath("//span/p[contains(., 'Add a new property')]"));
        Assert.assertTrue(findByID("form-dialog-title").isDisplayed(), "Failed to display Add new property dialog box");



    }



}
