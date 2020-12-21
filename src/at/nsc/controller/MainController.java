package at.nsc.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import at.nsc.model.Model;

/**NSC Calculator - MainController
 * @author Niklas Schachl
 * @version 1.4, 21.12.2020
 */
public class MainController
{
    private Stage stage;
    private StringBuilder inputs = new StringBuilder();
    private StringBuilder numbers = new StringBuilder();
    private int indexOfSB;

    @FXML
    private Label label_input;

    public static void show(Stage stage)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/at/nsc/view/mainView.fxml"));
            Parent root = fxmlLoader.load();

            //get controller which is connected to this fxml file
            MainController ctrl = fxmlLoader.getController();
            ctrl.stage = stage;

            stage.getIcons().add(new Image("/at/nsc/images/icon_logo.png"));
            stage.setTitle("NIS RPN Calculator");
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (Exception exception)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Internal Error");
            alert.setContentText(String.format("An internal Error occurred. Please restart the program%nor contact the developer on GitHub%n%nError message: %s", exception.getMessage()));
            alert.showAndWait();
            System.err.println(exception.getMessage());
            exception.printStackTrace(System.err);
        }
    }

    @FXML
    private void action_number(ActionEvent event)
    {
        Object node = event.getSource();
        Button button = (Button)node;

        inputs.append(button.getText());
        indexOfSB = inputs.indexOf(button.getText());
        numbers.append(button.getText());
        label_input.setText(inputs.toString());
    }

    @FXML
    private void action_enter()
    {
        Model.add(numbers.toString());
        numbers.delete(0, numbers.length());

        double result = Model.calculate();
        inputs.append("=");
        inputs.append(result);
        label_input.setText(inputs.toString());
        clear();
    }

    @FXML
    private void action_C()
    {
        inputs.deleteCharAt(indexOfSB);
        label_input.setText(inputs.toString());
    }

    @FXML
    private void action_clear()
    {
        label_input.setText("");
        clear();
    }

    @FXML
    private void action_operators(ActionEvent event)
    {
        Model.add(numbers.toString());
        numbers.delete(0, numbers.length());

        Object node = event.getSource();
        Button button = (Button)node;

        inputs.append(button.getText());
        indexOfSB = inputs.indexOf(button.getText());
        Model.add(button.getText());
        label_input.setText(inputs.toString());
    }

    @FXML
    private void action_point(ActionEvent event)
    {
        Object node = event.getSource();
        Button button = (Button)node;

        inputs.append(button.getText());
        indexOfSB = inputs.indexOf(button.getText());
        numbers.append(".");
        label_input.setText(inputs.toString());
    }

    @FXML
    private void action_divide(ActionEvent event)
    {
        Model.add(numbers.toString());
        numbers.delete(0, numbers.length());

        Object node = event.getSource();
        Button button = (Button)node;

        inputs.append(button.getText());
        indexOfSB = inputs.indexOf(button.getText());
        Model.add("/");
        label_input.setText(inputs.toString());
    }

    @FXML
    private void action_about()
    {
        AboutController.show(stage);
    }

    public void clear()
    {
        numbers.delete(0, numbers.length());
        inputs.delete(0, inputs.length());
    }
}
