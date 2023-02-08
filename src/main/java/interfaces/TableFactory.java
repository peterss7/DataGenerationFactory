package interfaces;

public abstract class TableFactory {

    public static String[] headers = {"", ""};
    public static String filepath = "filepath";
    public static int[] nullables = {0,0};
    public static int iterations;

    public abstract void createTableData();
    public abstract void createTableCsv();
}
