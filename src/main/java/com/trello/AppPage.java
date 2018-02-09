package com.trello;


import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class AppPage implements DashboardProvider
{

    /**
     * By ID
     */

    @FindBy(how = How.ID, using = UserNameText)
    WebElement userNameText;
    @FindBy(how = How.ID, using = Passwordtext)
    WebElement passwordText;
    @FindBy(how = How.ID, using = LoginButton)
    WebElement loginButton;
    @FindBy(how = How.ID, using = BoardTitleInput)
    WebElement boardTitleInput;

    /**
     * By CSS
     */


    /**
     * By XPATH
     */
    @FindBy(how = How.XPATH, using = CreateNewBoardButton)
    WebElement createNewBoardButton;
    @FindBy(how = How.XPATH, using = CreateBoardButton)
    WebElement createBoardButton;
    @FindBy(how = How.XPATH, using = ExpandMore)
    WebElement expandMore;
    @FindBy(how = How.XPATH, using = CloseBoard)
    WebElement closeBoard;
    @FindBy(how = How.XPATH, using = CloseBoardButton)
    WebElement closeBoardButton;
    @FindBy(how = How.XPATH, using = CloseConfirmationText)
    WebElement closeConfirmationText;

    @FindBy(how = How.XPATH, using = EnterListNameText)
    WebElement enterListNameText;
    @FindBy(how = How.XPATH, using = SaveListNameButton)
    WebElement saveListNameButton;
    @FindBy(how = How.XPATH, using = GetListName)
    WebElement getListName;
    @FindBy(how = How.XPATH, using = OpenBoardButton)
    WebElement openBoardButton;
    @FindBy(how = How.XPATH, using = EditListName)
    WebElement editListName;
    @FindBy(how = How.XPATH, using = EditModeListName)
    WebElement editModeListName;
    @FindBy(how = How.XPATH, using = AddListButton)
    WebElement addListButton;

    WebDriver driver;
    WebDriverWait w;


    public void Login(){

        String mailAddress = "ufukigde@windowslive.com";
        String password = "12341234";
        System.setProperty("webdriver.chrome.driver", "src/chromedriver");
        driver = new ChromeDriver();
        w = new WebDriverWait(driver, 15, 30);
        String loginUrl = "https://trello.com/login";
        driver.get(loginUrl);
        driver.findElement(By.id(UserNameText)).sendKeys(mailAddress);
        driver.findElement(By.id(Passwordtext)).sendKeys(password);
        driver.findElement(By.id(LoginButton)).click();

    }

    public void CloseBrowser(){

        driver.close();
        driver.quit();

    }

    public void CreateNewBoard() throws InterruptedException {

        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CreateNewBoardButton)));
        driver.findElement(By.xpath(CreateNewBoardButton)).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id(BoardTitleInput)));
        driver.findElement(By.id(BoardTitleInput)).sendKeys("Test Project");
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CreateBoardButton)));
        driver.findElement(By.xpath(CreateBoardButton)).click();


    }

    public void CloseBoard(){

        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ExpandMore)));
        driver.findElement(By.xpath(ExpandMore)).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CloseBoard)));
        driver.findElement(By.xpath(CloseBoard)).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CloseBoardButton)));
        driver.findElement(By.xpath(CloseBoardButton)).click();
        String closeMessage = driver.findElement(By.xpath(CloseConfirmationText)).getText();

        if(!closeMessage.contains("Test Project is closed.")){
            Assert.fail("Test Failed - Board did not closed successfully!");
        }

    }

    public void CreateList(String listName){

        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EnterListNameText)));
        driver.findElement(By.xpath(EnterListNameText)).sendKeys(listName);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SaveListNameButton)));
        driver.findElement(By.xpath(SaveListNameButton)).click();

    }

    public void ValidateListName(String validateListName, int position){

        w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(GetListName)));
        List<WebElement> listName = driver.findElements(By.xpath(GetListName));

        if (!listName.get(position).getText().contains(validateListName)) {
            System.out.println("List name is " + listName.get(position).getText());
            Assert.fail("Test Failed - List Name does not match with " + validateListName);
        }
    }

    public Boolean EditListName(String oldListName, String newListName) throws InterruptedException {

        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EditListName)));
        driver.findElement(By.xpath("//textarea[@class = 'list-header-name mod-list-name js-list-name-input' and @aria-label = '" + oldListName + "']")).clear();
        driver.findElement(By.xpath("//textarea[@class = 'list-header-name mod-list-name js-list-name-input' and @aria-label = '" + oldListName + "']")).sendKeys(newListName);
        return true;

    }

    public void OpenExistingBoard(){

        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OpenBoardButton)));
        driver.findElement(By.xpath(OpenBoardButton)).click();

    }

}
