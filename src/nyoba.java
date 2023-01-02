import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class nyoba extends JFrame{
    private JButton button1;
    private JTable table1;
    private JPanel panelA;

    public void display(nyoba screen) {
        screen.setContentPane(screen.panelA);
        screen.setSize(400, 400);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void tombol1() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("A");
            }
        });
    }
}
