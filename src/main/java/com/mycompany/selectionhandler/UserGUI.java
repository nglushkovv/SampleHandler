/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.selectionhandler;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 79175
 */
public class UserGUI extends javax.swing.JFrame {
    private ManagementController managementController;
    private Boolean entryRestriction;
    private int instructionPageCounter = 0;
    private ImageIcon tableImage;
    private ImageIcon loadFileImage;
    private ImageIcon configurationImage;
    private ImageIcon saveImage;
    private ImageIcon logo;
    private Boolean[] selectedPoints;
    

    /**
     * Creates new form UserGUI
     * @param managementController
     */
    public UserGUI(ManagementController managementController) {
        this.managementController = managementController;
        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | 
                InstantiationException | UnsupportedLookAndFeelException e) {
        }
        
        initComponents();
        ComponentsConfiguration();
    }
    
    private void ComponentsConfiguration() {
        sheetNamesComboBox.setVisible(false);
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel files", "xlsx", "xls");
        
        
        try {
            File currentDirectory = new File(getClass().getProtectionDomain()
                    .getCodeSource().getLocation().toURI().getPath()).getParentFile();
            fileChooser = new JFileChooser(currentDirectory);
            fileSaver = new JFileChooser(currentDirectory);
            fileChooser.setFileFilter(filter);
            fileSaver.setFileFilter(filter);
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileSaver.setAcceptAllFileFilterUsed(false);
            fileSaver.setDialogType(JFileChooser.SAVE_DIALOG);
        } catch (URISyntaxException ex) {
            Logger.getLogger(UserGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        configureCheckBoxes(false);
        startCalculationButton.setVisible(false);
        saveAsButton.setVisible(false);
        
        samplesTable.setVisible(false);
        
       URL inputStream = this.getClass().getResource("/loadScreen.png");
       loadFileImage = new ImageIcon(inputStream);
       inputStream = this.getClass().getResource("/configurationScreen.png");
       configurationImage = new ImageIcon(inputStream);
       inputStream = this.getClass().getResource("/saveScreen.png");
       saveImage = new ImageIcon(inputStream);
       inputStream = this.getClass().getResource("/tableScreen.png");
       tableImage = new ImageIcon(inputStream);
       inputStream = this.getClass().getResource("/logo.png");
       logo = new ImageIcon(inputStream);
       instructionDialog.setIconImage(logo.getImage());
       this.setIconImage(logo.getImage());
       
       
        
    }
    
    private void configureCheckBoxes(Boolean bool){
        arifmeticMeanCheckBox.setVisible(bool);
        geometricMeanCheckBox.setVisible(bool);
        confidenceCheckBox.setVisible(bool);
        countCheckBox.setVisible(bool);
        deviationCheckBox.setVisible(bool);
        dispersionCheckBox.setVisible(bool);
        variationCheckBox.setVisible(bool);
        scopeCheckBox.setVisible(bool);
        covarianceCheckBox.setVisible(bool);
        maxMinsCheckBox.setVisible(bool);
        

    }
    
    private void showReadingErrorMessage() {
        JOptionPane.showMessageDialog(rootPane, "Ошибка чтения."
                + " Убедитесь, что выборка сформирована правильно.",
                "Ошибка чтения", JOptionPane.ERROR_MESSAGE);
        
    }
    
    
    private void configureTable() throws IOException {
        DefaultTableModel model = new DefaultTableModel();
        entryRestriction = false;
        String sheetName = sheetNamesComboBox.getSelectedItem().toString();
        try{
            
            ArrayList<Double[]> dataList = managementController.getInputReader()
                .readDataFromSheet(sheetName);
            managementController.setSample(dataList);
            String[] columnNames = new String[] {"X", "Y", "Z", "A", "B", "С", "D", "E", "F"};
            for(int i=0; i<dataList.size(); i++) {
                if (i >= columnNames.length-1){
                    model.addColumn("F"+String.valueOf(i - (columnNames.length-1)), dataList.get(i));
                }
                else{
                    model.addColumn(columnNames[i], dataList.get(i));
                }
                
            }


            samplesTable.setModel(model);
            samplesTable.setVisible(true);
        } catch(NullPointerException | IllegalStateException e) {
            showReadingErrorMessage();
            entryRestriction = true;
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        instructionDialog = new javax.swing.JDialog();
        instructionLabel = new javax.swing.JLabel();
        instructionImage = new javax.swing.JLabel();
        nextStepButton = new javax.swing.JButton();
        fileSaver = new javax.swing.JFileChooser();
        mainPanel = new javax.swing.JPanel();
        introductionLabel = new javax.swing.JLabel();
        loadFileButton = new javax.swing.JButton();
        fileStatusLabel = new java.awt.Label();
        sheetNamesComboBox = new javax.swing.JComboBox<>();
        geometricMeanCheckBox = new javax.swing.JCheckBox();
        arifmeticMeanCheckBox = new javax.swing.JCheckBox();
        deviationCheckBox = new javax.swing.JCheckBox();
        scopeCheckBox = new javax.swing.JCheckBox();
        covarianceCheckBox = new javax.swing.JCheckBox();
        countCheckBox = new javax.swing.JCheckBox();
        variationCheckBox = new javax.swing.JCheckBox();
        confidenceCheckBox = new javax.swing.JCheckBox();
        dispersionCheckBox = new javax.swing.JCheckBox();
        maxMinsCheckBox = new javax.swing.JCheckBox();
        startCalculationButton = new javax.swing.JButton();
        saveAsButton = new javax.swing.JButton();
        scrollPaneForFirstTable = new javax.swing.JScrollPane();
        samplesTable = new javax.swing.JTable();
        scrollPaneForSecondTable = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        menuBar = new javax.swing.JMenuBar();
        mainMenu = new javax.swing.JMenu();
        loadFileItem = new javax.swing.JMenuItem();
        showInstructionItem = new javax.swing.JMenuItem();

        instructionDialog.setIconImage(null);
        instructionDialog.setIconImages(null);
        instructionDialog.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        instructionLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        instructionLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        instructionLabel.setText("1. Подготовьте Excel таблицу с выборками. ");
        instructionDialog.getContentPane().add(instructionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 650, 40));

        instructionImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tableScreen.png"))); // NOI18N
        instructionDialog.getContentPane().add(instructionImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 620, 330));

        nextStepButton.setBackground(new java.awt.Color(255, 255, 255));
        nextStepButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        nextStepButton.setText("Далее");
        nextStepButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextStepButtonActionPerformed(evt);
            }
        });
        instructionDialog.getContentPane().add(nextStepButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 140, 40));

        fileSaver.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        introductionLabel.setBackground(new java.awt.Color(255, 255, 255));
        introductionLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        introductionLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        introductionLabel.setText("Sample Handler");
        mainPanel.add(introductionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 280, 40));

        loadFileButton.setBackground(new java.awt.Color(255, 255, 255));
        loadFileButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        loadFileButton.setForeground(new java.awt.Color(0, 0, 0));
        loadFileButton.setText("Загрузить файл");
        loadFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFileButtonActionPerformed(evt);
            }
        });
        mainPanel.add(loadFileButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 170, 30));

        fileStatusLabel.setAlignment(java.awt.Label.RIGHT);
        fileStatusLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        fileStatusLabel.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        fileStatusLabel.setText("Файл не загружен.");
        mainPanel.add(fileStatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 700, 30));

        sheetNamesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sheetNamesComboBoxActionPerformed(evt);
            }
        });
        mainPanel.add(sheetNamesComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 170, -1));

        geometricMeanCheckBox.setSelected(true);
        geometricMeanCheckBox.setText("Среднее геометрическое");
        geometricMeanCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geometricMeanCheckBoxActionPerformed(evt);
            }
        });
        mainPanel.add(geometricMeanCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        arifmeticMeanCheckBox.setSelected(true);
        arifmeticMeanCheckBox.setText("Среднее арифметическое");
        arifmeticMeanCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arifmeticMeanCheckBoxActionPerformed(evt);
            }
        });
        mainPanel.add(arifmeticMeanCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        deviationCheckBox.setSelected(true);
        deviationCheckBox.setText("Оценка стандартного отклонения");
        mainPanel.add(deviationCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        scopeCheckBox.setSelected(true);
        scopeCheckBox.setText("Размах");
        mainPanel.add(scopeCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        covarianceCheckBox.setSelected(true);
        covarianceCheckBox.setText("Коэффициенты ковариации");
        mainPanel.add(covarianceCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        countCheckBox.setSelected(true);
        countCheckBox.setText("Количество элементов");
        mainPanel.add(countCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        variationCheckBox.setSelected(true);
        variationCheckBox.setText("Коэффициент вариации");
        mainPanel.add(variationCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        confidenceCheckBox.setSelected(true);
        confidenceCheckBox.setText("Доверительный интервал для мат. ожидания");
        mainPanel.add(confidenceCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        dispersionCheckBox.setSelected(true);
        dispersionCheckBox.setText("Оценка дисперсии");
        mainPanel.add(dispersionCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        maxMinsCheckBox.setSelected(true);
        maxMinsCheckBox.setText("Максимумы и минимумы");
        maxMinsCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxMinsCheckBoxActionPerformed(evt);
            }
        });
        mainPanel.add(maxMinsCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        startCalculationButton.setText("Расчёт показателей");
        startCalculationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startCalculationButtonActionPerformed(evt);
            }
        });
        mainPanel.add(startCalculationButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 150, -1));

        saveAsButton.setText("Сохранить в файл...");
        saveAsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsButtonActionPerformed(evt);
            }
        });
        mainPanel.add(saveAsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 150, -1));

        samplesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollPaneForFirstTable.setViewportView(samplesTable);

        mainPanel.add(scrollPaneForFirstTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 740, 190));

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollPaneForSecondTable.setViewportView(resultTable);

        mainPanel.add(scrollPaneForSecondTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 740, 220));

        mainMenu.setText("Файл");

        loadFileItem.setText("Загрузить файл (Excel)");
        loadFileItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFileItemActionPerformed(evt);
            }
        });
        mainMenu.add(loadFileItem);

        showInstructionItem.setText("Инструкция");
        showInstructionItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showInstructionItemActionPerformed(evt);
            }
        });
        mainMenu.add(showInstructionItem);

        menuBar.add(mainMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1033, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadFileItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadFileItemActionPerformed
        showFileChooser();
    }//GEN-LAST:event_loadFileItemActionPerformed

    private void showInstructionItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showInstructionItemActionPerformed
       showInstructionDialog();
    }//GEN-LAST:event_showInstructionItemActionPerformed
    
    private void showInstructionDialog() {
        instructionDialog.setSize(600,500);
        instructionDialog.setVisible(true);
        instructionDialog.setLocationRelativeTo(null);
        instructionPageCounter = 1;
    }
    
    private void showFileChooser() {
        int returnValue = fileChooser.showOpenDialog(null);
        
        if (returnValue == JFileChooser.APPROVE_OPTION) {
              File selectedFile = fileChooser.getSelectedFile();
            try {
                managementController.getInputReader().loadFile(selectedFile);
                entryRestriction = false;
                fileStatusLabel.setText(selectedFile.getName());
                ArrayList<String> namesList = managementController
                        .getInputReader().getSheetNames();
                sheetNamesComboBox.setModel(new DefaultComboBoxModel<>(namesList.toArray(
                        new String[namesList.size()])));
                configureCheckBoxes(true);
                startCalculationButton.setVisible(true);
                sheetNamesComboBox.setVisible(true);
                configureTable();
                
                
            } catch (FileNotFoundException ex) {
            } catch (IOException ex) {
            }
              
              
        }
        
    }
    
    private void loadFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadFileButtonActionPerformed
        showFileChooser();
        
    }//GEN-LAST:event_loadFileButtonActionPerformed

    private void sheetNamesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sheetNamesComboBoxActionPerformed
        try {
            configureTable();
            saveAsButton.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(UserGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sheetNamesComboBoxActionPerformed

    private void geometricMeanCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geometricMeanCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_geometricMeanCheckBoxActionPerformed

    private void arifmeticMeanCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arifmeticMeanCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arifmeticMeanCheckBoxActionPerformed

    private void maxMinsCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxMinsCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maxMinsCheckBoxActionPerformed

    private ArrayList<String> getShowedIndicators(Boolean[] selectedPoints) {
        String[] indicatorsInfo =
            {"Cреднее геометрическое:",
             "Среднее арифметическое:",
             "Оценка стандартного отклонения:",
             "Размах:",
             "Коэффициенты ковариации:",
             "Количество элементов",
             "Коэффициент вариации",
             "Доверительный интервал:",
             "Оценка дисперии:",
             "Минимум и максимум:"};
        
        ArrayList<String> showedIndicators= new ArrayList<>();
        
        int counter = 0;
        for(Boolean permission: selectedPoints) {
            if (permission) {
                    showedIndicators.add(indicatorsInfo[counter]);      
                }
            counter += 1;
            }
        return showedIndicators;
        
    }
    private void updateTableWithResult(ArrayList<List<String>> result, Boolean[] selectedPoints) {
        
        ArrayList<String> showedIndicators = getShowedIndicators(selectedPoints);
        DefaultTableModel resultModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
        };
        };
        
        String[] columnNames = new String[] {"X", "Y", "Z", "A", "B", "С", "D", "E", "F"};
        
        
        int counter = 0;
        resultModel.addColumn("Результаты", showedIndicators.toArray());
        for(List<String> res: result){
            if(counter >= columnNames.length-1){
                resultModel.addColumn("F" + String.valueOf((counter++) - columnNames.length+1),
                        res.toArray());
            }
            else{
                resultModel.addColumn(columnNames[counter++], res.toArray());
            }
            
        }
        
        resultTable.setModel(resultModel);
        
        
    }
    private void startCalculationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startCalculationButtonActionPerformed
        selectedPoints = new Boolean[] {
                geometricMeanCheckBox.isSelected(),
                arifmeticMeanCheckBox.isSelected(),
                deviationCheckBox.isSelected(),
                scopeCheckBox.isSelected(),
                covarianceCheckBox.isSelected(),
                countCheckBox.isSelected(),
                variationCheckBox.isSelected(),
                confidenceCheckBox.isSelected(),
                dispersionCheckBox.isSelected(),
                maxMinsCheckBox.isSelected()
                };
        
        if (!entryRestriction) {
            try{
                ArrayList<List<String>> result = managementController.startCalculation(selectedPoints);
                updateTableWithResult(result, selectedPoints);
                saveAsButton.setVisible(true);
            } catch (Exception ex){
                showErrorCalculationMessage();
                saveAsButton.setVisible(false);
            }
            
        }
        else{
            showErrorCalculationMessage();
            
        }
        
        
    }//GEN-LAST:event_startCalculationButtonActionPerformed

    private void nextStepButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextStepButtonActionPerformed
        switch(instructionPageCounter) {
            case 0:
                instructionImage.setIcon(tableImage);
                instructionLabel.setText("1. Подготовьте Excel таблицу с выборками. ");
                break;
            case 1:
                instructionImage.setIcon(loadFileImage);
                instructionLabel.setText("2. Нажмите кнопку загрузить файл и выберите Ваш файл.");
                break;
            case 2:
                instructionImage.setIcon(configurationImage);
                instructionLabel.setText("<html>3. Выберите лист Excel, необходимые показатели<br> и нажмите "
                        + "кнопку 'Расчёт показателей'.<html>");
                break;
            case 3:
                instructionImage.setIcon(saveImage);
                instructionLabel.setText("<html>4. Нажмите кнопку 'Сохранить как...'<br>. "
                        + "Введите название и выберите где сохранить файл.<html>");
                instructionPageCounter = -1;
                break;
            
                
        }
        instructionPageCounter++;
    }//GEN-LAST:event_nextStepButtonActionPerformed

    private void saveAsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsButtonActionPerformed
        int returnValue = fileSaver.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileSaver.getSelectedFile();
            if (!fileToSave.getAbsolutePath().endsWith(".xlsx")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".xlsx");
           }
            try {
                managementController.writeToFile(fileToSave, selectedPoints);
            } catch (IOException ex) {
                Logger.getLogger(UserGUI.class.getName()).log(Level.SEVERE, null, ex);
                showErrorWritingMessage();
            }
        }
        
        
    }//GEN-LAST:event_saveAsButtonActionPerformed
    
    private void showErrorWritingMessage() {
        JOptionPane.showMessageDialog(rootPane, "Ошибка записи файла. Попробуйте в другой раз"
                + " Пожалуйста, прикрепите другой файл",
                "Ошибка записи файла", JOptionPane.ERROR_MESSAGE);
    }
    private void showErrorCalculationMessage() {
        JOptionPane.showMessageDialog(rootPane, "Файл не подходит для вычисления показателей."
                + " Пожалуйста, прикрепите другой файл",
                "Неподходящий файл", JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox arifmeticMeanCheckBox;
    private javax.swing.JCheckBox confidenceCheckBox;
    private javax.swing.JCheckBox countCheckBox;
    private javax.swing.JCheckBox covarianceCheckBox;
    private javax.swing.JCheckBox deviationCheckBox;
    private javax.swing.JCheckBox dispersionCheckBox;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JFileChooser fileSaver;
    private java.awt.Label fileStatusLabel;
    private javax.swing.JCheckBox geometricMeanCheckBox;
    private javax.swing.JDialog instructionDialog;
    private javax.swing.JLabel instructionImage;
    private javax.swing.JLabel instructionLabel;
    private javax.swing.JLabel introductionLabel;
    private javax.swing.JButton loadFileButton;
    private javax.swing.JMenuItem loadFileItem;
    private javax.swing.JMenu mainMenu;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JCheckBox maxMinsCheckBox;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton nextStepButton;
    private javax.swing.JTable resultTable;
    private javax.swing.JTable samplesTable;
    private javax.swing.JButton saveAsButton;
    private javax.swing.JCheckBox scopeCheckBox;
    private javax.swing.JScrollPane scrollPaneForFirstTable;
    private javax.swing.JScrollPane scrollPaneForSecondTable;
    private javax.swing.JComboBox<String> sheetNamesComboBox;
    private javax.swing.JMenuItem showInstructionItem;
    private javax.swing.JButton startCalculationButton;
    private javax.swing.JCheckBox variationCheckBox;
    // End of variables declaration//GEN-END:variables
}
