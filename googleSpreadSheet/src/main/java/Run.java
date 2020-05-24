import operations.GoogleSheetCreator;
import operations.GoogleSheetReader;
import operations.GoogleSheetUpdater;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

public class Run {
    public static void main(String[] args) throws IOException, GeneralSecurityException {
        List<List<Object>> values = GoogleSheetReader.getSheetsData("A1", "C1");

        if(values == null || values.isEmpty()){
            System.out.println("no data");
        } else {
            for(List row: values) {
                for(Object item: row) {
                    System.out.println(item);
                }
            }
        }

        List<List<Object>> appendValues = Arrays.asList(
                Arrays.asList("this", "from", "code")
        );

        GoogleSheetCreator.setSheetsData(appendValues);

        List<List<Object>> updateValues = Arrays.asList(
                Arrays.asList("update")
        );

        GoogleSheetUpdater.updateSheetsData(updateValues, "B2");
    }
}
