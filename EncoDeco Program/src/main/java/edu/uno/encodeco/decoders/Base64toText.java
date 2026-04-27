package edu.uno.encodeco.decoders;

import java.util.Base64;

import edu.uno.encodeco.ConverterType;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Base64toText implements ConverterType{

    @Override 
    public String theConverter(String convertable) throws IllegalArgumentException {
        try{         
            byte[] b64 = Base64.getDecoder().decode(convertable.getBytes());

            String decoded64 = new String(b64);

            return decoded64;

        } catch (IllegalArgumentException illArg) {
            System.out.println("Illegal argument exception occured: " +illArg.getMessage());

            Alert dialog = new Alert(AlertType.NONE, "Please make sure the format is in Base 64!", ButtonType.OK);
            dialog.setTitle("Incorrect Encoding Format Detected!");
            dialog.show();
            
        } catch (NullPointerException nul) {
                System.out.println("Null exception occured: " +nul.getMessage());
                Alert dialog = new Alert(AlertType.NONE, "Please upload a file before choosing decoder type.", ButtonType.OK);
                dialog.setTitle("Exception Occured!");
                dialog.show();

                //nul.printStackTrace();
        }
        return convertable;
    }

    @Override
    public String toString(){
        return "Base 64 to Text";
    }
}
