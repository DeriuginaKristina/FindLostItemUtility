package org.example;

import java.util.Map;
import java.util.Random;
import java.util.Set;


public class CodeGenerator {
    private static final String VALID_CHARS = "ABCDEFGHJKMNPQRSTUVWXYZ23456789";
    private static final Map<Character, Integer> CHAR_MAP = MainByAndrej.CHAR_MAP; // см. твой фиксированный Map
    private static final Set<String> BLOCKLIST = MainByAndrej.BLOCKLIST;

    private final Random random = new Random();

    public String generateFullCode() {
        String part6;
        String cc;
        String fullCode;

        do {
            part6 = generateRandomPart();
            cc = generateControlCharacters(part6);
            fullCode = part6.substring(0, 4) + "-" + part6.substring(4) + cc;
        } while (containsBadWord(fullCode));

        return fullCode;
    }


    private String generateRandomPart() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            char c = VALID_CHARS.charAt(random.nextInt(VALID_CHARS.length()));
            sb.append(c);
        }
        return sb.toString(); // e.g., "X7KPQ2"
    }

    private String generateControlCharacters(String part6) {
        int sum = 0;
        for (char c : part6.toCharArray()) {
            sum += CHAR_MAP.getOrDefault(c, 0);
        }

        if (sum % 2 == 0) return algorithmA(part6);
        else if (sum % 3 == 0) return algorithmB(part6);
        else if (sum % 5 == 0) return algorithmC(part6);
        else return fallbackAlgorithm(part6);
    }

    private boolean containsBadWord(String code) {
        String upperCode = code.toUpperCase();
        for (String bad : BLOCKLIST) {
            if (upperCode.contains(bad)) {
                return true;
            }
        }
        return false;
    }


    private String algorithmA(String part6) {
        int val1 = CHAR_MAP.get(part6.charAt(0));
        int val2 = CHAR_MAP.get(part6.charAt(5));
        return indexToChars((val1 + val2) % 31, (val1 * val2) % 31);
    }

    private String algorithmB(String part6) {
        int evenSum = 0, oddSum = 0;
        for (int i = 0; i < part6.length(); i++) {
            int val = CHAR_MAP.get(part6.charAt(i));
            if (i % 2 == 0) evenSum += val;
            else oddSum += val;
        }
        return indexToChars(evenSum % 31, (evenSum ^ oddSum) % 31);
    }

    private String algorithmC(String part6) {
        String first3 = part6.substring(0, 3);
        int hash = first3.hashCode();
        return indexToChars(Math.abs(hash) % 31, Math.abs(hash / 31) % 31);
    }

    private String fallbackAlgorithm(String part6) {
        int sum = 0;
        for (char c : part6.toCharArray()) {
            sum += CHAR_MAP.getOrDefault(c, 0);
        }
        return indexToChars(sum % 31, (sum * 2 + 17) % 31);
    }

    public boolean isCodeValid(String code) {
        if (code == null || code.length() != 9 || code.charAt(4) != '-') return false;

        String part6 = code.substring(0, 4) + code.substring(5, 7); // без '-'
        String cc = code.substring(7); // контрольные 2 символа

        if (containsBadWord(code)) return false;
        String expectedCC = generateControlCharacters(part6);

        return cc.equals(expectedCC);
    }


    private String indexToChars(int idx1, int idx2) {
        return "" + VALID_CHARS.charAt(idx1) + VALID_CHARS.charAt(idx2);
    }
}

