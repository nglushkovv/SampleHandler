/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.selectionhandler.modules;
import java.util.List;
import org.apache.commons.math3.stat.correlation.Covariance;

/**
 *
 * @author 79175
 */
public class CovarianceModule {
    public double calculateCovariance(List<Double> dataFirst, List<Double> dataSecond) {
        double[] firstArray = new double[dataFirst.size()];
        double[] secondArray = new double[dataSecond.size()];
        int maxSize = dataFirst.size();
        if(dataSecond.size() > maxSize) maxSize = dataSecond.size();
        Covariance covariance = new Covariance();
        

        for(int i=0; i < maxSize; i++) {
            if (i < dataFirst.size()){
                firstArray[i] = dataFirst.get(i);
            }
            if (i < dataSecond.size()) {
                secondArray[i] = dataSecond.get(i);
            }
        }
        
        return covariance.covariance(firstArray, secondArray);
        
        
        
       
       
    }
}
