import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class ProductPage {
    ElementsCollection productsNames = $$(ElementSelector.PRODUCT_PRODUCTS_NAMES.getCssSelector());

    public int getSize(){
        return productsNames.size();
    }
}
