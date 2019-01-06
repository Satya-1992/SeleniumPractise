import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import static org.apache.poi.ss.usermodel.CellType.*;

public class ReadingExcelData {

  public static void main(String[] args) throws Exception {


    String filepath = System.getProperty("user.dir") + "//Excelfile//TestData.xlsx";
    File path = new File(filepath);
    FileInputStream fis = new FileInputStream(path);
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    XSSFSheet sheet = wb.getSheetAt(0);
    int rowCount = sheet.getLastRowNum();
    int colCount = sheet.getRow(0).getLastCellNum();

    XSSFRow rowNum = sheet.getRow(rowCount);
    //ArrayList<Object> getCellValue1= new ArrayList<Object>();
    Object[][] getCellValue = new Object[rowCount][colCount];

    //System.out.println();
    for (int row = 1; row < rowCount; row++)
      for (int col = 0; col < colCount; col++)
      {
        XSSFCell cell = rowNum.getCell(col);

        if (cell.getCellTypeEnum() == STRING)
          getCellValue[row][col] = sheet.getRow(row).getCell(col).getStringCellValue();
        else if (cell.getCellTypeEnum() == NUMERIC)
        {
          Double data = sheet.getRow(row).getCell(col).getNumericCellValue();
          getCellValue[row][col] = data.intValue();

        }
        else if (cell.getCellTypeEnum() == BLANK) getCellValue[row][col] = null;

      }

  }


}

