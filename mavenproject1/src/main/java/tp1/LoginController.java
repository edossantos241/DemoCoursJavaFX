package tp1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import tp1.ContexteIdentification;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Etu
 */
public class LoginController implements Initializable {

    @FXML
    private TextField login;
    @FXML
    private PasswordField password;
    
    ContexteIdentification contexte;
    ContexteAvatar contexteAvatar;
    @FXML
    private ButtonBar ButtonBar;
    @FXML
    private Button buttonOK;
    @FXML
    private Button buttonCancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void processOK(ActionEvent event) {
        System.out.println("Login: "+contexte.getLoginUtilisateurConnecte());
        Personne personneConnectee = contexte.idendification();
        
        if (personneConnectee != null)
        {
            try {
                Stage stage = (Stage)this.login.getScene().getWindow();
                
                FXMLLoader loader;
                loader = new FXMLLoader();
                loader.setLocation(DemoCours1.class.getResource("FenetreTemp.fxml"));
                BorderPane rootLayout = (BorderPane) loader.load();
                
                FenetereTempController controller = loader.getController();
                controller.setContexte(contexte);
                contexte.loginUtilisateurConnecteProperty().unbind();
                contexte.passwordUtilisateurConnecteProperty().unbind();
                
                //ContexteAvatar contexteAvatar = new ContexteAvatar(new Personnes());
                //controller.setContexte(contexteAvatar);
                
                Scene scene = new Scene(rootLayout);
                
                ButtonBar.setButtonData(buttonOK, ButtonData.YES);
                ButtonBar.setButtonData(buttonCancel, ButtonData.NO);
                
                stage.setScene(scene);
                stage.centerOnScreen();
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    private void processCancel(ActionEvent event) {
        login.textProperty().set("");
        password.textProperty().set("");
    }

    void setContexte(ContexteIdentification contexte) {
        this.contexte = contexte;
        contexte.loginUtilisateurConnecteProperty().bind(login.textProperty());
        contexte.passwordUtilisateurConnecteProperty().bind(password.textProperty());
    }
    
}
