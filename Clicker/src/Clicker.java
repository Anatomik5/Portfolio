import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Alisher Darmenov
 * @since 11.02.2023
 */
public class Clicker implements ActionListener {
        private int count =0;
        private JLabel label;
        private JFrame frame;
        private JPanel panel;
        public Clicker(){
            frame = new JFrame();

            JButton button = new JButton("Click");
            button.addActionListener(this);
            label = new JLabel("Clicked: ");

            panel = new JPanel();
            panel.setBorder(BorderFactory.createEmptyBorder(60,60,60,60));
            panel.setLayout(new GridLayout(0,1));
            panel.add(button);
            panel.add(label);
            frame.add(panel, BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Clicker");
            frame.pack();
            frame.setVisible(true);

        }
        public static void main(String[] args){
            new Clicker();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            count++;
            label.setText("Clicked: "+count);
        }
    }

