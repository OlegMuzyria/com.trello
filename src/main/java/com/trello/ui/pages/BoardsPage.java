package com.trello.ui.pages;

import com.trello.ui.core.Constants;
import com.trello.ui.core.Elem;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Date;

import static com.trello.ui.core.BrowserFactory.*;

public class BoardsPage {
    private static final String PATH = "olegmuzyria2/boards";

    public Elem selectionHeader = new Elem (By.cssSelector(".boards-page-board-section-header"), "Board selection header");
    public Elem createBoardBtn = new Elem (By.cssSelector(".mod-add"), "Create new personal Board button");
    public Elem boardNameInput = new Elem (By.cssSelector(".subtle-input"), "Board name input");
    public Elem saveNewBoardButton = new Elem (By.cssSelector(".primary"), "Save new Board button");

    public Elem boardByUrlName(String urlName){
        return new Elem(By.cssSelector(".board-tile[href*='" + urlName + "']"), urlName);
    }

    public void open(){
        get(Constants.URL + PATH);
        Assert.assertTrue(isOpened(), "Boards page is not opened");

    }

    public boolean isOpened(){

        return selectionHeader.isPresent();
    }

    public void openBoard (String urlName){
        boardByUrlName(urlName).click();
    }

    public void createBoard(){
        createBoardBtn.click();
        boardNameInput.type("New board" + new Date().getTime() );
        saveNewBoardButton.click();
        Assert.assertTrue(driver().getCurrentUrl().contains("New board"));
    }

    public void deleteBoard (){

    }

}

