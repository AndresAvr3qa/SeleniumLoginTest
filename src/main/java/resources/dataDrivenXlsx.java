package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDrivenXlsx {
	
	//Excel file name: OrangeHRMDatasrc.xlsx
	
	public ArrayList<String> getData(String testData) throws IOException{
		
		ArrayList<String> al = new ArrayList<String>();		
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Selenium\\OrangeHRMLive\\src\\main\\java\\resources\\OrangeHRMDatasrc.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis); //Create an Excel workbook object
		
		int sheets = workbook.getNumberOfSheets();
		
		//Accessing and selecting the sheet > test data
		for(int i=0; i<sheets;i++) { //this iterates across all sheets
			if(workbook.getSheetName(i).equalsIgnoreCase("Hoja 1")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				
				//Sheet > Rows: moves between rows. 
				Iterator <Row> rows = sheet.iterator();
				Row firstRow = rows.next(); //places the ctrl in the 1st row
				Iterator<Cell> ce = firstRow.cellIterator();
				
				int k=0; //Cloumn index variable
				int coloumn =0;
				
				//Check rows text, and look for "UserID" Coloumn
				while(ce.hasNext()) {					
					Cell value = ce.next();
					if(value.getStringCellValue().equalsIgnoreCase(testData)) {						
						coloumn=k;
					}
				k++;
				}
				//System.out.println("Column is: " + coloumn);
				
				//Iterating between rows > moving through rows til value is found
				while(rows.hasNext()) {
					Row r = rows.next();
					
					if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase("Admin")) {  //get value at Coloumn index determinated above
						Iterator <Cell> cv = r.cellIterator(); //iterates through cells, on the specified row
						while(cv.hasNext()) {
							Cell c = cv.next();
							if(c.getCellType()==CellType.STRING) {
								al.add(c.getStringCellValue());
							}else {
								al.add(c.getStringCellValue());
							}
						}
					}
				}
				
			}
		}
		
		//Accessing rows in the selected sheet > Search for UserID and Scan the coloumn and look for "Admin" row
	
		return al;
		
	}	
	
}
