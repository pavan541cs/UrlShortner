package org.example.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ShortLinkUtils {
    private static final int NUM_CHARS_SHORT_LINK = 7;
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    @Autowired
    private Random random;
    public String createShortLink(String url) {
        char[] result = new char[NUM_CHARS_SHORT_LINK];
        while (true) {
            for (int i = 0; i < NUM_CHARS_SHORT_LINK; i++) {
                int randomIndex = random.nextInt(ALPHABET.length() - 1);
                result[i] = ALPHABET.charAt(randomIndex);
            }
            String shortLink = new String(result);
            // TODO: make sure the short link isn't already used
//            if (!DB.checkShortLinkExists(shortLink)) {
//                return shortLink;;
//            }
            return  shortLink;
        }
    }
}
