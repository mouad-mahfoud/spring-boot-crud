package com.demo.app.ws.shared.utils;


import java.security.SecureRandom;
import java.util.Random;

public class EntityUtils {

    private EntityUtils() {
        throw new RuntimeException("Should not instantiate this class");
    }

    public static String generateStrongId(int idLenght){
        Random RANDOM = new SecureRandom();
        String ALPHABET = "1234567890AZERTYUIOPQSDFGHJKLMWXCVBNazertyuiopqsdfghjklmwxcvbn";
        StringBuilder str = new StringBuilder(idLenght);

        for (int i = 0; i< idLenght; i++){
            str.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return new String(str);
    }
}
