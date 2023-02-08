package factory.users;

import interfaces.TableFactory;
import utilities.CsvHelper;

import java.util.ArrayList;
import java.util.List;

import static dataresources.csvproperties.Filepaths.USERS;
import static dataresources.csvproperties.Headers.USER_HEADERS;
import static dataresources.csvproperties.Nullables.USER_NULLABLES;

public class UsersTable extends TableFactory {

    public static String[] headers = USER_HEADERS.getHeaders();
    public static int[] nullables = USER_NULLABLES.getNullables();
    public static String filepath = USERS.getFilepath();
    public static int iterations;

    List<String[]> tableData = new ArrayList<>();

    public UsersTable(int iterations){
        this.iterations = iterations;
    }

    @Override
    public void createTableData(){

        for (int i = 0; i < iterations; i++){
            UserRow currentUser = new UserRow(i);
            tableData.add(currentUser.getDataRow());
        }
    }

    @Override
    public void createTableCsv(){
        CsvHelper.buildCsv(tableData, headers, nullables, filepath);
    }

}
