package comcast.vtiger.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * 
	 * @param SheetName
	 * @param RowNam
	 * @param CellNum
	 * @return
	 * @throws Throwable
	 */
	
	public String getDataFromExcel(String SheetName,int RowNam,int CellNum) throws Throwable
	{
		
		FileInputStream fis2= new FileInputStream("./Book2.xlsx");
		Workbook wb=WorkbookFactory.create(fis2);
		//Sheet sh=wb.getSheet(SheetName);
		//Row row=sh.getRow(0);
	   // Cell cell=row.getCell(1);
	   // String data=cell.getStringCellValue();
		//return data;
		
		DataFormatter format=new DataFormatter();
		return format.formatCellValue(wb.getSheet(SheetName).getRow(RowNam).getCell(CellNum));
		
		
	}
}
