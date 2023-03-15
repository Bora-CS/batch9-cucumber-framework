package utilities;

import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pojo.AmazonSearchResult;

public class ExcelUtil {

	public static void writeAmazonSearchResultToFile(List<AmazonSearchResult> results, String searchTerm) {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(searchTerm);

		XSSFRow firstRow = sheet.createRow(0);
		firstRow.createCell(0).setCellValue("ID");
		firstRow.createCell(1).setCellValue("Price");
		firstRow.createCell(2).setCellValue("Title");

		AmazonSearchResult firstResult = results.get(0);
		double max = firstResult.price;
		double min = firstResult.price;
		double total = 0;

		int rowNum = 1;
		for (AmazonSearchResult result : results) {
			XSSFRow row = sheet.createRow(rowNum);
			row.createCell(0).setCellValue(result.id);
			row.createCell(1).setCellValue(result.price);
			row.createCell(2).setCellValue(result.title);

			if (result.price > max) {
				max = result.price;
			}

			if (result.price < min) {
				min = result.price;
			}

			total += result.price;
			rowNum++;
		}

		XSSFRow maxRow = sheet.createRow(102);
		maxRow.createCell(0).setCellValue("Max");
		maxRow.createCell(1).setCellValue(max);
		XSSFRow minRow = sheet.createRow(103);
		minRow.createCell(0).setCellValue("Min");
		minRow.createCell(1).setCellValue(min);
		XSSFRow averageRow = sheet.createRow(104);
		averageRow.createCell(0).setCellValue("Average");
		averageRow.createCell(1).setCellValue(total / results.size());

		try {
			FileOutputStream fos = new FileOutputStream("target/AmazonSearch" + getTimeStamp() + ".xlsx");
			workbook.write(fos);

			workbook.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static long getTimeStamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp.getTime();
	}

}
