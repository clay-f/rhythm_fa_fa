package com.f.studyDesignPatterns.interfacePattern.interfaceAdapter;

import java.awt.Component;
import java.awt.Font;
import javax.swing.*;

public class ShowRocketTable {
    public static void main(String[] args) {
        setFonts();
        JTable table = new JTable(getRocketTable());
        table.setRowHeight(36);
        JScrollPane pane = new JScrollPane(table);
        pane.setPreferredSize(
                new  java.awt.Dimension(300, 100)
        );

        display(pane, "Rockets");
    }

    public static void display(Component c, String title) {
        JFrame frame = new JFrame(title);
        frame.getContentPane().add(c);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private static RocketTableModel getRocketTable() {
       Rocket r1 = new Rocket("foo", 50.2, 50.2);
       return new RocketTableModel();

    }

    private static void setFonts() {
        Font font = new Font("Dialog", Font.PLAIN, 18);
        UIManager.put("Table.font", font);
        UIManager.put("TableHeader.font", font);
    }
}
