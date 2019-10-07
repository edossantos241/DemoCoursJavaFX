package tp1;


import java.time.LocalDateTime;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Etu
 */
public class Personne {
    private final StringProperty login = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();
    private final StringProperty nom = new SimpleStringProperty();
    private final StringProperty adresse1 = new SimpleStringProperty();
    private final StringProperty adresse2 = new SimpleStringProperty();
    private final StringProperty tel1 = new SimpleStringProperty();
    private final StringProperty tel2 = new SimpleStringProperty();
    private final ObjectProperty<LocalDateTime> derniereConnexion = new SimpleObjectProperty();
    
    Personne(String login, String password, String nom, String adresse1, String adresse2, String tel1, String tel2) {
        this.login.setValue(login);
        this.password.setValue(password);
        this.nom.setValue(nom);
        this.adresse1.setValue(adresse1);
        this.adresse2.setValue(adresse2);
        this.tel1.setValue(tel1);
        this.tel2.setValue(tel2);
    }
    
    private String getLogin(){
        return login.getValue();
    }

    private void setLogin(String value){
        login.setValue(value);
    }
    
    private StringProperty loginProperty(){
        return login;
    }
    
    boolean checkPassword(String login, String password) {
        return login.equals(this.login.getValue()) && password.equals(this.password.getValue());
    }
    
    public final LocalDateTime getDerniereConnexion(){
        return derniereConnexion.getValue();
    }
    
    public final void setDerniereConnexion(LocalDateTime value){
        derniereConnexion.setValue(value);
    }
    
    public ObjectProperty<LocalDateTime> derniereConnexionProperty(){
        return derniereConnexion;
    }
}
