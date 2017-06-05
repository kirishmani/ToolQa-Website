package testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PageData {
	
	@DataProvider(name = "data1")
	public static Object[][] getdata() throws IOException {
		Object[][] data = getExcelData();
		return data;
	}

	@BeforeTest
	public static Object[][] getExcelData() throws IOException {
		File f = new File("C:\\Users\\dell\\Desktop\\target\\Excel\\Test3.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Home");
		int row = sheet.getLastRowNum() + 1;
		int col = sheet.getRow(0).getLastCellNum();
		System.out.println(row);
		System.out.println(col);
		Object[][] data = new Object[1][2];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (sheet.getRow(i).getCell(j).getCellType() == Cell.CELL_TYPE_STRING) {
					String data1 = sheet.getRow(i).getCell(j)
							.getStringCellValue();
					data[i][j] = data1;
					System.out.print(data + " ");
				} else if (sheet.getRow(i).getCell(j).getCellType() == Cell.CELL_TYPE_NUMERIC) {
					data[i][j] = (int) sheet.getRow(i).getCell(j)
							.getNumericCellValue();
					System.out.print(data + " ");
				}
			}
			System.out.println();
		}
		fis.close();
		return data;
	}
}
