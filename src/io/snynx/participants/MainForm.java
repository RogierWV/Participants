package io.snynx.participants;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Main form for the application
 */
public class MainForm extends JFrame {
    private JTextField txtName;
    private JPanel mainPanel;
    private JSpinner spnTimeH;
    private JSpinner spnTimeM;
    private JButton btnSubmit;
    private JList<Object> lstErrors;
    private JList<Object> lstParticipants;

    public MainForm() {
        this.setContentPane(mainPanel);
        this.setTitle("Participant");
        this.setSize(300, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnSubmit.addActionListener(event -> {
            try {
                Storage.getInstance().add(new Participation(txtName.getText(), (int) spnTimeH.getValue(), (int) spnTimeM.getValue()));
                Storage.getInstance().sort();
            } catch (Throwable ex) {
                Throwable throwable = ex;
                List<String> errors = new ArrayList<>();
                do {
                    errors.add(throwable.getMessage());
                } while((throwable = throwable.getCause()) != null);
                lstErrors.setListData(errors.toArray());
            }
            lstParticipants.setListData(Storage.getInstance().toArray());

        });
    }

    private void createUIComponents() {
        spnTimeH = new JSpinner(new SpinnerNumberModel(0, 0, 23, 1));
        spnTimeM = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
    }
}
