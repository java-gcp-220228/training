package com.revature.main;

import java.lang.reflect.Field;

public class Driver {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        stringDemo();
        stringBuilderDemo();
    }

    public static void stringBuilderDemo() {
        // Strings are immutable, which means that if we want to do operations such as concatenation,
        // a new String object needs to be created each time

        // There is a lot of overhead in doing so

        // Problem: Reversing a String
        // input: Hello
        // output: olleH
        String input = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut varius ultrices lorem eu ultricies. Nulla consequat, tortor eget suscipit pretium, tortor leo vestibulum urna, ut tincidunt orci orci vitae elit. Sed vel eros posuere, lobortis orci a, commodo lorem. Aliquam erat volutpat. Integer ultricies efficitur sapien vehicula mollis. Vivamus quis purus massa. Nulla facilisi. Curabitur et viverra lectus.\n" +
                "\n" +
                "Aliquam sed justo eget augue elementum rhoncus. Suspendisse mollis augue ut orci venenatis, et pharetra augue consectetur. Vivamus aliquet est vitae scelerisque viverra. Mauris ultrices urna sapien, sed ultrices urna finibus vitae. Sed molestie metus rutrum, pellentesque enim at, tincidunt justo. In rhoncus, ipsum sed fringilla cursus, felis diam ultrices metus, eu rutrum urna neque ut neque. Suspendisse nec ligula nec lectus tempus gravida sed sed nunc. Nullam ipsum lectus, bibendum nec pretium ac, pellentesque rhoncus velit. Morbi vehicula lorem magna. Aliquam in pretium velit. Morbi iaculis lectus arcu, eu rutrum lacus ullamcorper sed. Vivamus sed ante libero.\n" +
                "\n" +
                "Sed ac dolor posuere, ultricies nulla ac, lacinia metus. Vestibulum turpis tortor, lacinia non consectetur nec, laoreet eu nisl. Aliquam consequat, mauris eget facilisis gravida, erat lectus ultrices ligula, ac rutrum turpis nulla ut dui. Integer ac lorem blandit tortor aliquam laoreet. Mauris laoreet mi vel elementum volutpat. Fusce hendrerit pretium nibh. In et mattis elit. Integer in augue a enim scelerisque posuere. Mauris eu sapien eu ipsum semper sodales. Aenean dapibus leo sed dui pretium laoreet. Nam libero quam, varius at velit in, sollicitudin eleifend sapien. Phasellus vestibulum ornare nisl, eu sodales mi volutpat lobortis. Nunc fringilla porttitor augue ut sodales. Pellentesque nec metus varius, tristique dolor ut, ullamcorper enim. Fusce interdum maximus lacus, sed luctus neque consequat vel.\n" +
                "\n" +
                "Suspendisse vel mi sit amet ipsum luctus consequat ac a velit. Proin faucibus vulputate risus, ac scelerisque nibh. Praesent non sapien urna. Suspendisse varius augue dolor, ac auctor quam hendrerit id. Ut sit amet ultricies dolor, a congue mauris. Sed dictum nibh sit amet velit tempus mollis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Vestibulum nec est in neque ultrices fringilla. Fusce lacinia facilisis tellus, non maximus risus bibendum sed. Suspendisse ut scelerisque ipsum. Donec vitae tincidunt lorem, in aliquet metus. In malesuada risus eu augue rhoncus lobortis. Vestibulum velit nunc, blandit vel velit at, porttitor ullamcorper diam. Praesent vestibulum ligula eu risus tempus, ac blandit ligula bibendum.\n" +
                "\n" +
                "Vestibulum fringilla condimentum feugiat. Vivamus luctus augue vitae euismod molestie. Integer at mattis ex, at ullamcorper ex. Quisque ut faucibus ipsum, id consectetur ex. Proin fermentum, turpis at mollis consectetur, ex urna finibus mi, et congue orci eros in augue. Donec vitae mi elit. Duis sed enim nec nibh placerat feugiat ut ullamcorper elit. Morbi mi dolor, laoreet a dapibus eu, dignissim et dui. Nunc ac enim sollicitudin, vehicula eros ut, mollis nulla. Nullam at pharetra risus.";

        // Naive way
        String s = "";
        // O(n^2) algorithm
        // -> n = length of the string we want to reverse
        // O(n^2) implies that with a length of 10, we need ~100 operations
        //      with a length of 20, we need ~400 operations
        long startTime = System.currentTimeMillis();
        for (int i = input.length() - 1; i >= 0; i--) {
            s = s + input.charAt(i); // every time you do this (string concatenation), a new string object is created
            // 0 + 1 + 2 + 3 + 4 -> approximates to n^2
        }
        long endTime = System.currentTimeMillis();
        System.out.println("String concatenation took " + (endTime - startTime) + " ms");

        // StringBuilder is like a String in the sense that it is an array of characters (behind the scenes),
        // but it is a mutable object
        // You can add, remove, and update characters in a StringBuilder object
        // It is essentially a "mutable" String
        // StringBuffer is the same as StringBuilder except it is "synchronized" (thread-safe)
        //      Thread-safe essentially means that if you have multiple threads trying to mutate the object,
        //      only one thread can do so at a time. Checking to see if there is a thread already using the object
        //      adds additional overhead
        // String v. StringBuilder v. StringBuffer speed:
        //      1. StringBuilder (fastest) (concatenation)
        //      2. StringBuffer (fast) (concatenation)
        //      3. String (very slow) (concatenation)
        StringBuilder sb = new StringBuilder();
        // O(n) time complexity
        startTime = System.currentTimeMillis();
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i)); // O(1) operation
        }
        endTime = System.currentTimeMillis();
        String output = sb.toString();
        System.out.println("StringBuilder took " + (endTime - startTime) + " ms");
    }

    public static void stringDemo() throws NoSuchFieldException, IllegalAccessException {
        // When your Java program runs, the JVM will scan through and find all unique occurrences
        // of String literals and create a String object that will be in the String pool

        // String literals are reference variables

        String myString = "Hello world";
        System.out.println(myString);

        System.out.println("Hi there!");

        myString = null;

        String myString2 = new String(
                new char[] { 'H', 'e', 'l', 'l' , 'o', ' ', 'w', 'o', 'r', 'l', 'd'}); // Any object that is constructed
        // with the new keyword will be in the regular heap

        String myString3 = "Hello world"; // myString and myString3 are referring to the same
        // String object in the String pool

        String myString4 = "Hello worl";

        /*
            Java Reflection: changing the internal value of a String
         */
        String s = "Hello world";
        Field f = String.class.getDeclaredField("value");
        f.setAccessible(true); // Allows us to change a private and final field
        f.set(s, new char[] {'h', 'e', 'l', 'l', 'o'});

        System.out.println("Hello world"); // hello
        System.out.println("Hello world"); // hello
        System.out.println("Hello world"); // hello
        System.out.println("Hello world"); // hello

        /*
            String API methods
         */
        String s1 = "Hello";
        String s2 = " world";

        s1.concat(s2); // Concat will take the first String and concatenate it with the second string
        // Strings are immutable, calling .concat and doing nothing with it will pretty much accomplish nothing
        // You're not actually changing the s1 string

        System.out.println(s1); // Hello

        s1 = s1.concat(s2); // concat creates a brand new String object (in the regular heap). Here we are
        // reassigning s1 to point to this new String object

        // If you see any method that looks like it is modifying a String, it really actually is NOT, because
        // Strings are immutable. What it will do is return a reference to a new String object that has been created

        // .length()
        // to find the length of a string
        System.out.println("length of s1: " + s1.length());

        // startsWith(...)
        System.out.println("s1 starts with he: " + s1.startsWith("He"));

        // endsWith(...)
        System.out.println("s1 ends with orld: " + s1.endsWith("orld"));

        // .matches(regular expression)
        System.out.println("abc123".matches("[a-z]+")); // Does abc123 only have 1 or more letters (a-z)? False

        // .indexOf(...)
        System.out.println("first occurrence of e in 'hello' is at index: " + "hello".indexOf('e'));;

        // .charAt(...)
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }

        // String comparison
        String x = "hello"; // String pool object
        String y = new String(new char[] { 'h', 'e', 'l', 'l', 'o' }); // Heap object
        System.out.println("x.equals(y): " + (x.equals(y))); // true, because .equals compares the chars of each object
        System.out.println("x == y: " + (x == y)); // false, because they are two different references

        // Whenever you utilize == between two reference variables, the question being asked is
        // "are these two reference variables referring to the same object or not?"

        String a = "hello";
        String b = "hello";
        System.out.println("a == b: " + (a == b)); // true, because a and b are referring to the same object
        // in the String pool
    }

}
