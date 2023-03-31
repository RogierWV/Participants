package io.snynx.participants;

import javax.swing.UIManager;
import java.nio.file.Paths;

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
        String path = (args.length > 0)? args[0] : (Paths.get(System.getProperty("java.io.tmpdir"), "participants")).toString();
        new MainForm(path);
    }
}