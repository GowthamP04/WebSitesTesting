package StockMarketTesting;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteAndPrintExcel {

public static void writemethod( ArrayList<String> data  ) {


        // Sample ArrayList data
   //     ArrayList<String> data = new ArrayList<>();
       
/*
* data.add("Name, Age, City"); data.add("John Doe, 30, New York");
* data.add("Jane Smith, 25, Los bitch"); data.add("Mike Wilson, 35, Chicago");
*/
       
        // Output Excel file path
        String excelFilePath = "output.xlsx";
        String sheetName = "Sheet1"; // Name of the sheet to create
 
        try {
            // Create Excel workbook
            Workbook workbook = new XSSFWorkbook();
 
            // Check if sheet exists and delete it
            int sheetIndex = workbook.getSheetIndex(sheetName);
            if (sheetIndex != -1) {
                workbook.removeSheetAt(sheetIndex);
            }
 
            // Create new sheet
            Sheet sheet = workbook.createSheet(sheetName);
 
            // Write data to Excel
            int rowCount = 0;
            for (String rowData : data) {
                Row row = sheet.createRow(rowCount++);
                String[] rowDataArray = rowData.split("<"); // Split by comma and optional space
                int columnCount = 0;
                for (String field : rowDataArray) {
                    Cell cell = row.createCell(columnCount++);
                    cell.setCellValue(field.trim()); // Trim to remove any leading/trailing whitespace
                }
            }
 
            // Write the output to a file
            try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
                workbook.write(outputStream);
            }
 
            // Close workbook to prevent leaks
            workbook.close();
 
            System.out.println("Excel file has been generated successfully!");
 
            // Print the contents of the sheet
            System.out.println("\nContents of Sheet:");
            printSheet(sheet);
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    private static void printSheet(Sheet sheet) {
        // Iterate through each row in the sheet
        for (Row row : sheet) {
            // Iterate through each cell in the row
            for (Cell cell : row) {
                // Print each cell's value
                System.out.print(cell.getStringCellValue() + "\t\t");
            }
            System.out.println();
        }
    }
}