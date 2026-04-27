package edu.uno.encodeco.encoders;

import java.util.Base64;

import edu.uno.encodeco.ConverterType;

public class TexttoBase64 implements ConverterType{

    @Override
    public String theConverter(String convertable){
             
        String b64 = Base64.getEncoder().encodeToString(convertable.getBytes());

        return b64;
    }

    @Override
    public String toString(){
        return "Text to Base 64";
    }
}
