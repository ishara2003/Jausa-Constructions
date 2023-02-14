package lk.sankalpa.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.sankalpa.Util.Navigation;
import lk.sankalpa.Util.Routes;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainFormController {

    Stage stage;
    public  AnchorPane MainForm;
    public Label lblDate;
    public Label lblTime;
    public AnchorPane mainFormOne;
    public AnchorPane adminLoginFrom;
    public Button btnManager;
    public Button btnAdmin;
    public JFXButton btnMainMenu;
    public Button btnClose;

    public void initialize() throws IOException {
        setTime();
        setDate();
        btnAdmin.setCursor(Cursor.HAND);
        btnMainMenu.setCursor(Cursor.HAND);



    }
    private void setTime(){

    Timeline timeline=new Timeline(new KeyFrame(Duration.ZERO, e-> {

        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm:ss");

        lblTime.setText(LocalDateTime.now().format(formatter));
    }),new KeyFrame(Duration.seconds(1)));

    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.play();

}
    private void setDate(){

    Timeline timeline=new Timeline(new KeyFrame(Duration.ZERO, e-> {

        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");

        lblDate.setText(LocalDateTime.now().format(formatter));
    }),new KeyFrame(Duration.seconds(1)));

    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.play();

}
    public void MainFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.MAIN_FROM,mainFormOne);
    }
    public void AdminOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN,MainForm);
    }
    public void CloseOnAction(ActionEvent actionEvent) throws Exception {

    }
}
