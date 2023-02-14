package lk.sankalpa.others;

import com.jfoenix.controls.JFXHamburger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.awt.*;

public class MenuTranslater {


    public static void setTranslater(JFXHamburger hmbMain, JFXHamburger hmbMainClose, Pane slider) {
        slider.setTranslateX(1550);
        hmbMain.setOnMouseClicked(event -> {
            TranslateTransition slide=new TranslateTransition();
            slide.setDuration(Duration.seconds(0.3));
            slide.setNode(slider);

            slide.setToX(0);
            slide.play();
            slider.setTranslateX(1550);
            slide.setOnFinished((ActionEvent e)->{
//                slider.setVisible(true);
            });
        });
        hmbMainClose.setOnMouseClicked(event -> {
            TranslateTransition slide=new TranslateTransition();
            slide.setDuration(Duration.seconds(0.3));
            slide.setNode(slider);

            slide.setToX(1550);
            slide.play();
            slider.setTranslateX(0);
            slide.setOnFinished((ActionEvent e)->{
//                slider.setVisible(false);
            });
        });
    }

    public static void setAddTranclate(JFXHamburger hbAdd, JFXHamburger closeOnAction, AnchorPane slider_p_o) {
        slider_p_o.setTranslateY(-400);
        hbAdd.setOnMouseClicked(event -> {
            TranslateTransition slide=new TranslateTransition();
            slide.setDuration(Duration.seconds(0.5));
            slide.setNode(slider_p_o);

            slide.setToY(0);
            slide.play();
            slider_p_o.setTranslateY(-400);
            slide.setOnFinished((ActionEvent e)->{
//                slider.setVisible(true);
            });
        });
        closeOnAction.setOnMouseClicked(event -> {
            TranslateTransition slide=new TranslateTransition();
            slide.setDuration(Duration.seconds(0.5));
            slide.setNode(slider_p_o);

            slide.setToY(-400);
            slide.play();
            slider_p_o.setTranslateY(0);
            slide.setOnFinished((ActionEvent e)->{
//                slider.setVisible(false);
            });
        });
    }

    public static void setSearchTranclate(JFXHamburger hbSearch, JFXHamburger searchCloseOnAction, AnchorPane searchSlider) {
        searchSlider.setTranslateY(-400);
        hbSearch.setOnMouseClicked(event -> {
            TranslateTransition slide=new TranslateTransition();
            slide.setDuration(Duration.seconds(0.5));
            slide.setNode(searchSlider);

            slide.setToY(0);
            slide.play();
            searchSlider.setTranslateY(-400);
            slide.setOnFinished((ActionEvent e)->{
//                slider.setVisible(true);
            });
        });
        searchCloseOnAction.setOnMouseClicked(event -> {
            TranslateTransition slide=new TranslateTransition();
            slide.setDuration(Duration.seconds(0.5));
            slide.setNode(searchSlider);

            slide.setToY(-400);
            slide.play();
            searchSlider.setTranslateY(0);
            slide.setOnFinished((ActionEvent e)->{
//                slider.setVisible(false);
            });
        });
    }

    public static void setEditTranclate(JFXHamburger hbEdit, JFXHamburger editCloseOnAction, AnchorPane editSlider) {

        editSlider.setTranslateY(-400);
        hbEdit.setOnMouseClicked(event -> {
            TranslateTransition slide=new TranslateTransition();
            slide.setDuration(Duration.seconds(0.5));
            slide.setNode(editSlider);

            slide.setToY(0);
            slide.play();
            editSlider.setTranslateY(-400);
            slide.setOnFinished((ActionEvent e)->{
//                slider.setVisible(true);
            });
        });
        editCloseOnAction.setOnMouseClicked(event -> {
            TranslateTransition slide=new TranslateTransition();
            slide.setDuration(Duration.seconds(0.5));
            slide.setNode(editSlider);

            slide.setToY(-400);
            slide.play();
            editSlider.setTranslateY(0);
            slide.setOnFinished((ActionEvent e)->{
//                slider.setVisible(false);
            });
        });

    }
    //==========================
    public static void setEditTranclate(MenuItem hbEdit, JFXHamburger editCloseOnAction, AnchorPane editSlider) {



    }

    public static void setDeleteTranclate(JFXHamburger hbDelete, JFXHamburger deleteCloseOnAction, AnchorPane deleteSlider) {

        deleteSlider.setTranslateY(-400);
        hbDelete.setOnMouseClicked(event -> {
            TranslateTransition slide=new TranslateTransition();
            slide.setDuration(Duration.seconds(0.5));
            slide.setNode(deleteSlider);

            slide.setToY(0);
            slide.play();
            deleteSlider.setTranslateY(-400);
            slide.setOnFinished((ActionEvent e)->{
//                slider.setVisible(true);
            });
        });
        deleteCloseOnAction.setOnMouseClicked(event -> {
            TranslateTransition slide=new TranslateTransition();
            slide.setDuration(Duration.seconds(0.5));
            slide.setNode(deleteSlider);

            slide.setToY(-400);
            slide.play();
            deleteSlider.setTranslateY(0);
            slide.setOnFinished((ActionEvent e)->{
//                slider.setVisible(false);
            });
        });

    }

   /* public static void setEditTranclateByMenu(javafx.scene.control.MenuItem editSliderById, JFXHamburger editCloseOnAction, AnchorPane editSlider) {

        editSlider.setTranslateY(-400);
        editSliderById.setOnMouseClicked(event -> {
            TranslateTransition slide=new TranslateTransition();
            slide.setDuration(Duration.seconds(0.5));
            slide.setNode(editSlider);

            slide.setToY(0);
            slide.play();
            editSlider.setTranslateY(-400);
            slide.setOnFinished((ActionEvent e)->{
//                slider.setVisible(true);
            });
        });
        editCloseOnAction.setOnMouseClicked(event -> {
            TranslateTransition slide=new TranslateTransition();
            slide.setDuration(Duration.seconds(0.5));
            slide.setNode(editSlider);

            slide.setToY(-400);
            slide.play();
            editSlider.setTranslateY(0);
            slide.setOnFinished((ActionEvent e)->{
//                slider.setVisible(false);
            });
        });

    }*/
}
