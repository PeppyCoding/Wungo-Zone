package edu.uno.encodeco.encoders;

import java.util.HexFormat;

import edu.uno.encodeco.ConverterType;

public class TexttoHex implements ConverterType {

    @Override
    public String theConverter(String convertable){
        byte[] bytes = convertable.getBytes();

        String hex = HexFormat.of().withUpperCase().withDelimiter(" ").formatHex(bytes);

        return hex;
    }

    @Override
    public String toString(){
        return "ASCII to Hexadecimal";
    }

}
