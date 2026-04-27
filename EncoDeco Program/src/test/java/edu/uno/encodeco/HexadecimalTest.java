package edu.uno.encodeco;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HexFormat;

public class HexadecimalTest {

    @Test
    void encodeHex(){
        String seedString = "The student stayed up late finishing his Unit Tests.";
        String expectedString = "54 68 65 20 73 74 75 64 65 6E 74 20 73 74 61 79 65 64 20 75 70 20 6C 61 74 65 20 66 69 6E 69 73 68 69 6E 67 20 68 69 73 20 55 6E 69 74 20 54 65 73 74 73 2E";

        byte[] bytes = seedString.getBytes();

        String encodedString = HexFormat.of().withUpperCase().withDelimiter(" ").formatHex(bytes);        

        assertEquals(expectedString, encodedString);
    }

    @Test
    void decodeHex(){
        String seedString = "41 6E 20 61 70 70 6C 65 20 61 20 64 61 79 20 6B 65 65 70 73 20 74 68 65 20 64 6F 63 74 6F 72 20 61 77 61 79 2E";
        String expectedString = "An apple a day keeps the doctor away.";

        byte[] bytes = HexFormat.of().withUpperCase().withDelimiter(" ").parseHex(seedString);

        String decodedString = new String(bytes);

        assertEquals(expectedString, decodedString);
    }
}
