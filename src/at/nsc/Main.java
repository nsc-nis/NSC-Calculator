package at.nsc;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * NSC Calculator
 * @author Niklas Schachl
 * @version 1.3, 3.10.2020
 */
public class Main extends Application
{
    ArrayList<Double> arrayList_inputs = new ArrayList<Double>();
    ArrayList<Integer> arrayList_operations = new ArrayList<Integer>();
    StringBuilder sb = new StringBuilder();
    String string_value = "";
    double result = 0;

    @Override
    public void start(Stage stage) throws Exception
    {
        //loading screen
        /*
        ChildWindows.loadingWindow(stage);
        Aus irgendeinem Grund funktioniert diese Funktion bei mir nicht. Es wird nur ein sehr sehr kleines Fenster bei mir angezeigt, kann aber auch an meinem Rechner liegen
         */

        //set Icon
        stage.getIcons().add(new Image("/at/nsc/NIS Logo1.png"));

        //Main Box settings
        VBox box_main = new VBox(10);
        box_main.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        ObservableList list_main = box_main.getChildren();

        //Scene settings
        Scene scene = new Scene(box_main, 750, 650);
        stage.setScene(scene);

        //text result
        Text text_result = new Text("0");
        text_result.setStyle("-fx-font-size:45;-fx-font-weight: bold");

        //Welcome Box
        HBox box_welcome = new HBox();
        box_welcome.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        ObservableList list_welcome = box_welcome.getChildren();

        //Button box
        HBox box_buttons = new HBox();
        box_buttons.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        ObservableList list_buttons = box_buttons.getChildren();

        //button box 2
        VBox box_buttons2 = new VBox();
        box_buttons2.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        ObservableList list_buttons2 = box_buttons2.getChildren();

        //Button box 3
        VBox box_buttons3 = new VBox();
        box_buttons3.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        ObservableList list_buttons3 = box_buttons3.getChildren();

        //Logo
        Image image_welcomeLogo = new Image(getClass().getResource("NIS Logo1.png").toExternalForm());
        ImageView imageView_aboutIconView = new ImageView(image_welcomeLogo);
        imageView_aboutIconView.setFitHeight(145);
        imageView_aboutIconView.setFitWidth(130);
        list_welcome.add(imageView_aboutIconView);

        //Welcome Text1
        Text text_welcome1 = new Text(String.format("Willkommen bei%nNSC Calculator!"));
        text_welcome1.setFont(Font.font ("Verdana", 60));
        list_welcome.add(text_welcome1);

        //EventHandler Operations
        EventHandler<MouseEvent> eventHandler_operationsHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e)
            {
                Object node = e.getSource(); //returns the object that generated the event
                Button btn = (Button)node;   //get the button
                String s = btn.getText();    //get text from button
                double value = 0;

                /*
                + = 1
                - = 2
                * = 3
                / = 4
                 */

                if (s.equals("="))
                {
                    string_value = "";
                    string_value = sb.toString();
                    //text_result.setText(string_value);
                    value = Double.parseDouble(string_value);
                    arrayList_inputs.add(value);
                    sb.delete(0, sb.length());

                    double value1 = arrayList_inputs.get(0);
                    double value2 = arrayList_inputs.get(1);
                    int counter = 0;

                    for (int i = 1; i < arrayList_inputs.size(); i++) {
                        if (i > 1) {
                            value1 = result;
                            value2 = arrayList_inputs.get(i);
                            System.out.println(value2);
                        }

                        int operation = arrayList_operations.get(counter);
                        switch (operation) {
                            case 1:
                                result = value1 + value2;
                                counter++;
                                break;
                            case 2:
                                result = value1 - value2;
                                counter++;
                                break;
                            case 3:
                                result = value1 * value2;
                                counter++;
                                break;
                            case 4:
                                result = value1 / value2;
                                counter++;
                        }
                    }
                    text_result.setText(String.format("%f", result));
                }
                else
                {
                    switch (s)
                    {
                        case "+":
                            string_value = "";
                            string_value = sb.toString();
                            //text_result.setText(string_value);
                            value = Double.parseDouble(string_value);
                            string_value = "";
                            sb.delete(0, sb.length());
                            arrayList_inputs.add(value);

                            arrayList_operations.add(1);
                            break;
                        case "-":
                            string_value = "";
                            string_value = sb.toString();
                            text_result.setText(string_value);
                            value = Double.parseDouble(string_value);
                            string_value = "";
                            sb.delete(0, sb.length());
                            arrayList_inputs.add(value);

                            arrayList_operations.add(2);
                            break;
                        case "*":
                            string_value = "";
                            string_value = sb.toString();
                            text_result.setText(string_value);
                            value = Double.parseDouble(string_value);
                            string_value = "";
                            sb.delete(0, sb.length());
                            arrayList_inputs.add(value);

                            arrayList_operations.add(3);
                            break;
                        case "÷":
                            string_value = "";
                            string_value = sb.toString();
                            text_result.setText(string_value);
                            value = Double.parseDouble(string_value);
                            string_value = "";
                            sb.delete(0, sb.length());
                            arrayList_inputs.add(value);

                            arrayList_operations.add(4);
                            break;
                        case ",":
                            string_value = "";
                            sb.append(".");
                            string_value = sb.toString();

                            text_result.setText(string_value);
                            break;
                        default:
                            string_value = "";
                            sb.append(s);
                            string_value = sb.toString();

                            text_result.setText(string_value);
                            break;
                    }
                }
            }
        };

        //EventHandler clear
        EventHandler<MouseEvent> eventHandler_clearHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                arrayList_inputs.clear();
                arrayList_operations.clear();
                string_value = "";
                sb.delete(0, sb.length());
                text_result.setText("0");
            }
        };

        //EventHandler about
        EventHandler<MouseEvent> eventHandler_aboutHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ChildWindows.aboutWindow(stage);
            }
        };

        //EventHandler close
        EventHandler<MouseEvent> eventHandler_closeHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                stage.close();
            }
        };

        //Left keypad (Buttons)
        GridPane grid_buttons1 = new GridPane();

        ArrayList<String> buttons1 = new ArrayList<String>();
        buttons1.add("7");
        buttons1.add("8");
        buttons1.add("9");
        buttons1.add("4");
        buttons1.add("5");
        buttons1.add("6");
        buttons1.add("1");
        buttons1.add("2");
        buttons1.add("3");
        buttons1.add(",");
        buttons1.add("0");
        buttons1.add("=");

        for(String s : buttons1) {
            Button btn = new Button();
            int index = buttons1.indexOf(s);
            grid_buttons1.add(btn, index % 3, index / 3);
            btn.setText(s);
            btn.setMinWidth(100);
            btn.setMinHeight(100);
            btn.setStyle("-fx-font-size:45;-fx-font-weight: bold");
            btn.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler_operationsHandler);
        }
        list_buttons.add(grid_buttons1);

        //right keypad(buttons)
        Button button_plus = new Button("+");
        button_plus.setMinWidth(100);
        button_plus.setStyle("-fx-font-size:45;-fx-font-weight: bold");
        button_plus.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler_operationsHandler);
        list_buttons2.add(button_plus);

        Button button_minus = new Button("-");
        button_minus.setMinWidth(100);
        button_minus.setMinHeight(100);
        button_minus.setStyle("-fx-font-size:45;-fx-font-weight: bold");
        button_minus.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler_operationsHandler);
        list_buttons2.add(button_minus);

        Button button_multiply = new Button("*");
        button_multiply.setMinWidth(100);
        button_multiply.setMinHeight(100);
        button_multiply.setStyle("-fx-font-size:45;-fx-font-weight: bold");
        button_multiply.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler_operationsHandler);
        list_buttons2.add(button_multiply);

        Button button_divide = new Button("÷");
        button_divide.setMinWidth(100);
        button_divide.setMinHeight(100);
        button_divide.setStyle("-fx-font-size:45;-fx-font-weight: bold");
        button_divide.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler_operationsHandler);
        list_buttons2.add(button_divide);

        Button button_clear = new Button("Clear");
        button_clear.setMinWidth(100);
        button_clear.setMinHeight(100);
        button_clear.setStyle("-fx-font-size:45;-fx-font-weight: bold");
        button_clear.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler_clearHandler);
        list_buttons3.add(button_clear);

        Button button_about = new Button("Über");
        button_about.setMinWidth(100);
        button_about.setMinHeight(100);
        button_about.setStyle("-fx-font-size:45;-fx-font-weight: bold");
        button_about.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler_aboutHandler);
        list_buttons3.add(button_about);

        Button button_close = new Button("Beenden");
        button_close.setMinWidth(100);
        button_close.setMinHeight(100);
        button_close.setStyle("-fx-font-size:45;-fx-font-weight: bold");
        button_close.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler_closeHandler);
        list_buttons3.add(button_close);

        list_buttons.add(box_buttons2);
        list_buttons.add(box_buttons3);

        //Add everything to box_main
        list_main.add(box_welcome);
        list_main.add(text_result);
        list_main.add(box_buttons);

        //stage settings
        stage.setTitle("NSC Calculator");
        stage.show();
    }
}