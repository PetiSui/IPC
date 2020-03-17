/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padeljavafx;

import DBAcess.ClubDBAccess;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author PetiSui
 */
public class FXMLPadelController implements Initializable {

    @FXML
    private Button btniniciar;
    @FXML
    private Button btnregistrarse;
    @FXML
    private Label tituloclub;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ClubDBAccess clubDBAcess;
        clubDBAcess = ClubDBAccess.getSingletonClubDBAccess();
        
        tituloclub.setText("Bienvenido a " + clubDBAcess.getClubName());
    }

    @FXML
    private void iniciarsesion(ActionEvent event) {
        try {
            //Carga la vista de la ventana de iniciar sesion para socios            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLIniciarSesion.fxml"));
            
            Parent root = loader.load();
            
            FXMLIniciarSesionController controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Iniciar Sesión");
            stage.showAndWait();
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLPadelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void registrarse(ActionEvent event) {
        try {
            //Carga la vista de la ventana de registrarse para nuevos socios           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLRegistrarse.fxml"));
            
            Parent root = loader.load();
            
            FXMLRegistrarseController controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Registrarse");
            stage.showAndWait();
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLPadelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
