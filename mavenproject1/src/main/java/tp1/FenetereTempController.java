/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.Property;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AdminEtu
 */
public class FenetereTempController implements Initializable {
    
    ContexteIdentification contexte;
    ContexteAvatar contexteAvatar;

    @FXML
    private MenuItem afficherPofil;
    @FXML
    private MenuItem configurerAvatar;
    @FXML
    private MenuItem quitter;
    
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn colonneLogin;
    @FXML
    private TableColumn colonneNom;
    @FXML
    private TableColumn colonneVille;
    @FXML
    private TextField createLogin;
    @FXML
    private TextField createNom;
    @FXML
    private TextField createVille;
    @FXML
    private Button boutonCreerPersonne;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void afficherProfilAlert(ActionEvent event) {
        Personne personneConnectee = contexte.idendification();
        
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Profil");
        alert.setContentText("Nom: " + personneConnectee.getNom() 
                + "\nLogin: " + personneConnectee.getLogin()
        + "\nAdresse: " + personneConnectee.getAdresse1()
        +"\nTéléphone: " + personneConnectee.getTel());
        alert.showAndWait();
    }

    void setContexte(ContexteIdentification contexte) {
        this.contexte = contexte;
        
        tableView.setItems(contexte.getPersonnes().getListe());  
        for (Personne p: contexte.getPersonnes().getListe()){
            colonneLogin.setCellValueFactory(new PropertyValueFactory<Personne, String>("login"));
            colonneNom.setCellValueFactory(new PropertyValueFactory<Personne, String>("nom"));
            colonneVille.setCellValueFactory(new PropertyValueFactory<Personne, String>("adresse1"));
        }
        
        contexte.loginNouvellePersonneProperty().bind(createLogin.textProperty());
        contexte.nomNouvellePersonneProperty().bind(createNom.textProperty());
        contexte.villeNouvellePersonneProperty().bind(createVille.textProperty());
        
        
        /*tableView.getSelectionModel().selectedItemProperty().addListener(event -> {
            //lineSelected();
            createLogin.textProperty().bind(tableView.);
        });*/
    }

    @FXML
    private void configurerAvatar(ActionEvent event) throws IOException {
        
        Stage stageNew = new Stage();
        
        FXMLLoader loader;
        loader = new FXMLLoader();
        loader.setLocation(DemoCours1.class.getResource("MainWindow.fxml"));
        BorderPane rootLayout = (BorderPane) loader.load();

        MainWindowController controller = loader.getController();

        contexteAvatar = new ContexteAvatar(new Personnes());
        controller.setContexte(contexteAvatar);

        Scene scene = new Scene(rootLayout);

        stageNew.setScene(scene);
        stageNew.centerOnScreen();
        stageNew.show();
    }

    @FXML
    private void confirmationQuitter(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setContentText("Voulez-vous vraiment quitter?");
        
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Platform.exit();
            System.exit(0);
        } else {
            alert.close();
        }
    }

    @FXML
    private void creerPersonne(ActionEvent event) {
        Personne p = new Personne(createLogin.getText(), "", createNom.getText(), createVille.getText(), "", "", "");
        contexte.getPersonnes().getListe().add(p);
    }

    private void lineSelected() {
        createLogin.setText(colonneLogin.getText());
    }
    
}
