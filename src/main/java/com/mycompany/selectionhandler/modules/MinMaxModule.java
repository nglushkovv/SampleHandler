/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.selectionhandler.modules;

import java.util.Collections;
import java.util.List;


/**
 *
 * @author 79175
 */
public class MinMaxModule {
    public Double[] calculateMinMax(List<Double> data) {
        return new Double[] {Collections.min(data),Collections.max(data)};
    }
}
