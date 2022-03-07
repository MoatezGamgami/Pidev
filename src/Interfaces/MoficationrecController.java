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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author moatez
 */
public class MoficationrecController implements Initializable {

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
    private Button retour;
    @FXML
    private Button show;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Table.setEditable(true);
        Description.setCellFactory(TextFieldTableCell.forTableColumn());
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
    private void show(ActionEvent event) {
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
        private void oneditchange(TableColumn.CellEditEvent<Reclamation, String> ReclamationStringCellEditEvent) {
        Reclamation rec = Table.getSelectionModel().getSelectedItem();
        rec.setDescription(ReclamationStringCellEditEvent.getNewValue());
        ReclamationCrud pp = new ReclamationCrud();
        Integer z = rec.getIdrec();
        pp.modifreclamation(rec);
        
    }
    
}
