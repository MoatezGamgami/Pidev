/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author moatez
 */
public class MenuGestionController implements Initializable {

    @FXML
    private Button ajoutrecbutton;
    @FXML
    private Button modifrecbutton;
    @FXML
    private Button afficherecbutton;
    @FXML
    private Button supprimrecbutton;
    @FXML
    private ImageView admin;
    @FXML
    private ImageView stat;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void savereclamation(ActionEvent event) throws IOException {
        ///// conversion int : int idp = integer.parseInt.getText();
        Parent affichescene = FXMLLoader.load(getClass().getResource("Ajoutrec.fxml"));
        Scene affichage = new Scene(affichescene);
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.setScene(affichage);
        appstage.show();
    }

    @FXML
    private void details(ActionEvent event) throws IOException {
        Parent affichescene = FXMLLoader.load(getClass().getResource("reclamationdetail.fxml"));
        Scene affichage = new Scene(affichescene);
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.setScene(affichage);
        appstage.show();
        
      
    }

    @FXML
    private void modifshow(ActionEvent event) throws IOException {
        Parent affichescene = FXMLLoader.load(getClass().getResource("moficationrec.fxml"));
        Scene affichage = new Scene(affichescene);
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.setScene(affichage);
        appstage.show();
    }

    @FXML
    private void supprimershow(ActionEvent event) throws IOException {
        Parent affichescene = FXMLLoader.load(getClass().getResource("Supprimerrec.fxml"));
        Scene affichage = new Scene(affichescene);
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.setScene(affichage);
        appstage.show();
        
    }

    

    @FXML
    private void cliqadmin(MouseEvent event) throws IOException {
        Notifications notificationBuilder = Notifications.create().
            title("Gestion Reclamation").text("ESPACE ADMIN").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
            .position(Pos.CENTER_RIGHT);
           
        notificationBuilder.darkStyle();
        notificationBuilder.show();
        Parent affichescene = FXMLLoader.load(getClass().getResource("Admininterface.fxml"));
        Scene affichage = new Scene(affichescene);
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.setScene(affichage);
        appstage.show();
    }

    @FXML
    private void afiichstat(MouseEvent event) throws IOException {
        Notifications notificationBuilder = Notifications.create().
            title("STATS").text("Statistque des reclamations").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
            .position(Pos.CENTER_LEFT);
           
        notificationBuilder.darkStyle();
        notificationBuilder.show();
        Parent affichescene = FXMLLoader.load(getClass().getResource("stat.fxml"));
        Scene affichage = new Scene(affichescene);
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.setScene(affichage);
        appstage.show();
    }

    @FXML
    private void gorate(MouseEvent event) throws IOException {
        Parent affichescene = FXMLLoader.load(getClass().getResource("AvisDG.fxml"));
        Scene affichage = new Scene(affichescene);
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.setScene(affichage);
        appstage.show();
        
    }
    
    
}
