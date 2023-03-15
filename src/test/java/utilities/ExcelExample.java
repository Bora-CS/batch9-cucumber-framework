package utilities;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelExample {

	public static void main(String[] args) {

		// This is like the excel file
		XSSFWorkbook workbook = new XSSFWorkbook();
		// This is like a sheet
		XSSFSheet sheet = workbook.createSheet("BoraTech");

		// This is the column header
		XSSFRow firstRow = sheet.createRow(0);
		firstRow.createCell(0).setCellValue("ID");
		firstRow.createCell(1).setCellValue("Gender");
		firstRow.createCell(2).setCellValue("Name");

		for (int rowNunber = 1; rowNunber <= 20; rowNunber++) {
			XSSFRow row = sheet.createRow(rowNunber);
			row.createCell(0).setCellValue(rowNunber);
			row.createCell(1).setCellValue(rowNunber % 2 == 0 ? "Female" : "Male");
			row.createCell(2).setCellValue("FirstName" + rowNunber + " XXX");
		}

		try {
			FileOutputStream fos = new FileOutputStream("target/TestData.xlsx");
			workbook.write(fos);

			workbook.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
