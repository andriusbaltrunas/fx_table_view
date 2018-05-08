package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Created by andriusbaltrunas on 3/29/2018.
 */
public class SecondController {

    @FXML
    private TextField id;

    @FXML
    private TextField name;

    @FXML
    private TextField surname;

    public void save(ActionEvent event){
        ObservableList<Student> students = Controller.students;
        students.add(new Student(Integer.valueOf(id.getText()), name.getText(), surname.getText()));
    }

    public void callAnotherControllerMethod(ActionEvent event){
        Controller.calledFromAnotherController("SecondController");
    }
}
