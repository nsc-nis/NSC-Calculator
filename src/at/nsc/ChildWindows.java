package at.nsc;

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

/**
 * NSC Calculator
 * @author Niklas Schachl
 * @version 1.3, 3.10.2020
 */
public class ChildWindows
{
    public static void aboutWindow(Stage stage)
    {
        Stage stage_aboutStage = new Stage();
        stage_aboutStage.initOwner(stage);
        stage_aboutStage.getIcons().add(new Image("at/nsc/NIS Logo1.png"));

        VBox box_about = new VBox(10);
        box_about.setPadding(new Insets(70));
        box_about.setStyle("-fx-text-align: center;");
        box_about.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        ObservableList list_about = box_about.getChildren();

        Image image_aboutIcon = new Image(ChildWindows.class.getResource("at/nsc/NIS Logo2.png").toExternalForm());
        ImageView imageView_aboutIconView = new ImageView(image_aboutIcon);
        imageView_aboutIconView.setFitHeight(200);
        imageView_aboutIconView.setFitWidth(100);
        list_about.add(imageView_aboutIconView);


        Text text_name = new Text("NSC Calculator");
        text_name.setFont(Font.font("Verdana", 16));
        Text text_version = new Text("Version: 1.3");
        text_version.setFont(Font.font("Verdana", 16));
        Text text_about = new Text("Ein einfacher Taschenrechner");
        text_about.setFont(Font.font("Verdana", 16));
        Text text_copyright = new Text("Copyright (C)2018 - 2020 NSC IT Solutions");
        text_copyright.setFont(Font.font("Verdana", 16));
        list_about.addAll(text_name, text_version, text_copyright, text_about);

        Button button_aboutClose = new Button("Schließen");
        button_aboutClose.setStyle("-fx-font-size:15;-fx-font-weight: bold");
        EventHandler<MouseEvent> eventHandler_aboutCloseHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                stage_aboutStage.close();
            }
        };
        button_aboutClose.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler_aboutCloseHandler);
        list_about.add(button_aboutClose);

        Scene aboutScene = new Scene(box_about, 450, 470);
        stage_aboutStage.setTitle("Über NSC Calculator");
        stage_aboutStage.setScene(aboutScene);

        stage_aboutStage.show();
    }

    public static void loadingWindow(Stage stage)
    {
        //Stage
        Stage stage_loadingStage = new Stage();
        stage_loadingStage.initOwner(stage);
        stage_loadingStage.setTitle("NSC Calculator wird gestartet...");

        //set Icon
        stage_loadingStage.getIcons().add(new Image("NIS Logo1.png"));

        //Main Box settings
        VBox box_main = new VBox(10);
        box_main.setPadding(new Insets(70));
        box_main.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        box_main.setStyle("-fx-text-align: center;");
        ObservableList list_main = box_main.getChildren();

        //Scene settings
        Scene scene = new Scene(box_main, 450, 470);
        stage_loadingStage.setScene(scene);

        //Logo
        Image image_logo = new Image(ChildWindows.class.getResource("NIS Logo2.png").toExternalForm());
        ImageView imageView_aboutIconView = new ImageView(image_logo);
        imageView_aboutIconView.setFitHeight(200);
        imageView_aboutIconView.setFitWidth(100);
        list_main.add(imageView_aboutIconView);

        //Text 1
        Text text_loadingText1 = new Text("NSC Calculator wird gestartet...");
        text_loadingText1.setFont(Font.font("Verdana", 45));
        list_main.add(text_loadingText1);

        //Text 2
        Text text_loadingText2 = new Text("NSC Calculator wird gestartet...");
        text_loadingText2.setFont(Font.font("Verdana", 16));
        list_main.add(text_loadingText2);

        //Show
        stage_loadingStage.setScene(scene);
        stage_loadingStage.show();

        //wait
        try
        {
            Thread.sleep(5000);
        }
        catch (Exception ex)
        {

        }

        //close
        stage_loadingStage.close();
    }
}

