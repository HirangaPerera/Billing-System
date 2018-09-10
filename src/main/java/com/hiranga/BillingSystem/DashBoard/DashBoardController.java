package com.hiranga.BillingSystem.DashBoard;

import java.net.URL;
import java.util.ResourceBundle;

import com.hiranga.BillingSystem.SupplierForm.ProductTable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DashBoardController implements Initializable {
	 	@FXML
	    private TableColumn<ProductTable, String> clmnsellingprice;

	    @FXML
	    private TableColumn<ProductTable, String> clmnavailability;

	    @FXML
	    private TableColumn<ProductTable, String> clmncodeno;

	    @FXML
	    private TableColumn<ProductTable, String> clmnbuingprice;

	    @FXML
	    private TableView<ProductTable> clmndashboardtable;

	    @FXML
	    private TableColumn<?, ?> clmnitem;
ObservableList<ProductTable> oblist = new FXCollections.observableArrayList();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
public void getIten(ActionEvent e) {
	
}
}
