package tp1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

/**
 * FXML Controller class
 *
 * @author Etu
 */
public class MainWindowController implements Initializable {
    private GraphicsContext gc;
    
    private ContexteAvatar contexteAvatar;
    @FXML
    private ComboBox<String> couleurCheveux;
    @FXML
    private Slider longueurCheveux;
    @FXML
    private ComboBox<String> formeVisage;
    @FXML
    private ListView<String> couleurYeux;
    @FXML
    private Canvas avatar;

    String couleurYeuxChoisie = "BLACK";
    String couleurCheveuxChoisie = "BLACK";
    String formeVisageChoisie = "ROND";
    double longueurCheveuxChoisie = 30;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        longueurCheveux.setMin(0);
        longueurCheveux.setMax(100);
        longueurCheveux.setValue(30);
        
        gc = avatar.getGraphicsContext2D();
        gc.strokeOval(100, 100, 80, 80);
        gc.fillOval(125, 120, 10, 10);
        gc.fillOval(145, 120, 10, 10);
        gc.fillArc(130, 90, 30, 30, 0, 180, ArcType.CHORD);
        
        ObservableList<String> colorsYeux = FXCollections.observableArrayList(
        "GREEN","BROWN","BLUE"
        );
        couleurYeux.setItems(colorsYeux);

        ObservableList<String> colorsCheveux = FXCollections.observableArrayList(
                "RED","BROWN","YELLOW"
        );
        couleurCheveux.setItems(colorsCheveux);
        
        ObservableList<String> formeVisageList = FXCollections.observableArrayList(
                "ROND","RECTANGLE"
        );
        formeVisage.setItems(formeVisageList);
    }    

    void setContexte(ContexteAvatar contexteAvatar) {
        this.contexteAvatar = contexteAvatar;
        contexteAvatar.couleurYeuxProperty().bind(couleurYeux.getSelectionModel().selectedItemProperty());
        contexteAvatar.couleurCheveuxProperty().bind(couleurCheveux.getSelectionModel().selectedItemProperty());
        contexteAvatar.formeVisageProperty().bind(formeVisage.getSelectionModel().selectedItemProperty());
        contexteAvatar.longueurCheveuxProperty().bind(longueurCheveux.accessibleTextProperty());
        couleurYeux.getSelectionModel().selectedItemProperty().addListener(event -> {
            draw();
        });
        couleurCheveux.getSelectionModel().selectedItemProperty().addListener(event -> {
            draw();
        });
        formeVisage.getSelectionModel().selectedItemProperty().addListener(event -> {
            draw();
        });
        longueurCheveux.valueProperty().addListener(event -> {
            draw();
        });
    }
    
    private void draw() {
        gc.clearRect(0, 0, 300, 300);
        
        if (formeVisage.getSelectionModel().selectedItemProperty().getValue() != null){
                    formeVisageChoisie = formeVisage.getSelectionModel().selectedItemProperty().getValue();
        }
        
        if ("ROND".equals(formeVisageChoisie)){
            gc.strokeOval(100, 100, 80, 80);
        } else {
            gc.strokeRect(100, 100, 80, 80);
        }
        
        if (couleurYeux.getSelectionModel().selectedItemProperty().getValue() != null){
                    couleurYeuxChoisie = couleurYeux.getSelectionModel().selectedItemProperty().getValue();

        }
        if (couleurCheveux.getSelectionModel().selectedItemProperty().getValue() != null){
                    couleurCheveuxChoisie = couleurCheveux.getSelectionModel().selectedItemProperty().getValue();
        }
 
        gc.setFill(Color.valueOf(couleurYeuxChoisie));
        gc.fillOval(125, 120, 10, 10);
        gc.strokeOval(125, 120, 10, 10);
        gc.fillOval(145, 120, 10, 10);
        gc.strokeOval(145, 120, 10, 10);
        
        gc.setFill(Color.valueOf(couleurCheveuxChoisie));
        
        longueurCheveuxChoisie = longueurCheveux.getValue();
        
        gc.fillArc(130, 90, longueurCheveuxChoisie, longueurCheveuxChoisie, 0, 180, ArcType.CHORD);

    }   
}
