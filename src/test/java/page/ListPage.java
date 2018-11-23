package page;

import base.BasePageUtil;
import com.thoughtworks.gauge.Step;
import constants.ListPageConstants;
import constants.LoginPageConstants;
import org.junit.Assert;

public class ListPage extends BasePageUtil implements ListPageConstants, LoginPageConstants {

    @Step("Go to wish list page")
    public void goToWishListPage(){
        hoverToElement(SIGNINLABEL);
        clickObjectBy(WISHLIST);
    }

    @Step("Compare product title on wish list with the recorded title")
    public void checkProductTitle(){

        String productNameOnWishlist = getElementBy(PRODUCTTITLEONWHISLIST).getText();
        log.info("Product name on wishlist is : " + productNameOnWishlist);

        log.info("Product name added to wishlist is " + ProductListingPage.getProductTitle());

        Assert.assertTrue("Product names are not same", productNameOnWishlist.equalsIgnoreCase(ProductListingPage.getProductTitle()));
    }

    @Step("Delete product from wish list")
    public void deleteItemFromWishlist(){
        clickObjectBy(DELETEFROMLIST);
        Assert.assertTrue("Ürünü silme işlemi gerçekleşmedi", !isElementExist(DELETEFROMLIST));
    }

    @Step("If wish list is not empty, remove all products.")
    public void deleteAllItemsFromWishList(){
        goToWishListPage();
        int sizeOfProductsOnWishlist = driver.findElements(DELETEFROMLIST).size();
        log.info("Size of products on wish list is " + sizeOfProductsOnWishlist);
        if (sizeOfProductsOnWishlist >0){
            for (int i=0;i<sizeOfProductsOnWishlist;i++){
                clickObjectBy(DELETEFROMLIST);
            }
        }
    }
}

