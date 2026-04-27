package edu.uno.encodeco;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTest {

    @Test
    void encodeBinary(){
        String seedString = "Gordon, I need spices.";
        String expectedString = "1000111 1101111 1110010 1100100 1101111 1101110 101100 100000 1001001 100000 1101110 1100101 1100101 1100100 100000 1110011 1110000 1101001 1100011 1100101 1110011 101110 ";
        
        String encodedString = "";
        char[] ch = seedString.toCharArray();
     
        for (int i = 0; i < ch.length; i++){
            
            encodedString += Integer.toBinaryString(ch[i]) + " ";
        }

        assertEquals(expectedString, encodedString);
    }

    @Test
    void decodeBinary(){
        String seedString = "1000111 1101111 1110010 1100100 1101111 1101110 101100 100000 1001001 100000 1101110 1100101 1100101 1100100 100000 1110011 1110000 1101001 1100011 1100101 1110011 101110 ";
        String expectedString = "Gordon, I need spices.";

        String decodedString = "";
        StringBuilder result = new StringBuilder();

        String[] spaces = seedString.split(" ");

        for (String space : spaces) {

            int charCode = Integer.parseInt(space, 2);

            decodedString = result.append((char) charCode).toString();
        }

        assertEquals(expectedString, decodedString);
    }

}
