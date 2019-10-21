package com.trello.ui.pages;

import com.trello.ui.core.Constants;
import com.trello.ui.core.Elem;
import org.openqa.selenium.By;
import org.testng.Assert;


import static com.trello.ui.core.BrowserFactory.*;


public class LoginPage {

    private static final String PATH = "login";

    public Elem emailFld = new Elem (By.cssSelector("#user"), "Login Field");
    public Elem passFld = new Elem (By.cssSelector("#password"), "Password Field");
    public Elem loginBtn = new Elem (By.cssSelector("#login"), "Login Buttons" );
    public Elem boardSelection = new Elem (By.cssSelector(".boards-page-board-section-header"), "Board selection panel" );
    public Elem secondLoginBtn = new Elem (By.cssSelector(".global-header-section-button"), "Repeat login button" );
    public Elem userMenuBtn = new Elem (By.cssSelector(".header-avatar"), "User Menu" );
    public Elem logoutMenuDD = new Elem (By.cssSelector(".js-logout"), "Logout menu dropdown" );


    public void open (){
        get(Constants.URL+PATH);
        Assert.assertTrue(isOpened(),"Page 'Login' [" + PATH + "] is not Opened");
    }


    public boolean isOpened(){
        return loginBtn.isPresent() && driver().getCurrentUrl().contains(Constants.URL + PATH);
    }


    public void login (String email, String password){
        emailFld.type(email);
        passFld.type(password);
        loginBtn.click();
        Assert.assertTrue(boardSelection.isPresent(), " Board page not opened");
    }

    public void logout() {
        userMenuBtn.click();
        logoutMenuDD.click();
        Assert.assertTrue(!secondLoginBtn.isPresent(), "Logout page is not opened");

    }
}

