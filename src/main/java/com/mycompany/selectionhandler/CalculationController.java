/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.selectionhandler;

import com.mycompany.selectionhandler.modules.ArithmeticMeanModule;
import com.mycompany.selectionhandler.modules.ConfidenceIntervalModule;
import com.mycompany.selectionhandler.modules.CountModule;
import com.mycompany.selectionhandler.modules.CovarianceModule;
import com.mycompany.selectionhandler.modules.GeometricMeanModule;
import com.mycompany.selectionhandler.modules.MinMaxModule;
import com.mycompany.selectionhandler.modules.ScopeModule;
import com.mycompany.selectionhandler.modules.StandartDeviationModule;
import com.mycompany.selectionhandler.modules.VarianceEstimationModule;
import com.mycompany.selectionhandler.modules.VarianceModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author 79175
 */
public class CalculationController {
    private ArrayList<List<Double>> samples;
    private Boolean[] permissions;
    
    private ArrayList<List<String>> results = new ArrayList<>();
    private ArithmeticMeanModule arithmeticMeanModule;
    private GeometricMeanModule geometricMeanModule;
    private StandartDeviationModule standartDeviationModule;
    private ScopeModule scopeModule;
    private CovarianceModule covarianceModule;
    private CountModule countModule;
    private VarianceModule varianceModule;
    private ConfidenceIntervalModule confidenceIntervalModule;
    private VarianceEstimationModule varianceEstimationModule;
    private MinMaxModule minMaxModule;
    
    public ArrayList<List<String>> start(Boolean[] selectedPoints, ArrayList<Double[]> samples) {
        prepareSelections(samples);
        this.permissions = selectedPoints;
        execute();
        return results;
    }
    
    public CalculationController() {
        initModules();
    }
    
    private void initModules() {
        arithmeticMeanModule = new ArithmeticMeanModule();
        geometricMeanModule = new GeometricMeanModule();
        standartDeviationModule = new StandartDeviationModule();
        scopeModule = new ScopeModule();
        covarianceModule = new CovarianceModule();
        countModule = new CountModule();
        varianceModule = new VarianceModule();
        confidenceIntervalModule = new ConfidenceIntervalModule();
        varianceEstimationModule = new VarianceEstimationModule();
        minMaxModule = new MinMaxModule();
        
    }
    
    private void prepareSelections(ArrayList<Double[]> samples) {
       ArrayList<List<Double>> samplesNew = new ArrayList<>();
       results = new ArrayList<>();
       for(Double[] array: samples){
           ArrayList<Double> list = new ArrayList<>(Arrays.asList(array));
           list.removeAll(Collections.singleton(null));
           samplesNew.add(list);
           results.add(new ArrayList<>());
       }
       
       
       this.samples = samplesNew;
       
    }
    
    private void execute() {
        int counter = 0;
        for(List<Double> sample: samples){

            getGeometricMean(sample, counter);
            getArithmeticMean(sample, counter);
            getStandartDeviation(sample, counter);
            getScope(sample, counter);
            getCovariance(sample, counter);
            getCount(sample, counter);
            getVariance(sample, counter);
            getConfidenceInterval(sample, counter);
            getVarianceEstimation(sample, counter);
            getMinMax(sample, counter++);
        }
    }
       

    
    private void getGeometricMean(List<Double> sample, int counter) {
        if(permissions[0]) {
            String geometricMean = String.valueOf(geometricMeanModule
                    .calculateGeometricMean(sample));
            results.get(counter)
                    .add(geometricMean.replace("NaN", "Невозможно вычислить."));
            
        }
    }
    
    private void getArithmeticMean(List<Double> sample, int counter) {
        if(permissions[1]) {
            results.get(counter).add(String.valueOf(arithmeticMeanModule
                    .calculateArithmeticMean(sample)));
            
        }
    }
    
    private void getStandartDeviation(List<Double> sample, int counter) {
        if(permissions[2]){
            results.get(counter).add(String.valueOf(standartDeviationModule
                    .calculateStandartDeviation(sample)));
            
        }
    }
    
    private void getScope(List<Double> sample, int counter) {
        if(permissions[3]){
            results.get(counter).add(String.valueOf(scopeModule
                    .calculateScope(sample)));
        }
    }
    
    private void getCovariance(List<Double> sample, int counter) {
        if(permissions[4]){
            String covarianceCoeffs = "";
            int anotherCounter = 0;
            for(List<Double> anotherSample: samples){
                if(anotherCounter != counter){
                    covarianceCoeffs += "(" + String.valueOf(covarianceModule
                       .calculateCovariance(sample, anotherSample)) + ") ";
                }
                anotherCounter++;
            }
            results.get(counter).add(covarianceCoeffs);
            
        }
    }
    
    private void getCount(List<Double> sample, int counter) {
        if(permissions[5]){
            results.get(counter).add(String.valueOf(countModule
                    .calculateCount(sample)));
            
        }
    }
    
    private void getVariance(List<Double> sample, int counter) {
        if(permissions[6]) {
            results.get(counter).add(String.valueOf(varianceModule
                    .calculateVariance(sample)));
        }
    }
    
    private void getConfidenceInterval(List<Double> sample, int counter) {
        if(permissions[7]) {
            results.get(counter).add("["+String.valueOf(confidenceIntervalModule
                    .calculateConfidenceInterval(sample)[0]+"," + 
                    String.valueOf(confidenceIntervalModule
                    .calculateConfidenceInterval(sample)[1]))+"]");
            
        }
    }
    
    private void getVarianceEstimation(List<Double> sample, int counter) {
        if(permissions[8]) {
            results.get(counter).add(String.valueOf(varianceEstimationModule
                    .calculateVarianceEstimation(sample)));
        }
        
    }
    
    private void getMinMax(List<Double> sample, int counter) {
        if(permissions[9]) {
            results.get(counter).add(String.valueOf(minMaxModule
                    .calculateMinMax(sample)[0] + ", " + String.valueOf(minMaxModule
                    .calculateMinMax(sample)[1])));
        }
    }
    
}
