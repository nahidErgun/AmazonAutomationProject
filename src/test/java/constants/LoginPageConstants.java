package constants;

import org.openqa.selenium.By;

public interface LoginPageConstants {

    public By SIGNINLABEL = By.id("nav-link-accountList");

    public By SIGNINBUTTON = By.xpath("//a[@data-nav-role='signin']");

    public By EMAIL = By.id("ap_email");

    public By PASSWORD = By.id("ap_password");

    public By LOGINSUBMIT = By.id("signInSubmit");

    public By DELETEFROMLIST = By.xpath("//input[contains(@name,'submit.deleteItem') and contains(@class,'a-declarative') ]");


}
