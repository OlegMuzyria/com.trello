package junk;

import com.trello.api.TrelloRestClient;
import com.trello.api.models.Card;
import org.testng.annotations.Test;

import java.io.IOException;

public class TryTrelloApi {
    TrelloRestClient client = new TrelloRestClient();

    @Test
    public void callIt() throws IOException, InterruptedException{
        Card card = new Card();
        card.name = "My New CARD";
        Card createdCard = client.cardService.createCard("5ce5888e82328274eee4db14", card).execute().body();
        System.out.println(createdCard);
        //client.cardService.deleteCard(createdCard.id).execute();
    }
}
