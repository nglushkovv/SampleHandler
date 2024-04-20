/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.selectionhandler;

import com.mycompany.selectionhandler.data.OutputWriter;
import com.mycompany.selectionhandler.data.InputReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 79175
 */
public class ManagementController {
    private final InputReader inputReader = new InputReader();
    private final OutputWriter outputWriter = new OutputWriter();
    private final CalculationController calcController = new CalculationController();
    private ArrayList<Double[]> sample = new ArrayList<>();
    private ArrayList<List<String>> result;
    
    public InputReader getInputReader() {
        return inputReader;
    }
    
    public OutputWriter getOutputWriter() {
        return outputWriter;
    }
    
    public void writeToFile(File file, Boolean[] selectedPoints) throws IOException {
        outputWriter.saveToFile(file, result, selectedPoints);
    }
    
    public CalculationController getCalculationController() {
        return calcController;
    }
    
    public void setSample(ArrayList<Double[]> sample) {
        this.sample = sample;
    }
    
    public ArrayList<List<String>> startCalculation(Boolean[] selectedPoints){
        result = calcController.start(selectedPoints, this.sample);
        return result;
    }
    
    
}
