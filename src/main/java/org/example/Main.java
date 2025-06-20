package org.example;

import java.util.Random;
import java.util.Set;

public class Main {
    // Список запрещённых слов
    Set<String> blocklist = Set.of("ASS", "SEX", "FUCK", "P00", "BAD", "XXX");

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main main = new Main();

        for (int j = 0; j < 1; j++) {
            //      String s = main.generateCode3x3();
            String code = "ABSEXC";

            if (main.isCleanCode(code)) {
                System.out.println(code);
            }
        }
    }

    public String generateCode3x3() {
        String chars = "ABCDEFGHJKMNPQRSTUVWXYZ23456789"; // 31 символ
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }

        // Вы можете раскомментировать, если нужен дефис между блоками
        // sb.append('-');

        for (int i = 0; i < 3; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }

        return sb.toString(); // Например: "X7KLQ9"
    }

    public boolean isCleanCode(String code) {
        if (code.length() < 6 || code.length() > 6) return false; // защита от ошибок
        for (String badWord : blocklist) {
            if (code.contains(badWord)) {
                System.out.println("Code: " + code + " contains bad Word: " + badWord);
                return false;
            }
        }

        return true;
    }
}
