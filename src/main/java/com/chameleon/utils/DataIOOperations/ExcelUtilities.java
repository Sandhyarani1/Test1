package com.chameleon.utils.DataIOOperations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.accuweather.glacier.api.APIConstants;
import com.chameleon.utils.io.PropertiesManager;

public class ExcelUtilities
{
	private static XSSFSheet excelWSheet;
	private static XSSFWorkbook excelWBook;
	private static XSSFCell cell;
	private static XSSFRow row;
	public static int rowNo = 0;
	public static Map<String, String> apiProperties = PropertiesManager.properties(APIConstants.API_PROPERTIES);
	
	/**
	 * @author HFARAZ
	 * Method to read the location_keys.xlsx file
	 * **/
	public static void readLocationKeysFile()
	{
		ExcelUtilities.readExcelFile(apiProperties.get(APIConstants.LOCATION_KEYS_FILE_PATH), apiProperties.get(APIConstants.US_SHEET));
	}
	
	/**
	 * @author HFARAZ
	 * Method to fetch the location key from location_keys.xlsx file
	 * @return String value: location key/CityID based on the row number provided in the parameter
	 * */
	public static String getLocationKey(int rowNo)
	{
		return ExcelUtilities.getNumericData(rowNo, 0)+"";
	}
	
	/**
	 * @author HFARAZ
	 * Method to fetch the zipcode from location_keys.xlsx file
	 * @return String value: zipcode based on the row number provided in the parameters
	 * */
	public static String getZipCode(int rowNo)
	{
		String zipCode = ExcelUtilities.getNumericData(rowNo, 5)+"";
		if(zipCode.length()==4)
		{
			zipCode = 0+zipCode;
		}
		return zipCode;
	}
	
	/**
	 * @author HFARAZ
	 * Method to fetch the country code from location_keys.xlsx file
	 * @return String value: country code based on the row number provided in the parameters
	 * */
	public static String getCountryCode(int rowNo)
	{
		String countryCode = ExcelUtilities.getStringData(rowNo, 1)+"";
		return countryCode;
	}
	
	 /**
	   * @author HFARAZ
	   * Method to get the City Name from location_keys.xlsx file
	   * @return String value: city name based on the row no provide in the parameter
	   * **/
	  public static String getCityName(int rowNo)
	  {
		  String cityName = ExcelUtilities.getStringData(rowNo, 2);
		  return cityName;
	  }
	  
	  /**
	   * @author HFARAZ
	   * Method to get the State code from location_keys.xlsx file
	   * @return String value: state code based on the row no provide in the parameter
	   * **/
	  public static String getStateCode(int rowNo)
	  {
		  String stateCode = ExcelUtilities.getStringData(rowNo, 3);
		  return stateCode;
	  }
	  
	  /**
	   * @author HFARAZ
	   * Method to get the State Name from location_keys.xlsx file
	   * @return String value: state name based on the row no provide in the parameter
	   * **/
	  public static String getStateName(int rowNo)
	  {
		  String stateName = ExcelUtilities.getStringData(rowNo, 4);
		  return stateName;
	  }
	  
	  /**
	   * @author HFARAZ
	   * Method to get the State Name from location_keys.xlsx file
	   * @return String value: state name based on the row no provide in the parameter
	   * **/
	  public static String getRegionName(int rowNo)
	  {
		  String regionName = ExcelUtilities.getStringData(rowNo, 6);
		  return regionName;
	  }
	  
	  /**
	   * @author HFARAZ
	   * Method to get the country Name from location_keys.xlsx file
	   * @return String value: country name based on the row no provide in the parameter
	   * **/
	  public static String getCountryName(int rowNo)
	  {
		  String countryName = ExcelUtilities.getStringData(rowNo, 7);
		  return countryName;
	  }
	
	/**
	 * @author HFARAZ
	 * This method is to set the File path and to open the Excel file
	 * @param Provide the complete path of the excel file
	 * @param Provide the sheet name that you want the code to read
	 */
	public static void setExcelFile(String path,String sheetName)
	{
		try
		{
			// Open the Excel file
			FileInputStream excelFile = new FileInputStream(path);
			// Access the required test data sheet
			excelWBook = new XSSFWorkbook(excelFile);
			excelWSheet = excelWBook.getSheet(sheetName);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @author HFARAZ
	 * This method is to read the String data from the Excel cell
	 * @param rowNumber: Provide the row number
	 * @param columnNumber: Provide the column number
	 * **/

	public static String getStringData(int rowNum, int colNum)
	{
		try
		{
			cell = excelWSheet.getRow(rowNum).getCell(colNum);
			String cellData = cell.getStringCellValue();
			return cellData;

		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
			return"";
		}

	}
	
	/**
	 * @author HFARAZ
	 * This method is to read the numeric data from the Excel cell
	 * @param rowNumber: Provide the row number
	 * @param columnNumber: Provide the column number
	 * */
		public static int getNumericData(int rowNum, int colNum)
		{
				try
				{
					cell = excelWSheet.getRow(rowNum).getCell(colNum);
					int cellData = new Double(cell.getNumericCellValue()).intValue();
					System.out.println(cellData);
					return cellData;
				}
				catch (Exception e)
				{
					System.err.println(e.getMessage());
					return 0;
				}
		}
		
		/**
		 * @author HFARAZ
		 * Method to get the last row having data
		 * @return integer value: "the last row number having data"
		 * **/
		public static int getLastRow()
		{
			return excelWSheet.getLastRowNum();
		}
		
		/**
		 * @author HFARAZ
		 * Method to read the excel file
		 * **/
		public static void readExcelFile(String path, String sheetName)
		{
			ExcelUtilities.setExcelFile(System.getProperty("user.dir")+path, sheetName);
		}
		
		/**
		 * @author HFARAZ
		 * Method to get the row number of the location specified in the parameter
		 * @return Integer value: "row number" for the location having any alerts
		 * **/
		public static int getRowNumberForCity(String cityName)
		{
			readLocationKeysFile();
			
			for(rowNo=1;rowNo<=ExcelUtilities.getLastRow();rowNo++)
			{		
				if(getCityName(rowNo).equalsIgnoreCase(cityName))
						break;
			}
			System.out.println("City found at row number:---->"+rowNo);
			return rowNo;
		}
		
		/**
		 * @author HFARAZ
		 * This method deals with updating the excel sheet with any data
		 * based on the row number , column no provided in the parameters
		 * */
		public static void setCellData(String Result,  int RowNum, int ColNum)
		{
			try
			{
				row  = excelWSheet.getRow(RowNum);
				cell = row.getCell(ColNum, row.RETURN_BLANK_AS_NULL);

				if (cell == null) 
				{
					cell = row.createCell(ColNum);
					cell.setCellValue(Result);

				}
				else
				{
					cell.setCellValue(Result);
				}

		// Constant variables Test Data path and Test Data file name

				FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Qualitest\\Downloads\\location_keys.xlsx");
				excelWBook.write(fileOut);
				fileOut.flush();
				fileOut.close();

			}
			catch(Exception e)
			{
				System.err.println(e.getMessage());
			}

		}
	
}
