/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.selectionhandler.modules;

import java.util.List;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

/**
 *
 * @author 79175
 */
public class VarianceModule {
    
    public double calculateVariance(List<Double> data) {
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (double value : data) {
            stats.addValue(value);
        }
        double mean = stats.getMean();
        double standardDeviation = stats.getStandardDeviation();
        return (standardDeviation / mean) * 100;
        
    }
    
}
