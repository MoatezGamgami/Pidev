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
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author moatez
 */
public class AjoutrecController implements Initializable {

    @FXML
    private Button envoyerbutton;
    @FXML
    private Button retour;
    @FXML
    private TextArea myreclamation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajoutrec(ActionEvent event) {
       ReclamationCrud pn = new ReclamationCrud();
        if(myreclamation.getText().trim().isEmpty()){
        Alert fail= new Alert(AlertType.INFORMATION);
        fail.setHeaderText("failure");
        fail.setContentText("you havent typed something");
        fail.showAndWait();
        } else if ( pn.Bad(myreclamation.getText())){
        Alert fail= new Alert(AlertType.INFORMATION);
        fail.setHeaderText("failure");
        fail.setContentText("Bad WORDS detected");
        fail.showAndWait();
        
    } else {
        
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirmation Dialog");
        alert.setContentText("Voulez-vous ajouter cette réclamation?");
        String z = myreclamation.getText();
        Reclamation h = new Reclamation(z);
        ReclamationCrud pz = new ReclamationCrud();
        
        
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
           pz.ajoutReclamation2(h);
           Alert alert2 = new Alert(AlertType.INFORMATION);
           alert2.setTitle("Information Dialog");
           alert2.setHeaderText(null);
           alert2.setContentText("Votre reclamation est ajoutée .. Merci!");

alert2.showAndWait();
Notifications notificationBuilder = Notifications.create().
            title("New Reclamation").text("Votre reclamation est ajoutée").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
            .position(Pos.CENTER_RIGHT);
           
        notificationBuilder.darkStyle();
        notificationBuilder.show();
         } else {
       alert.close();
    
         }
        }
        
        
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        Notifications notificationBuilder = Notifications.create().
            title("Gestion Recalamtion").text("ESPACE CLIENT").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
            .position(Pos.CENTER_LEFT);
           
        notificationBuilder.darkStyle();
        notificationBuilder.show();
        Parent affichescene = FXMLLoader.load(getClass().getResource("MenuGestion.fxml"));
        Scene affichage = new Scene(affichescene);
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.setScene(affichage);
        appstage.show();
    }
    
}
