package weather123;

import java.io.IOException;
import weather123.GoogleAPI_Weather;
import weather123.Read_WriteExcel;

import org.testng.annotations.Test;


public class NewTest 
{
	@Test
	public void f() throws IOException
	{
		
	  GoogleAPI_Weather W1 = new GoogleAPI_Weather();
	  String path = System.getProperty("user.dir");
	  String filePath = path + "\\resources\\excelFiles\\Weather.xlsx";		
	  String Cityname[];
	  String Temperature[];
	  
	  Cityname = Read_WriteExcel.getCity(filePath);
	  Temperature = W1.GetWeatherDetails(Cityname);
	  Read_WriteExcel.writeTemperature(filePath, Temperature);
		
	}
}