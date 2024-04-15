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
        System.out.println("тут");
        return sheetNames;
    }
    
    public ArrayList<Double[]> readDataFromSheet(String sheetName) throws IOException {
        FileInputStream input = new FileInputStream(file);
        XSSFWorkbook excelBook = new XSSFWorkbook(input);
        XSSFSheet excelSheet = excelBook.getSheet(sheetName);
        XSSFRow row;
        
      
        ArrayList<Double[]> list = new ArrayList<>();
        Double[] columnX = new Double[excelSheet.getLastRowNum()];
        Double[] columnY = new Double[excelSheet.getLastRowNum()];
        Double[] columnZ = new Double[excelSheet.getLastRowNum()];
        
        for(int i=1; i < excelSheet.getLastRowNum() - 1; i++) {
            row = excelSheet.getRow(i);
            
            if(row.getCell(0) != null) columnX[i-1] = row.getCell(0).getNumericCellValue();
            if(row.getCell(1) != null) columnY[i-1] = row.getCell(1).getNumericCellValue();
            if(row.getCell(2) != null) columnZ[i-1] = row.getCell(2).getNumericCellValue();
            
        }
        if (columnX[0]!=null && columnY[0]!=null && columnZ[0]!=null){
            list.add(columnX);
            list.add(columnY);
            list.add(columnZ);
        }
        else{
            System.out.println(columnZ[0]);
            throw new NullPointerException();
        }
        input.close();
        return list;
    }
}
