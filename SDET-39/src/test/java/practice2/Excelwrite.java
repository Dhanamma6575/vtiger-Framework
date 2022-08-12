package practice2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelwrite {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./Book2.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("sheet2");
		Row r=sh.createRow(1);
		Cell cell=r.createCell(3);
		cell.setCellValue("Test yantra");
		
		
		FileOutputStream fos=new FileOutputStream("./Book2.xlsx");
		wb.write(fos);
		wb.close();
		
	}

}
