import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ElementSelector {
    LOGIN_USERNAME_INPUT("#user-name"),
    LOGIN_PASSWORD_INPUT("#password"),
    LOGIN_LOGIN_BUTTON("#login-button"),

    PRODUCT_PRODUCTS_NAMES(".inventory_item_name");

    @Getter
    public final String cssSelector;
}
