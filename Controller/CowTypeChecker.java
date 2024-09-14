package Controller;

import java.util.List;

public class CowTypeChecker {
    private List<String[]> data; // data from csv

    public CowTypeChecker(List<String[]> data) {
        this.data = data;
    }

    // check cow type
    public String checkCowType(String cowID) {
        for (String[] row : data) {
            
            if (row.length > 1 && row[0].equals(cowID)) {
                return row[1]; // column 1 is cowType
            }
        }
        return null; // CowID is not found
    }
}
