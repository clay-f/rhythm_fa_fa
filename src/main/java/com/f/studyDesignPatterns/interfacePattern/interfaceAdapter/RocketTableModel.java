package com.f.studyDesignPatterns.interfacePattern.interfaceAdapter;

import javax.swing.table.AbstractTableModel;

public class RocketTableModel extends AbstractTableModel {

    protected Rocket[] rockets;

    protected String[] columnNames = new String[]{"Name", "Price", "pogee"};

    public RocketTableModel(Rocket[] rockets) {
        this.rockets = rockets;
    }

    public RocketTableModel() {
    }

    @Override
    public int getRowCount() {
        return columnNames.length;
    }

    public String getColumnName(int i) {
        return columnNames[i];
    }

    @Override
    public int getColumnCount() {
        return rockets.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rockets[rowIndex].getName();
            case 1:
                return rockets[rowIndex].getPrice();
            case 2:
                return new Double(rockets[rowIndex].getPogee());
            default:
                return null;
        }
    }
}
