package by.teachmeskills.eshop.utils;

public enum PagesPathEnum {
    HOME_PAGE("home"),
    SIGN_IN_PAGE("signin"),
    CATEGORY_PAGE("category"),
    CART_PAGE("cart"),
    MY_PAGE("mypage"),
    REGISTRATION_PAGE("registration"),
    SEARCH_PAGE("search"),
    PRODUCT_PAGE("product");

    private final String path;

    PagesPathEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

