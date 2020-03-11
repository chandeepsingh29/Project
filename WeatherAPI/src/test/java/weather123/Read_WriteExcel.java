package weather123;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Read_WriteExcel
{
	static public XSSFWorkbook wb;
	static public Sheet sh;
	public String City[];
	static public String Weather[];
	static public int rowCount;
	
	static public String[] getCity(String filePath) 
	{
		try 
		{
			FileInputStream	fis = new FileInputStream(filePath);
			wb = new XSSFWorkbook(fis);
			sh = wb.getSheet("Sheet1");
			
		}	catch (IOException e)
		{
			System.out.println("Error with the Excel Sheet");
		}
		rowCount = sh.getLastRowNum()-sh.getFirstRowNum();
		
		String City[]= new String[rowCount];
		
		for (int row = 1; row <= rowCount; row++) 
		{
			City[row-1] = sh.getRow(row).getCell(0).getStringCellValue();
			System.out.println(City[row-1]);
		}	
		
		return (City);
	}
	
	
	static public void writeTemperature(String filePath, String[] Temp) 
	{
		Weather = Temp;
		
		try
		{
		for (int row = 1; row <= rowCount; row++) 
		{
			sh.getRow(row).createCell(1).setCellValue(Weather[row-1]);
		}

	 FileOutputStream fos=new FileOutputStream(filePath);
	 wb.write(fos);
	 fos.close();
	 
		} catch(IOException e)
		{ 
			System.out.println("Error with the Excel Sheet");
		}
		
	}
}
