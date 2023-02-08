package dataresources.csvproperties;

public enum TableSizes {

    USERS_SIZE(100),
    VENDORS_SIZE(50),
    PRODUCTS_SIZE(300),
    REQUESTS_SIZE(400),
    REQUEST_LINES_SIZE(500);

    private int size;

    TableSizes (int size){
        this.size = size;
    }

    public int getSize() {
        return size;
    }

}
