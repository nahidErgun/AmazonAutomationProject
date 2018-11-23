package page;

import base.BasePageUtil;
import com.thoughtworks.gauge.Step;
import constants.LoginPageConstants;

public class LoginPage extends BasePageUtil implements LoginPageConstants {


    @Step("Enter <email> as email.")
    public void enterUsername(String username) {
        setObjectBy(EMAIL, username);
    }

    @Step("Enter <password> as password.")
    public void enterPassword(String password) {
        setObjectBy(PASSWORD, password);
    }

    @Step("Click login button")
    public void clickLoginButton() {
        clickObjectBy(LOGINSUBMIT);
    }

    @Step("Click sign in button")
    public void clickSignIn() {
        clickObjectBy(SIGNINLABEL);
    }

}