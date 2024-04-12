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
public class StandartDeviationModule {
    public double calculateStandartDeviation(List<Double> data){
        DescriptiveStatistics statistics = new DescriptiveStatistics();
        for(Double d: data) {
            statistics.addValue(d);
        }
        
        return statistics.getStandardDeviation();
    }
}
