/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.selectionhandler.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author 79175
 */
public class OutputWriter {
    
    public void saveToFile(File file, ArrayList<List<String>> result, Boolean[] selectedPoints)
            throws FileNotFoundException, IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Результаты расчёта");
        XSSFRow row;
        XSSFCell cell;
        ArrayList<String> showedIndicators = selectIndicators(selectedPoints);

        
        for(int i=0; i < showedIndicators.size(); i++) {
            row = sheet.createRow(i);
            
            cell = row.createCell(0);
            cell.setCellValue(showedIndicators.get(i));
            for(int j=0; j < result.size(); j++){
                cell = row.createCell(j+1);
                cell.setCellValue(result.get(j).get(i));
                sheet.autoSizeColumn(j);
            }
            
        }
        
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        
    }
    
    public ArrayList<String> selectIndicators(Boolean[] selectedPoints) {
        String[] indicatorsInfo =
            {"Cреднее геометрическое:",
             "Среднее арифметическое:",
             "Оценка стандартного отклонения:",
             "Размах:",
             "Коэффициенты ковариации (слева направо):",
             "Количество элементов",
             "Коэффициент вариации",
             "Доверительный интервал:",
             "Оценка дисперии:",
             "Минимум и максимум:"};
        
        ArrayList<String> showedIndicators= new ArrayList<>();
        int counter = 0;
        for(Boolean permission: selectedPoints) {
            if (permission) {
                    showedIndicators.add(indicatorsInfo[counter]);
                }
            counter += 1;    
            }
        
        return showedIndicators;
    }
    
}
