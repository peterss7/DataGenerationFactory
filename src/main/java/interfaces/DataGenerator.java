package interfaces;


import java.util.List;

public interface DataGenerator {
    public abstract void generateData(String tableDataType);
    public abstract String[] getDataRow();
}
