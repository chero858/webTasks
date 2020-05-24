package operations;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class GoogleSheetUpdater {
    public static void updateSheetsData(List<List<Object>> values, String range) throws IOException, GeneralSecurityException {
        Sheets sheetsService = GoogleSheetServiceProvider.getSheetsService();
        String SPREADSHEET_ID = "1pnKQ9pyPtOYcvDOHO3Le1q85QvK3UoWUr8q44JH4h6A";
        ValueRange body = new ValueRange().setValues(values);

        UpdateValuesResponse result = sheetsService.spreadsheets().values()
                .update(SPREADSHEET_ID, range, body)
                .setValueInputOption("RAW")
                .execute();

    }

}

