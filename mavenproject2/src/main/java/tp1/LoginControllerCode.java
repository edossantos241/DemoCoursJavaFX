/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

/**
 *
 * @author Etu
 */
class LoginControllerCode {
    private TextField login;
    private PasswordField password;
    private ProgressBar bar;
    LoginCode ui;
    
    ContexteIdentification contexte;
    
    public void setUI(LoginCode ui){
        login = ui.login;
        password = ui.password;
        bar = ui.bar;
        this.ui = ui;
        ui.setControleur(this);
    }
    
    public void setContexte(ContexteIdentification contexte){
        this.contexte = contexte;
        contexte.loginUtilisateurConnecteProperty().bind(login.textProperty());
        contexte.passwordUtilisateurConnecteProperty().bind(password.textProperty());
    }
    
    void processOK(ActionEvent e) {
         System.out.println("Login: "+contexte.getLoginUtilisateurConnecte());
    }

    void processCancel(ActionEvent e) {
        login.textProperty().set("");
        password.textProperty().set("");
        bar.progressProperty().set(0.0);
    }

    public void initialize(URL url, ResourceBundle rb) {
        login.textProperty().set("");
        password.textProperty().set("");
        bar.progressProperty().set(0.0);
        /*
        bar.setProgress(password.getText().length()/0.8f);
        
        password.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                bar.setProgress(newValue.length()/8.0f);
            }
        });
*/
    }
}
