package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import base.BaseClass;

public class ExcelUtility extends BaseClass {

	//public static Properties prop;

    // Static block to initialize properties
    static {
        try{
            loadConfig();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file");
        }
    }

	
	GenerateUniqueData  dg = new GenerateUniqueData();
	
	
	/**
	 * Reads data from an Excel sheet.
	 * 
	 * @return An array of strings containing the read data.
	 * @throws Exception if any error occurs during reading.
	 */
	public String[] readExcelData() throws Exception {
		
		File excelFile = new File(prop.getProperty("excelFilePath"));
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("userDetails");
		String[] list = new String[2];
		
		// Generate a random row number within the valid range
		//int randomRowNumber = dg.generateRandomNumber(1, sheet.getLastRowNum());
		int randomRowNumber = 1;
		DataFormatter df = new DataFormatter();
		
		// Read specific cell values from the randomly selected row
		list[0] = df.formatCellValue(sheet.getRow(randomRowNumber).getCell(2)); // email
		list[1] = df.formatCellValue(sheet.getRow(randomRowNumber).getCell(6));  // pass
		
		fis.close();
		workbook.close();
		
		return list;
	}
	
	

    /**
     * Reads data from an Excel sheet.
     * 
     * @return A list of arrays of strings containing the read data.
     * @throws Exception if any error occurs during reading.
     */
    public List<String[]> readExcelDataList() throws Exception {
    	File excelFile = new File(prop.getProperty("excelFilePath"));
        FileInputStream fis = new FileInputStream(excelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("userDetails");
        List<String[]> dataList = new ArrayList<>();

        DataFormatter df = new DataFormatter();
        
        // Read data from each row in the sheet
        for (int i = 1; i <= sheet.getLastRowNum(); i++) { // assuming first row is header
            String[] data = new String[2];
            data[0] = df.formatCellValue(sheet.getRow(i).getCell(2)); // email
            data[1] = df.formatCellValue(sheet.getRow(i).getCell(6)); // password
            dataList.add(data);
        }
        
        fis.close();
        workbook.close();
        
        return dataList;
    }
	
	
	/**
	 * Writes data to an Excel sheet.
	 * 
	 * @param data An array of strings containing the data to be written.
	 * @throws Exception if any error occurs during writing.
	 */

    public void writeExcelData(String[] data) throws Exception {
        // Ensure data array length matches the number of columns
        if (data.length != 7) { // Adjust this length if the number of columns changes
            throw new IllegalArgumentException("Data length does not match the number of columns.");
        }

        File excelFile = new File(prop.getProperty("excelFilePath"));
        FileInputStream fis = new FileInputStream(excelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("userDetails");

        // If sheet does not exist, create a new one
        if (sheet == null) {
            sheet = workbook.createSheet("userDetails");
        }

        int rowNum = sheet.getLastRowNum();
        // If there are no rows, start from row 1 to leave room for headers
        if (rowNum == 0 && sheet.getRow(rowNum) == null) {
            rowNum = 1;
            // Create header row
            XSSFRow headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("firstName");
            headerRow.createCell(1).setCellValue("lastName");
            headerRow.createCell(2).setCellValue("email");
            headerRow.createCell(3).setCellValue("phoneNumber");
            headerRow.createCell(4).setCellValue("occupation");
            headerRow.createCell(5).setCellValue("gender");
            headerRow.createCell(6).setCellValue("password");
        } else {
            rowNum++; // Move to the next row
        }

        // Create a new row and write data to each cell in that row
        XSSFRow row = sheet.createRow(rowNum);

        // Define column indices based on your column order
        int firstNameIndex = 0;
        int lastNameIndex = 1;
        int emailIndex = 2;
        int phoneNumberIndex = 3;
        int occupationIndex = 4;
        int genderIndex = 5;
        int passwordIndex = 6;

        // Map each data field to its column index
        row.createCell(firstNameIndex).setCellValue(data[0]); // firstName
        row.createCell(lastNameIndex).setCellValue(data[1]);  // lastName
        row.createCell(emailIndex).setCellValue(data[2]);   // email
        row.createCell(phoneNumberIndex).setCellValue(data[3]); // phoneNumber
        row.createCell(occupationIndex).setCellValue(data[4]); // occupation
        row.createCell(genderIndex).setCellValue(data[5]);   // gender
        row.createCell(passwordIndex).setCellValue(data[6]); // password

        // Print confirmation message
        System.out.println("Updated: " + data[0]);

        fis.close();

        try (FileOutputStream fileOut = new FileOutputStream(excelFile)) {
            workbook.write(fileOut);
        }

        workbook.close();
    }
}
