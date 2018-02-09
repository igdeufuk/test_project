package com.trello;

public interface DashboardProvider {

    /**
     * ID
     */

    String UserNameText = "user";
    String Passwordtext = "password";
    String LoginButton  = "login";
    String BoardTitleInput = "boardNewTitle";


    /**
     * CSS
     */



    /**
     * XPATH
     */

    String CreateNewBoardButton = "//a[@class = 'board-tile mod-add']";
    String CreateBoardButton = "//input[@class = 'primary wide js-submit']";
    String ExpandMore = "//a[@class = 'board-menu-navigation-item-link js-open-more']";
    String CloseBoard = "//a[@class = 'board-menu-navigation-item-link js-close-board']";
    String CloseBoardButton = "//input[@class = 'js-confirm full negate']";
    String CloseConfirmationText = "//div[@class = 'big-message quiet']";
    String EnterListNameText = "//input[@class = 'list-name-input']";
    String SaveListNameButton = "//input[@class = 'primary mod-list-add-button js-save-edit']";
    String GetListName = "//div[@class = 'list-header js-list-header u-clearfix is-menu-shown is-subscribe-shown']";
    String OpenBoardButton = "//span[@class = 'board-tile-details is-badged']";
    String EditListName = "//div[@class = 'list-header js-list-header u-clearfix is-menu-shown']";
    String EditModeListName = "//testarea[@class = 'list-header-name mod-list-name js-list-name-input is-editing']";
    String AddListButton = "//span[@class = 'placeholder js-open-add-list']";


}
