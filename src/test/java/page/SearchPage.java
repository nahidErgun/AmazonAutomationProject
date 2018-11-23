package page;

import base.BasePageUtil;
import com.thoughtworks.gauge.Step;
import constants.SearchPageConstants;
import org.junit.Assert;

public class SearchPage extends BasePageUtil implements SearchPageConstants {

    @Step("Search for <text> text and check the search result accuracy")
    public void searchTextThenCheck(String text){

        sendKeys(SEARCHINPUT,text);
        log.info("Text to search is " + text);

        String searchResult = getElementBy(SEARCHRESULT).getText();
        log.info("Search result is about " + searchResult);

        Assert.assertTrue("Search results are not correct " , searchResult.contains(text));

    }
}
