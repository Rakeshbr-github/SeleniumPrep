package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	
	
public static void writeProductsToExcel(List<String> products) throws IOException
 {
	
	XSSFWorkbook wb=new XSSFWorkbook();
	XSSFSheet sheet=wb.createSheet("Product Info");
	
//	Setting Column Values
	 XSSFRow header = sheet.createRow(0);
	header.createCell(0).setCellValue("Product Name");
	header.createCell(1).setCellValue("Product Price");

//	Writing one by one value
	for(int i=0;i<products.size();i++)
	{
		String[] data=products.get(i).split(":::::");
		XSSFRow setrowdata=sheet.createRow(i+1);
		setrowdata.createCell(0).setCellValue(data[0]);
		setrowdata.createCell(1).setCellValue(data[1]);;
	}


    FileOutputStream fos =
    		new FileOutputStream(System.getProperty("user.dir")
            + "\\src\\testresults\\LaptopProducts1.xlsx");
//            new FileOutputStream("LaptopProducts.xlsx");

    wb.write(fos);

    wb.close();
    fos.close();

    System.out.println("Excel file created successfully");
    System.out.println(System.getProperty("user.dir"));
		
		

 }


}
