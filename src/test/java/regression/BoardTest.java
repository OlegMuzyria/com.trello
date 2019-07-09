package regression;

import com.trello.api.TrelloAPILogin;
import com.trello.api.TrelloRestClient;
import com.trello.api.models.Board;
import com.trello.ui.core.BrowserFactory;
import com.trello.ui.core.Constants;
import com.trello.ui.pages.BoardsPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class BoardTest extends BrowserFactory {

    public BoardsPage boardsPage = new BoardsPage();

    public TrelloRestClient client = new TrelloRestClient();
    public TrelloAPILogin loginByApi = new TrelloAPILogin();

    Board board = new Board();
    @BeforeTest
    public void prepareData() throws IOException, InterruptedException {
        loginByApi.loginByAPI();
    }

    @AfterTest
    public void clearData () throws IOException {
        client.boardService.deleteBoard(board.id).execute();
    }

    @Test
    public void openBoards (){
        boardsPage.open();
    }

    @Test (dependsOnMethods = "openBoards")
    public void createBoard(){
        boardsPage.createBoard();
    }
}
