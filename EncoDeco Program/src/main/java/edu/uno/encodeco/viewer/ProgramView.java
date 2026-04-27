package edu.uno.encodeco.viewer;
import edu.uno.encodeco.ConverterMenu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.FileChooser;


public class ProgramView extends Application {
    String toConvert; //The important one that holds the file.
    String radio = "Encoding";     //The one that tells if program encodes or decodes.

    @Override
    public void start(Stage stage) throws IOException, NullPointerException{

        TextArea outputArea = new TextArea();
        outputArea.setWrapText(true);
        outputArea.setEditable(false);

        Button uploadButton = new Button("Choose File");
        //FILE I/O for uploadButton
        uploadButton.setOnAction(e -> {
            FileChooser chooseFile = new FileChooser();
            fancyFileChooser(chooseFile);
            File file = chooseFile.showOpenDialog(stage);
            String content = null;

            try {
                content = Files.readString(file.toPath());
            } catch (IOException io) {
                System.out.println("IOException occured: " +io.getMessage());
                io.printStackTrace();
            } catch (NullPointerException nul) {
                System.out.println("Null exception occured: " +nul.getMessage());
                Alert dialog = new Alert(AlertType.NONE, "Please choose a file to upload.", ButtonType.OK);
                dialog.setTitle("Exception Occured!");
                dialog.show();

                //nul.printStackTrace();
            }
            toConvert = content;

            outputArea.setText(content); // TO TEST IF THAT  WORKS
        });

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15,12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: aquamarine;");

        Text hTitle = new Text ("Conversion Option");
        hTitle.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 14));
        
        ToggleGroup group = new ToggleGroup();
        RadioButton encoderChoice = new RadioButton(" Encoding ");
        encoderChoice.setPrefSize(100, 20);
        encoderChoice.setToggleGroup(group);
        encoderChoice.getStyleClass().remove("radio-button");
        encoderChoice.getStyleClass().add("toggle-button");
        encoderChoice.setUserData("Encoding");
        encoderChoice.setSelected(true);
        
        RadioButton decoderChoice = new RadioButton(" Decoding ");
        decoderChoice.setPrefSize(100, 20);
        decoderChoice.setToggleGroup(group);
        decoderChoice.getStyleClass().remove("radio-button");
        decoderChoice.getStyleClass().add("toggle-button");
        decoderChoice.setUserData("Decoding");   
    
        hbox.getChildren().addAll(hTitle, encoderChoice, decoderChoice);

        
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);

        Text vTitle =  new Text ("Encoding Types.");
        vTitle.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 14));
        vbox.getChildren().add(vTitle);

        group.selectedToggleProperty().addListener((observable, oldToggle, newToggle) -> {
            if (newToggle != null) {
                RadioButton chosen = (RadioButton) newToggle;
                radio = (String) chosen.getUserData();
                vTitle.setText(radio + " Types.");
            }
        });           

        Button[] choices = new Button[] {
            new Button("Base64"),
            new Button("Hex"),
            new Button("Binary")};
        
        for (int i=0; i<3; i++) {
            choices[i].setUserData(i);
            VBox.setMargin(choices[i],new Insets(0,0,0,8));
            vbox.getChildren().add(choices[i]);
        }
        //MAKE THE BUTTONS DO THE CONVERTO PRESTO
        //EDITION 2: ONE LAMBDA FOR THREE BUTTONS HAHAHA
        for (Button btn : choices){
            
            btn.setOnAction(e -> {
                int i = (Integer) btn.getUserData();
                String r = radio;
                ConverterMenu interpreter = new ConverterMenu(r, i, toConvert);
                String output = interpreter.getConversion();
                
                outputArea.setText(output);
            });
        }

        GridPane gpane = new GridPane();
        gpane.setHgap(10);
        gpane.setVgap(20);
        gpane.setPadding(new Insets(10,10,10,10));
        //gpane.getColumnConstraints().add(new ColumnConstraints(75));

        gpane.addRow(1, uploadButton);
        gpane.addRow(0, new Label("Output:"), outputArea);


        // Building the GUI's prettyness
        BorderPane bPane = new BorderPane();
        bPane.setTop(hbox);
        bPane.setLeft(vbox);
        bPane.setCenter(gpane);

        Scene scene = new Scene(bPane, 870, 540);

        stage.setScene(scene);
        stage.setTitle("Carter's Compact Conversion Program");
        stage.show();
    }

    private static void fancyFileChooser(final FileChooser chooseFile){
        chooseFile.setTitle("Choose Text File");
        chooseFile.setInitialDirectory(
            new File(System.getProperty("user.dir"))
        );
        chooseFile.getExtensionFilters().add(
            new FileChooser.ExtensionFilter("TXT", "*.txt")
        );
    }
    /* public static void main(String[] args){
        
        ProgramView.launch(ProgramView.class, args); 
    } */
}

