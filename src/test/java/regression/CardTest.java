package regression;

import com.trello.api.TrelloRestClient;
import com.trello.api.models.Card;
import com.trello.ui.core.BrowserFactory;
import com.trello.ui.pages.BoardsPage;
import com.trello.ui.pages.CardPage;
import com.trello.ui.pages.LoginPage;
import io.qameta.allure.Story;
import com.trello.api.TrelloAPILogin;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.trello.ui.core.Elem;

import java.io.IOException;
import java.util.Date;

public class CardTest extends BrowserFactory {


    public TrelloRestClient client = new TrelloRestClient();

    public BoardsPage boardsPage = new BoardsPage();
    public CardPage cardPage = new CardPage();
    public TrelloAPILogin loginByApi = new TrelloAPILogin();

    Card card = new Card("Test_Card_" + new Date().getTime());

    @BeforeTest
    public void prepareData() throws IOException, InterruptedException {
        loginByApi.loginByAPI();
        card = client.cardService.createCard("5ce5888e82328274eee4db14", card).execute().body();
    }

    @AfterTest
    public void clearData() throws IOException {
        client.cardService.deleteCard(card.id).execute();
    }

    @Test //(dependsOnMethods = "login")
    public void openCard() {
        cardPage.open(card.url);
    }

    @Test
    public void moveCard() {
        //   cardPage.moveToList(""):

    }

    @Test
    public void rename() {

    }

    @Story ("Add card member from the list")
    @Test (dependsOnMethods = "openCard")
    public void addMember() {
        cardPage.addMember();

    }

    @Test (dependsOnMethods = "addMember")
    public void addLabel (){
        cardPage.addLabel();
    }

    @Test (dependsOnMethods = "addLabel")
    public void addChecklist() throws InterruptedException {
        cardPage.addCheckList();
    }

    @Test (dependsOnMethods = "addChecklist")
    public void deleteChecklist (){
        cardPage.deleteChecklist();
    }

    @Test (dependsOnMethods = "deleteChecklist")
    public void attachLink () throws InterruptedException {
        cardPage.addAttachment();
    }

    @Test (dependsOnMethods = "attachLink")
    public void deleteAttachment () throws InterruptedException {
        cardPage.deleteAttachment();
    }

    @Test (dependsOnMethods = "deleteAttachment")
    public void copyCard() throws InterruptedException {
        cardPage.copyCard("5d19add087c7254fce730784", "5d19db3149379a0b8b401c81");
    }
}

