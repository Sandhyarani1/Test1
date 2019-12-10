package com.chameleon.utils.DataIOOperations;

import java.io.FileInputStream;
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
	public static Map<String, String> apiProperties = PropertiesManager.properties(APIConstants.API_PROPERTIES);
	
	/**
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
			System.out.println(cellData);
			return cellData;

		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
			return"";
		}

	}
	
	/**
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
	
}
