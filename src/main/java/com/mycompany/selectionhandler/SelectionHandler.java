/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.selectionhandler;

/**
 *
 * @author 79175
 */
public class SelectionHandler {

    public static void main(String[] args) {
        ManagementController managementController = new ManagementController();
        UserGUI gui = new UserGUI(managementController);
        gui.setVisible(true);
        gui.setSize(1100, 560);
        gui.setLocationRelativeTo(null);
        
    }
}
