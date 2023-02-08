import factory.products.ProductsTable;
import factory.requestlines.RequestLinesTable;
import factory.requests.RequestsTable;
import factory.users.UsersTable;
import factory.vendors.VendorsTable;
import interfaces.TableFactory;

import static dataresources.csvproperties.TableSizes.*;

public class Database {

    TableFactory users, vendors,
            products, requests, requestLines;

    public Database(){

        users = new UsersTable(USERS_SIZE.getSize());
        vendors = new VendorsTable(VENDORS_SIZE.getSize());
        products = new ProductsTable(PRODUCTS_SIZE.getSize());
        requests = new RequestsTable(REQUESTS_SIZE.getSize());
        requestLines = new RequestLinesTable(REQUEST_LINES_SIZE.getSize());
    }

    public void createTables(){

        users.createTableData();
        users.createTableCsv();

        vendors.createTableData();
        vendors.createTableCsv();

        products.createTableData();
        products.createTableCsv();

        requestLines.createTableData();;
        requestLines.createTableCsv();

        requests.createTableData();
        requests.createTableCsv();
    }

}
