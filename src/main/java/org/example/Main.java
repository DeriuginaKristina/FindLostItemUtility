package org.example;

import java.util.Random;
import java.util.Set;


public class Main {
    Set<String> blocklist = Set.of("ASS", "SEX", "FUCK", "P00", "BAD", "XXX");

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main main = new Main();
        for (int j = 0; j < 10; j++) {
            String s = main.generateCode3x3();
            System.out.println(s);
        }
    }

    public String generateCode3x3() {
        String chars = "ABCDEFGHJKMNPQRSTUVWXYZ23456789"; // 31 chars
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }

        //sb.append('-');

        for (int i = 0; i < 3; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }

        return sb.toString(); // e.g., "X7K-LQ9"
    }

    public boolean isCleanCode(String code) {
        String prefix = code.substring(0, 3); // check first block
        String suffix = code.substring(4);   // optional: check second block
        return !blocklist.contains(prefix) && !blocklist.contains(suffix);
    }


}