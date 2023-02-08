package factory.products;

import interfaces.TableFactory;
import utilities.CsvHelper;

import java.util.ArrayList;
import java.util.List;

import static dataresources.csvproperties.Filepaths.PRODUCTS;
import static dataresources.csvproperties.Headers.PRODUCT_HEADERS;
import static dataresources.csvproperties.Nullables.PRODUCT_NULLABLES;


public class ProductsTable extends TableFactory {


    public String[] headers = PRODUCT_HEADERS.getHeaders();
    public int[] nullables = PRODUCT_NULLABLES.getNullables();
    public String filepath = PRODUCTS.getFilepath();
    int iterations;

    List<String[]> tableData = new ArrayList<>();

    public ProductsTable(int iterations){
        this.iterations = iterations;
    }

    @Override
    public void createTableData(){
        for (int i = 0; i < iterations; i++){
            ProductRow currentProduct = new ProductRow(i);
            tableData.add(currentProduct.getDataRow());
        }
    }

    @Override
    public void createTableCsv(){
        CsvHelper.buildCsv(tableData, headers, nullables, filepath);
    }

}
