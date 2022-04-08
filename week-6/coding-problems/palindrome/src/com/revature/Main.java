package com.revature;

public class Main {

    public static void main(String[] args) {
        System.out.println(isPalindromeSolution1("car")); // false
        System.out.println(isPalindromeSolution1("racecar")); // true
        System.out.println(isPalindromeSolution1("noon")); // true

        System.out.println(isPalindromeSolution2("car")); // false
        System.out.println(isPalindromeSolution2("racecar")); // true
        System.out.println(isPalindromeSolution2("noon")); // true
    }

    // O(n)
    public static boolean isPalindromeSolution2(String s) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = s.toCharArray();

        // Reverse arr2
        int left = 0;
        int right = arr2.length - 1;
        while (left < right) {
            // Swapping
            char temp = arr2[left];
            arr2[left] = arr2[right];
            arr2[right] = temp;

            left++;
            right--;
        }

        // Compare arr1 and arr2, and if arr2 is still equal to arr1, we know we are dealing with a palindrome
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }

        return true;
    }

    // true if it is a palindrome
    // false if it is not
    // Big O -> O(n)
    public static boolean isPalindromeSolution1(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;

            left++;
            right--;
        }

        return true;
    }
}
