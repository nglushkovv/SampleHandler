/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.selectionhandler.modules;

import java.util.List;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;


/**
 *
 * @author 79175
 */
public class ConfidenceIntervalModule {
    public double[] calculateConfidenceInterval(List<Double> data) {
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (double value : data) {
            stats.addValue(value);
        }
        
        double mean = stats.getMean();
        double stdDeviation = stats.getStandardDeviation() / Math.sqrt(stats.getN());
        NormalDistribution normalDistribution = new NormalDistribution();
        double z = normalDistribution.inverseCumulativeProbability(1 - (1 - 0.95) / 2);

        double lowerBound = mean - z * stdDeviation;
        double upperBound = mean + z * stdDeviation;

        return new double[]{lowerBound, upperBound};
    }
    
}
