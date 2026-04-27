package edu.uno.encodeco;
import edu.uno.encodeco.encoders.*;
import edu.uno.encodeco.decoders.*;

public class ConverterMenu {
    
    public int interp;
    public String radio;
    public String convertaString;
    ConverterType theDecider;


    public ConverterMenu(String radio, int interp, String convertable){
        this.radio = radio;
        this.interp = interp;
        
        ConverterType t = switch(radio){                         // Strategy Pattern
            case "Encoding" -> switch(interp){               // Is this way of doing it efficient?
                case 0 -> new TexttoBase64();                // I don't know!
                case 1 -> new TexttoHex();                   // But it looks nice :D
                case 2 -> new TexttoBinary();
                default -> null;
            };
            case "Decoding" -> switch(interp){
                case 0 -> new Base64toText();
                case 1 -> new HextoText();
                case 2 -> new BinarytoText();
                default -> null;
            };
            default -> null;
        };
        if (t == null){
            System.out.println("How did you press a fourth Button?");
        };

        this.convertaString = convertable;
        this.theDecider = t;
        
    }

    public String getConversion(){
        return theDecider.theConverter(convertaString);
    }
    public String getName(){
        return theDecider.toString();
    }
}
