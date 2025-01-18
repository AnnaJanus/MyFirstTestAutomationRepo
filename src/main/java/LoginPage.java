import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    SelenideElement usernameInput = $(ElementSelector.LOGIN_USERNAME_INPUT.getCssSelector());
    SelenideElement passwordInput = $(ElementSelector.LOGIN_PASSWORD_INPUT.getCssSelector());
    SelenideElement loginButton = $(ElementSelector.LOGIN_LOGIN_BUTTON.getCssSelector());

    public void usernameFill(String username){
        usernameInput.sendKeys(username);
    }

    public void passwordFill(String password){
        passwordInput.sendKeys(password);
    }

    public void loginButtonClick(){
        loginButton.click();
    }
}
