/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Etu
 */
class LoginControllerCode {
    private TextField login;
    private PasswordField password;
    LoginCode ui;
    
    ContexteIdentification contexte;
    
    public void setUI(LoginCode ui){
        login = ui.login;
        password = ui.password;
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
    }
}
