/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.selectionhandler.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author 79175
 */
public class InputReader {
    private File file;
    
    public void loadFile(File file) throws FileNotFoundException {
        this.file = file;
    }
    
    public ArrayList<String> getSheetNames() throws IOException {
        ArrayList<String> sheetNames = new ArrayList<>();
        FileInputStream input = new FileInputStream(file);
        XSSFWorkbook excelBook = new XSSFWorkbook(input);
        for(int i=0; i< excelBook.getNumberOfSheets();i++){
            sheetNames.add(excelBook.getSheetName(i));
        }
        input.close();
        return sheetNames;
    }
    
    public ArrayList<Double[]> readDataFromSheet(String sheetName) throws IOException {
        FileInputStream input = new FileInputStream(file);
        XSSFWorkbook excelBook = new XSSFWorkbook(input);
        XSSFSheet excelSheet = excelBook.getSheet(sheetName);
        XSSFRow row;
        
      
        ArrayList<Double[]> list = new ArrayList<>();
        
        for (int j=0; j < excelSheet.getRow(0).getLastCellNum(); j++){
            list.add(new Double[excelSheet.getLastRowNum()]);
        }
        
        for(int i=1; i < excelSheet.getLastRowNum() - 1; i++) {
            row = excelSheet.getRow(i);
            for (int j=0; j < excelSheet.getRow(i).getLastCellNum(); j++){
                if(row.getCell(j) != null) list.get(j)[i-1] = row.getCell(j).getNumericCellValue();
                if(list.get(j)[0] == null) throw new NullPointerException();
            }

        }
        

        input.close();
        return list;
    }
}
