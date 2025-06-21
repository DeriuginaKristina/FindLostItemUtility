package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainByAndrej {
    public static final Map<Character, Integer> CHAR_MAP = Map.ofEntries(
            Map.entry('A', 84),
            Map.entry('B', 147),
            Map.entry('C', 56),
            Map.entry('D', 35),
            Map.entry('E', 154),
            Map.entry('F', 63),
            Map.entry('G', 91),
            Map.entry('H', 7),
            Map.entry('J', 98),
            Map.entry('K', 140),
            Map.entry('M', 105),
            Map.entry('N', 49),
            Map.entry('P', 28),
            Map.entry('Q', 112),
            Map.entry('R', 21),
            Map.entry('S', 70),
            Map.entry('T', 133),
            Map.entry('U', 119),
            Map.entry('V', 42),
            Map.entry('W', 77),
            Map.entry('X', 14),
            Map.entry('Y', 126),
            Map.entry('Z', 168),
            Map.entry('2', 161),
            Map.entry('3', 175),
            Map.entry('4', 182),
            Map.entry('5', 189),
            Map.entry('6', 196),
            Map.entry('7', 203),
            Map.entry('8', 210),
            Map.entry('9', 217)
    );

    public static final Set<String> BLOCKLIST = Set.of("ASS", "SEX", "FUCK", "BAD", "P00", "XXX");

    public static void main(String[] args) {
        CodeGenerator gen = new CodeGenerator();
        String code = gen.generateFullCode();
        System.out.println(code); // → G5XP-7QFH
        System.out.println(gen.isCodeValid(code)); // → true
    }
}
