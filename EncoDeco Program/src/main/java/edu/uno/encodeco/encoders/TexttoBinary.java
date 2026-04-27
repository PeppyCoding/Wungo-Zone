package edu.uno.encodeco.encoders;

import edu.uno.encodeco.ConverterType;

public class TexttoBinary implements ConverterType {
    
    @Override
    public String theConverter(String convertable){
        String bin = "";
        char[] ch = convertable.toCharArray();
     
        for (int i = 0; i < ch.length; i++){
            
            bin += Integer.toBinaryString(ch[i]) + " ";
        }
        
        return bin;
        
    }

    @Override
    public String toString(){
        return "Text to Binary";
    }
}
