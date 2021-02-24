package Helper;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;


public class CellValues {

    int rows_total;
    DataRead dataSheet = null;
    DataRead datasheet1 = null;
    //List<DataRead> dataSheetList = new ArrayList<DataRead>();
    Row row = null;
    XSSFCell cell = null;

    ///---------------------UBL Credential Cell Values---------------//
    public List<DataRead> LoginData(String filePath, String sheetName) throws Exception {
        List<DataRead> dataSheetList = new ArrayList<DataRead>();
        FileInputStream inputStream = new FileInputStream(filePath);
        @SuppressWarnings("resource")
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        rows_total = sheet.getLastRowNum();
        for (int i = 1; i <= rows_total; i++) {
            row = sheet.getRow(i);
            dataSheet = new DataRead();
            cell = (XSSFCell) row.getCell(0);
            cell.setCellType(CellType.STRING);
            dataSheet.setUserName(cell.getStringCellValue());

            cell = (XSSFCell) row.getCell(1);cell.setCellType(CellType.STRING);dataSheet.setPassword(cell.getStringCellValue());
//            cell = (XSSFCell) row.getCell(2);cell.setCellType(CellType.STRING);dataSheet.setNickName(cell.getStringCellValue());
//            cell = (XSSFCell) row.getCell(3);cell.setCellType(CellType.STRING);dataSheet.setBalance(cell.getStringCellValue());
//            cell = (XSSFCell) row.getCell(4);cell.setCellType(CellType.STRING);dataSheet.setCNIC(cell.getStringCellValue());
//            cell = (XSSFCell) row.getCell(5);cell.setCellType(CellType.STRING);dataSheet.setNumber(cell.getStringCellValue());
//            cell = (XSSFCell) row.getCell(6);cell.setCellType(CellType.STRING);dataSheet.setEmail(cell.getStringCellValue());
            dataSheetList.add(dataSheet);
        }
        return dataSheetList;
    }
    public List<DataRead> PassInfo (String filePath,String sheetName) throws Exception{
        DataRead datasheet1 = null;
        List<DataRead> dataSheetList = new ArrayList<DataRead>();
        FileInputStream inputStream = new FileInputStream (filePath);
        @SuppressWarnings("resource")
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        rows_total = sheet.getLastRowNum();
        for (int i=1;i<=rows_total;i++){
            row = sheet.getRow(i);
            dataSheet = new DataRead();
            cell = (XSSFCell) row.getCell(0);cell.setCellType(CellType.STRING);datasheet1.setPort(cell.getStringCellValue());
            cell = (XSSFCell) row.getCell(1);cell.setCellType(CellType.STRING);datasheet1.setEntryGate(cell.getStringCellValue());
//            cell = (XSSFCell) row.getCell(2);cell.setCellType(CellType.STRING);dataSheet.setPasstype(cell.getStringCellValue());
//            cell = (XSSFCell) row.getCell(3);cell.setCellType(CellType.STRING);dataSheet.setPassDuration(cell.getStringCellValue());

//            cell = (XSSFCell) row.getCell(4);cell.setCellType(CellType.STRING);dataSheet.setVisitReason(cell.getStringCellValue());
//            cell = (XSSFCell) row.getCell(5);cell.setCellType(CellType.STRING);dataSheet.setDateVisit(cell.getStringCellValue());
//            cell = (XSSFCell) row.getCell(6);cell.setCellType(CellType.STRING);dataSheet.setTitle(cell.getStringCellValue());
//            cell = (XSSFCell) row.getCell(7);cell.setCellType(CellType.STRING);dataSheet.setFirstName(cell.getStringCellValue());
//            cell = (XSSFCell) row.getCell(8);cell.setCellType(CellType.STRING);dataSheet.setLastName(cell.getStringCellValue());
//            cell = (XSSFCell) row.getCell(9);cell.setCellType(CellType.STRING);dataSheet.setNationality(cell.getStringCellValue());
//            cell = (XSSFCell) row.getCell(10);cell.setCellType(CellType.STRING);dataSheet.setMobile(cell.getStringCellValue());
//            cell = (XSSFCell) row.getCell(11);cell.setCellType(CellType.STRING);dataSheet.setVisaType(cell.getStringCellValue());
//            cell = (XSSFCell) row.getCell(12);cell.setCellType(CellType.STRING);dataSheet.setCompanyName(cell.getStringCellValue());
//            cell = (XSSFCell) row.getCell(13);cell.setCellType(CellType.STRING);dataSheet.setDesignation(cell.getStringCellValue());
//            cell = (XSSFCell) row.getCell(14);cell.setCellType(CellType.STRING);dataSheet.setEmail(cell.getStringCellValue());
//            cell = (XSSFCell) row.getCell(15);cell.setCellType(CellType.STRING);dataSheet.setVehicleNumber(cell.getStringCellValue());
//            cell = (XSSFCell) row.getCell(16);cell.setCellType(CellType.STRING);dataSheet.setCompanyAddress(cell.getStringCellValue());
//            cell = (XSSFCell) row.getCell(17);cell.setCellType(CellType.STRING);dataSheet.setEmiratesId(cell.getStringCellValue());
//            cell = (XSSFCell) row.getCell(18);cell.setCellType(CellType.STRING);dataSheet.setHostCompany(cell.getStringCellValue());
//            cell = (XSSFCell) row.getCell(19);cell.setCellType(CellType.STRING);dataSheet.setPersonName(cell.getStringCellValue());

            dataSheetList.add(dataSheet);
        }
        return dataSheetList;
    }
}