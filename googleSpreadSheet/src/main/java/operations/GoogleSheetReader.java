package operations;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class GoogleSheetReader {
    public static List<List<Object>> getSheetsData(String startCell, String endCell) throws IOException, GeneralSecurityException {
        Sheets sheetsService = GoogleSheetServiceProvider.getSheetsService();
        String range = "data!" + startCell + ":" + endCell;
        String SPREADSHEET_ID = "1XhBUJ2o946YUXzrPGf6kMnEjc4-RK1V7kzKYJBhmLug";

        ValueRange response = sheetsService.spreadsheets().values()
                .get(SPREADSHEET_ID, range)
                .execute();

        return response.getValues();
    }
}
