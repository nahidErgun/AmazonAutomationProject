package page;

import base.BasePageUtil;
import com.thoughtworks.gauge.Step;
import constants.ProductListingPageConstants;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductListingPage extends BasePageUtil implements ProductListingPageConstants {

    private static String productTitle ="";

    public static String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }


    @Step("Go to <pageNumber>'nd page then verify the url contains <partOfUrlContainsPageNumber>.")
    public void goToGivenPageThenCheck(String pageNumber, String partOfUrlContainsPageNumber) {

        List<WebElement> elements = driver.findElements(PAGINATIONLINK);
        for (WebElement element : elements) {
            if (element.getText().equals(pageNumber)) {
                element.click();
            }
            String currentUrl = driver.getCurrentUrl();
            log.info("Current url is : " + currentUrl);
            Assert.assertTrue("2nd page not opened", currentUrl.contains(partOfUrlContainsPageNumber));
        }
    }

    @Step("Select <productNumber>'rd product from the results")
    public void selectProductAccordingToGivenNumber(int productNumber){
        driver.findElements(PRODUCTSIMG).get(productNumber-1).click();

    }

    @Step("Keep product title")
    public void keepProductTitle(){
        productTitle = getElementBy(PRODUCTTITLE).getText();
        log.info("Product title is : " + productTitle);
        setProductTitle(productTitle);

    }

}