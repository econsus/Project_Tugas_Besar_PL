import javax.swing.*;

public class Main_Screen extends JFrame {
    private JPanel mainPanel;
    private JButton cariBookButton;
    private JButton inputBukuButton;
    private JButton deleteBookButton;
    private JButton updateBookButton;
    private cari_buku cariBuku = new cari_buku();
    DatabaseManager databaseManager = new DatabaseManager();
    //private TestFormAndData inputPanel = new TestFormAndData();

    public void displayMainScreen(Main_Screen screen) {
        //Main_Screen screen = new Main_Screen();
        screen.setContentPane(screen.mainPanel);
        screen.setTitle("Testing");
        screen.setSize(400, 400);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

//    public void tombolInput() {
//        inputBukuButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dispose();
//                inputPanel.displayMainScreen(inputPanel);
//            }
//        });
//    }

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
