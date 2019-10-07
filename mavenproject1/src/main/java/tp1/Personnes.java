package tp1;


import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Etu
 */
public class Personnes {
    private final ObservableList<Personne> liste;
    
    public Personnes(List<Personne> liste){
        this.liste = FXCollections.observableArrayList(liste);
    }
    
    public Personnes(){
        this.liste = FXCollections.observableArrayList();
        this.liste.add(new Personne("e", "t", "Emma Dos Santos", "Toulouse", "13 rue Bigard", "0612685102","0598612018"));
        this.liste.add(new Personne("kamal.aarab", "tatata", "Kamal Aarab", "Marseille", "14 rue Bigard", "0612685102","0598612018"));
    }
    
    public ObservableList<Personne> getListe(){
        return liste;
    }
    
    public Personne identification(String login, String password){
        for (Personne p: liste)
            if(p.checkPassword(login, password))
                return p;
        return null;
    }
    
}
