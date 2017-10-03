package driverscript;


import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.bcel.classfile.Constant;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ExcelUtils {
	
	private static HSSFWorkbook ExcelWBook;
	private static HSSFCell Cell;
	private static HSSFRow Row;
	static HSSFSheet ExcelWSheet;
	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
	 
	public static void main(String args[]) throws Exception{
		
		ExcelUtils e=new ExcelUtils();
        //e.getCellData(1,12);
		//e.setCellData("Pass",1,16);
				
	}
	
    public static String getCellData(int RowNum, int ColNum) throws Exception{

			try{

				FileInputStream ExcelFile = new FileInputStream("D:\\Shruti Bagule\\Seleniumeclipse\\Selenium\\TrackWise_RICForm_Code\\Automation_TestCase_Data.xls");
				
				// Access the required test data sheet

				ExcelWBook = new HSSFWorkbook(ExcelFile);

				HSSFSheet ExcelWSheet = ExcelWBook.getSheet("Input");

			System.out.println("input");
  			String CellData = ExcelWSheet.getRow(RowNum).getCell(ColNum).getStringCellValue();
  			
  			//String CellData = Cell.getStringCellValue();
  			
  			
  			System.out.println("Using Excel-->"+CellData);

  			return CellData;

  			}catch (Exception e){

				return"";

  			}

    }
    
  //This method is to write in the Excel cell, Row num and Col num are the parameters

  	public static void setCellData(String Result,int RowNum,int ColNum,String sheetname) throws Exception	{

  			try{
  				
  			FileInputStream ExcelFile = new FileInputStream("D:\\Shruti Bagule\\Seleniumeclipse\\Selenium\\TrackWise_RICForm_Code\\Automation_TestCase_Data.xls");

  				// Access the required test data sheet

  				ExcelWBook = new HSSFWorkbook(ExcelFile);

  				ExcelWSheet = ExcelWBook.getSheet(sheetname);

    			Row  = ExcelWSheet.getRow(RowNum);

  			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

  			if (Cell == null) {

  				Cell = Row.createCell(ColNum);

  				Cell.setCellValue(Result);
  				
  				System.out.println("jbefore-"+Result);

  				} else {

  					Cell.setCellValue(Result);

  					System.out.println("jhhag--s-"+Result);
  				}

    // Constant variables Test Data path and Test Data file name

    				FileOutputStream fileOut = new FileOutputStream("D:\\Shruti Bagule\\Seleniumeclipse\\Selenium\\TrackWise_RICForm_Code\\Automation_TestCase_Data.xls");
    				ExcelWBook.write(fileOut);

    				fileOut.flush();

  					fileOut.close();

  				}catch(Exception e){

  					throw (e);

  			}

  		}
    
}