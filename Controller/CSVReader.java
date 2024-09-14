package Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private String csvFile;

    // Constructor รับชื่อไฟล์ CSV
    public CSVReader(String csvFile) {
        this.csvFile = csvFile;
    }

    // อ่านข้อมูลจาก CSV โดยใช้ BufferedReader
    public List<String[]> readCSV() {
        List<String[]> data = new ArrayList<>();
        String line;
        String csvSplitBy = ","; // ใช้ในการแยกคอลัมน์

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // ข้ามบรรทัดแรกที่เป็นชื่อคอลัมน์
            br.readLine();
            while ((line = br.readLine()) != null) {
                // แยกข้อมูลในแต่ละแถวด้วยเครื่องหมาย comma
                String[] row = line.split(csvSplitBy);
                data.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    // ค้นหาข้อมูล Cow ตาม ID
    public String[] findCowById(String id) {
        List<String[]> data = readCSV();
        for (String[] row : data) {
            if (row.length > 0 && row[0].equals(id)) {
                return row;
            }
        }
        return null;
    }
}
