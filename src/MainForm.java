import javax.swing.*;
import java.util.ArrayList;

/**
 * Main form for the application
 */
public class MainForm extends JFrame {
    private JTextField txtName;
    private JPanel mainPanel;
    private JSpinner spnTimeH;
    private JSpinner spnTimeM;
    private JButton btnSubmit;
    private JList lstErrors;
    private JList<Object> lstParticipants;

    public MainForm() {
        this.setContentPane(mainPanel);
        this.setTitle("Participant");
        this.setSize(300, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnSubmit.addActionListener(e -> {
            Storage.getInstance().add(new Participation(txtName.getText(), (int)spnTimeH.getValue(), (int)spnTimeM.getValue()));
            lstParticipants.setListData(Storage.getInstance().toArray());
        });
    }
}
