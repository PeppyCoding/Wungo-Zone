package edu.uno.encodeco;

import org.junit.jupiter.api.Test;
import java.util.Base64;
import static org.junit.jupiter.api.Assertions.*;



public class Base64Test {
    
    @Test
    void encodeBase64(){
        String seedString = "Hello World!";
        String expectedString = "SGVsbG8gV29ybGQh";

        String encodedString = Base64.getEncoder().encodeToString(seedString.getBytes());

        assertEquals(expectedString, encodedString);
    }

    @Test
    void decodeBase64(){
        String seedString = "VGhpcyBzdGF0ZW1lbnQgaXMgZmFsc2Uh";
        String expectedString = "This statement is false!";

        byte[] b64 = Base64.getDecoder().decode(seedString.getBytes());

        String decodedString = new String(b64);

        assertEquals(expectedString, decodedString);
    }
}
