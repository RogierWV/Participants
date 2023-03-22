import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JTextField txtName;
    private JPanel mainPanel;
    private JSpinner spnTimeH;
    private JSpinner spnTimeM;
    private JButton btnSubmit;
    private JList lstErrors;
    private JList lstParticipants;

    public MainForm() {
        this.setContentPane(mainPanel);
        this.setTitle("Participant");
        this.setSize(300, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(btnSubmit,
                        String.format("%s at %02d:%02d", txtName.getText(), spnTimeH.getValue(), spnTimeM.getValue()));
            }
        });
    }
}
