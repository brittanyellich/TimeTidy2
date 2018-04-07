/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bhellersoftwareii;

import bhellersoftwareii.CustomerAppointment;
import bhellersoftwareii.MonthAppointmentButton;
import bhellersoftwareii.HomeController;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Britt
 */
public class AppointmentDetailsController implements Initializable {

    
    public static CustomerAppointment currentAppointment = new CustomerAppointment();
    String clickedButton = HomeController.getClickedButtonID();
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("Appointment ID for this button is " + clickedButton);
        ApptIDLabel.setText(clickedButton);
        CustomerAppointment thisAppointment = new CustomerAppointment().getAppointmentDetails(clickedButton);
        ApptTitleLabel.setText(thisAppointment.getAppointmentTitle());
        ApptDescriptionLabel.setText(thisAppointment.getAppointmentDescription());
        ApptLocationLabel.setText(thisAppointment.getAppointmentLocation());
        ApptContactLabel.setText(thisAppointment.getAppointmentContact());
        ApptURLLabel.setText(thisAppointment.getAppointmentURL());
        ApptStartTimeLabel.setText(thisAppointment.getStartTime());
        ApptEndTimeLabel.setText(thisAppointment.getEndTime());
        ApptLastUpdatedByLabel.setText(thisAppointment.getAppointmentLastUpdatedBy());
    }    
    
    @FXML
    private Button ApptDetailsCloseButton;

    @FXML
    private Button ApptDetailsEditButton;

    @FXML
    private Button ApptDetailsDeleteButton;

    @FXML
    private Label ApptTitleLabel;

    @FXML
    private Label ApptDescriptionLabel;

    @FXML
    private Label ApptLocationLabel;

    @FXML
    private Label ApptIDLabel;

    @FXML
    private Label ApptContactLabel;

    @FXML
    private Label ApptURLLabel;

    @FXML
    private Label ApptStartTimeLabel;

    @FXML
    private Label ApptEndTimeLabel;

    @FXML
    private Label ApptLastUpdatedByLabel;

    @FXML
    void ApptDetailsCloseButtonClicked(ActionEvent event) {
       Stage stage = (Stage) ApptDetailsCloseButton.getScene().getWindow();
       stage.close();
    }

    @FXML
    void ApptDetailsDeleteButtonClicked(ActionEvent event) {
        System.out.println("Appointment Delete button clicked");
    }

    @FXML
    void ApptDetailsEditButtonClicked(ActionEvent event) throws IOException {
        System.out.println("Appointment Edit button clicked");
        Parent modAppt = FXMLLoader.load(getClass().getResource("ModifyAppointment.fxml"));
        Scene modApptScene = new Scene(modAppt);
        Stage modApptStage = new Stage();
        modApptStage.setScene(modApptScene);
        modApptStage.show();

    }
    
    
    
}
