/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padeljavafx;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PetiSui
 */
public class FXMLIniciarSesionController implements Initializable {

    @FXML
    private TextField nomUsuario;
    @FXML
    private PasswordField contra;
    @FXML
    private Button btnContinuar;
    @FXML
    private Label ini_error;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void continuar(ActionEvent event) {
        
        
        try {
            //Carga la vista de la ventana de reservas (falta comprobar si el usiario existe)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLReservar.fxml"));
            
            Parent root = loader.load();
            
            FXMLReservarController controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Registrarse");
            stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(FXMLIniciarSesionController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
    }
    
}
