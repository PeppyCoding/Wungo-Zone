package edu.uno.encodeco;


public interface ConverterType {  
    
    @Override
    public String toString();

    // All encoders MUST have method theConverter, this allows for the menu class to pull the conversion functions from this
    public String theConverter(String placeholder);
    
} 