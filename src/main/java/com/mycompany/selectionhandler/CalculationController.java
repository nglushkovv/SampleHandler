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
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author 79175
 */
public class CalculationController {
    private List<Double> selectionX;
    private List<Double> selectionY;
    private List<Double> selectionZ;
    private Boolean[] permissions;
    private List<String> resultX;
    private List<String> resultY;
    private List<String> resultZ;
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
    
    public ArrayList<List<String>> start(Boolean[] selectedPoints, ArrayList<Double[]> selections) {
        prepareSelections(selections);
        this.permissions = selectedPoints;
        execute();
        
        ArrayList<List<String>> response = new ArrayList<>();
        Collections.replaceAll(resultX, "NaN", "Невозможно вычислить.");
        Collections.replaceAll(resultY, "NaN", "Невозможно вычислить.");
        Collections.replaceAll(resultZ, "NaN", "Невозможно вычислить.");
        response.add(resultX);
        response.add(resultY);
        response.add(resultZ);
        

        return response;
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
    
    private void prepareSelections(ArrayList<Double[]> selections) {
       selectionX = new LinkedList<>(Arrays.asList(selections.get(0)));
       selectionY = new LinkedList<>(Arrays.asList(selections.get(1)));
       selectionZ = new LinkedList<>(Arrays.asList(selections.get(2)));
       
       resultX = new ArrayList<>();
       resultY = new ArrayList<>();
       resultZ = new ArrayList<>();
       
      
       if (selectionX.contains(null)) selectionX
            .removeAll(Collections.singleton(null));
       if (selectionY.contains(null)) selectionY
            .removeAll(Collections.singleton(null));
       if (selectionZ.contains(null)) selectionZ
            .removeAll(Collections.singleton(null));
       
    }
    
    private void execute() {
        getGeometricMean();
        getArithmeticMean();
        getStandartDeviation();
        getScope();
        getCovariance();
        getCount();
        getVariance();
        getConfidenceInterval();
        getVarianceEstimation();
        getMinMax();
    }

    
    private void getGeometricMean() {
        if(permissions[0]) {
            resultX.add(String.valueOf(geometricMeanModule
                    .calculateGeometricMean(selectionX)));
            resultY.add(String.valueOf(geometricMeanModule
                    .calculateGeometricMean(selectionY)));
            resultZ.add(String.valueOf(geometricMeanModule
                    .calculateGeometricMean(selectionZ)));
        }
    }
    
    private void getArithmeticMean() {
        if(permissions[1]) {
            String mean;
            mean = String.valueOf(arithmeticMeanModule
                    .calculateArithmeticMean(selectionX));
            System.out.println(String.valueOf(arithmeticMeanModule
                    .calculateArithmeticMean(selectionX)));
            resultX.add(mean);
            resultY.add(String.valueOf(arithmeticMeanModule
                    .calculateArithmeticMean(selectionY)));
            resultZ.add(String.valueOf(arithmeticMeanModule
                    .calculateArithmeticMean(selectionZ)));
        }
    }
    
    private void getStandartDeviation() {
        if(permissions[2]){
            resultX.add(String.valueOf(standartDeviationModule
                    .calculateStandartDeviation(selectionX)));
            resultY.add(String.valueOf(standartDeviationModule
                    .calculateStandartDeviation(selectionY)));
            resultZ.add(String.valueOf(standartDeviationModule
                    .calculateStandartDeviation(selectionZ)));
        }
    }
    
    private void getScope() {
        if(permissions[3]){
            resultX.add(String.valueOf(scopeModule
                    .calculateScope(selectionX)));
            resultY.add(String.valueOf(scopeModule
                    .calculateScope(selectionY)));
            resultZ.add(String.valueOf(scopeModule
                    .calculateScope(selectionZ)));
        }
    }
    
    private void getCovariance() {
        if(permissions[4]){
            String covarianceCoeffs =
                String.valueOf(covarianceModule
                       .calculateCovariance(selectionX, selectionY, arithmeticMeanModule)) + ","+
                String.valueOf(covarianceModule
                       .calculateCovariance(selectionX, selectionZ, arithmeticMeanModule)) + ","+
                String.valueOf(covarianceModule
                       .calculateCovariance(selectionY, selectionZ, arithmeticMeanModule));
            resultX.add(covarianceCoeffs);
            resultY.add(covarianceCoeffs);
            resultZ.add(covarianceCoeffs);
        }
    }
    
    private void getCount() {
        if(permissions[5]){
            resultX.add(String.valueOf(countModule
                    .calculateCount(selectionX)));
            resultY.add(String.valueOf(countModule
                    .calculateCount(selectionY)));
            resultZ.add(String.valueOf(countModule
                    .calculateCount(selectionZ)));
        }
    }
    
    private void getVariance() {
        if(permissions[6]) {
            resultX.add(String.valueOf(varianceModule
                    .calculateVariance(selectionX)));
            resultY.add(String.valueOf(varianceModule
                    .calculateVariance(selectionY)));
            resultZ.add(String.valueOf(varianceModule
                    .calculateVariance(selectionZ)));
        }
    }
    
    private void getConfidenceInterval() {
        if(permissions[7]) {
            resultX.add("["+String.valueOf(confidenceIntervalModule
                    .calculateConfidenceInterval(selectionX)[0]+"," + 
                    String.valueOf(confidenceIntervalModule
                    .calculateConfidenceInterval(selectionX)[1]))+"]");
            resultY.add("["+String.valueOf(confidenceIntervalModule
                    .calculateConfidenceInterval(selectionY)[0]+"," + 
                    String.valueOf(confidenceIntervalModule
                    .calculateConfidenceInterval(selectionY)[1]))+"]");
            resultZ.add("["+String.valueOf(confidenceIntervalModule
                    .calculateConfidenceInterval(selectionZ)[0]+"," + 
                    String.valueOf(confidenceIntervalModule
                    .calculateConfidenceInterval(selectionZ)[1]))+"]");
        }
    }
    
    private void getVarianceEstimation() {
        if(permissions[8]) {
            resultX.add(String.valueOf(varianceEstimationModule
                    .calculateVarianceEstimation(selectionX)));
            resultY.add(String.valueOf(varianceEstimationModule
                    .calculateVarianceEstimation(selectionY)));
            resultZ.add(String.valueOf(varianceEstimationModule
                    .calculateVarianceEstimation(selectionZ)));
        }
        
    }
    
    private void getMinMax() {
        if(permissions[9]) {
            resultX.add(String.valueOf(minMaxModule
                    .calculateMinMax(selectionX)[0] + ", " + String.valueOf(minMaxModule
                    .calculateMinMax(selectionX)[1])));
            resultY.add(String.valueOf(minMaxModule
                    .calculateMinMax(selectionY)[0] + ", " + String.valueOf(minMaxModule
                    .calculateMinMax(selectionY)[1])));
            resultZ.add(String.valueOf(minMaxModule
                    .calculateMinMax(selectionZ)[0] + ", " + String.valueOf(minMaxModule
                    .calculateMinMax(selectionZ)[1])));
        }
    }
    
}
