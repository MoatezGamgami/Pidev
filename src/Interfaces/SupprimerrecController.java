/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import edu.esprit.crud.ReclamationCrud;
import edu.esprit.entites.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author moatez
 */
public class SupprimerrecController implements Initializable {

    @FXML
    private TableView<Reclamation> Table;
    @FXML
    private TableColumn<Reclamation, Integer> idrec;
    @FXML
    private TableColumn<Reclamation, String> Description;
    @FXML
    private TableColumn<Reclamation, String> repense;
    @FXML
    private TableColumn<Reclamation, Integer> status;
    @FXML
    private Button supprimerbutton;
    @FXML
    private Button searchbutton;
    @FXML
    private TextField idrecherche;
    @FXML
    private ChoiceBox choicebox;
    @FXML
    private Button buttonretour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        List<Reclamation> mylist = new ArrayList<>();
        ReclamationCrud pp = new ReclamationCrud();
        mylist=pp.affichereclamation();
        idrec.setCellValueFactory(new PropertyValueFactory<Reclamation,Integer>("idrec"));
        Description.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("Description"));
        repense.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("repense"));
        status.setCellValueFactory(new PropertyValueFactory<Reclamation,Integer>("status"));
        ObservableList<Reclamation> list = FXCollections.observableArrayList(mylist);
        Table.setItems((list));
    }    

    @FXML
    private void retour(ActionEvent event) throws IOException {
        Parent affichescene = FXMLLoader.load(getClass().getResource("MenuGestion.fxml"));
        Scene affichage = new Scene(affichescene);
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.setScene(affichage);
        appstage.show();
        
    }

    @FXML
    private void suprrimer(ActionEvent event) {
      Reclamation n =  Table.getSelectionModel().getSelectedItem();
      ReclamationCrud pp = new ReclamationCrud();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirmation Dialog");
        alert.setContentText("Voulez-vous supprimer cette réclamation?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
           pp.suppressionreclamation(n);
           Table.getItems().remove(n);
           Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
           alert2.setTitle("Information Dialog");
           alert2.setHeaderText(null);
           alert2.setContentText("Votre reclamation est supprimée .. Merci!");

        alert2.showAndWait();
         } else {
        alert.close();
    
         }
        
        
        
        
    }

    @FXML
    private void search(ActionEvent event) {
        if(idrecherche.getText().trim().isEmpty()){
        Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("failure");
        fail.setContentText("you havent typed something");
        fail.showAndWait();
    } else {
        String x = idrecherche.getText();
        Integer m =Integer.parseInt(x);
         List<Reclamation> mylist = new ArrayList<>();
        ReclamationCrud pp = new ReclamationCrud();
        mylist=pp.rechercherecstatus(m);
        idrec.setCellValueFactory(new PropertyValueFactory<Reclamation,Integer>("idrec"));
        Description.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("Description"));
        repense.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("repense"));
        status.setCellValueFactory(new PropertyValueFactory<Reclamation,Integer>("status"));
        ObservableList<Reclamation> list = FXCollections.observableArrayList(mylist);
        Table.setItems((list));
    }
    } 
}
