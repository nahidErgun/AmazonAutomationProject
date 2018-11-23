package page;

import base.BasePageUtil;
import com.thoughtworks.gauge.Step;
import constants.ProductDetailPageConstants;

public class ProductDetailPage extends BasePageUtil implements ProductDetailPageConstants {

    @Step("Add product to wishlist")
    public void addToLisT(){
        clickObjectBy(ADDTOWISHLISTBUTTON);
        clickObjectBy(WISHLISTICON);
        clickObjectBy(BUTTONCLOSE);
    }

}
