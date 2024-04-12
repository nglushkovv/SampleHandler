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
public class ScopeModule {
    
    public double calculateScope(List<Double> data) {
        return (double) (Collections.max(data) - Collections.min(data));
    }
    
}
