package regression;

import com.trello.ui.core.BrowserFactory;
import com.trello.ui.pages.BoardsPage;
import com.trello.ui.pages.CardPage;
import com.trello.ui.pages.LoginPage;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BrowserFactory {

    public LoginPage loginPage = new LoginPage();
    public BoardsPage boardsPage = new BoardsPage();
    public CardPage cardPage = new CardPage();

    @Story("Login with valid user")
    @Test
    public void login() throws InterruptedException {

        loginPage.open();
        loginPage.login("olegmuzyria89@gmail.com", "Maxmotives95");
    }

    @Test(dependsOnMethods = "login")
    public void logout() throws IOException {
        loginPage.logout();
    }
}

