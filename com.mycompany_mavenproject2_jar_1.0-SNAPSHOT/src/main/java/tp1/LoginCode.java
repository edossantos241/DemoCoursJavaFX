/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Etu
 */
public class LoginCode extends BorderPane {
    Label titre;
    TextField login;
    PasswordField password;
    LoginControllerCode controleur; //Le controleur

    public LoginCode() {
        titre = new Label("Identification");
        titre.setId("titre");
        this.setTop(titre); //Met le titre en haut du BorderPane
        
        GridPane centerPane = new GridPane();
        Label label1 = new Label("Login");
        label1.setPrefWidth(100);
        centerPane.add(label1,0,0);
        login = new TextField();
        centerPane.add(login,1,0);
        Label label2 = new Label("Password");
        centerPane.add(label2,0,1);
        password = new PasswordField();
        centerPane.add(password,1,1);
        this.setCenter(centerPane);
        
        FlowPane bottomPane = new FlowPane();
        bottomPane.setHgap(10);
        
        Button okButton = new Button("OK");
        
        okButton.setOnMouseEntered(new EventHandler<MouseEvent> (){
            @Override
            public void handle(MouseEvent event){
                if(login.textProperty().getValue().isEmpty()){
                    login.setStyle("-fx-background-color:red");
                } else {
                    login.setStyle("-fx-background-color:white");
                }
            }
        });
        
        okButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //Traitement de l'activation du bouton
                System.out.println("Le bouton est activé");;
            }
        });
        
        okButton.setDefaultButton(true);
        //okButton.setOnAction(e -> {controleur.processOK(e);});
        Button cancelButton = new Button("Cancel");
        cancelButton.setCancelButton(true);
        cancelButton.setOnAction(e -> {controleur.processCancel(e);});
        bottomPane.getChildren().addAll(okButton, cancelButton);
        this.setBottom(bottomPane);
        
        this.setPrefSize(437, 187);
        this.setPadding((new Insets(10,0,10,0)));
    }

    void setControleur(LoginControllerCode aThis) {
       this.controleur = aThis;
    }
}
