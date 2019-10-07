package tp1;


import tp1.ContexteIdentification;
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
public class DemoCours1 extends Application{

    private Object okayButton;

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        try{
            FXMLLoader loader;
            loader = new FXMLLoader();
            loader.setLocation(DemoCours1.class.getResource("Login.fxml"));
            BorderPane rootLayout = (BorderPane) loader.load();
            
            //Récupération d'une référence au contrôleur
            LoginController controller = loader.getController();
            ContexteIdentification contexte = new ContexteIdentification(new Personnes());
            controller.setContexte(contexte);
            
            
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        launch(args);
    }

    
    
}
