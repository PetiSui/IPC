/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padeljavafx;

import DBAcess.ClubDBAccess;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author PetiSui
 */
public class PadelJavaFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        ClubDBAccess clubDBAcess;
        clubDBAcess = ClubDBAccess.getSingletonClubDBAccess();
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLPadel.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        
        stage.setOnCloseRequest((WindowEvent event) -> {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle(clubDBAcess.getClubName());
            alert.setHeaderText("Saving data in DB");
            alert.setContentText(
            "The application is saving the changes into the database. This action can expend some minutes.");
            alert.show();
            clubDBAcess.saveDB();
        });
        
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
