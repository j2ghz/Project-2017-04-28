package UI.Swing;

import Domain.Management.Administration;
import Domain.Model.ToDo;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jakob on 24-Apr-17.
 */
public class ToDoUI {
    private JButton btGenerateToDo;
    private JTextArea taToDo;
    private JPanel pnHolding;
    private JTextField tfToDo;
    private JLabel lbToDo;

    public ToDoUI(Administration adm) {
        btGenerateToDo.addActionListener(Action -> generateToDo(adm));
    }

    public static void main(Administration adm) {
        JFrame frame = new JFrame("To-Do");
        frame.setContentPane(new ToDoUI(adm).pnHolding);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void generateToDo(Administration adm) {
        Date date = null;
        try {
            date = new SimpleDateFormat().parse(tfToDo.getText());
        } catch (java.text.ParseException e) {
            JOptionPane.showConfirmDialog(pnHolding, "The entered check out was invalid, reservation was not created.");
        }

        ArrayList<ToDo> toDo = adm.getToDos(date);

        StringBuilder toDoString = new StringBuilder();

        for (int i = 0; i < toDo.size(); i++) {
            toDoString.append(toDo.get(i).getEmployee().getName()).append("\n");
            toDoString.append(toDo.get(i).getDescription());
            if (i + 1 != toDo.size()) {
                toDoString.append("\n\n\n");
            }
        }

        taToDo.setText(toDoString.toString());
    }


}
