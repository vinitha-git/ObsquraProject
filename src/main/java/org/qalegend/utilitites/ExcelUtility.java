package org.qalegend.utilitites;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.qalegend.constants.Constants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelUtility {
    public static FileInputStream file;
    public static XSSFWorkbook wb;
    public static XSSFSheet sh;

    public static ArrayList<String> readData(String file_path, String sheet){
        try {
            String path = Constants.HOME_DIRECTORY+file_path;
            file = new FileInputStream(path);
        }
        catch(FileNotFoundException ex)
        {
            throw new RuntimeException(ex);
        }
        try {
            wb = new XSSFWorkbook(file);
        }
        catch( IOException ex)
        {
            throw new RuntimeException(ex);
        }
        sh= wb.getSheet(sheet);
        ArrayList<String>excelRows=new ArrayList<>();
        int rowCount=sh.getLastRowNum()- sh.getFirstRowNum();
        for(int i=0;i<=rowCount;i++){
            Row row=sh.getRow(i);
            int cellCount = row.getLastCellNum();
            for(int j=0;j<cellCount;j++){
                excelRows.add(row.getCell(j).getStringCellValue());
            }
        }
        return excelRows;
    }
}
