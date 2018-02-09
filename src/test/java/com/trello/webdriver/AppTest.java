package com.trello.webdriver;

import com.trello.AppPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AppTest
{

   private AppPage app;


    @BeforeMethod(alwaysRun = true)
    public void setUpTest() {

    }

    /**
     *
     * Test Case : Board_0001
     */
    @Test
    public void CreateNewBoard() throws InterruptedException {

        app = new AppPage();
        app.Login();
        app.CreateNewBoard();
        app.CloseBoard();
        app.CloseBrowser();

    }


    /**
     *
     * Test Case : Board_0003
     */
    @Test
    public void CreateListAndValidate() throws InterruptedException{
        app = new AppPage();
        app.Login();
        app.CreateNewBoard();
        app.CreateList("Backlog");
        app.ValidateListName("Backlog", 0);
        app.CreateList("On Dev");
        app.CreateList("At QA");
        app.CreateList("Done");
        app.CloseBoard();
        app.CloseBrowser();

    }

    /**
     *
     * Test Case : Board_0004
     */
    @Test
    public void UpdateListName() throws InterruptedException{
        app = new AppPage();
        app.Login();
        app.CreateNewBoard();
        app.CreateList("Backlog");
        app.ValidateListName("Backlog", 0);
        app.CreateList("On Dev");
        app.EditListName("On Dev", "In Development");
        app.CloseBoard();
        app.CloseBrowser();
    }

}
