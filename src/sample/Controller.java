package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public static ObservableList<Student> students;

    @FXML
    private TableView<Student> tableView;

    @FXML
    private TableColumn<Student, Integer> id;

    @FXML
    private TableColumn<Student, String> name;

    @FXML
    private TableColumn<Student, String> surname;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        students = FXCollections.observableList(createDummyStudents());
        id.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        surname.setCellValueFactory(new PropertyValueFactory<Student, String>("surname"));
        tableView.setItems(students);

    }

    public void editItem(ActionEvent event){
        Student st = tableView.getSelectionModel().getSelectedItem();
        System.out.println(st);
    }

    public void newItem(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("secondsample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Second Hello World");
        stage.setScene(new Scene(root));

        stage.show();

    }


    private List<Student> createDummyStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Petras", "Petraitis"));
        students.add(new Student(2, "Jonas", "Jonaitis"));
        students.add(new Student(3, "Antanas", "Antanaitis"));
        students.add(new Student(4, "Kaziukas", "Kaziukaitis"));

        return students;
    }
}
