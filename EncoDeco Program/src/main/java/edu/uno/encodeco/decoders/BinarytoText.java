package edu.uno.encodeco.decoders;

import edu.uno.encodeco.ConverterType;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class BinarytoText implements ConverterType {
    
    @Override
    public String theConverter(String convertable) throws NumberFormatException{
        try{
            String decodedBin = "";
            StringBuilder result = new StringBuilder();

            String[] spaces = convertable.split(" ");

            for (String space : spaces) {

                int charCode = Integer.parseInt(space, 2);

                decodedBin = result.append((char) charCode).toString();
            }
            
            return decodedBin;
        } catch (NumberFormatException numFor) {
            System.out.println("Number format exception occured: " +numFor.getMessage());

            Alert dialog = new Alert(AlertType.NONE, "Please make sure the format is in Binary!", ButtonType.OK);
            dialog.setTitle("Incorrect Encoding Format Detected!");
            dialog.show();
            
        } catch (NullPointerException nul) {
                System.out.println("Null exception occured: " +nul.getMessage());
                Alert dialog = new Alert(AlertType.NONE, "Please upload a file before choosing decoder type.", ButtonType.OK);
                dialog.setTitle("Exception Occured!");
                dialog.show();

                //nul.printStackTrace();
        }

        return convertable;  // if stuff brokey, then it just returns the string it was given
        
    }

    @Override
    public String toString(){
        return "Binary to Text";
    }
}
