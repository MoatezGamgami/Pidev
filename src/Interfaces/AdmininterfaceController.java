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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author moatez
 */
public class AdmininterfaceController implements Initializable {

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
    private Button repondre;
    @FXML
    private ImageView deletebutton;
    @FXML
    private TextArea rep;
    @FXML
    private ImageView retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Table.setEditable(true);
        repense.setCellFactory(TextFieldTableCell.forTableColumn());
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
    private void repondre(ActionEvent ReclamationStringCellEditEvent) {
        if(rep.getText().trim().isEmpty()){
        Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("failure");
        fail.setContentText("you havent typed something");
        fail.showAndWait();
    } else {
        String h = rep.getText();
         Reclamation rec = Table.getSelectionModel().getSelectedItem();
        ReclamationCrud pp = new ReclamationCrud();
        Integer z = rec.getIdrec();
        Reclamation m = new Reclamation(z,h);
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirmation Dialog");
        alert.setContentText("Voulez-vous repondre a cette réclamation?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
           pp.modifrecreponse(m);
           pp.modifrecstatus(rec);
           Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
           alert2.setTitle("Information ");
           alert2.setHeaderText(null);
           alert2.setContentText("Votre reponse est ajoutée .. Merci!");

        alert2.showAndWait();
        Notifications notificationBuilder = Notifications.create().
            title("New Respond").text("Une reponse est ajoutée").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
            .position(Pos.CENTER_LEFT);
           
        notificationBuilder.darkStyle();
        notificationBuilder.show();
        
        
        
         } else {
        alert.close();
    
         }
        }
        
        
        
    }

    @FXML
    private void delete(MouseEvent event) {
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
        Notifications notificationBuilder = Notifications.create().
            title("DELETED").text("Une reponse est supprimé").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
            .position(Pos.CENTER_RIGHT);
           
        notificationBuilder.darkStyle();
        notificationBuilder.show();
         } else {
        alert.close();
    
         }
    }

    @FXML
    private void refresh(MouseEvent event) {
        Notifications notificationBuilder = Notifications.create().
            title("Refreshing").text("Voila").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
            .position(Pos.CENTER_LEFT);
           
        notificationBuilder.darkStyle();
        notificationBuilder.show();
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
    private void retour(MouseEvent event) throws IOException {
        Notifications notificationBuilder = Notifications.create().
            title("Gestion de reclamation").text("Espace Client").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
            .position(Pos.CENTER_RIGHT);
           
        notificationBuilder.darkStyle();
        notificationBuilder.show();
        Parent affichescene = FXMLLoader.load(getClass().getResource("MenuGestion.fxml"));
        Scene affichage = new Scene(affichescene);
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.setScene(affichage);
        appstage.show();
    }
    
}
