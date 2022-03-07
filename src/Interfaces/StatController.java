/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import edu.esprit.crud.ReclamationCrud;
import edu.esprit.entites.Reclamation;
import edu.esprit.entites.count0;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import static jdk.nashorn.internal.objects.NativeArray.slice;

/**
 * FXML Controller class
 *
 * @author moatez
 */
public class StatController implements Initializable {

  
    
    @FXML
    private PieChart Piechart;
    @FXML
    private TableView<count0> Table;
    @FXML
    private TableColumn<count0, String> Region;
    @FXML
    private TableColumn<count0, Integer> nombrenonrepondu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        // TODO
    }    

    @FXML
    private void show(ActionEvent event) {
        List<count0> mylist = new ArrayList<>();
        ReclamationCrud pp = new ReclamationCrud();
        mylist=pp.affichecount();
        
        Region.setCellValueFactory(new PropertyValueFactory<count0,String>("Region"));
        nombrenonrepondu.setCellValueFactory(new PropertyValueFactory<count0,Integer>("nombrenonrepondu"));
        ObservableList<count0> list = FXCollections.observableArrayList(mylist);
        Table.setItems((list));
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        
      for (int i = 0; i < mylist.size(); i++) {
        pieChartData.add(new PieChart.Data(mylist.get(i).getRegion(),mylist.get(i).getNombrenonrepondu()));
    	Piechart.setData(pieChartData);
        
    	}
        
    	}
        
      
        
           
    

    @FXML
    private void retour(ActionEvent event) throws IOException {
        Parent affichescene = FXMLLoader.load(getClass().getResource("MenuGestion.fxml"));
        Scene affichage = new Scene(affichescene);
        Stage appstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appstage.setScene(affichage);
        appstage.show();
    }
    
    
}
