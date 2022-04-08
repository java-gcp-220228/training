package com.revature;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    // Problem: Given a string, determine if the string has all unique characters or if there are duplicate characters
    public static void main(String[] args) {
        System.out.println(containsUniqueCharactersBruteforce("abcdefg")); // true
        System.out.println(containsUniqueCharactersBruteforce("apple")); // false
        System.out.println(containsUniqueCharactersBruteforce("pear")); // true

        System.out.println(containsUniqueCharactersSet("abcdefg")); // true
        System.out.println(containsUniqueCharactersSet("apple")); // false
        System.out.println(containsUniqueCharactersSet("pear")); // true

        System.out.println(containsUniqueCharactersSorting("abcdefg")); // true
        System.out.println(containsUniqueCharactersSorting("apple")); // false
        System.out.println(containsUniqueCharactersSorting("pear")); // true

        System.out.println(containsUniqueCharactersBooleanArray("abcdefg")); // true
        System.out.println(containsUniqueCharactersBooleanArray("apple")); // false
        System.out.println(containsUniqueCharactersBooleanArray("pear")); // true
    }

    // Boolean array
    // O(n)
    public static boolean containsUniqueCharactersBooleanArray(String s) {
        boolean[] bools = new boolean[128]; // this assumes the string only has ASCII characters

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (bools[c]) return false; // we have already encountered that particular character

            bools[c] = true; // we have encountered the character
        }

        return true;
    }

    // Sorting
    // O(n log n)
    public static boolean containsUniqueCharactersSorting(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars); // O(n log n)

        // O(n)
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) return false; // check if the adjacent characters in a sorted array are equal
            // which means we have duplicates
        }

        return true;
    }

    // HashSet datastructure
    // O(n)
    public static boolean containsUniqueCharactersSet(String s) {
        Set<Character> encounteredCharacters = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            // contains is O(n) for a List
            // contains is O(1) for a HashSet
            // That's why we use a Set here
            if (encounteredCharacters.contains(s.charAt(i))) return false;

            encounteredCharacters.add(s.charAt(i));
        }

        return true;
    }

    // Bruteforce solution
    // Nested for loops
    // O(n^2)
    public static boolean containsUniqueCharactersBruteforce(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) return false;
            }
        }

        return true;
    }


}
