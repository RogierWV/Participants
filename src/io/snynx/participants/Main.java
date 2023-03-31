package io.snynx.participants;

import javax.swing.UIManager;

/**
 * Main class, does basic setup and creates the MainForm
 */
public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        new MainForm();
    }
}