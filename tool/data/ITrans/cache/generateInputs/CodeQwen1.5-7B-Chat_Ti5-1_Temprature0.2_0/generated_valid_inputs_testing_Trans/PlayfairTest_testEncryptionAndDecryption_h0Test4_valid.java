package com.thealgorithms.ciphers;

import com.thealgorithms.ciphers.PlayfairTest_testEncryptionAndDecryption;

import com.thealgorithms.ciphers.PlayfairCipher;
import com.thealgorithms.ciphers.PlayfairCipher.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayfairTest_testEncryptionAndDecryption_h0Test4_valid {

    @Test
    public void testEncryptionAndDecryption_h0Test4() {
    PlayfairCipher playfairCipher = new PlayfairCipher("KEYWORD");
    String plaintext = "JAVAJAVA";
    String textTodecrypt  = PlayfairTest_testEncryptionAndDecryption.inputTransformation_testEncryptionAndDecryption(playfairCipher, plaintext);
        String encryptedText = playfairCipher.encrypt(plaintext);
        String decryptedText = playfairCipher.decrypt(textTodecrypt);
        assertEquals(plaintext, decryptedText);
    }
}
