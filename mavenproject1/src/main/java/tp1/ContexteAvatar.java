/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author AdminEtu
 */
public class ContexteAvatar {
    private Personnes personnes;
    //private ComboBox<?> couleurCheveux;
    //private Slider longueurCheveux;
    //private ComboBox<?> formeVisage;
    private StringProperty couleurYeux;
    private StringProperty couleurCheveux;
    private StringProperty formeVisage;
    private StringProperty longueurCheveux;
 
    public ContexteAvatar(Personnes personnes){
        this.personnes = personnes;
        couleurYeux = new SimpleStringProperty();
        couleurCheveux = new SimpleStringProperty();
        formeVisage = new SimpleStringProperty();
        longueurCheveux = new SimpleStringProperty();
    }
    
    public StringProperty couleurYeuxProperty(){
        return couleurYeux;
    }
    
    String getCouleurYeux(){
        return couleurYeux.getValue();
    }
    
    public StringProperty couleurCheveuxProperty(){
        return couleurCheveux;
    }
    
    String getCouleurCheveux(){
        return couleurCheveux.getValue();
    }

    public StringProperty formeVisageProperty() {
        return formeVisage;   
    }
    
    String getFormeVisage(){
        return formeVisage.getValue();
    }

    public StringProperty longueurCheveuxProperty() {
        return longueurCheveux; 
    }
    
    String getLongueurCheveux(){
        return longueurCheveux.getValue();
    }
}
