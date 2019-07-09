package junk;

import com.trello.ui.core.BrowserFactory;
import org.testng.annotations.Test;

public class TryBrowser extends BrowserFactory {

    @Test
    public void openClose(){
        driver().get("https://gogle.com");
    }
}
