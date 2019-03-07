package com.yw.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DttUtil {
	 public static Object[][] dtt(String filePath,int sheetId) throws IOException{
		 
	        File file = new File(filePath);
	        FileInputStream fis = new FileInputStream(file);
	 
	        XSSFWorkbook wb = new XSSFWorkbook(fis);
	        XSSFSheet sh = wb.getSheetAt(sheetId);
	        int numberrow = sh.getPhysicalNumberOfRows();
	        int numbercell = sh.getRow(0).getLastCellNum();
	 
	        Object[][] dttData = new Object[numberrow][numbercell];
	        for(int i=0;i<numberrow;i++){
	            if(null==sh.getRow(i)||"".equals(sh.getRow(i))){
	                continue;
	            }
	            for(int j=0;j<numbercell;j++) {
	                if(null==sh.getRow(i).getCell(j)||"".equals(sh.getRow(i).getCell(j))){
	                    continue;
	                }
	                XSSFCell cell = sh.getRow(i).getCell(j);
	                cell.setCellType(CellType.STRING);
	                dttData[i][j] = cell.getStringCellValue();
	            }
	        }
	 
	        return dttData;
	    }
}
