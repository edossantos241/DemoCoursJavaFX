package tp1;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Etu
 */
public class DemoCours2 extends Application{

    private Object okayButton;

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        //FXMLLoader loader;
        //loader = new FXMLLoader();
        //loader.setLocation(DemoCours2.class.getResource("Login.fxml"));
        
        BorderPane rootLayout = new LoginCode();
        //Récupération d'une référence au contrôleur
        LoginControllerCode controller = new LoginControllerCode();
        ContexteIdentification contexte = new ContexteIdentification(new Personnes());
        controller.setUI((LoginCode) rootLayout);
        //controller.initialize();
        controller.setContexte(contexte);
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args){
        launch(args);
    }

    
    
}
