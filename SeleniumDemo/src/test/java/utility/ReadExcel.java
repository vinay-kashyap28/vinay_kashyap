package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel
{
	
	public static String[][] ReadExcelData(String filePath, String fileName, String sheetName) throws IOException
	{
		String[][] data=null;
		
		File file=new File(filePath+"/"+fileName);
		FileInputStream inputStream= new FileInputStream(file);
		//for the xlsx type format
		Workbook workbook= new XSSFWorkbook(inputStream);
		Sheet sheet= workbook.getSheet(sheetName);
		int rowCount= sheet.getLastRowNum()-sheet.getFirstRowNum();
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getFirstRowNum());
		
		int colCount= sheet.getRow(0).getLastCellNum();
		data= new String[rowCount][colCount]; //Should take Rowcount
		
		for (int i=1; i<=rowCount; i++) //Should take Rowcount
		{
			for (int j=0;j<colCount; j++)
			{
				data[i-1][j]= sheet.getRow(i).getCell(j).toString();
				System.out.print(data[i-1][j]+"  |   ");
			}
			System.out.println();
		}
		
		
		return data;
		
	}

}
