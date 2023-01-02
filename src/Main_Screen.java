import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Screen extends JFrame {
    private JPanel mainPanel;
    private JButton cariBukuButton;
    private JButton inputBukuButton;
    private JButton deleteBukuButton;
    private JButton updateBukuButton;
    private cari_buku cariBuku = new cari_buku();
    DatabaseManager databaseManager = new DatabaseManager();
    //private TestFormAndData inputPanel = new TestFormAndData();

    private Input_buku input_buku = new Input_buku();

    public void displayMainScreen(Main_Screen screen) {
        //Main_Screen screen = new Main_Screen();
        tombolInput();
        screen.setContentPane(screen.mainPanel);
        screen.setTitle("Testing");
        screen.setSize(400, 400);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void tombolInput() {
        inputBukuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                input_buku.displayInput(input_buku);
            }
        });
    }

//    public void changeToCariBukuScreen(Main_Screen screen) {
//        inputBukuButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                screen.getContentPane().removeAll();
//                screen.setContentPane(cariBuku.getCari_Buku());
//                //screen.getContentPane().add(new JPanel());
////                screen.setContentPane(input_Screen.form_input);
//                //JOptionPane.showMessageDialog(inputBukuButton, "Halo");
//            }
//        });
//    }


}
