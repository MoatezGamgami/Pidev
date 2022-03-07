/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import edu.esprit.crud.DeliveryRateCrud;
import edu.esprit.crud.ReclamationCrud;
import edu.esprit.entites.Livreur;
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
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.PropertySheet.Item;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author moatez
 */
public class AvisDGController implements Initializable {

    @FXML
    private TableView<Livreur> Table;
    @FXML
    private TableColumn<Livreur, Double> Stars;
    @FXML
    private TableColumn<Livreur, String> name;
    @FXML
    private Button retour;
    @FXML
    private Button addrate;
    @FXML
    private Rating GiveRate;
    @FXML
    private Rating GetRate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        List<Livreur> mylist = new ArrayList<>();
        DeliveryRateCrud pp= new DeliveryRateCrud();
        mylist=pp.affichedelivertyguy();
        
        Stars.setCellValueFactory(new PropertyValueFactory<Livreur,Double>("Stars"));
        name.setCellValueFactory(new PropertyValueFactory<Livreur,String>("name"));
        
        ObservableList<Livreur> list = FXCollections.observableArrayList(mylist);
        Table.setItems((list));
        
        
        
        GetRate.setRating(5);
    }    

    @FXML
    private void goretour(ActionEvent event) throws IOException {
         Parent affichescene = FXMLLoader.load(getClass().getResource("MenuGestion.fxml"));
        Scene affichage = new Scene(affichescene);
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.setScene(affichage);
        appstage.show();
    }

    @FXML
    private void addrate(ActionEvent event) {
        Livreur rec = Table.getSelectionModel().getSelectedItem();
        Double x = GiveRate.getRating();
        Double y = rec.getStars();
        Double h= x+y;
        Double z=h/2;
        DeliveryRateCrud pp = new DeliveryRateCrud();
        if(y==0.0){
            pp.modif1erlivreur(rec, x);
        }else{
            pp.modif1erlivreur(rec, z);
        }
        Notifications notificationBuilder = Notifications.create().
            title("Gestion Avis").text("New Rate Added ").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
            .position(Pos.CENTER_LEFT);
           
        notificationBuilder.darkStyle();
        notificationBuilder.show();
        List<Livreur> mylist = new ArrayList<>();
        DeliveryRateCrud ps= new DeliveryRateCrud();
        mylist=pp.affichedelivertyguy();
        
        Stars.setCellValueFactory(new PropertyValueFactory<Livreur,Double>("Stars"));
        name.setCellValueFactory(new PropertyValueFactory<Livreur,String>("name"));
        
        ObservableList<Livreur> list = FXCollections.observableArrayList(mylist);
        Table.setItems((list));
        
    }
    
}
