package operations;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class GoogleSheetCreator {
    public static void setSheetsData(List<List<Object>> values) throws IOException, GeneralSecurityException {
        Sheets sheetsService = GoogleSheetServiceProvider.getSheetsService();
        ValueRange appendBody = new ValueRange().setValues(values);

        String SPREADSHEET_ID = "1pnKQ9pyPtOYcvDOHO3Le1q85QvK3UoWUr8q44JH4h6A";
        AppendValuesResponse appendResult = sheetsService.spreadsheets().values()
                .append(SPREADSHEET_ID, "data", appendBody)
                .setValueInputOption("USER_ENTERED")
                .setInsertDataOption("INSERT_ROWS")
                .setIncludeValuesInResponse(true)
                .execute();

    }
}
