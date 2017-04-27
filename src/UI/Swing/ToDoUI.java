package UI.Swing;

import Domain.Model.ToDo;
import Services.Database.DB;

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

    public static void main(DB db) {
        JFrame frame = new JFrame("To-Do");
        frame.setContentPane(new ToDoUI(db).pnHolding);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public ToDoUI(DB db) {
        btGenerateToDo.addActionListener(Action -> generateToDo(db));
    }

    private void generateToDo(DB db) {
        Date date = null;
        try {
            date = new SimpleDateFormat().parse(tfToDo.getText());
        } catch (java.text.ParseException e) {
            JOptionPane.showConfirmDialog(pnHolding, "The entered check out was invalid, reservation was not created.");
        }

        ArrayList<ToDo> toDo = db.getToDos(date);

        String toDoString = "";

        for (int i = 0; i < toDo.size(); i++) {
            toDoString += toDo.get(i).getEmployee().getName() + "\n";
            toDoString += toDo.get(i).getDescription();
            if (i + 1 != toDo.size()) {
                toDoString += "\n\n\n";
            }
        }

        taToDo.setText(toDoString);
    }


}
