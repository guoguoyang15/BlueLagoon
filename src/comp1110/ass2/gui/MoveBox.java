package comp1110.ass2.gui;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class MoveBox {
    public static void makeMoveBoxes(String[] args) {

        JFrame frame = new JFrame("A Simple GUI");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocation(430, 100);

        JPanel panel = new JPanel();

        frame.add(panel);

        JLabel lbl = new JLabel("Select one of the possible choices and click OK");
        lbl.setVisible(true);

        panel.add(lbl);

        String[] pieces = {"Village", "Settler"};
        String[] rows = {"0", "1"};
        String[] columns = {"0", "1"};

        final JComboBox<String> cb = new JComboBox<String>(pieces);
        final JComboBox<String> rowMoves = new JComboBox<String>(rows);
        final JComboBox<String> rowCols = new JComboBox<String>(columns);

        cb.setVisible(true);
        panel.add(cb);
        rowMoves.setVisible(true);
        panel.add(rowMoves);
        rowCols.setVisible(true);
        panel.add(rowCols);

        JButton btn = new JButton("OK");
        panel.add(btn);

        }
    }
