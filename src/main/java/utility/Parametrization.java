package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class Parametrization {
	public static String FetchData(WebDriver driver,String sheetName,int row,int cell ) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("F:\\Automation\\swaglabs\\src\\main\\resources\\inputData.xlsx");
	String value	=WorkbookFactory.create(file).getSheet("sheetName").getRow(row).getCell(cell).getStringCellValue();
	return value;
	}

}
