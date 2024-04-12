/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.selectionhandler.modules;
import java.util.List;
import org.apache.commons.math3.stat.correlation.Covariance;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

/**
 *
 * @author 79175
 */
public class CovarianceModule {
    public double calculateCovariance(List<Double> dataFirst, List<Double> dataSecond,
            ArithmeticMeanModule mean) {
        DescriptiveStatistics firstStat = new DescriptiveStatistics();
        DescriptiveStatistics secondStat = new DescriptiveStatistics();
        double covariance = 0;
        double firstMean = mean.calculateArithmeticMean(dataFirst);
        double secondMean = mean.calculateArithmeticMean(dataSecond);
        
        for(Double i: dataFirst) {
            for(Double j: dataSecond){
                covariance += (i - firstMean) * (j - secondMean); 
            }
        }
        covariance = covariance/(dataFirst.size() + dataSecond.size() - 1);
        return covariance;
       
    }
}
