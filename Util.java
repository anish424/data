package no.kantega.springandreact;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Util {

	public static ArrayList<STG_CCAR_STATISTICS> read(InputStream in) throws ParseException {
		ArrayList<STG_CCAR_STATISTICS> data = new ArrayList<>();
		
		{

			try {

				// FileInputStream excelFile = new FileInputStream(new
				// File(FILE_NAME));
				Workbook workbook = new XSSFWorkbook(in);
				Sheet datatypeSheet = workbook.getSheetAt(0);
				Iterator<Row> iterator = datatypeSheet.iterator();

				while (iterator.hasNext()) {
					ArrayList<String> row = new ArrayList<>();
					Row currentRow = iterator.next();
					Iterator<Cell> cellIterator = currentRow.iterator();

					while (cellIterator.hasNext()) {

						Cell currentCell = cellIterator.next();
						// getCellTypeEnum shown as deprecated for version 3.15
						// getCellTypeEnum ill be renamed to getCellType
						// starting from version 4.0
						if (currentCell.getCellTypeEnum() == CellType.STRING) {
							System.out.println("111");
							System.out.print(currentCell.getStringCellValue() + "--");
							row.add(currentCell.getStringCellValue());
						} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
							System.out.println("222");
							System.out.print(currentCell.getNumericCellValue() + "--");
							row.add("" + currentCell.getNumericCellValue());
						}
						

					}
					
					data.add(new STG_CCAR_STATISTICS(row));
					
				}
				System.out.println();
				workbook.close();

				/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		        Date date1 =  sdf.parse("2018-07-31");
		        Date date = new Date();
				
				if(date.after(date1))
					throw new RuntimeException("Wrong data");*/
				System.out.println("*****************");
				for(STG_CCAR_STATISTICS a: data)
				{
					System.out.println(a.PARTITION_KEY);
				}
				
				return data;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return data;
	}

}
