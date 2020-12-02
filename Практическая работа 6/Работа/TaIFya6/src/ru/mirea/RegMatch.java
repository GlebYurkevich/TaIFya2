package ru.mirea;

import java.util.*;

public class RegMatch {
    public static final int START = 0;
    public static final int DIGITS = 1;
    public static void main(String[] args) {
        List<Character> digits = Arrays.asList(';', ':', '.', ',', '!', '?', '"', '(', ')', '-');
        Set<Integer> endStates = Collections.singleton(DIGITS);
        StateMachine sm = new StateMachine(START, endStates);
        // Переход START -> DIGITS при '0'..'9' на входе
        sm.add(START, digits, DIGITS);
        // Переход DIGITS -> DIGITS при '0'..'9' на входе
        sm.add(DIGITS, digits, DIGITS);
        // Поиск всех вхождений в строке:
        Scanner in = new Scanner(System.in);
        System.out.print("Input a string: ");
        String str = in.nextLine();
        sm.findAll(str);
    }
}